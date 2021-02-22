
public class Test {

	public static void main(String[] args) {
		
//		int sum = 0;
//		
//		for(int i=3;i<=20;i++) {
//			System.out.println(findNextSpecialNumber(i));
//		}
//		
//		findNextSpecialNumber(12);
//		
//		System.out.println(sum);
		System.out.println((int)(Math.random()*26));
	}
	
	private static int findNextSpecialNumber(int num) {

        int temp = num;

        int result = 0;
        int count = 0;
        boolean carry = false;

        int lsd = 0;

        boolean isSpecial = true;

        while(temp!=0) {
            lsd = temp%10;

            if(lsd!=2 && lsd != 5) {
                isSpecial = false;
            }

            if(lsd < 2) {
                lsd = 2;
            }
            else if(lsd < 5){
                lsd = 5;
            }
            else {
                lsd = 2;
                carry = true;
            }

            result += lsd*((int)Math.pow(10, count));

            count++;
            temp = temp/10;
        }

        if(isSpecial) {
            return num;
        }

        if(carry) {
            result += lsd*((int)Math.pow(10, count));
        }

        return result;
    }
}
