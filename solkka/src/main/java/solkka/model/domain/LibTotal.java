package solkka.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibTotal {
	private Long id;
	
	// 총자본 -> 같은 id값 총 자산 - 총 부채 = 총 자본(순자산) 이라 필요 없을 것 같기도 하고..
}
/* 총 부채 세부 테이블
은행대출잔액
금투대출잔액
보험대출잔액
 */
