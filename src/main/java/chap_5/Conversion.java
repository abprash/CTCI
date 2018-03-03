package chap_5;

public class Conversion {
	
	public void conversion(int a, int b){
		
		int count = 0;
		int res = a ^ b;
		String s = Integer.toBinaryString(res);
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='1')
				count++;
		}
		System.out.println(count);
	}
	
	public static void main(String[] args){
		new Conversion().conversion(29, 15);
	}
}
