package problem12851;

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
		int count = 0;
		Arrays.fill(a, -1);
		a[v1] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v1);
		while(!q.isEmpty()){
			int temp = q.remove();
			if(temp==v2){
				count++;
				continue;
			}
			if(a[v2]!=-1 && a[v2]<a[temp])continue;
			if(temp-1>=0){
				if(a[temp-1]==-1){
					a[temp-1] = a[temp]+1;
					q.add(temp-1);
				}else{
					if(a[temp-1]==a[temp]+1){
						q.add(temp-1);
					}
				}
			}
			if(temp+1<=100000){
				if(a[temp+1]==-1){
					a[temp+1] = a[temp]+1;
					q.add(temp+1);
				}else{
					if(a[temp+1]==a[temp]+1){
						q.add(temp+1);
					}
				}
			}
			if((temp*2)<=100000){
				if(a[temp*2]==-1){
					a[temp*2] = a[temp]+1;
					q.add((temp*2));
				}else{
					if(a[temp*2]==a[temp]+1){
						q.add(temp*2);
					}
				}
			}
		}
		System.out.println(a[v2]);
		System.out.println(count);
	}
}
