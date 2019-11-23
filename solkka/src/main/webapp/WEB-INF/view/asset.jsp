<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sinhan - valocity</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="assets/css/slicknav.min.css" media="all" />
<link rel="stylesheet" type="text/css" href="assets/css/icofont.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/magnific-popup.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/switcher-style.css">
<link rel="stylesheet" type="text/css" href="assets/css/animate.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="assets/css/responsive.css"
	media="all" />
<link rel="icon" type="image/png" href="assets/img/favcion.png" />
</head>
<style>
.chartLoc {
	margin: 50px 250px 550px 8000px;
}
</style>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

	google.charts.load('current', {'packages':['bar']});
	var valueOver; 
	var valueLess; 
	function getExpenseRate(userId,income){
		valueOver = []; valueLess = [];
		var data = '{"userId":"'+userId+'","income":'+income+'}';
		var self = '';
		if(userId=='boy2019') {
			self = '본인'
		} else {
			self = '배우자'
		}
		valueOver[0] = ['category', self + ' 지출','소득분위 평균지출'];
		valueLess[0] = ['category', self + ' 지출','소득분위 평균지출'];
		var categories = ['','식료품','주류','의류','주거','가정','보건','교통','통신','오락','교육','음식','기타'];
		axios.post("http://localhost:8000/getExpenseRate",JSON.parse(data))
		.then(resData => {
			resData = resData.data;
			for(var i = 1 ; i <= 12; i++) {
				j = '';
				if(i<10){
					j = '0';
				}
					j += i.toString();
					console.log(resData[j]["0"]);
					if(resData[j]["0"] > resData[j]["1"]) {
						valueOver[valueOver.length] = [categories[i], Math.round(resData[j]["0"]), Math.round(resData[j]["1"])];
					} else {
						valueLess[valueLess.length] = [categories[i], Math.round(resData[j]["0"]), Math.round(resData[j]["1"])];
					}
			}
			console.log(valueOver);
			google.charts.setOnLoadCallback(drawChart(valueLess, valueOver));
		}).catch(error => {
			console.log("비정상 응답 ", error);
		});
	}
	
    function drawChart(valueLess, valueOver) {
        var data = google.visualization.arrayToDataTable(valueLess);
		var options = {
			chart: {
				title: '현명한 소비습관',
				subtitle: '동 소득군 평균 대비 저소비 항목',
			},
			bars: 'horizontal' // Required for Material Bar Charts.
		};
        var chart = new google.charts.Bar(document.getElementById('barchart_material1'));
        chart.draw(data, google.charts.Bar.convertOptions(options));
        
        var data = google.visualization.arrayToDataTable(valueOver);
		var options = {
			chart: {
				title: '개선 가능한 소비습관',
				subtitle: '동 소득군 평균 대비 과소비 항목',
			},
			bars: 'horizontal' // Required for Material Bar Charts.
		};
        var chart = new google.charts.Bar(document.getElementById('barchart_material2'));
        chart.draw(data, google.charts.Bar.convertOptions(options));
      }  
	
	function getExpenseRateCouple(boy,girl,incomeSum){
		valueOver = []; valueLess = [];
		var data = '{"userId1":"'+boy+'","userId2":"'+girl+'","incomeSum":'+incomeSum+'}';
		var self = '부부';
		
		valueOver[0] = ['category', self + ' 지출','소득분위 평균지출'];
		valueLess[0] = ['category', self + ' 지출','소득분위 평균지출'];
		var categories = ['','식료품','주류','의류','주거','가정','보건','교통','통신','오락','교육','음식','기타'];
		axios.post("http://localhost:8000/getExpenseRateCouple",JSON.parse(data))
		.then(resData => {
			resData = resData.data;
			for(var i = 1 ; i <= 12; i++) {
				j = '';
				if(i<10){
					j = '0';
				}
					j += i.toString();
					console.log(resData[j]["0"]);
					if(resData[j]["0"] > resData[j]["1"]) {
						valueOver[valueOver.length] = [categories[i], Math.round(resData[j]["0"]), Math.round(resData[j]["1"])];
					} else {
						valueLess[valueLess.length] = [categories[i], Math.round(resData[j]["0"]), Math.round(resData[j]["1"])];
					}
			}
			console.log(valueOver);
			google.charts.setOnLoadCallback(drawChart(valueLess, valueOver));
		}).catch(error => {
			console.log("비정상 응답 ", error);
		});
	}
</script>



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
					<a href="#home"><font color="white" size="5"><p>SoL
								Assets</p></font></a>
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
							<li><a class="appao-btn" href="/conSelf">세부 내역 보기</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- header section end -->
	<!-- hero area start -->
	<section class="hero-area" id="home">
		<div class="container">
			<div class="row">
				<div class="col-lg-7">
					<div class="hero-area-content">
						<h1>한눈에 볼 수 있는 자산 현황 관리 Flatform</h1>
						<p>
							독박 재테크 탈출! <br> 부부 사이에도 투명한 자산관리를 위하여! <br>
						</p>
						<!-- <a href="#" class="appao-btn">App Store</a> -->
					</div>
				</div>
				<div class="col-lg-4">
					<div class="hand-mockup text-lg-left text-center">
						<img src="assets/img/hand-mockup2.png" alt="Hand Mockup" />
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- hero area end -->
	<!-- showcase section start -->
	<section class="showcase-area ptb-90">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="sec-title">
						<h2>
							신한 부부 자산 궁합<span class="sec-title-border"><span></span><span></span><span></span></span>
						</h2>
						<p>안전한 미래를 위한 부부의 소비 성향 및 투자 성향 확인!</p>
					</div>
				</div>
			</div>
			<div class="row flexbox-center">
				<div class="col-lg-6">
					<div class="single-showcase-box">
						<div id="chartLoc">
							<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소비
								패턴 궁합 보러 가기</h4>
							<p>부부 소비 패턴을 분석 하여 얼마 만큼의 시너지를 내는지 궁합으로 볼 수 있습니다!</p>
							<button onclick="getExpenseRate('boy2019',3000000)"
								class="appao-btn appao-btn2">나의 소비 패턴</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button onclick="getExpenseRate('girl2019',2500000)"
								class="appao-btn appao-btn2">배우자 소비 패턴</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button
								onclick="getExpenseRateCouple('boy2019','girl2019',5500000)"
								class="appao-btn appao-btn2">부부 소비 패턴</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="single-showcase-box">
					<div id="chart-container" default></div>
				</div>
		<div id="api"></div>
		<div id="barchart_material1" style="width: 900px; height: 500px;"></div>
		<br><hr><br>	
		<div id="barchart_material2" align="center" style="width: 900px; height: 200px;"></div>
			</div>
		</div>
	</section>
	<!-- showcase section end -->
	<!-- pricing section start -->
	
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.slicknav.min.js"></script>
	<script src="assets/js/slick.min.js"></script>
	<script src="assets/js/owl.carousel.min.js"></script>
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<script src="assets/js/jquery.counterup.min.js"></script>
	<script src="assets/js/waypoints.min.js"></script>
	<script src="assets/js/jquery.mb.YTPlayer.min.js"></script>
	<script src="assets/js/gmap3.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBnKyOpsNq-vWYtrwayN3BkF3b4k3O9A_A"></script>
	<script src="assets/js/custom-map.js"></script>
	<script src="assets/js/wow-1.3.0.min.js"></script>
	<script src="assets/js/switcher.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>