package chap_5;

public class Insertion {
	
	public int insertion(int m, int n, int i, int j){
		//n >> m
		//we will be inserting m into n
		//we will loop thro the binary repr of n from pos i to j
		for(int pos=i; pos <= j; pos++ ){
			boolean isBitSet = (m & (1 << (pos-i))) != 0 ;
			n = updateBit(n, pos, isBitSet);
			//System.out.println(Integer.toBinaryString(n));
		}
		return n;
		
	}
	
	int updateBit(int num, int i, boolean isBitSet){
		int digit = isBitSet ? 1 : 0;
		int mask = ~(1 << i);
		return (num & mask) | (digit << i);
	}
	

	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(256));
		System.out.println(Integer.toBinaryString(7));
		System.out.println(Integer.toBinaryString(new Insertion().insertion(7, 256, 2, 4)));
		
	}
}
