package problem11724;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] g;
	static boolean[] chk;
	static void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()){
			int next = q.remove();
			chk[next] = true;
			for(int num : g[next]){
				if(!chk[num]){
					chk[num] = true;
					q.add(num);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		chk = new boolean[n+1];
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
		int result = 0;
		for(int i=1;i<=n;i++){
			if(!chk[i]){
				chk[i]=true;
				result++;
				bfs(i);
			}
		}
		System.out.println(result);
	}
}
