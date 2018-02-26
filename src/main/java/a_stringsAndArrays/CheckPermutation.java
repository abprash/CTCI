package a_stringsAndArrays;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class CheckPermutation {

	public static boolean checkPermutation(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				count++;
				map.put(c, count);
			} else
				map.put(c, 1);
		}

		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				count--;
				map.put(c, count);
			} else
				return false;
		}

		// get the valueset
		Set<Entry<Character, Integer>> set = map.entrySet();
		int sum = 0;
		for (Entry<Character, Integer> e : set) {
			sum = sum + e.getValue();
		}

		if (sum == 0)
			return true;
		else
			return false;
	}
}
