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
        <img src="static/img/Rushia.jpg" class="book_img" alt="图片加载失败">
      </div>
      <ul class="inf-right">
<%--        // TODO 假如人家需要显示这些图书信息啦，怎么布局前端您看着办吧 --%>
        <li><div>编号</div><p>5</p></li>
        <li><div>书名</div><p>Java并发编程实战</p></li>
        <li><div>作者</div><p>Brian Goetz&Tim Peierls&Joshua Bloch&Joseph Bowbeer&David Holmes&Doug Lea</p></li>
        <li><div>译者</div><p>童云兰</p></li>
        <li><div>关键字</div><p>Java 并发编程 计算机</p></li>
        <li><div>下载量</div><p>6356</p></li>
        <li><div>收藏量</div><p>6356</p></li>
        <li><div>评价</div><p>本书深入浅出地介绍了Java线程和并发，是一本完美的Java并发参考手册。书中从并发性和线程安全性的基本概念出发，介绍了如何使用类库提供的基本并发构建块，用于避免并发危险、构造线程安全的类及验证线程安全的规则，如何将小的线程安全类组合成更大的线程安全类，如何利用线程来提高并发应用程序的吞吐量，如何识别可并行执行的任务，如何提高单线程子系统的响应性，如何确保并发程序执行预期任务，如何提高并发代码的性能和可伸缩性等内容，最后介绍了一些高级主题，如显式锁、原子变量、非阻塞算法以及如何开发自定义的同步工具类。</p></li>
        <li><div>上传用户</div><p>bear</p></li>
        <li><div>上传时间</div><p>2022-03-22</p></li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>