<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<!--
	Cube by FreeHTML5.co
	Twitter: http://twitter.com/gettemplateco
	URL: http://freehtml5.co
-->
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
										<h1 class="no-margin">Contact</h1>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Officia facilis, accusamus iusto animi.</p>
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
				<div class="row">
					<div class="col-md-8 col-md-offset-2 gtco-heading text-center">
						<h2>Get In Touch</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus placerat enim et urna sagittis, rhoncus euismod erat tincidunt. Donec tincidunt volutpat erat.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<form action="#">
							<div class="form-group">
								<label for="name">Name</label>
								<input type="text" class="form-control" id="name">
							</div>
							<div class="form-group">
								<label for="name">Email</label>
								<input type="text" class="form-control" id="email">
							</div>
							<div class="form-group">
								<label for="message"></label>
								<textarea name="" id="message" cols="30" rows="10" class="form-control"></textarea>
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn btn-special" value="Send Message">
							</div>
						</form>
					</div>
					<div class="col-md-5 col-md-push-1">
						<div class="gtco-contact-info">
							<h3>Our Address</h3>
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
							<ul >
								<li class="address">198 West 21th Street, Suite 721 New York NY 10016</li>
								<li class="phone"><a href="tel://1234567890">1235 2355 980</a></li>
								<li class="email"><a href="#">info@yoursite.com</a></li>
								<li class="url"><a href="#">www.yoursite.com</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END .gtco-services -->

		<%--Doesn't Work ATM--%>
		<%--<div id="map"></div>--%>


			<%@ include file="parts/footer.jsp" %>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	</body>
</html>

