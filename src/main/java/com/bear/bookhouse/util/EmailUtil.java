package com.bear.bookhouse.util;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/15 16:56
 */
public class EmailUtil {
    /**
     * 发件人邮箱账号
     */
    private static final String FROM_EMAIL = "springbear2020@163.com";
    /**
     * 发件人邮箱授权码
     */
    private static final String FROM_EMAIL_PW = "DEPHWPTNAEKRBOFG";
    /**
     * 发件人邮箱服务器
     */
    private static final String MY_EMAIL_SMTP_HOST = "smtp.163.com";

    /**
     * 验证码长度
     */
    private static final int VERIFY_CODE_LEN = 6;
    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 会话对象
     */
    private static Session session;
    /**
     * 邮件工具类对象
     */
    private static final EmailUtil EMAIL_UTIL_OBJ = new EmailUtil();

    public String getVerifyCode() {
        return verifyCode;
    }

    public static EmailUtil getInstance() {
        return EMAIL_UTIL_OBJ;
    }

    /**
     * 配置属性信息
     */
    private EmailUtil() {
        Properties properties = new Properties();
        // 使用的协议（JavaMail 规范要求）
        properties.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.host", MY_EMAIL_SMTP_HOST);
        // 需要请求认证
        properties.setProperty("mail.smtp.auth", "true");
        session = Session.getInstance(properties);
        // 设置为debug模式, 可以查看详细的发送 log
        // session.setDebug(true);
    }

    /**
     * 构建邮件内容
     *
     * @param dstEmail 收件人邮箱地址
     * @return 邮件内容
     * @throws Exception exception
     */
    private MimeMessage createMailContent(String dstEmail) throws Exception {
        MimeMessage message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(FROM_EMAIL, "Book House", "UTF-8"));
        // 设置收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(dstEmail));
        // 邮件主题
        message.setSubject("欢迎使用 Book House 身份验证系统", "UTF-8");
        // 邮件正文
        verifyCode = NumberUtil.randomGenerateCode(VERIFY_CODE_LEN);
        Date date = new Date();
        message.setContent("您好！您的验证码是：" + verifyCode + "，您正在进行身份验证，打死都不要告诉别人哦！发送时间：" + date, "text/html;charset=UTF-8");
        // 设置发件时间
        message.setSentDate(new Date());
        // 保存设置
        message.saveChanges();
        return message;
    }

    /**
     * 发送邮件
     *
     * @param dstEmail 收件人邮箱地址
     * @throws Exception exception
     */
    public synchronized void sendEmail(String dstEmail) throws Exception {
        Transport transport = session.getTransport();
        transport.connect(FROM_EMAIL, FROM_EMAIL_PW);
        // 生成邮件内容并发送
        MimeMessage message = createMailContent(dstEmail);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}


