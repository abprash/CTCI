package chap_5;

public class FlipBits {
	
	//we have a number
	//we should flip only 1 bit from 0 to 1, and find the longest seq of 1s possible with the newly flipped bit
	
	public void flipBits(int num){
		int maxCount = 0;
		String s = Integer.toBinaryString(num);
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '0'){
				//go left
				int count = 1;
				int pos = i;
				pos--;
				while(pos >= 0 && s.charAt(pos) == '1'){
					pos--;
					count++;
				}
				//go right
				pos = i;
				pos++;
				while(pos < s.length() && s.charAt(pos) == '1'){
					pos++;
					count++;
				}
				maxCount = Math.max(count,  maxCount);
			}
		}
		System.out.println(maxCount);
	}
	
	public static void main(String[] args){
		new FlipBits().flipBits(1775);
	}

}
