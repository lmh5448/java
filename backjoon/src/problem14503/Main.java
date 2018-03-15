package problem14503;

import java.util.Scanner;

public class Main {
	static int[] dx={-1,0,1,0};
	static int[] dy={0,1,0,-1};
	static int[][] a;
	static int n,m;
	static int ans = 1;
	static void dfs(int r,int c,int d){
		int nr,nc,nd=d;
		for(int i=0;i<4;i++){
			nd = (nd+3)%4;
			nr = r + dx[nd];
			nc = c + dy[nd];
			if(nr<0 || nr>=n || nc<0 || nc>=m)continue;
			if(a[nr][nc]==0){
				ans++;
				a[nr][nc]=2;
				dfs(nr,nc,nd);
				return;
			}
		}
		nd = (d+2)%4;
		nr = r + dx[nd];
		nc = c + dy[nd];
		if(a[nr][nc]==1){
			return;
		}else{
			dfs(nr,nc,d);
		}
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		a = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
			}
		}
		a[r][c] = 2;
		dfs(r,c,d);
		System.out.println(ans);
	}
}
/*
 * 
 * 
이번에 찾은 오류는 아.... 조건에서 r와 c가 하나 잘못되어있었다...
nr>=0 && nr<n && nc>=0 && nr<m << 좀 확실하게 보고 풀자..
import java.util.Scanner;

public class Main {
	static int[] dy={0,1,0,-1};
	static int[] dx={-1,0,1,0};
	static int ans = 1;
	
	public static void go(int[][] a,int n,int m,int r,int c,int d){
		
		for(int i=(d+3)%4,j=0;j<4;j++,i=(i+3)%4){
			int nr = r + dx[i];
			int nc = c + dy[i];
			if(nr>=0 && nr<n && nc>=0 && nc<m){
				if(a[nr][nc]==0){
					a[nr][nc] = 2;
					ans++;
					go(a,n,m,nr,nc,i);
					return;
				}
			}else{
				continue;
			}
		}
		int nr = r + dx[(d+2)%4];
		int nc = c + dy[(d+2)%4];
		if(a[nr][nc]==1){
			return;
		}else{
			go(a,n,m,nr,nc,d);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
			}
		}
		a[r][c]=2;
		go(a,n,m,r,c,d);
		System.out.println(ans);
		
	}
}
*/
