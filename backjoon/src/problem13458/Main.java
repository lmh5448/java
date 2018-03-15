package problem13458;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++){
			a[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int c = sc.nextInt();
		BigInteger ans = BigInteger.ZERO;
		for(int i=1;i<=n;i++){
			long temp = 0;
			if(a[i]>b){
				if((a[i]-b)%c==0){
					temp = (a[i]-b)/c+1;
				}else{
					temp = (a[i]-b)/c+2;
				}
			}else{
				temp = 1;
			}
			ans = ans.add(BigInteger.valueOf(temp));
		}
		System.out.println(ans);
	}
}
