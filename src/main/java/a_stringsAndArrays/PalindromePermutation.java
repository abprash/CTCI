package a_stringsAndArrays;

public class PalindromePermutation {

	
	public static void main(String[] args){
		String s1 = "tact oca";//true
		String s2 = "tact ocaw";//false
		System.out.println(palindromePermutation(s1));
	}
	public static boolean palindromePermutation1(String test) {

		//
		int[] countArray = new int[52];
		if (test == null)
			return false;
		if (test.length() == 0 || test.isEmpty())
			return false;
		if (test.length() == 1)
			return true;
		int oddNumberCounter = 0;
		for (int i = 0; i < test.length(); i++) {
			int pos = 0;
			char c = test.charAt(i);
			// store the count
			// get the ascii position

			// find if its a cap or small letter
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c))
					pos = c - 'A';
				else
					pos = c - 'a' + 26;
				// countArray - [ABCD...XYZabc...xyz]
				System.out.println(pos);
				countArray[pos]++;
			}
		}
		// checking phase
		for (int i = 0; i < countArray.length; i++) {
			if (countArray[i] % 2 != 0)
				oddNumberCounter++;
			if (oddNumberCounter > 1)
				return false;
		}
		return true;

	}
	
	public static boolean palindromePermutation(String s1){
		if(s1 == null || s1.length() == 0 )
			return false;
		//get the xor value
		//if both strings length come to even -> result == 0
		//if both strings length are odd, -> result == 1
		
		int res = s1.charAt(0);
		int total = 1;
		for(int i=1; i< s1.length(); i++){
			if(s1.charAt(i) != ' '){
				System.out.println(res);
				res = res ^ s1.charAt(i);
				total++;
			}
		}
		System.out.println(res+","+total);
		
		
		if(total%2 == 0 && res == 0 || total%2 == 1 && res != 0)
			return true;
		
		return false;
		
	}
	
}
