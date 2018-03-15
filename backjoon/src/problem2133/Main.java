package problem2133;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] d = new int[len+1];
		d[0] = 1;
		d[1] = 0;
		if(len>=2)d[2]=3;
		for(int i=3;i<=len;i++){
			for(int j=2;j<=i;j+=2){
				if(j==2){
					d[i] += 3*d[i-2];
				}else{
					d[i] += 2*d[i-j];
				}
			}
		}
		System.out.println(d[len]);
	}
}
