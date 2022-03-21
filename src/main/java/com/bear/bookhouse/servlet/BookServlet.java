package com.bear.bookhouse.servlet;


import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import com.bear.bookhouse.util.DateUtil;
import com.bear.bookhouse.util.NumberUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 19:42
 */
public class BookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();
    /**
     * 图书文件经服务器部署后的相对路径
     */
    private String bookWebRelativePath;
    /**
     * 封面文件经服务器部署后的相对路径
     */
    private String coverWebRelativePath;
    /**
     * 图书文件的磁盘绝对路径
     */
    private File bookRealDiskPath;
    /**
     * 封面文件的磁盘绝对路径
     */
    private File coverRealDiskPath;

    /**
     * 通过图书 id 下载对应的图书数据
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void downloadBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idStr = req.getParameter("id");
        int id = NumberUtil.objectToInteger(idStr, 0);
        String bookSavePath = bookService.getBookPathById(id);
        // 读取文件类型
        String mimeType = getServletContext().getMimeType("/file/" + bookSavePath);
        // 通过响应头通知客户端返回的数据类型
        resp.setContentType(mimeType);
        // 告知客户端数据用于下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(DateUtil.fileNameFormat(new Date()) + ".pdf", "UTF-8"));
        // 从磁盘读取想要下载的字节数据到流中
        InputStream inputStream = getServletContext().getResourceAsStream("/" + bookSavePath);
        // 将文件字节流数据赋值给响应输出流
        IOUtils.copy(inputStream, resp.getOutputStream());
    }


    /**
     * 图书上传
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void uploadBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Book book = new Book();
        // 判断上传的文件是否为多段格式
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建用于解析上传数据的工具类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                // 逐条解析文件数据，分普通表单项和文件进行处理
                for (FileItem fileItem : fileItemList) {
                    // 普通表单项，读取 name - value 信息并封装为 Book 对象
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();
                        String value = fileItem.getString("UTF-8");
                        switch (name) {
                            case "title":
                                book.setTitle(value);
                                break;
                            case "author":
                                book.setAuthor(value);
                                break;
                            case "translator":
                                book.setTranslator(value);
                                break;
                            case "keywords":
                                book.setKeywords(value);
                                break;
                            case "comment":
                                book.setComment(value);
                                break;
                            case "uploadUsername":
                                book.setUploadUsername(value);
                                break;
                            default:
                        }
                    } else {
                        // 非普通表单项，获取文件信息；获取文件表单项的 name 属性值
                        String fieldName = fileItem.getFieldName();
                        // 获取上传的文件名
                        String uploadFileName = fileItem.getName();
                        if ("book".equals(fieldName)) {
                            // 将图书文件保存到磁盘真实路径下目录下
                            fileItem.write(new File(bookRealDiskPath + "/" + uploadFileName));
                            // 设置图书文件经服务器部署后的相对路径为 bookWebPath
                            book.setBookPath(bookWebRelativePath + uploadFileName);
                        } else if ("cover".equals(fieldName)) {
                            // 将封面文件保存到磁盘真实路径下
                            fileItem.write(new File(coverRealDiskPath + "/" + uploadFileName));
                            // 设置封面文件相对路径为 coverWebPath
                            book.setCoverPath(coverWebRelativePath + uploadFileName);
                        }
                    }
                }

                // 设置图书默认下载量、收藏量和上传时间
                book.setCollections(0);
                book.setDownloads(0);
                book.setUploadTime(new Date());
                // 保存图书记录到数据库
                if (bookService.saveBook(book)) {
                    req.setAttribute("uploadMsg", "图书文件上传成功，感谢您的共享");
                } else {
                    req.setAttribute("uploadMsg", "图书文件上传失败，请您稍后重试");
                }

                req.getRequestDispatcher("/pages/book/upload.jsp").forward(req, resp);
            } catch (Exception e) {
                req.setAttribute("uploadMsg", "图书文件上传失败，请您稍后重试");
                req.getRequestDispatcher("/pages/book/upload.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定页码获取图书数据，每页默认 5 条数据
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws IOException exception
     */
    protected void listBooksByPageNum(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pageNumStr = req.getParameter("pageNum");
        // 页码错误则默认加载第 1 页
        int pageNum = NumberUtil.objectToInteger(pageNumStr, 1);
        // 获取图书分页数据
        Page<Book> bookPageData = bookService.getBookPageData(pageNum, 5);
        if (bookPageData != null) {
            req.setAttribute("bookPageData", bookPageData);
            req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/pages/error/500.jsp");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 从 web.xml 中读取图书、封面文件经服务器部署后的自定义相对路径，例：http://ip:port/project/WEB-INF/book/
        this.bookWebRelativePath = config.getInitParameter("bookPath");
        this.coverWebRelativePath = config.getInitParameter("coverPath");
        // 获取图书、封面文件在磁盘上的真实路径，若目录不存在则新建目录
        this.bookRealDiskPath = new File(getServletContext().getRealPath("/") + "/" + this.bookWebRelativePath);
        this.coverRealDiskPath = new File(getServletContext().getRealPath("/") + "/" + this.coverWebRelativePath);
        if (!this.bookRealDiskPath.exists()) {
            if (bookRealDiskPath.mkdirs()) {
                System.out.println("图书磁盘保存目录创建成功");
            }
        }
        if (!this.coverRealDiskPath.exists()) {
            if (coverRealDiskPath.mkdirs()) {
                System.out.println("封面磁盘保存目录创建成功");
            }
        }
    }
}
