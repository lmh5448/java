package problem14502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int zero = 0;
	static int ans = Integer.MIN_VALUE;
	static int n,m;
	static int[][] a;
	static ArrayList<Pair> empty;
	static ArrayList<Pair> virus;
	static void go(String s,int count){
		if(s.length()>empty.size())return;
		if(s.length()==empty.size()){
			if(count==3){
				Queue<Pair> q = new LinkedList<Pair>();
				for(int i=0;i<s.length();i++){
					if(s.charAt(i)=='1'){
						q.add(empty.get(i));
						if(q.size()==3)break;
					}
				}
				int num = bfs(q);
				ans = Math.max(ans, zero-num-3);
			}else{
				return;
			}
		}
		if(count<3){
			go(s+"1",count+1);
		}
		go(s+"0",count);
	}
	
	static int bfs(Queue<Pair> q){
		int count = 0;
		int[][] array = new int[n][m];
		for(int i=0;i<n;i++){
			array[i] = Arrays.copyOf(a[i], m);
		}
		while(!q.isEmpty()){
			Pair p = q.remove();
			array[p.x][p.y]=1;
		}
		//테스트용
		/*for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(array[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(a[i][j]);
			}System.out.println();
		}
		System.out.println();*/
		for(int i=0;i<virus.size();i++){
			q.add(virus.get(i));
		}
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(array[nx][ny]==0){
						array[nx][ny] = 2;
						count++;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		empty = new ArrayList<Pair>();
		virus = new ArrayList<Pair>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
				if(a[i][j]==2){
					virus.add(new Pair(i,j));
				}
				if(a[i][j]==0){
					zero++;
					empty.add(new Pair(i,j));
				}
			}
		}
		go("",0);
		System.out.println(ans);
	}
}
