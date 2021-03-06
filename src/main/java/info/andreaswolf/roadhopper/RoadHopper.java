package info.andreaswolf.roadhopper;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.routing.Path;
import com.graphhopper.routing.QueryGraph;
import com.graphhopper.storage.Graph;
import info.andreaswolf.roadhopper.route.Route;

import java.util.List;

public class RoadHopper extends GraphHopper
{

	protected QueryGraph queryGraph;

	public Route createRoute(GHRequest request) {
		return new Route(getPaths(request));
	}

	public List<Path> getPaths(GHRequest request)
	{
		GHResponse response = new GHResponse();
		List<Path> paths = getPaths(request, response);

		return paths;
	}

	@Override
	protected QueryGraph createQueryGraph(Graph routingGraph)
	{
		// store the query graph for usage outside this class
		queryGraph = super.createQueryGraph(routingGraph);

		return queryGraph;
	}

	public QueryGraph getQueryGraph()
	{
		return queryGraph;
	}
}
