package event;

import java.util.Arrays;

public enum EventType {
	ONEPLUSONE("1+1"),
	TWOPLUSONE("2+1"),
	TENPERCENT("10% 할인"),
	TWENTYPERCENT("20% 할인");

	private final String value;

	EventType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static String[] getValArr() {
		String[] arr = new String[EventType.values().length];

		int i = 0;
		for (EventType value : EventType.values()) {
			arr[i++] = value.getValue();
		}
		return arr;
	}

}
