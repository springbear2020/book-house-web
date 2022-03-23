<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/22
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
  <meta charset="utf-8">
  <title>图书详情</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <%@include file="/pages/common/base.jsp" %>
  <link rel="stylesheet" type="text/css" href="static/css/detail.css">
  <link rel="stylesheet" type="text/css" href="static/css/common.css">
  <script type="text/javascript" src="static/script/tools.js"></script>
</head>
<body>
<%@include file="/pages/common/title.jsp" %>
<div class="middle">
  <div class="middle-frame">
    <div class="book-inf">
      <div class="inf-left">
        <img src="${requestScope.book.coverPath}" class="book_img" alt="图片加载失败">
      </div>
      <ul class="inf-right">
<%--        // TODO 假如人家需要显示这些图书信息啦，怎么布局前端您看着办吧 --%>
        <li><div>编号</div><p>${requestScope.book.id}</p></li>
        <li><div>书名</div><p>${requestScope.book.title}</p></li>
        <li><div>作者</div><p>${requestScope.book.author}</p></li>
        <li><div>译者</div><p>${requestScope.book.translator}</p></li>
        <li><div>关键字</div><p>${requestScope.book.keywords}</p></li>
        <li><div>下载量</div><p>${requestScope.book.downloads}</p></li>
        <li><div>收藏量</div><p>${requestScope.book.collections}</p></li>
        <li><div>评价</div><p>${requestScope.book.comment}</p></li>
        <li><div>上传用户</div><p>${requestScope.book.uploadUsername}</p></li>
        <li><div>上传时间</div><p>${requestScope.book.uploadTime}</p></li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>