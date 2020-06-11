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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <%@ include file="parts/meta.jsp" %>
    <%@ include file="parts/styles.jsp" %>
    <%@ include file="parts/scripts.jsp" %>
    <script src="${pageContext.request.contextPath}/js/empJquery.js"></script>


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
                                    <h1 class="no-margin">Employee Record</h1>
                                    <p>Request Page to view details of a Single Employee. <br>
                                       Please submit the SID to view employee details.</p>
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

            <form method="post" action="viewSingleEmployeeJSTLrequestPOST" >
                <div align="center">

                            <input type="radio" id="selectsingleemp" name="employeeoperation" value="selectsingleemp">
                            <label for="selectsingleemp">Select Single Emp</label>

                            <input type="radio" id="selectallemp" name="employeeoperation" value="selectallemp">
                            <label for="selectallemp">Select All Emp</label>
                            <br>

                            <div id="textboxes" style="display: none">
                                <%--<label>  Enter SID:  </label>--%>
                                <label for="sid">Enter SID: </label><input type="text" id="sid" name="sid"/>

                            </div>
                    <br>

                            <button type="submit" value="retrieve">Retrieve</button>

                            <button type="reset" value="reset">Reset</button>

                </div>
            </form>


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

