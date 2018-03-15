package problem9663;

import java.util.Scanner;

public class Main {
	static int ans = 0;
	static int n;
	static boolean[][] a;
	public static void calc(int row){
		if(row == n){
			ans+=1;
		}
		for(int col=0;col<n;col++){
			a[row][col] = true;
			if(check(row,col)){
				calc(row+1);
			}
			a[row][col] = false;
		}
	}
	
	public static boolean check(int row, int col){
		for(int i=0;i<n;i++){
			if(i==row)continue;
			if(a[i][col]){
				return false;
			}
			int j = col+i-row;
			if(j>=0 && j<n && a[i][j])return false;
			j = row+col-i;
			if(j>=0 && j<n && a[i][j])return false;
			/*for(int j=0;j<n;j++){
				if(((row-i)==(col-j)) && a[i][j])return false;
				if(((row+col)==(i+j)) && a[i][j])return false;
			}*/
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new boolean[n+1][n+1];
		calc(0);
		System.out.println(ans);
	}
}
