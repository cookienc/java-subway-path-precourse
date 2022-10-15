package subway.view;

import subway.service.PathFinder;

import java.util.List;
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

		int type = Integer.parseInt(command);
		if (type == 1 || type == 2) {
			PathFinder pathFinder = new PathFinder();
			pathFinder.initialize(type);

			View.START.print();
			String startStation = scanner.next();
			View.END.print();
			String endStation = scanner.next();

			List<String> shortestPath = pathFinder.getShortestPath(startStation, endStation);

			View.RESULT.print(shortestPath);

		}
	}
}
