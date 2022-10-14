package subway.domain;

public class Section {
	private Station upStation;
	private Station downStation;
	private int distance;
	private int time;

	public Section(String upStation, String downStation, int distance, int time) {
		this.upStation = new Station(upStation);
		this.downStation = new Station(downStation);
		this.distance = distance;
		this.time = time;
	}
}
