package problem1644;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static boolean[] p;
	static int ans = 0;
	static void go(int index,int sum){
		if(sum>n)return;
		if(index>n+1)return;
		if(sum==n){
			ans++;
			return;
		}
		for(int i=index+1;i<=4000000;i++){
			if(p[i]){
				go(i,sum+i);
				return;
			}
		}
		return;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = new boolean[4000001];
		Arrays.fill(p, true);
		p[0]=false;
		p[1]=false;
		for(int i=2;i<=Math.sqrt((double)4000000);i++){
			for(int j=2;i*j<=4000000;j++){
				p[i*j]=false;
			}
		}
//		for(int i=0;i<1000;i++){
//			if(p[i]){
//				System.out.println("p : "+i);
//			}
//		}
//		System.out.println();
		for(int i=1;i<=n;i++){
			if(p[i]){
				go(i,i);
			}
		}
		System.out.println(ans);
	}
}
