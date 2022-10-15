package subway.view;

import subway.utils.Text;

import java.util.List;
import java.util.function.Supplier;

public enum View {
	MAIN(View::getMainPage), FIND(View::getFindPage),
	START(View::startStation), END(View::endStation),
	RESULT(View::result),
	;

	private String message;

	View(Supplier<String> message) {
		this.message = message.get();
	}

	public void print() {
		System.out.println(message);
	}

	public void print(List<String> shortestPath) {
		for (String path : shortestPath) {
			System.out.println(path);
		}
	}

	private static String getMainPage() {
		return Text.MAIN + Text.ROUTE + Text.QUIT + Text.SELECT;
	}

	private static String getFindPage() {
		return Text.TYPE + Text.MINIMUM_DISTANCE + Text.MINIMUM_TIME + Text.BACK + Text.SELECT;
	}

	private static String startStation() {
		return Text.START;
	}

	private static String endStation() {
		return Text.END;
	}

	private static String result() {
		return Text.RESULT;
	}
}
