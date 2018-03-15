package problem11576;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int numLen = sc.nextInt();
		int sum = 0;
		Stack<Integer> result = new Stack<>();
		int[] anum = new int[numLen];
		for(int i=0;i<numLen;i++){
			anum[i] = sc.nextInt();
			sum = sum*a + anum[i];
		}
		while(sum!=0){
			result.push(sum%b);
			sum/=b;
		}
		while(!result.isEmpty()){
			System.out.print(result.pop()+" ");
		}
	}
}
