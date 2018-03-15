package problem2529;

import java.util.Scanner;

public class Main {
	static boolean next_permutation(int[] a){
		int i = a.length-1;
		while(i>0 && a[i-1]>=a[i])i--;
		if(i<=0)return false;
		int j = a.length-1;
		while(a[j]<=a[i-1])j--;
		swap(a,i-1,j);
		j = a.length-1;
		while(i<j){
			swap(a,i,j);
			i++;
			j--;
		}
		return true;
	}
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
	static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	static boolean check(char[] a,int[] minmax){
		for(int i=0;i<a.length;i++){
			if(a[i]=='<'){
				if(minmax[i]>minmax[i+1])return false;
			}else{
				if(minmax[i]<minmax[i+1])return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		char[] a = new char[k];
		for(int i=0;i<k;i++){
			a[i] = sc.next().charAt(0);
		}
		int[] min = {0,1,2,3,4,5,6,7,8,9};
		int[] max = {9,8,7,6,5,4,3,2,1,0};
		do{
			if(check(a,min)){
				break;
			}
//			for(int i=0;i<10;i++){
//				System.out.print(min[i]+" ");
//			}System.out.println();
		}while(next_permutation(min));
		
		do{
			if(check(a,max)){
				break;
			}
//			for(int i=0;i<10;i++){
//				System.out.print(max[i]+" ");
//			}System.out.println();
		}while(pre_permutation(max));
		String s_min = "";
		String s_max = "";
		for(int i=0;i<=k;i++){
			s_min += min[i]+"";
			s_max += max[i]+"";
		}
		System.out.println(s_max);
		System.out.println(s_min);
	}
}
