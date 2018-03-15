package problem11005;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		String[] chg = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		Stack<String> temp = new Stack<>();
		while(a!=0){
			temp.push(chg[a%b]);
			a = a/b;
		}
		int tempSize = temp.size();
		for(int i=0;i<tempSize;i++){
			System.out.print(temp.pop());
		}System.out.println();
	}
}
