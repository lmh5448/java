package problem1339;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean pre_permutation(int[] a){
		int i = a.length-1;
		while(i>0 && a[i-1]<=a[i])i--;
		if(i<=0)return false;
		int j = a.length-1;
		while(a[j]>=a[i-1])j--;
		swap(a,i-1,j);
		j = a.length-1;
		while(i<j){
			swap(a,i,j);
			i++;
			j--;
		}
		return true;
	}
	static void swap(int[] a,int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	static int sum(String[] words,int[] num,int[] ntoa){
		int sum = 0;
		int temp_sum;
		for(int i=0;i<words.length;i++){
			temp_sum = 0;
			for(int j=0;j<words[i].length();j++){
				temp_sum *= 10;
				temp_sum += num[ntoa[words[i].charAt(j)-'A']];
			}
			sum += temp_sum;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		sc.nextLine();
		for(int i=0;i<n;i++){
			words[i] = sc.nextLine();
		}
		int[] ntoa = new int[26];
		Arrays.fill(ntoa, -1);
		int index=0;
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words[i].length();j++){
				if(ntoa[words[i].charAt(j)-'A']==-1){
					ntoa[words[i].charAt(j)-'A']=index;
					index++;
				}
			}
		}
		int ans = 0;
		int[] a = {9,8,7,6,5,4,3,2,1,0};
		do{
			ans = Math.max(ans, sum(words,a,ntoa));
		}while(pre_permutation(a));
		System.out.println(ans);
	}
}
