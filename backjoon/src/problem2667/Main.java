package problem2667;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y));
		group[x][y] = cnt;
		while(!q.isEmpty()){
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int i=0;i<4;i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n){
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
		int len = sc.nextInt();
		sc.nextLine();
		int[][] a = new int[len][len];
		for(int i=0;i<len;i++){
			String temp = sc.nextLine();
			for(int j=0;j<len;j++){
				a[i][j] = temp.charAt(j)-'0';
			}
		}
		int cnt = 0;
		int[][] group = new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(a[i][j]==1 && group[i][j]==0){
					bfs(a,group,i,j,++cnt,len);
				}
			}
		}
		int[] result = new int[cnt];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(group[i][j]!=0){
					result[group[i][j]-1]+=1;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(result);
		for(int i=0;i<cnt;i++){
			System.out.println(result[i]);
		}
	}
}
