package problem10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		Stack<String> s = new Stack<String>();
		int ans = 0;
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)=='('){
				s.push(temp.charAt(i)+"");
			}else if(temp.charAt(i)==')'){
				if(i>0 && temp.charAt(i-1)=='('){
					s.pop();
					ans += s.size();					
				}else{
					s.pop();
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
