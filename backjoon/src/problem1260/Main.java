package problem1260;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] b;		
	static boolean[] d;
	static ArrayList<Integer>[] g;
	static void dfs(int node){
		System.out.print(node+" ");
		d[node]=true;
		for(int num : g[node]){
			if(!d[num]){
				dfs(num);
			}
		}
	}
	static void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		b[start] = true;
		while(!q.isEmpty()){
			int num = q.remove();
			System.out.print(num + " ");
			for(int num2 : g[num]){
				if(!b[num2]){
					b[num2] = true;
					q.add(num2);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		d = new boolean[n+1];
		b = new boolean[n+1];
		g = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			g[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++){
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from].add(to);
			g[to].add(from);
		}
		for(int i=1;i<=n;i++){
			Collections.sort(g[i]);
		}
		//dfs
		dfs(start);
		System.out.println();
		//bfs
		bfs(start);
		System.out.println();
	}
}
