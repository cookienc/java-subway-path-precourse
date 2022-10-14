package subway.view;

import subway.utils.Text;

import java.util.function.Supplier;

public enum View {
	MAIN(View::getMainPage), FIND(View::getFindPage);

	private String message;

	View(Supplier<String> message) {
		this.message = message.get();
	}

	public void print() {
		System.out.println(message);
	}

	private static String getMainPage() {
		return Text.MAIN + Text.ROUTE + Text.QUIT + Text.SELECT;
	}

	private static String getFindPage() {
		return Text.TYPE + Text.MINIMUM_DISTANCE + Text.MINIMUM_TIME + Text.BACK + Text.SELECT;
	}
}
