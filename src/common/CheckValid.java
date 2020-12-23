package common;

import java.util.regex.Pattern;

public class CheckValid {
	// 유효성 검사 클래스

	public CheckValid() {
		// TODO Auto-generated constructor stub
	}

	// 상품코드 - 대문자 영문자 + 숫자 1~5개 조합
	public boolean isAlphaNum(String str) {
		return Pattern.matches("^[A-Z]{1}[0-9]{1,5}$", str);
	}

	// 공백여부 - 트림 후 공백인지 체크
	public boolean isStrEmpty(String str) {
		return str.trim().isEmpty();
	}

	// 가격 - 숫자 10~99999 원까지
	public boolean isNumeric(String str) {
		return Pattern.matches("^[1-9][0-9]{1,5}$", str);
	}

	// 수량 - 숫자 1~999까지
	public boolean isQtChk(String str) {
		return Pattern.matches("^([1-9])[0-9]{0,2}$", str);

	}

}
