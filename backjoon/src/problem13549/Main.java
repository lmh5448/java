package problem13549;

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
	static boolean[] check = new boolean[100001];
	static int[] dx = {-1,1};
	static int dfs(int n,int m){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(n,0));
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int temp = x;
			while(temp<=100000 && temp>0){
				temp*=2;
				if(temp>100000 || temp<0)break;
				if(!check[temp]){
					check[temp]=true;
					if(temp==m)return y;
					q.add(new Pair(temp,y));
				}
			}
			for(int i=0;i<2;i++){
				int nx = x+dx[i];
				int ny = y+1;
				if(nx>=0 && nx<=100000){
					if(!check[nx]){
						check[nx] = true;
						if(nx==m)return ny;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		check[n] = true;
		int ans = dfs(n,m);
		System.out.println(ans);
	}
}
