package stringsAndArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class StringAndArrayLauncher {
	
	public static void main(String[] args){
		System.out.println(urlify1(new char[12]));
		String s1 = "mr john %20smith    ";
		char[] testWords = new char[s1.length()];
		for(int i=0; i<s1.length(); i++){
			testWords[i] = s1.charAt(i);
		}
		urlify2(testWords);
	}
	
	//Problem 1.1
	//page 90
	public static boolean isUnique(String t1){
		//should check if the string has all unique characters
		//return true or false
		//Method 1: hashmap
		//method 2: xor operator?
		
		
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<t1.length(); i++){
			
			char c = t1.charAt(i);
			if(map.containsKey(c)){
				return false;
			}
			map.put(c, 1);
		}
		return true;
	}
	
	public static boolean isUnique2(String t1){
		//should check if the string has all unique characters
		//return true or false
		//Method 1: hashmap
		//method 2: xor operator?
		
		
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		int result = 0;
		for(int i=0; i<t1.length(); i++){
			if(i == 0)
				result = t1.charAt(i);
			else
				result = result ^ ((int) t1.charAt(i));
			//System.out.println("char="+(int) t1.charAt(i)+","+""+result);
			/*
			char c = t1.charAt(i);
			if(map.containsKey(c)){
				return false;
			}
			map.put(c, 1);*/
		}
		//return true;
		if(result == 0)
			return false;
		else
			return true;
	}
	
	public static void isUniqueDriver(){
		String t1 = "jsdhfbk";
		String t2 = "sdfsdf";
		System.out.println(isUnique2(t1));
		System.out.println(isUnique2(t2));
		//blah1();
	}
	
	public static boolean isUnique3(String s){
		//assuming it contains (a-z) or (A-Z)
		if(s == null)
			return false;
		if(s == "")
			return false;
		//if it is only ascii characters then yeah there are only 128 characters
		//or if extended ascii then there are 256 characters
		if(s.length() > 128)
			return false;
		if(s.length() == 1)
			return true;
		int checker = 1;
		for(int i=0; i<s.length(); i++){
			int displacement = 1 << (s.charAt(i)- 'a');
			//check for duplicates
			
			if((checker & (displacement)) > 0) return false;
			checker = checker | displacement;
			System.out.println("checker == "+checker);
			
			//checker = checker  << (s.charAt(i) - 'a');
			//System.out.println(checker);
			
		}
		return true;
	}
	
	public static boolean checkPermutation(String s1, String s2){
		if(s1 == null || s2 == null)
			return false;
		if(s1.length() != s2.length())
			return false;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s1.length(); i++){
			char c = s1.charAt(i);
			if(map.containsKey(c)){
				int count = map.get(c);
				count++;
				map.put(c,count);
			}
			else
				map.put(c, 1);
		}
		
		for(int i=0; i<s2.length(); i++){
			char c = s2.charAt(i);
			if(map.containsKey(c)){
				int count = map.get(c);
				count--;
				map.put(c,count);
			}
			else
				return false;
		}
		
		//get the valueset
		Set<Entry<Character, Integer>> set = map.entrySet();
		int sum = 0;
		for(Entry<Character, Integer> e: set){
			sum = sum + e.getValue();
		}
		
		if(sum == 0)
			return true;
		else
			return false;
	}
	
	
	
	public static char[] urlify2(char[] testWords){
		//did not work yet
		//char[] temp = new char[20];
		//String s1 = "mr john %20smith    ";
		//String s2 = "error stringy df    ";
		String s1= new String(testWords);
		for(int i=0; i<s1.length(); i++){
			testWords[i] = s1.charAt(i);
		}
		int lastLetterPosition = 0;
		int spaceCounter = 0;
		//find where the last word ends in the string
		for(int i=s1.length()-1; i>=0; i-- ){
			if(s1.charAt(i) != ' ' && lastLetterPosition==0){
				lastLetterPosition = i;
			}
			if(lastLetterPosition > 0){
				//start counting spaces
				if(s1.charAt(i) == ' ')
					spaceCounter++;
			}
		}
		System.out.println("LL "+lastLetterPosition);
		System.out.println("SC "+spaceCounter);
		int l = lastLetterPosition;
		int r = testWords.length-1;
		while(spaceCounter > 0){
			//should break out when spaceCounter = 0,
			if(testWords[l] == ' ')
				spaceCounter--;
			if(testWords[l] != ' ' && testWords[r] == ' '){
				testWords[r] = testWords[l];
				testWords[l] = ' ';
				l--;
				r--;
			}
			else if(testWords[l] ==' ' && testWords[r] == ' '){
				testWords[r] = '0';
				testWords[r-1] = '2';
				testWords[r-2] = '%';
				r=r-3;
				l--;
			}
		}
		System.out.println("-->"+Arrays.toString(testWords));
		return testWords;
	}
	
	

}

