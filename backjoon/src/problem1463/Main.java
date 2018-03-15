package problem1463;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[1000001];
		array[1]=0;
		for(int i=2;i<1000001;i++){
			array[i] = array[i-1]+1;
			if(i%3==0){
				if(array[i]>(array[i/3]+1)){
					array[i] = array[i/3]+1;
				}
			}
			if(i%2==0){
				if(array[i]>(array[i/2]+1)){
					array[i] = array[i/2]+1;
				}
			}
		}
		int index = sc.nextInt();
		System.out.println(array[index]);
	}
}
