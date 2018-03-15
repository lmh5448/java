package problem7576;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[n][m];
		int[][] chk = new int[n][m];
		for(int i=0;i<n;i++){
			Arrays.fill(chk[i], -1);
		}
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
				if(a[i][j]==1){
					q.add(new Pair(i,j));
					chk[i][j]=0;
				}
			}
		}
		int result = 0;
		int x,y;
		while(!q.isEmpty()){
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(a[nx][ny]==0 && chk[nx][ny]==-1){
						q.add(new Pair(nx,ny));
						a[nx][ny] = 1;
						chk[nx][ny] = chk[x][y]+1;
						result = Math.max(result, chk[nx][ny]);
					}
				}
			}
		}
		boolean ans = true;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(a[i][j]==0){
					ans = false;
					break;
				}
			}
		}
		if(ans)System.out.println(result);
		else System.out.println(-1);
	}
}
