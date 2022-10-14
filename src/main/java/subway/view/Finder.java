package subway.view;

import java.util.Scanner;

public class Finder {

	private Scanner scanner;

	public Finder(Scanner scanner) {
		this.scanner = scanner;
	}

	public void start() {
		View.MAIN.print();
		String command = scanner.next();
		if ("Q".equals(command)) {
			return;
		}

		View.FIND.print();
		command = scanner.next();
		if ("B".equals(command)) {
			start();
		}

		if (Integer.parseInt(command) == 1) {

		}

		if (Integer.parseInt(command) == 2) {

		}
	}
}
