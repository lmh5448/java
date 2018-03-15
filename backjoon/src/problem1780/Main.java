package problem1780;

import java.util.Scanner;

public class Main {
	static int[][] a;
	static int[] cnt = new int[3];
	static void solve(int x, int y, int n){
		if(same(x,y,n)){
			cnt[a[x][y]+1]++;
			return;
		}
		int m = n/3;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				solve(x+i*m, y+j*m, m);
			}
		}
	}
	
	static boolean same(int x, int y, int n){
		for(int i=x;i<x+n;i++){
			for(int j=y;j<y+n;j++){
				if(a[x][y] != a[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j] = sc.nextInt();
			}
		}
		solve(0,0,n);
		for(int i=0;i<3;i++){
			System.out.println(cnt[i]);
		}
	}
}
