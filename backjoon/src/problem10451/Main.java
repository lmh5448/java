package problem10451;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
			int len = sc.nextInt();
			int[] a = new int[len+1];
			boolean[] chk = new boolean[len+1];
			for(int i=1;i<=len;i++){
				a[i] = sc.nextInt();
			}
			int result = 0;
			for(int i=1;i<=len;i++){
				if(chk[i])continue;
				int j = a[i];
				while(i!=j){
					chk[j]=true;
					j = a[j];
				}
				result++;
			}
			System.out.println(result);
		}
	}
}
