package solkka.controller;

import java.io.FileOutputStream;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RFileInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import solkka.service.SolkkaService;

@RestController
public class SolkkaController {
	@Autowired
	SolkkaService service;

//	@PostMapping("/apiTest")
//	public JSONObject apiTest(@RequestBody JSONObject body) throws Exception {
//		System.out.println("API TEST");
//		return service.callApi(body);
//	}

	@GetMapping("/recommend")
	public String idlePoint() {
		String answer = null;
		RConnection connection = null;
		try {
			connection = new RConnection();
			connection.eval("require(quadprog)");
			connection.eval("library(knitr)");
			connection.eval("library(rmdformats)");
			connection.eval("library(tidyverse)");
			connection.eval("library(tidyquant)");
			connection.eval("library(lubridate)");
			connection.eval("library(timetk)");
			connection.eval("library(DT)");
			connection.eval("library(PerformanceAnalytics)");
			connection.eval("library(PortfolioAnalytics)");
			connection.eval("stocks <- c(\"SHG\",\"LPL\",\"INTC\",\"TM\",\"BMW.DE\",\"HYMTF\",\"MSFT\")");
			connection.eval(
					"stock_data <- tq_get(stocks, get  = \"stock.prices\", from = Sys.Date() - months(12), to = Sys.Date()) ");
			connection.eval(
					"mo_returns <- stock_data %>% group_by(symbol) %>% tq_transmute(select = adjusted, mutate_fun = periodReturn, period = \"monthly\", col_rename = \"returns\") ");
			connection.eval(
					"stock_returns <- mo_returns %>% spread(key = symbol, value = returns) %>% tk_xts(date_var = date) %>%na.omit()");
			connection.eval("MV_QP<-function(nx, tarRet, Sig=NULL,long_only=FALSE){\n"
					+ "  if (is.null(Sig)) Sig=cov(nx)\n" + "  dvec=rep(0,ncol(Sig))\n" + "  meq=2\n"
					+ "  Amat=rbind(rep(1,ncol(Sig)),\n" + "             apply(nx,2,mean) )\n" + "  bvec=c(1,tarRet )\n"
					+ "  if (long_only) {\n" + "    meq=1\n" + "    Amat=Amat[-1,]\n" + "    Amat=rbind(Amat,\n"
					+ "               diag(1,ncol(Sig)),\n" + "               rep(1,ncol(Sig)),\n"
					+ "               rep(-1,ncol(Sig)))\n" + "    bvec=bvec[-1]\n" + "    bvec=c(bvec,\n"
					+ "           rep(0,ncol(Sig)),.98,-1.02)\n" + "  }\n"
					+ "  sol  <- solve.QP(Dmat=Sig, dvec, t(Amat), bvec, meq=meq)$solution \n" + "}");
			connection.eval("x<-stock_returns");
			connection.eval("µ.b <- apply(X = x, 2, FUN = mean)");
			connection.eval("long_only=TRUE");
			connection.eval("range.bl <- seq(from = min(µ.b), to = max(µ.b)*ifelse(long_only,1,1.6), length.out = 50)");
			connection.eval("risk.bl <- t(sapply(range.bl, function(targetReturn) { \n"
					+ "  w <- MV_QP(x, targetReturn,long_only=long_only) \n" + "  c(sd(x %*% w),w)  }))");
			connection.eval("weigthsl=round(risk.bl[,-1],4)");
			connection.eval("colnames(weigthsl)=colnames(x)");
			connection.eval("risk.bl=risk.bl[,1]");
			connection.eval("rets.bl<- (weigthsl%*%µ.b)*12");
			double returnValue = connection.eval("rets.bl[which.min(risk.bl),]").asDouble();
			double risk = connection.eval("min(risk.bl)").asDouble();
			double[] investRatio = connection.eval("weigthsl[which.min(risk.bl),]").asDoubles();
			String[] investName = connection.eval("colnames(weigthsl)").asStrings();
			connection.close();
			answer = getString(returnValue, risk, investRatio, investName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	//서비스단으로 이동 필요
	public String getString(double returnV, double risk, double[] investRatio, String[] investName) {
		String answer = null;
		int size = investRatio.length;
		answer = "{\"기대수익률\":\"" + returnV + "\",\"리스크\":\"" + risk + "\",\"추천투자비율\":{";
		for (int i = 0; i < size - 1; i++) {
			answer = answer + "\"" + investName[i] + "\":\"" + investRatio[i] + "\",";
		}
		answer = answer + "\"" + investName[size - 1] + "\":\"" + investRatio[size - 1] + "\"}}";
		System.out.println(answer);
		return answer;
	}

	@PostMapping("man")
	public void manGraph() {
		RConnection connection = null;
		try {
			connection = new RConnection();
			connection.eval("library(fmsb)");
			connection.eval("data <- as.data.frame(matrix( c(5,200,300,50,150,220) , ncol=6))");
			connection.eval("colnames(data) <-c(\"a\",\"b\",\"c\",\"d\",\"e\",\"f\")");
			connection.eval("data <- rbind(rep(500,6) , rep(0,6) , data)");
			connection.eval("jpeg(\"man.jpg\")");
			connection.eval("radarchart(data)");
			connection.eval("dev.off()");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
