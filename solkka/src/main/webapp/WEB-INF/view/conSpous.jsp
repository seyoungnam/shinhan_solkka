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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">

google.charts.load("current", {packages:['corechart']});
							  function getGraph(){
								  let data = '{"userId":"girl2019", "income":"5000000"}'
								  let fistData = 0
								  let second = 0
								  axios.post("http://localhost:8000/getExpenseRate",JSON.parse(data)).then(resData => {
									   fistData = resData.data["01"][0] +
											  resData.data["02"][0] +
											  resData.data["03"][0] +
											  resData.data["04"][0] +
											  resData.data["05"][0] +
											  resData.data["06"][0] +
											  resData.data["07"][0] +
											  resData.data["08"][0] +
											  resData.data["09"][0] +
											  resData.data["10"][0] +
											  resData.data["11"][0] +
											  resData.data["12"][0];
											  
										second = resData.data["01"][1] +
											  resData.data["02"][1] +
											  resData.data["03"][1] +
											  resData.data["04"][1] +
											  resData.data["05"][1] +
											  resData.data["06"][1] +
											  resData.data["07"][1] +
											  resData.data["08"][1] +
											  resData.data["09"][1] +
											  resData.data["10"][1] +
											  resData.data["11"][1] +
											  resData.data["12"][1];
										 google.charts.setOnLoadCallback(drawChart(fistData, second));
								  })
							  
							    
							   

							  }
							  
							    function drawChart(fistData, second) {
								      var value = google.visualization.arrayToDataTable([
								        ["Element", "원", { role: "style" } ],
								        ["배우자 지출", Math.ceil(fistData), "#b87333"],
								        ["평균 지출", Math.ceil(second), "gold"]
								      ]);
								
								      var view = new google.visualization.DataView(value);
								      view.setColumns([0, 1,
								                       { calc: "stringify",
								                         sourceColumn: 1,
								                         type: "string",
								                         role: "annotation" },
								                       2]);
								
								      var options = {
								        title: "-배우자와 소득이 비슷한 사람들은 이만큼 써요-",
								        width: 500,
								        height: 600,
								        bar: {groupWidth: "95%"},
								        legend: { position: "none" },
								        vAxis : {minValue:0}
								      };
								      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
								      chart.draw(view, options);
								      google.charts.load('current', {'packages':['table']});
								  	}
							    
							    
							  
							function getTable(){
							let data2 = '{"userId":"girl2019"}'
							let date = []
							axios.post("http://localhost:8000/getCardData",JSON.parse(data2)).then(resData => {
								resData.data.forEach(function(element){
								    date.push(Array(element["apprvDate"], element["cardType"], element["cat"], element["apprvAmount"]))
	
								});
						      google.charts.setOnLoadCallback(drawTable(date));
								
							});


						      function drawTable(date) {
						        var data = new google.visualization.DataTable();
						        data.addColumn('string', 'date');
						        data.addColumn('string', 'cardType');
						        data.addColumn('string', 'cat');
						        data.addColumn('number', 'amount');
						        data.addRows(date);

						        var table = new google.visualization.Table(document.getElementById('columnchart_values'));

						        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
						      }
							}
</script>
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
							<li><a class="nav-link" href="index.html#contact">Contact
									Us</a></li>
							<li><a class="appao-btn" href="/couple">부부 소비 패턴 보기</a></li>
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
						<h1>배우자의 소비 패턴</h1>
						<p>배우자의 소비 성향</p>
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
						<h4>배우자의 3개월간 소득 : 3,500,000만원</h4>
						<br>
						<hr>
						<br>
						<p>배우자의 소득 평균 소비</p>
						<button onclick="getGraph()" class="appao-btn appao-btn2">배우자의
							소비 패턴 그래프 보기</button>
						<button onclick="getTable()" class="appao-btn appao-btn2">배우자의
							소비 내역 보기</button>
						<div id="columnchart_values" style="width: 900px; height: 300px;"></div>
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
	<!-- WOW JS -->
	<script src="assets/js/wow-1.3.0.min.js"></script>
	<!-- Switcher JS -->
	<script src="assets/js/switcher.js"></script>
	<!-- main JS -->
	<script src="assets/js/main.js"></script>
</body>
</html>