package a_stringsAndArrays;

public class StringRotation {

	public static boolean isSubstring(String needle, String haystack){
		if(haystack.indexOf(needle) >= 0)
			return true;
		else
			return false;
	}
	/*
	public static boolean isRotation(String s1, String s2){
		//to verify is s1 or s2 is a rotation of the other
		if(s1 == null || s2 == null)
			return false;
		// start at the first char
		// 
		int l1 = s1.length();
		int l2 = s2.length();
		if(l1 != l2)
			return false;
		
		return isSubstring(s2,s1+s1);
	}
	
	*/
	
	//given two strings, we need to check if the s1 is the rotation of the other 
	//waterbottle is the rotation of erbottlewat
	//and do this with only one call to isSubstring()
	
	
	public boolean isRotation(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 )
			return false;
		
		if(s1.length() != s2.length())
			return false;
		
		return isSubstring(s1, s1+s2);
	}
}
