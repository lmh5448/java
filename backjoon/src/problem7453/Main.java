package problem7453;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static HashMap<Long, Integer> map;
	static void put(long num){
		if(map.containsKey(num)){
			map.put(num, map.get(num)+1);
		}else{
			map.put(num, 1);
		}
	}
	static int get(long num){
		if(map.containsKey(num)){
			return map.get(num);
		}else{
			return 0;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		long ans=0;
		map = new HashMap<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				put(a[i]+b[j]);
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				ans+=get((c[i]+d[j])*(-1));
			}
		}
		System.out.println(ans);
	}
}
