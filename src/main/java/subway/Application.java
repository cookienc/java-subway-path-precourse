package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.Finder;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        init();

        Finder finder = new Finder(scanner);
        finder.start();
        scanner.close();
    }

    private static void init() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        Line lineTwo = new Line("2호선");
        lineTwo.addSection(new Section("교대역", "강남역", 2, 3));
        lineTwo.addSection(new Section("강남역", "역삼역", 2, 3));
        LineRepository.addLine(lineTwo);


        Line lineThree = new Line("3호선");
        lineThree.addSection(new Section("교대역", "남부터미널역", 3, 2));
        lineThree.addSection(new Section("남부터미널역", "양재역", 6, 5));
        lineThree.addSection(new Section("양재역", "매봉역", 1, 1));
        LineRepository.addLine(lineThree);


        Line sinBunDang = new Line("신분당선");
        sinBunDang.addSection(new Section("강남역", "양재역", 2, 8));
        sinBunDang.addSection(new Section("양재역", "양재시민의숲역", 10, 3));
        LineRepository.addLine(sinBunDang);
    }
}
