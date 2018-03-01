package chap_4;

import java.util.*;
public class BuildOrder {
	
	//build order
	//given a list of projects
	public List<Character> buildOrder(char[][] dependencies){
		//in each row, the first project is dependent on the second project
		List<Character> projects = new ArrayList<>();
		int[] degrees = new int[projects.size()];
		
		List<Character> ans = new ArrayList<Character>();

		Set<Character> visited = new HashSet<Character>();
		//assuming they are loaded with the projects
		Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();

		for(Character c : projects)
			map.put(c, new ArrayList<Character>());
		Queue<Character> queue = new LinkedList<Character>();
		//now lets load up the dependencies
		for(char[] dep : dependencies){
			char start = dep[1];
			char end = dep[0];
			degrees[end-'a']++;
			map.get(start).add(end);
		}
		//find the projects with zero in degree first
		for(int i=0; i<degrees.length; i++){
			if(degrees[i] == 0)
				queue.offer(Character.toString((char) i));//will add e and f
		}

		//now start bfs from them
		while(!queue.isEmpty()){
			//
			char now = queue.poll();
			if(visited.contains(now))
				continue;
			//add to the visited set
			visited.add(now);
			//add to the ans
			ans.add(now);
			//get the neighbors
			List<Character> neighbors = map.get(now);
			if(neighbors.size() > 0){
				for(char c : neighbors)
					if(!visited.contains(c))
						queue.add(c);
			}
		}
		return ans;
	}

}
