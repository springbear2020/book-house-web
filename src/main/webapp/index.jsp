<%--
  Created by IntelliJ IDEA.
  User: accelerater
  Date: 2022/3/20
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Book House</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="/pages/common/base.jsp" %>
    <link rel="stylesheet" type="text/css" href="static/css/index.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css">
    <script type="text/javascript" src="static/script/tools.js"></script>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="middle">
    <div class="search">
        <div class="search-container">
            <%-- 搜索框表单 --%>
            <form class="search-form" method="post" action="#">
                <label><input class="search-text" placeholder="请输入书名"></label>
                <button type="submit" class="search-btn">搜索</button>
                <ul class="search-list">
                    <li class="search-li">...</li>
                    <li class="search-li">...</li>
                    <li class="search-li">...</li>
                </ul>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="one-book">
            <div class="thumbnail">
                <img class="img-books"
                     src="https://pixabay.com/get/gd9c05f6cefe744944d25c227c3a8b52a156607f1a602a6d8609a48fd773f820a1b99ffc9b885c3068536890a2a7899f34da9faad5ea6833bd175c01646335cfe_1280.jpg"
                     alt="二儿日天的头像">
                <div class="caption">
                    <div><span>书名：阿伟</span></div>
                    <div><span>作者：阿伟</span></div>
                    <div><span>下载量：阿伟</span></div>
                    <div><span>收藏数：阿伟</span></div>
                    <button type="button" value="立即下载">立即下载</button>
                    <button type="button" value="加入收藏夹">加入收藏夹</button>
                </div>
            </div>
        </div>
        <div class="one-book">
            <div class="thumbnail">
                <img class="img-books"
                     src="https://pixabay.com/get/gd9c05f6cefe744944d25c227c3a8b52a156607f1a602a6d8609a48fd773f820a1b99ffc9b885c3068536890a2a7899f34da9faad5ea6833bd175c01646335cfe_1280.jpg"
                     alt="二儿日天的头像">
                <div class="caption">
                    <div><span>书名：阿伟</span></div>
                    <div><span>作者：阿伟</span></div>
                    <div><span>下载量：阿伟</span></div>
                    <div><span>收藏数：阿伟</span></div>
                    <button type="button" value="立即下载">立即下载</button>
                    <button type="button" value="加入收藏夹">加入收藏夹</button>
                </div>
            </div>
        </div>
        <div class="one-book">
            <div class="thumbnail">
                <img class="img-books"
                     src="https://pixabay.com/get/gd9c05f6cefe744944d25c227c3a8b52a156607f1a602a6d8609a48fd773f820a1b99ffc9b885c3068536890a2a7899f34da9faad5ea6833bd175c01646335cfe_1280.jpg"
                     alt="二儿日天的头像">
                <div class="caption">
                    <div><span>书名：阿伟</span></div>
                    <div><span>作者：阿伟</span></div>
                    <div><span>下载量：阿伟</span></div>
                    <div><span>收藏数：阿伟</span></div>
                    <button type="button" value="立即下载">立即下载</button>
                    <button type="button" value="加入收藏夹">加入收藏夹</button>
                </div>
            </div>
        </div>
        <div class="one-book">
            <div class="thumbnail">
                <img class="img-books"
                     src="https://pixabay.com/get/gd9c05f6cefe744944d25c227c3a8b52a156607f1a602a6d8609a48fd773f820a1b99ffc9b885c3068536890a2a7899f34da9faad5ea6833bd175c01646335cfe_1280.jpg"
                     alt="二儿日天的头像">
                <div class="caption">
                    <div><span>书名：阿伟</span></div>
                    <div><span>作者：阿伟</span></div>
                    <div><span>下载量：阿伟</span></div>
                    <div><span>收藏数：阿伟</span></div>
                    <button type="button" value="立即下载">立即下载</button>
                    <button type="button" value="加入收藏夹">加入收藏夹</button>
                </div>
            </div>
        </div>
        <div class="one-book">
            <div class="thumbnail">
                <img class="img-books"
                     src="https://pixabay.com/get/gd9c05f6cefe744944d25c227c3a8b52a156607f1a602a6d8609a48fd773f820a1b99ffc9b885c3068536890a2a7899f34da9faad5ea6833bd175c01646335cfe_1280.jpg"
                     alt="二儿日天的头像">
                <div class="caption">
                    <div><span>书名：阿伟</span></div>
                    <div><span>作者：阿伟</span></div>
                    <div><span>下载量：阿伟</span></div>
                    <div><span>收藏数：阿伟</span></div>
                    <button type="button" value="立即下载">立即下载</button>
                    <button type="button" value="加入收藏夹">加入收藏夹</button>
                </div>
            </div>
        </div>
    </div>

    <nav aria-label="Page navigation" class="pag-chs">
        <ul class="pagination">
            <li><a href="#" class="pag-num pag-fl">首页</a></li>
            <li><a href="#" aria-label="Previous" class="pag-num"><span aria-hidden="true">&laquo;</span></a></li>
            <li><a href="#" class="pag-num">1</a></li>
            <li><a href="#" class="pag-num">2</a></li>
            <li><a href="#" class="pag-num">3</a></li>
            <li><a href="#" class="pag-num">4</a></li>
            <li><a href="#" class="pag-num">5</a></li>
            <li><a href="#" aria-label="Next" class="pag-num"><span aria-hidden="true">&raquo;</span></a></li>
            <li><a href="#" class="pag-num pag-fl">尾页</a></li>
        </ul>
    </nav>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
