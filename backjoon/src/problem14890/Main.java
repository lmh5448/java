package problem14890;

import java.util.Scanner;

public class Main {
	public static boolean check(int[][] a, int d,int n,int l,int i,int j,int sum){
		//d 방향, n은 배열의 크기, l경사로의 크기, i j 인덱스
		if(d==0){
			if(j+1==n){
				if(sum>=0){
					return true;
				}else{
					return false;
				}
			}
			if(a[i][j] == a[i][j+1]){
				return check(a,d,n,l,i,j+1,sum+1);
			}else if(a[i][j] == a[i][j+1]+1){
				if(sum>=0){
					return check(a,d,n,l,i,j+1,1-l);
				}else{
					return false;
				}
			}else if(a[i][j] == a[i][j+1]-1){
				if(sum-l>=0){
					return check(a,d,n,l,i,j+1,1);
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else if(d==1){
			if(j+1==n){
				if(sum>=0){
					return true;
				}else{
					return false;
				}
			}
			if(a[j][i] == a[j+1][i]){
				return check(a,d,n,l,i,j+1,sum+1);
			}else if(a[j][i] == a[j+1][i]+1){
				if(sum>=0){
					return check(a,d,n,l,i,j+1,1-l);
				}else{
					return false;
				}
			}else if(a[j][i] == a[j+1][i]-1){
				if(sum-l>=0){
					return check(a,d,n,l,i,j+1,1);
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++){
			if(check(a,0,n,l,i,0,1)){
				ans++;
			}
			if(check(a,1,n,l,i,0,1)){
				ans++;
			}
		}
		System.out.println(ans);
	}
}
