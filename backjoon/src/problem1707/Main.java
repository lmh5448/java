package problem1707;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] g;
	static int[] part;
	static void dfs(int start,int color){
		part[start] = color;
		for(int num : g[start]){
			if(part[num]==0){
				dfs(num,3-color);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			part = new int[n+1];
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
				if(part[i]==0){
					dfs(i,1);
				}
			}
			boolean result = true;
			for(int i=1;i<=n;i++){
				for(int j:g[i]){
					if(part[i]==part[j]){
						result = false;
					}
				}
			}
			if(result){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
