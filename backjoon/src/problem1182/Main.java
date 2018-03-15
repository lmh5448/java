package problem1182;

import java.util.Scanner;

public class Main {
	static int go(int[] a, int index, int sum, int n, int s){
		if(index==n){
			if(sum == s)return 1;
			else return 0;
		}
		return go(a,index+1,sum+a[index],n,s)+go(a,index+1,sum,n,s);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int ans = go(a,0,0,n,s);
		if(s==0){
			ans--;
		}
		System.out.println(ans);
	}
}
