package problem10815;

import java.io.*;
import java.util.*;

public class Main {
	public static boolean find(int[] a, int n) {
		int max = a.length - 1;
		int min = 0;
		while (min <= max) {
			int mid = (max + min) / 2;
			if (a[mid] > n) {
				max = mid - 1;
			} else if (a[mid] < n) {
				min = mid + 1;
			} else if (a[mid] == n) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public static void main(String[] args) { Scanner sc = new
	 * Scanner(System.in); int n = sc.nextInt(); int[] a = new int[n]; for(int
	 * i=0;i<n;i++){ a[i] = sc.nextInt(); } Arrays.sort(a); int m =
	 * sc.nextInt(); for(int i=0;i<m;i++){ int temp = sc.nextInt();
	 * if(find(a,temp)){ System.out.print("1 "); }else{ System.out.print("0 ");
	 * } } }
	 */
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String[] line = br.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(line[i]);
		}
		Arrays.sort(a);
		int m = Integer.valueOf(br.readLine());
		line = br.readLine().split(" ");
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int num = Integer.valueOf(line[i]);
			boolean res = find(a, num);
			if (res) {
				ans.append("1 ");
			} else {
				ans.append("0 ");
			}
		}
		System.out.println(ans);
	}
}
