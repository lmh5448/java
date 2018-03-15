package problem2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y,cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void bfs(int[][] a,int[][] chk,int x, int y,int n, int m, int cnt){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y,cnt));
		chk[x][y] = cnt;
		while(!q.isEmpty()){
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(a[nx][ny]==1 && chk[nx][ny]==0){
						q.add(new Pair(nx,ny,chk[x][y]+1));
						chk[nx][ny] = chk[x][y]+1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[][] a = new int[n][m];
		int[][] chk = new int[n][m];
		chk[0][0] = 1;
		for(int i=0;i<n;i++){
			String temp = sc.nextLine();
			for(int j=0;j<m;j++){
				a[i][j] = temp.charAt(j)-'0';
			}
		}
		bfs(a,chk,0,0,n,m,1);
		System.out.println(chk[n-1][m-1]);
	}
}
