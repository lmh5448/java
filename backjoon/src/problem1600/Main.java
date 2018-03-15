package problem1600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x;
	int y;
	int z;
	Pair(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main{
	static int[] hx = {-2,-1,1,2,2,1,-1,-2};
	static int[] hy = {1,2,2,1,-1,-2,-2,-1};
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static void bfs(int[][] a,int[][][] d,int k,int w,int h){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0,0));
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z;
				if(nx>=0 && nx<h && ny>=0 && ny<w){
					if(a[nx][ny]==0){
						if(d[nz][nx][ny]==0){
							d[nz][nx][ny] = d[z][x][y]+1;
							q.add(new Pair(nx,ny,nz));
						}
					}
				}
			}
			for(int i=0;i<8;i++){
				int nx = x + hx[i];
				int ny = y + hy[i];
				int nz = z + 1;
				if(nx>=0 && nx<h && ny>=0 && ny<w && nz<=k){
					if(a[nx][ny]==0){
						if(d[nz][nx][ny]==0){
							d[nz][nx][ny] = d[z][x][y]+1;
							q.add(new Pair(nx,ny,nz));
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int[][] a = new int[h][w];
		int[][][] d = new int[k+1][h][w];
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				a[i][j] = sc.nextInt();
			}
		}
		bfs(a,d,k,w,h);
		int ans = -1;
		for(int i=0;i<k+1;i++){
			if(d[i][h-1][w-1]!=0){
				if(ans==-1){
					ans = d[i][h-1][w-1];
				}else{
					ans = Math.min(ans, d[i][h-1][w-1]);
				}
			}
		}
		System.out.println(ans);
	}
}











/*
이코드 잘못된이유가 xy바꿔서 해서.. 아오 맞는걸 계속 수정했네 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x;
	int y;
	int z;
	Pair(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	public static int[] hx = {-2,-1,1,2,2,1,-1,-2};
	public static int[] hy = {1,2,2,1,-1,-2,-2,-1};
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void bfs(int[][][] d, int[][] a, int k,int w,int h){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0,0));
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x1 = p.x;
			int y1 = p.y;
			int z1 = p.z;
			for(int i=0;i<4;i++){
				int nx = x1 + dx[i];
				int ny = y1 + dy[i];
				int nz = z1;
				if(nx>=0 && nx<w && ny>=0 && ny<h){
					if(nx==0&&ny==0)continue;
					if(a[nx][ny]==0){
						if(d[nz][nx][ny]==0){
							d[nz][nx][ny] = d[z1][x1][y1]+1;
							q.add(new Pair(nx,ny,nz));
						}else{
							if(d[nz][nx][ny] > d[z1][x1][y1]+1){
								d[nz][nx][ny] = d[z1][x1][y1]+1;
								q.add(new Pair(nx,ny,nz));
							}
						}
					}
				}
			}
			for(int i=0;i<8;i++){
				int nx = x1 + hx[i];
				int ny = y1 + hy[i];
				int nz = z1 + 1;
				if(nx>=0 && nx<w && ny>=0 && ny<h && nz<=k){
					if(nx==0&&ny==0)continue;
					if(a[nx][ny]==0){
						if(d[nz][nx][ny]==0){
							d[nz][nx][ny] = d[z1][x1][y1]+1;
							q.add(new Pair(nx,ny,nz));
						}else{
							if(d[nz][nx][ny] > d[z1][x1][y1]+1){
								d[nz][nx][ny] = d[z1][x1][y1]+1;
								q.add(new Pair(nx,ny,nz));
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int[][] a = new int[w][h];
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				a[i][j]=sc.nextInt();
			}
		}
		int[][][] d = new int[k+1][w][h];
		bfs(d,a,k,w,h);
		int ans = -1;
		for(int i=0;i<k+1;i++){
			if(d[i][w-1][h-1]!=0){
				if(ans==-1){
					ans = d[i][w-1][h-1];
				}else{
					ans = Math.min(ans, d[i][w-1][h-1]);
				}
			}
		}
		System.out.println(ans);
	}
}
*/