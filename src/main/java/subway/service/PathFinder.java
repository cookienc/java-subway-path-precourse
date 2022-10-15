package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class PathFinder {
	private static WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

	public void initialize(int type) {
		initVertex();
		initEdgeWeight(type);
	}

	public List<String> getShortestPath(String start, String end) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
		return dijkstraShortestPath.getPath(start, end)
				.getVertexList();
	}

	private void initEdgeWeight(int type) {
		List<Section> sections = LineRepository.findAllSections();

		for (Section section : sections) {
			initWeight(section, type);
		}
	}

	private void initWeight(Section section, int type) {
		if (type == 1) {
			graph.setEdgeWeight(addEdge(section), section.findDistance());
			return;
		}
		graph.setEdgeWeight(addEdge(section), section.findTime());
	}

	private DefaultWeightedEdge addEdge(Section section) {
		return graph.addEdge(section.findUpStationName(), section.findDownStationName());
	}

	private void initVertex() {
		List<Station> stations = StationRepository.getAllStations();
		for (Station station : stations) {
			graph.addVertex(station.getName());
		}
	}
}
