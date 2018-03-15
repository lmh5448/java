package problem2089;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int temp = sc.nextInt();
		Stack<Integer> result = new Stack<>();
		while(true){
			if(temp%(-2)==-1){
				result.push(1);
				temp/=-2;
				temp+=1;
			}else{
				result.push(temp%(-2));
				temp/=-2;
			}
			if(temp==0){break;}
		}
		while(!result.isEmpty()){
			System.out.print(result.pop());
		}
	}

}
