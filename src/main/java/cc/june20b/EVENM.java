package cc.june20b;

import java.util.Scanner;

public class EVENM {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {
			int size = Integer.parseInt(scanner.nextLine());
			System.out.println(solveProblem(size));
		}

		scanner.close();
		
	}

	private static String solveProblem(int size) {
		
		StringBuilder builder = new StringBuilder();
		
		int count = 1;
		
		if( size % 2 !=0) {
			
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					builder.append(count).append(" ");
					count++;
				}
				builder.append("\n");
			}
			
		}
		else {
			
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					
					if(i%2==0) {
						builder.append(count).append(" ");
						count++;
					}
					else {
						
						if(count%2!=0) {
							builder.append(count + 1).append(" ");
						}
						else {
							builder.append(count - 1).append(" ");
						}
						count++;
					}
					
				}
				builder.append("\n");
			}
			
		}

		return builder.toString();
	}
	
}
