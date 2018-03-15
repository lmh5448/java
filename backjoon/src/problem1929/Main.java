package problem1929;

import java.util.Scanner;
//소수문제
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean[] prime = new boolean[b+1];
		prime[0]=true;
		prime[1]=true;
		for(int i=2;i*i<=b;i++){
			for(int j=2;i*j<=b;j++){
				prime[i*j] = true;
			}
		}
		for(int i=a;i<=b;i++){
			if(prime[i]==false){
				System.out.println(i);
			}
		}
	}
}