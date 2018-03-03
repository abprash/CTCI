package chap_5;

public class BinaryToString {
	//given a real number between 0 and 1, (0.72), passed as a double
	//if it cannot be represented as a 32 chars, then return error
	public static void main(String[] args){
		double d = 1.23;
		float f = 1.23f;
		System.out.println(Double.valueOf(d).equals(Float.valueOf(f)));
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(1.78)));//1061783605
		System.out.println(Long.toBinaryString(Float.floatToIntBits(1.78f)));//1061783605
	}

}
