package problem1697;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		int[] a = new int[100001];
		Arrays.fill(a, -1);
		a[v1] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v1);
		while(!q.isEmpty()){
			int temp = q.remove();
			if(a[v2]!=-1)break;
			if(temp-1>=0 && a[temp-1]==-1){
				q.add(temp-1);
				a[temp-1] = a[temp]+1;
			}
			if(temp+1<=100000 && a[temp+1]==-1){
				q.add(temp+1);
				a[temp+1] = a[temp]+1;
			}
			if((temp*2)<=100000 && a[temp*2]==-1){
				q.add((temp*2));
				a[temp*2] = a[temp]+1;
			}
		}
		System.out.println(a[v2]);
	}
}
