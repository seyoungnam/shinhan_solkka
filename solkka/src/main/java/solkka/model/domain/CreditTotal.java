package solkka.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditTotal {
	// id, name 필요할 것 같아서 임의로 만듬
	private Long id;
	// int? double? ?_?
	private double bankLibBal;
	private double finLibBal;
	private double insLibBal;
}
/* 총 부채 세부 테이블
은행대출잔액
금투대출잔액
보험대출잔액
 */
