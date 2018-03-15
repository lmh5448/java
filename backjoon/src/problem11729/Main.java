package problem11729;

import java.util.Scanner;

public class Main {
	static void solve(int n, int x, int y){
		if(n==0)return;
		solve(n-1,x,6-x-y);
		System.out.println(x+" "+y);
		solve(n-1,6-x-y,y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int)(Math.pow(2, n)-1));
		solve(n,1,3);
	}
}
