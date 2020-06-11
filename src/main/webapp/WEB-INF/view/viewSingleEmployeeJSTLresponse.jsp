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
                                    <h1 class="no-margin">Employee Record</h1>
                                    <p>Here is details for the employee requested.</p>
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

            <c:if test="${requestScope.employee != null}">

                <table align="center">
                    <thead>
                    <tr>
                        <th>
                            <strong>sid
                            </strong>
                        </th>
                        <th>
                            <strong>first_name
                            </strong>
                        </th>
                        <th>
                            <strong>last_name
                            </strong>
                        </th>
                        <th>
                            <strong>role
                            </strong>
                        </th>
                        <th>
                            <strong>email
                            </strong>
                        </th>
                        <th>
                            <strong>mgr_id
                            </strong>
                        </th>
                        <th>
                            <strong>dob
                            </strong>
                        </th>
                        <th>
                            <strong>ssn
                            </strong>
                        </th>
                    </tr>
                    </thead>
                        <%--<c:forEach  items="${employee}" var="employee" varStatus="loop">--%>
                    <tr>
                        <td>${employee.sid       }</td>
                        <td>${employee.first_name}</td>
                        <td>${employee.last_name }</td>
                        <td>${employee.role      }</td>
                        <td>${employee.email     }</td>
                        <td>${employee.mgr_id    }</td>
                        <td>${employee.dob       }</td>
                        <td>${employee.ssn       }</td>
                    </tr>
                </table>


            </c:if>


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

