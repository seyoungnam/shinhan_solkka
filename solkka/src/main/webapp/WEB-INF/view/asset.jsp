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
  function getExpenseRate(userId,income){
     var data = '{"userId":"'+userId+'","income":'+income+'}';
     var value = "[['category','average','myCost']";
     var categories = ["식료품","주류","의류","주거","가정","보건","교통","통신","오락","교육","음식","기타"];
     if(userId=="boy2019"){
    	 let reqCardData = {"userId":"girl2019"}
         axios.post("http://localhost:8000/getCardData",JSON.parse(reqCardData)).then(resData => {
            resData = resData.data;
                for(var i = 1 ; i <= 12; i++){
                   var j = '';
                  if(i<10){
                      j = '0'+i.toString();
                  }else{
                     j =i.toString()
                  }
                  console.log(j);
                  console.log(resData[j]);
                  value = value + ',['+categories[i]+','+resData[j]["0"]+','+resData[j]["1"]+']';
                }
              value = value +"]";
         }).catch(error => {
               console.log("비정상 응답 ", error);
         });
     }else{
         axios.post("http://localhost:8000/getExpenseRate",JSON.parse(data))
         .then(resData => {
            resData = resData.data;
                for(var i = 1 ; i <= 12; i++){
                   var j = "";
                  if(i<10){
                      j = '0'+i.toString();
                  }else{
                     j =i.toString()
                  }
                  value = value + ',['+categories[i]+','+ resData[j]['0']+','+resData[j]['1']+']';
                }
              value = value +"]";
         }).catch(error => {
               console.log("비정상 응답 ", error);
         });
     }
     var data1 = google.visualization.arrayToDataTable(value);
      var options = {
        chart: {
          title: 'Company Performance',
          subtitle: 'Sales, Expenses, and Profit: 2014-2017',
        },
        bars: 'horizontal' // Required for Material Bar Charts.
      };
      var chart = new google.charts.Bar(document.getElementById('barchart_material'));
      chart.draw(data1, google.charts.Bar.convertOptions(options));
}
  
  
  function getCardDataCouple(boy,girl,incomeSum){
     var data = '{"userId1":"'+boy+',"userId2":"'+girl+'","incomeSum":'+income+'"}';
         axios.post("http://localhost:8000/getExpenseRateCouple",JSON.parse(data))
         .then(resData => {
             document.getElementById("api").innerHTML = JSON.stringify(resData.data);
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
                     <li><a class="appao-btn" href="#">Download</a></li>
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
                     행복한 미래를 위하여!<br> 부부 사이에도 투명한 자산관리를 위하여! <br> 오빠 나 못 믿어?
                  </p>
                  <a href="#" class="appao-btn">음음음</a>
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
                     <button onclick="getExpenseRate('boy2019',5000000)"
                        class="appao-btn appao-btn2">나의 소비 패턴</button>
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <button onclick="getExpenseRate('boy2019',5000000)"
                        class="appao-btn appao-btn2">배우자 소비 패턴</button>
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <button onclick="getExpenseRateCouple('boy2019','girl2019',5000000)"
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
         </div>
      </div>
      </div>
      <div id="api"></div>
      <div id="barchart_material" style="width: 900px; height: 500px;"></div>
   </section>
   <!-- showcase section end -->
   <!-- pricing section start -->
   <section class="pricing-area ptb-90" id="pricing">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="sec-title">
                  <h2>
                     신한 은행 추천 금융 상품<span class="sec-title-border"><span></span><span></span><span></span></span>
                  </h2>
                  <p>당신의 목표를 이루기 위하여 아래 상품을 추천드립니다.</p>
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-lg-4">
               <div class="single-pricing-box">
                  <div class="pricing-top">
                     <h4>신한 첫급여 드림(DREAM) 적금</h4>
                     <p>적금상품</p>
                  </div>
                  <div class="price">
                     <h1>
                        <span>%</span>1.2 ~ 1.5
                     </h1>
                     <p>연이율</p>
                  </div>
                  <div class="price-details">
                     <ul>
                        <li>Email Marketing</li>
                        <li>Email Builder</li>
                        <li>Client Testing</li>
                        <li>Multiple Email Support</li>
                        <li>Email Read Receipent</li>
                        <li>2 User Free</li>
                     </ul>
                     <a class="appao-btn" href="#">Order Now</a>
                  </div>
               </div>
            </div>
            <div class="col-lg-4">
               <div class="single-pricing-box">
                  <div class="pricing-top">
                     <h4>Pro</h4>
                     <p>Suitable for Freelancer</p>
                  </div>
                  <div class="price">
                     <h1>
                        <span>$</span>199
                     </h1>
                     <p>Basic</p>
                  </div>
                  <div class="price-details">
                     <ul>
                        <li>Email Marketing</li>
                        <li>Email Builder</li>
                        <li>Client Testing</li>
                        <li>Multiple Email Support</li>
                        <li>Email Read Receipent</li>
                        <li>2 User Free</li>
                     </ul>
                     <a class="appao-btn" href="#">Order Now</a>
                  </div>
               </div>
            </div>
            <div class="col-lg-4">
               <div class="single-pricing-box">
                  <div class="pricing-top">
                     <h4>Ultimate</h4>
                     <p>Suitable for Freelancer</p>
                  </div>
                  <div class="price">
                     <h1>
                        <span>$</span>299
                     </h1>
                     <p>Basic</p>
                  </div>
                  <div class="price-details">
                     <ul>
                        <li>Email Marketing</li>
                        <li>Email Builder</li>
                        <li>Client Testing</li>
                        <li>Multiple Email Support</li>
                        <li>Email Read Receipent</li>
                        <li>2 User Free</li>
                     </ul>
                     <a class="appao-btn" href="#">Order Now</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
   <!-- pricing section end -->
   <!-- testimonial section start -->
   <a href="#" class="scrollToTop"> <i
      class="icofont icofont-arrow-up"></i>
   </a>
   <div class="switcher-area" id="switch-style">
      <div class="display-table">
         <div class="display-tablecell">
            <a class="switch-button" id="toggle-switcher"><i
               class="icofont icofont-wheel"></i></a>
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
   <!-- Gmap JS -->
   <script src="assets/js/gmap3.min.js"></script>
   <!-- Google map api -->
   <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBnKyOpsNq-vWYtrwayN3BkF3b4k3O9A_A"></script>
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