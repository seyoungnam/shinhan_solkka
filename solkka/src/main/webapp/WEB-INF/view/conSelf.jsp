<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html lang="EN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Singan - valocity</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" media="all" />
<!-- Slick nav CSS -->
<link rel="stylesheet" type="text/css"
	href="assets/css/slicknav.min.css" media="all" />
<!-- Iconfont CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/icofont.css"
	media="all" />
<!-- Slick CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/slick.css">

<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<!-- Owl carousel CSS -->
<link rel="stylesheet" type="text/css"
	href="assets/css/owl.carousel.css">
<!-- Popup CSS -->
<link rel="stylesheet" type="text/css"
	href="assets/css/magnific-popup.css">
<!-- Switcher CSS -->
<link rel="stylesheet" type="text/css"
	href="assets/css/switcher-style.css">
<!-- Animate CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/animate.min.css">
<!-- Main style CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/style.css"
	media="all" />
<!-- Responsive CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/responsive.css"
	media="all" />
<!-- Favicon Icon -->
<link rel="icon" type="image/png" href="assets/img/favcion.png" />
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>
<body data-spy="scroll" data-target=".header" data-offset="50">
	<!-- Page loader -->
	<div id="preloader"></div>
	<!-- header section start -->
	<header class="header">
		<div class="container">
			<div class="row flexbox-center">
				<div class="col-md-2 col-6">
					<div class="logo">
						<a href="index.html"><img src="assets/img/logo.png" alt="logo" /></a>
					</div>
				</div>
				<div class="col-md-10 col-6">
					<div class="responsive-menu"></div>
					<div class="mainmenu">
						<ul id="primary-menu">
							<li><a class="nav-link" href="index.html#home">Home</a></li>
							<li><a class="nav-link" href="index.html#feature">Feature</a></li>
							<li><a class="nav-link" href="index.html#screenshot">Screenshot</a></li>
							<li><a class="nav-link" href="index.html#pricing">Pricing</a></li>
							<li><a class="nav-link" href="index.html#team">Team</a></li>
							<li><a class="nav-link active" href="index.html#blog">Blog</a></li>
							<li><a class="nav-link" href="index.html#contact">Contact
									Us</a></li>
							<li><a class="appao-btn" href="#">Download</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- header section end -->
	<!-- breadcrumb area start -->
	<section class="hero-area breadcrumb-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="hero-area-content">
						<h1>나의 소비 패턴</h1>
						<p>나의 소비 성향</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- breadcrumb area end -->
	<!-- blog section start -->
	<section class="blog-detail" id="blog">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="blog-details">
						<h4>나의 3개월간 소득 : 4,000,000만원</h4>
						<br>
						<hr>
						<br>
						<p>나의 소득 평균 소비</p>
						<script type="text/javascript"
							src="https://www.gstatic.com/charts/loader.js"></script>
						<script type="text/javascript">
							google.charts.load("current", {
								packages : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(drawChart);
							function drawChart() {
								var data = google.visualization
										.arrayToDataTable([
												[ "Element", "Density", {
													role : "style"
												} ],
												[ "Copper", 8.94, "#b87333" ],
												[ "Silver", 10.49, "silver" ],
												[ "Gold", 19.30, "gold" ],
												[ "Platinum", 21.45,
														"color: #e5e4e2" ] ]);

								var view = new google.visualization.DataView(
										data);
								view.setColumns([ 0, 1, {
									calc : "stringify",
									sourceColumn : 1,
									type : "string",
									role : "annotation"
								}, 2 ]);

								var options = {
									title : "Density of Precious Metals, in g/cm^3",
									width : 600,
									height : 400,
									bar : {
										groupWidth : "95%"
									},
									legend : {
										position : "none"
									},
								};
								var chart = new google.visualization.ColumnChart(
										document
												.getElementById("columnchart_values"));
								chart.draw(view, options);
							}
						</script>
						<div id="columnchart_values" style="width: 900px; height: 300px;"></div>
						<script type="text/javascript" src="js/googleChart.js"></script>
						<div id="table_div"></div>

						<div class="post-author">
							<a href="#"><i class="icofont icofont-user"></i>John</a> <a
								href="#"><i class="icofont icofont-speech-comments"></i>Comments</a>
							<a href="#"><i class="icofont icofont-calendar"></i>21 Feb
								2018</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- blog section end -->
	<!-- jquery main JS -->
	<script src="assets/js/jquery.min.js"></script>
	<!-- Bootstrap JS -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- Slick nav JS -->
	<script src="assets/js/jquery.slicknav.min.js"></script>
	<!-- Slick JS -->
	<script src="assets/js/slick.min.js"></script>
	<!-- owl carousel JS -->
	<script src="assets/js/owl.carousel.min.js"></script>
	<!-- Popup JS -->
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<!-- Counter JS -->
	<script src="assets/js/jquery.counterup.min.js"></script>
	<!-- Counterup waypoints JS -->
	<script src="assets/js/waypoints.min.js"></script>
	<!-- YTPlayer JS -->
	<script src="assets/js/jquery.mb.YTPlayer.min.js"></script>
	<!-- jQuery Easing JS -->
	<script src="assets/js/jquery.easing.1.3.js"></script>
	<!-- WOW JS -->
	<script src="assets/js/wow-1.3.0.min.js"></script>
	<!-- Switcher JS -->
	<script src="assets/js/switcher.js"></script>
	<!-- main JS -->
	<script src="assets/js/main.js"></script>
</body>
</html>