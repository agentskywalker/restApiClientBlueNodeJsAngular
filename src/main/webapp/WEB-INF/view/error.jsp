<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<!--
Cube by FreeHTML5.co
Twitter: http://twitter.com/gettemplateco
URL: http://freehtml5.co
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="parts/meta.jsp" %>
    <%@ include file="parts/styles.jsp" %>
    <%@ include file="parts/scripts.jsp" %>

</head>
<body>

<div class="gtco-loader"></div>

<div id="page">

    <%@ include file="parts/header.jsp" %>

    <header id="gtco-header" class="gtco-cover gtco-cover-xs gtco-inner" role="banner">
        <div class="gtco-container">
            <div class="row">
                <div class="col-md-12 col-md-offset-0 text-left">
                    <div class="display-t">
                        <div class="display-tc">
                            <div class="row">
                                <div class="col-md-8 animate-box">
                                    <h1 class="no-margin">Error Page</h1>
                                    <p>Some Error occurred. Please try again.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- END #gtco-header -->

    <div class="gtco-section">
        <div class="gtco-container">

            <p align="center">
                If error persists, please contact site IT support using Contact page.
            </p>


        </div>
    </div>
    <!-- END .gtco-services -->

    <%@ include file="parts/footer.jsp" %>


</div>

<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
</div>

</body>
</html>

