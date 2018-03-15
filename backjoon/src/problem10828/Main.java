package problem10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<Integer>();
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- >0){
			String temp = sc.nextLine();
			String[] temp2 = temp.split(" ");
			if(temp2[0].equals("push")){
				s.push(Integer.parseInt(temp2[1]));
			}
			if(temp2[0].equals("pop")){
				if(s.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(s.pop());
				}
			}
			if(temp2[0].equals("size")){
				System.out.println(s.size());
			}
			if(temp2[0].equals("empty")){
				if(s.isEmpty()){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
			}
			if(temp2[0].equals("top")){
				if(s.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(s.peek());
				}
			}
		}
	}
}
