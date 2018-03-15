package problem9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- >0){
			stack.clear();
			boolean chk = false;
			String temp  = sc.nextLine();
			for(int i=0; i<temp.length();i++){
				if(temp.charAt(i)=='('){
					stack.push(temp.charAt(i)+"");
				}else if(temp.charAt(i)==')'){
					if(stack.isEmpty()){
						System.out.println("NO");
						chk=true;
						break;
					}else{
						stack.pop();
					}
				}
			}
			if(stack.isEmpty()&&chk==false)System.out.println("YES");
			else if(chk==false)System.out.println("NO");
		}
	}
}
