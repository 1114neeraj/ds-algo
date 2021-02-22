package leetcode.easy;

public class RotateString {

	public boolean rotateString(String A, String B) {
		
		if(A.length() != B.length()) {
			return false;
		}
		
		String C = A + A;
		
		return C.contains(B);
	}
	
	public static void main(String[] args) {
		RotateString solution = new RotateString();
		String A = "";
		String B = "";
		System.out.println(solution.rotateString(A, B));
	}

}
