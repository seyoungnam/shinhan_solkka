package solkka.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqExp {
	private Long id;
	private double foodIn;
	private double living;
	private double health;
	private double trans;
	private double wireless;
	private double foodOut;
	private nonLiv nonLiving;
}
/*
 식료품 · 비주류음료
주거 · 수도 · 광열
보건
교통
통신
음식 · 숙박
비소비지출
 */
