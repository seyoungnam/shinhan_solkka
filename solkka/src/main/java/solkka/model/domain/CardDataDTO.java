package solkka.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDataDTO {
	String userId; // 사용자 ID
	String cardType; // 카드종류 : 체크, 신용
	String apprvDate; // 승인일자
	String cat; // 소비 분류 (12분야)
	int apprvAmount; // 승인금액
	String storeName; // 가맹점명
}
