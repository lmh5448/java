package problem10819;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean next_permutation(int[] a){
		int i=a.length-1;
		while(i>0 && a[i-1]>=a[i]){
			i--;
		}
		if(i<=0){
			return false;
		}
		int j = a.length-1;
		while(a[j] <= a[i-1]){
			j--;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i<j){
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	static int calculate(int[] a){
		int sum = 0;
		for(int i=0;i<a.length-1;i++){
			sum += Math.abs(a[i]-a[i+1]);
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int sum = calculate(a);
		while(next_permutation(a)){
			int temp = calculate(a);
			if(sum < temp){
				sum = temp;
			}
		}
		System.out.println(sum);
	}
}
