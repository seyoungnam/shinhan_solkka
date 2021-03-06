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
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css" media="all" />
		<!-- Slick nav CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/slicknav.min.css" media="all" />
		<!-- Iconfont CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/icofont.css" media="all" />
		<!-- Slick CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/slick.css">

		<link rel="stylesheet" href="assets/css/font-awesome.min.css">
		<!-- Owl carousel CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/owl.carousel.css">
		<!-- Popup CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/magnific-popup.css">
		<!-- Switcher CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/switcher-style.css">
		<!-- Animate CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/animate.min.css">
		<!-- Main style CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/style.css" media="all" />
		<!-- Responsive CSS -->
		<link rel="stylesheet" type="text/css" href="assets/css/responsive.css" media="all" />
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
					<div class="col-lg-2 col-md-3 col-6">
						 <!-- <div class="logo">
							<a href="#home"><img src="assets/img/logo.PNG" alt="logo" /></a>
						</div>  -->
						<a href="#home"><font color="white" size="5"><p>SoL Assets</p></font></a>
					</div>
					<div class="col-lg-10 col-md-9 col-6">
						<div class="responsive-menu"></div>
					    <div class="mainmenu">
                            <ul id="primary-menu">
                                <li><a class="nav-link active" href="#home">Home</a></li>
                                <li><a class="nav-link" href="#feature">공동 자산</a></li>
                                <li><a class="nav-link" href="#screenshot">공동 재텍크</a></li>
                                <li><a class="nav-link" href="#pricing">Pricing</a></li>
                                <li><a class="nav-link" href="#team">Team</a></li>
                                <li><a class="nav-link" href="#blog">Blog</a></li>
                                <li><a class="nav-link" href="#contact">Contact Us</a></li>
                                <li><a class="appao-btn" href="/conSelf">세부내역 보기</a></li>
                            </ul>
					    </div>
					</div>
				</div>
			</div>
		</header><!-- header section end -->
		<!-- hero area start -->
		<section class="hero-area" id="home">
			<div class="container">
				<div class="row">
					<div class="col-lg-7">
						<div class="hero-area-content">
							<h1>부부 공동 자산관리 Flatform</h1>
							<p>
								행복한 미래를 위하여!<br> 
								 부부 사이에도 투명한 자산관리를 위하여! <br> 
							 	독박 자산관리는 이제 그만!
							</p>
							<a href="#a" class="appao-btn">소비 패턴 분석 바로가기</a>
							<a href="#b" class="appao-btn">주식 궁합 분석 바록가기</a>
							<!-- <a href="#" class="appao-btn">App Store</a> -->
						</div>
					</div>
					<div class="col-lg-5">
					    <div class="hand-mockup text-lg-left text-center">
							<img src="assets/img/hand-mockup2.png" alt="Hand Mockup" />
						</div>
					</div>
				</div>
			</div>
		</section><!-- hero area end -->
		<!-- about section start -->
		<section class="showcase-area ptb-90">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
					    <div class="sec-title">
							<h2>신한 부부 자산 관리 System<span class="sec-title-border"><span></span><span></span><span></span></span></h2>
							<p>본인과 배우자의 소비패턴 및, 투자 궁합을 한눈에 보기</p>
						</div>
					</div>
				</div>
				<div class="row flexbox-center">
					<div class="col-lg-6">
						<div class="single-showcase-box" id="a">
							<h4>소비 패턴 궁합 보기</h4>
							<p>본인과 배우자의 소비 패턴, 그리고 둘의 소비 패턴을 합쳤을 때의 궁합 볼 수 있습니다. </p>
							<a href="/asset" class="appao-btn appao-btn2">Read More</a>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="single-showcase-box">
							<img src="assets/img/showcase.png" alt="showcase">
						</div>
					</div>
				</div>
				<div class="row flexbox-center">
					<div class="col-lg-6">
						<div class="single-showcase-box">
							<img src="assets/img/showcase2.png" alt="showcase">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="single-showcase-box" id="b">
							<h4>투자 궁합 보기</h4>
							<p>본인과 배우자의 투자 성향을 분석하여 최적의 궁합을 보여드립니다. </p>
							<a href="#" class="appao-btn appao-btn2">Read More</a>
						</div>
					</div>
				</div>
			</div>
		</section><!-- showcase section end -->
		<!-- video section start -->
		
		
		<a href="#" class="scrollToTop">
			<i class="icofont icofont-arrow-up"></i>
		</a>
		<div class="switcher-area" id="switch-style">
			<div class="display-table">
				<div class="display-tablecell">
					<a class="switch-button" id="toggle-switcher"><i class="icofont icofont-wheel"></i></a>
					<div class="switched-options">
						<div class="config-title">Home variation:</div>
						<ul>
							<li class="active"><a href="index.html">Home - Fixed Text</a></li>
							<li><a href="index-slider.html">Home - Slider Effect</a></li>
							<li><a href="index-video.html">Home - Video Background</a></li>
						</ul>
						<div class="config-title">Other Pages</div>
						<ul>
							<li><a href="blog.html">Blog</a></li>
							<li><a href="blog-detail.html">Blog Details</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
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
		<!-- Gmap JS -->
		<script src="assets/js/gmap3.min.js"></script>
        <!-- Google map api -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBnKyOpsNq-vWYtrwayN3BkF3b4k3O9A_A"></script>
		<!-- Custom map JS -->
		<script src="assets/js/custom-map.js"></script>
		<!-- WOW JS -->
		<script src="assets/js/wow-1.3.0.min.js"></script>
		<!-- Switcher JS -->
		<script src="assets/js/switcher.js"></script>
		<!-- main JS -->
		<script src="assets/js/main.js"></script>
	</body>
</html>