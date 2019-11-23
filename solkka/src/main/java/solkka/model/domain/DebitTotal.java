package solkka.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 롬복 안먹어서 dependency에 version태그 추가해서 수정함
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitTotal {
	// id 필요할 것 같아서 임의로 만듬
	private Long id;
	// int? double? ?_?
	private double accBal;
	private double bankFundBal;
	private double trustBal;
	private double isaBal;
	private double stockBal;
	private double endowIns;
	
}
/* 총 자산 세부 테이블
 예적금잔액
은행펀드잔액
신탁잔액
ISA잔액
주식잔액
저축성보험
 */
