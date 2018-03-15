package problem6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int m,n,x,y;
	Pair(int m,int n,int x,int y){
		this.m = m;
		this.n = n;
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		Queue<Pair> q = new LinkedList<Pair>();
		
		while(t-- >0){
			String[] s = bf.readLine().split(" ");
			int m = Integer.parseInt(s[0]);
			int n = Integer.parseInt(s[1]);
			int x = Integer.parseInt(s[2]);
			int y = Integer.parseInt(s[3]);
			q.add(new Pair(m,n,x,y));
		}
		while(!q.isEmpty()){
			boolean check = false;
			Pair p = q.remove();
			int m = p.m;
			int n = p.n;
			int x = p.x-1;
			int y = p.y-1;
			for(int i=x;i<m*n;i+=m){
				if(i%n==y){
					System.out.println(i+1);
					check = true;
					break;
				}
			}
			if(!check)System.out.println(-1);
		}
	}
}
