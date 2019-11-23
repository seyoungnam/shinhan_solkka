package solkka.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class nonLiv {
	private double bankInt;
	private double finInt;
	private double insInt;
}
/* 비소비지출
은행대출이자
금투대출이자
보험대출이자 
 */