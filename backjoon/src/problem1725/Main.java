package problem1725;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int ans = 0;
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<n;i++){
			while(!s.isEmpty() && a[s.peek()] > a[i]){
				int height = a[s.peek()];
				s.pop();
				int width = i;
				if(!s.isEmpty()){
					width = (i-s.peek()-1);
				}
				ans = Math.max(ans, width*height);
			}
			s.push(i);
		}
		while(!s.isEmpty()){
			int height = a[s.peek()];
			s.pop();
			int width = n;
			if(!s.empty()){
				width = n-s.peek()-1;
			}
			ans = Math.max(ans, width*height);
		}
		System.out.println(ans);
	}
}
