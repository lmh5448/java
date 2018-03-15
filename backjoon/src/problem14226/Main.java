package problem14226;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[][] d= new int[len+1][len+1];
		for(int i=0;i<=len;i++){
			Arrays.fill(d[i], -1);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(0);
		d[1][0] = 0;
		while(!q.isEmpty()){
			int s = q.remove();
			int c = q.remove();
			if(d[s][s]==-1){
				d[s][s] = d[s][c] + 1;
				q.add(s);q.add(s);
			}
			if(s+c<=len && d[s+c][c] == -1){
				d[s+c][c] = d[s][c] + 1;
				q.add(s+c);q.add(c);
			}
			if(s>=1 && d[s-1][c] == -1){
				d[s-1][c] = d[s][c] + 1;
				q.add(s-1);q.add(c);
			}
		}
		int result=-1;
		for(int i=1;i<=len;i++){
			if(result == -1 || result>d[len][i]){
				result = d[len][i];
			}
		}
		System.out.println(result);
	}
}
