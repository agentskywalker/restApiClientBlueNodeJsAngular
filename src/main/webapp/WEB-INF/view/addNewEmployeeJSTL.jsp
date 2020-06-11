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
    <link href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css' rel='stylesheet'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <%--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>--%>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.16.0/themes/prism.css" />

    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">--%>
    <%@ include file="parts/meta.jsp" %>
    <%@ include file="parts/styles.jsp" %>
    <%@ include file="parts/scripts.jsp" %>
    <script src="/js/empJquery.js"></script>

    <style>
        /* Datepicker popup icon */

        button.calendar, button.calendar:active {
            width: 2.75rem;
            background-image: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACIAAAAcCAYAAAAEN20fAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAEUSURBVEiJ7ZQxToVAEIY/YCHGxN6XGOIpnpaEsBSeQC9ArZbm9TZ6ADyBNzAhQGGl8Riv4BLAWAgmkpBYkH1b8FWT2WK/zJ8ZJ4qiI6XUI3ANnGKWBnht2/ZBDRK3hgVGNsCd7/ui+JkEIrKtqurLpEWaphd933+IyI3LEIdpCYCiKD6HcuOa/nwOa0ScJEnk0BJg0UTUWJRl6RxCYEzEmomsIlPU3IPW+grIAbquy+q6fluy/28RIBeRMwDXdXMgXLj/B2uimRXpui4D9sBeRLKl+1N+L+t6RwbWrZliTTTr1oxYtzVWiTQAcRxvTX+eJMnlUDaO1vpZRO5NS0x48sIwfPc87xg4B04MCzQi8hIEwe4bl1DnFMCN2zsAAAAASUVORK5CYII=') !important;
            background-repeat: no-repeat;
            background-size: 23px;
            background-position: center;
        }

        /* Sortable table demo */

        th[sortable] {
            cursor: pointer;
            user-select: none;
            -webkit-user-select: none;
        }

        th[sortable].desc:before, th[sortable].asc:before {
            content: '';
            display: block;
            background: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAmxJREFUeAHtmksrRVEUx72fH8CIGQNJkpGUUmakDEiZSJRIZsRQmCkTJRmZmJgQE0kpX0D5DJKJgff7v+ru2u3O3vvc67TOvsdatdrnnP1Y///v7HvvubdbUiIhBISAEBACQkAICAEhIAQ4CXSh2DnyDfmCPEG2Iv9F9MPlM/LHyAecdyMzHYNwR3fdNK/OH9HXl1UCozD24TCvILxizEDWIEzA0FcM8woCgRrJCoS5PIwrANQSMAJX1LEI9bqpQo4JYNFFKRSvIgsxHDVnqZgIkPnNBM0rIGtYk9YOOsqgbgepRCfdbmFtqhFkVEDVPjJp0+Z6e6hRHhqBKgg6ZDCvYBygVmUoEGoh5JTRvIJwhJo1aUOoh4CLPMyvxxi7EWOMgnCGsXXI1GIXlZUYX7ucU+kbR8NW8lh3O7cue0Pk32MKndfUxQFAwxdirk3fHappAnc0oqDPzDfGTBrCfHP04dM4oTV8cxr0SVzH9FF07xD3ib6xCDE+M+aUcVygtWzzbtGX2rPBrEUYfecfQkaFzYi6HjVnGBdtL7epqAlc1+jRdAap74RrnPc4BCijttY2tRcdN0g17w7HqZrXhdJTYAuS3hd8z+vKgK3V1zWPae0mZDMykadBn1hTQBLnZNwVrJpSe/NwEeDsEwCctEOsJTsgxLvCqUl2ACftEGvJDgjxrnBqkh3ASTvEWrIDQrwrnJpkB3DSDrGW7IAQ7wqnJtkBnLRztejXXVu4+mxz/nQ9jR1w5VB86ejLTFcnnDwhzV+F6T+CHZlx6THSjn76eyyBIOPHyDakhBAQAkJACAgBISAEhIAQYCLwC8JxpAmsEGt6AAAAAElFTkSuQmCC') no-repeat;
            background-size: 22px;
            width: 22px;
            height: 22px;
            float: left;
            margin-left: -22px;
        }

        th[sortable].desc:before {
            transform: rotate(180deg);
            -ms-transform: rotate(180deg);
        }

        /* Filtering table demo */
        ngbd-table-filtering span.ngb-highlight {
            background-color: yellow;
        }

        /* Complete table demo */
        ngbd-table-complete span.ngb-highlight {
            background-color: yellow;
        }

        ngb-carousel .picsum-img-wrapper {
            position: relative;
            height: 0;
            padding-top: 55%; /* Keep ratio for 900x500 images */
        }

        ngb-carousel .picsum-img-wrapper>img {
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
        }

    </style>






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
                                    <p>Request Page to add a new Employee to official records. <br>
                                       Please fill all details and submit the request form.</p>
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

            <form method="post" action="addNewEmployeeJSTLrequestPOST" >
                <div align="center">

                    <table align="center">
                        <thead>
                        <%--<tr>
                            <th><strong>Please provide details for the new Employee to be added to Database</strong>
                            </th>
                        </tr>--%>
                        <tr>
                            <td><strong>Field</strong></td>
                            <td><strong>Value</strong></td>
                        </tr>
                        </thead>
                        <tr>
                            <td>
                                <strong>SID</strong>
                            </td>
                            <td>
                                <input type="text" id="sid" name="sid"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>first_name</strong>
                            </td>
                            <td>
                                <input type="text" id="first_name" name="first_name"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>last_name</strong>
                            </td>
                            <td>
                                <input type="text" id="last_name" name="last_name"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>role</strong>
                            </td>
                            <td>
                                <input type="text" id="role" name="role"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>email</strong>
                            </td>
                            <td>
                                <input type="text" id="email" name="email"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>mgr_id</strong>
                            </td>
                            <td>
                                <input type="text" id="mgr_id" name="mgr_id"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>dob</strong>
                            </td>
                            <td>
                                <%--<input type="text" id="datepicker" name="dob"/>--%>
                                <%--    <input type="text" id="datepicker">--%>
                                    <ngbd-datepicker-popup></ngbd-datepicker-popup>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>ssn</strong>
                            </td>
                            <td>
                                <input type="text" id="ssn" name="ssn"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit" value="addEmployee">Add Employee</button>
                            </td>
                            <td>
                                <button type="reset" value="reset">Reset</button>
                            </td>
                        </tr>

                    </table>


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

