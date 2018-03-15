package problem1978;

import java.util.Scanner;
//소수문제
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] num = new int[count];
		boolean[] prime = new boolean[1001];
		prime[0]=true;
		prime[1]=true;
		for(int i=2;i*i<1001;i++){
			for(int j=2;i*j<1001;j++){
				prime[i*j] = true;
			}
		}
		int result = 0;
		for(int i=0;i<count;i++){
			num[i] = sc.nextInt();
			if(prime[num[i]]==false){
				result++;
			}
		}
		System.out.println(result);
	}
}
