package chap_4;


import java.util.*;

public class RouteBetweenNodes {
	// we are given 2 nodes, we need to find if there exists a route between
	// them

	public boolean isRouteBetweenNodes(int a, int b) {

		// assuming we have an adj list built with the nodes already present and
		// given
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		// assuming we have an adj list built with the nodes already present and
		// given
		// we should start with the node a
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		while (!q.isEmpty()) {
			// do a bfs
			int visit = q.poll();
			if (visited.contains(visit))
				continue;
			visited.add(visit);
			// get the neighbors
			List<Integer> neighbors = map.get(visit);
			if (neighbors.contains(b))
				return true;
			for (int i : neighbors) {
				if (!visited.contains(i))
					q.offer(i);
			}
		}
		return false;
	}
}
