package cc.june20b;

import java.util.Scanner;
import java.util.Stack;

public class GUESSG {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		guess(scanner);
		scanner.close();
		
	}
	
	private static void guess(Scanner scanner) {
		
		int n = Integer.parseInt(scanner.nextLine());
		
		int l = 1;
		int r = n;
		
		int num = 0;
		String response = "E";
		Stack<String> stack = new Stack<>();
		
		while(true) {
			
			num = (l+r)/2;
			
			System.out.println(num);
			
			response = scanner.nextLine();
			
			if(response.equalsIgnoreCase("E")) {
				break;
			}
			
			if(stack.isEmpty()) {
				stack.add(response);
			}
			else {
				
				String lastResponse = stack.pop();
				
				if(response.equalsIgnoreCase(lastResponse)) {
					
					if(response.equalsIgnoreCase("G")) {
						l = num + 1;
					}
					else {
						r = num - 1;
					}
					
				}
				else {
					stack.add(response);
				}
				
			}
			
		}
		
	}
	
}
