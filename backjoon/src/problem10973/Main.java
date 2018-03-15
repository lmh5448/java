package problem10973;

import java.util.Scanner;

public class Main {
	public static boolean prev_permutation(int[] a){
		int i = a.length-1;
		while(i>0 && a[i-1] <= a[i]) i-=1;
		if(i<=0) return false;
		int j = a.length-1;
		while(a[j]>=a[i-1]) j-=1;
		swap(a,i-1,j);
		j = a.length-1;
		while(i<j){
			swap(a,i,j);
			i++;
			j--;
		}
		return true;
	}
	public static void swap(int[] a,int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] a = new int[len];
		for(int i=0;i<len;i++){
			a[i] = sc.nextInt();
		}
		if(prev_permutation(a)){
			for(int i=0;i<len;i++){
				System.out.print(a[i]);
				if(i<len-1){
					System.out.print(" ");
				}
			}System.out.println();
		}else{
			System.out.println(-1);
		}
	}
}
