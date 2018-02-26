package a_stringsAndArrays;

public class StringCompression {

	public static String basicStringCompressor(String test) {
		// 1. hashtable
		// 2. or basic stringbuilders

		// aabccccccaaa -> a2b1c6a3
		// if the resultant string is smaller than the input string do it else
		// no
		if (test == null)
			return null;
		if (test.length() <= 2)
			return test;
		StringBuilder sb = new StringBuilder();
		char previousChar = test.charAt(0);
		int currentCount = 1;
		int previousCount = 0;
		for (int i = 1; i < test.length(); i++) {
			char currentChar = test.charAt(i);

			if (previousChar == currentChar)
				currentCount++;
			if (previousChar != currentChar) {
				sb.append(previousChar);
				sb.append(currentCount);
				currentCount = 1;
				previousChar = currentChar;
			}
			if (i == test.length() - 1) {
				sb.append(currentChar);
				sb.append(currentCount);
				currentCount = 0;
			}
		}
		// System.out.println(new String(sb));
		if (new String(sb).length() > test.length())
			return test;
		else
			return new String(sb);
	}

	public static String basicStringDecompressor(String test) {
		final String invalidString = "Invalid input String";
		// input string will basically be in the format of
		// <char><count>
		// char will always be single
		// but the count will be single, double or even triple digit
		if (test == null)
			return null;
		if (test.length() <= 1)
			return invalidString;
		
		StringBuilder ans = new StringBuilder();
		int letterPointer = 0;
		int digitPointer = 1;
		if (!Character.isLetter(test.charAt(letterPointer)))
			return invalidString;
		if (!Character.isDigit(test.charAt(digitPointer)))
			return invalidString;
		// int count = 0;
		// count =
		// Integer.parseInt(Character.toString(test.charAt(countPointer)));

		StringBuilder count = new StringBuilder();
		char currentChar = test.charAt(letterPointer);
		while (digitPointer < test.length()) {
			// keep parsing the number
			//System.out.println("LP "+letterPointer);
			//System.out.println("CountP "+countPointer);
			if (Character.isDigit(test.charAt(digitPointer))) {
				// if its 1
				count.append(Character.toString(test.charAt(digitPointer)));
				digitPointer++;
				currentChar = test.charAt(letterPointer);
				System.out.println("counts "+count);
			} else {
				int totalOccurences = Integer.parseInt(new String(count));
				System.out.println(totalOccurences);
				StringBuilder temp = new StringBuilder();
				for (int i = 0; i < totalOccurences; i++) {
					temp.append(currentChar);
				}
				ans.append(temp);
				System.out.println(ans);
				// change the pos of letter and count pointers
				//countPointer++;
				letterPointer = digitPointer;
				digitPointer = letterPointer + 1;
				count = new StringBuilder();
				/*if(letterPointer >= test.length())
					break;
				if(digitPointer >= test.length())
					break;*/
				currentChar = test.charAt(letterPointer);	
			}
			if(digitPointer == test.length()-1){
				count.append(Character.toString(test.charAt(digitPointer)));
				int totalOccurences = Integer.parseInt(new String(count));
				System.out.println(totalOccurences);
				StringBuilder temp = new StringBuilder();
				for (int i = 0; i < totalOccurences; i++) {
					temp.append(currentChar);
				}
				ans.append(temp);
			}
		}
		return new String(ans);
	}
}
