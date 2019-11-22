package solkka.model.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CardData {
	String userId; // 사용자 ID
	String apprvDate; // 승인일자
	BigDecimal apprvNum; // 승인번호
	BigDecimal apprvAmount; // 승인금액
	BigDecimal cat; // 분류
	String store; // 가맹점명
}
