package problem4963;

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
	public static int[] dx={-1,0,1,-1,1,-1,0,1};
	public static int[] dy={1,1,1,0,0,-1,-1,-1};
	
	public static void bfs(int[][] a,int[][] group, int x,int y,int cnt, int w,int h){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y));
		group[x][y] = cnt;
		while(!q.isEmpty()){
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int i=0;i<8;i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<w && ny>=0 && ny<h){
					if(a[nx][ny]==1 && group[nx][ny]==0){
						q.add(new Pair(nx,ny));
						group[nx][ny] = cnt;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int h = sc.nextInt();
			int w = sc.nextInt();
			if(w==0 && h==0)break;
			
			int[][] a = new int[w][h];
			int[][] group = new int[w][h];
			for(int i=0;i<w;i++){
				for(int j=0;j<h;j++){
					a[i][j] = sc.nextInt();
				}
			}
			int cnt=0;
			for(int i=0;i<w;i++){
				for(int j=0;j<h;j++){
					if(a[i][j]==1 && group[i][j]==0){
						bfs(a,group,i,j,++cnt,w,h);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
