package solkka.model.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CardDataDTO {
	long dataId; // 승인번호
	String userId; // 사용자 ID
	String cardType; // 카드종류 : 체크, 신용
	String apprvDate; // 승인일자
	String cat; // 소비 분류 (12분야)
	BigDecimal apprvAmount; // 승인금액
	String store; // 가맹점명
}
