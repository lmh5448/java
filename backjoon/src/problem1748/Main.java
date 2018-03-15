package problem1748;

import java.util.Scanner;

public class Main{
	static int check(int n){
		int i = 0;
		
		while(n>0){
			n/=10;
			i++;
		}
		
		return i;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans = 0;
		for(int i=1;i<=n;i++){
			ans += check(i);
		}
		System.out.println(ans);
	}
}
