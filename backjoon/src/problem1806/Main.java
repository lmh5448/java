package problem1806;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int left = 0;
		int right = 0;
		int sum = a[0];
		int ans=Integer.MAX_VALUE;
		while(left<n&&right<n){
			if(sum>=s){
				ans = Math.min(ans, right-left+1);
				left++;
				sum-=a[left-1];
			}else{
				right++;
				if(right<n)sum += a[right];
			}
		}
		if(ans==Integer.MAX_VALUE)System.out.println(0);
		else System.out.println(ans);
	}
}


/*public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		s = bf.readLine().split(" ");
		int[] a = new int[n];
		int ans = 0;
		for(int i=0;i<n;i++){
			a[i] = Integer.parseInt(s[i]);
			if(i!=0){
				a[i] += a[i-1];
				if(ans==0){
					for(int j=0;j<i;j++){
						if(j==0){
							if(a[i]>=m){
								if(ans==0){
									ans = i+1;
								}else{
									ans = Math.min(ans, i+1);
								}
							}
						}else{
							if(a[i]-a[i-j-1]>=m){
								if(ans==0){
									ans = j+1;
								}else{
									ans = Math.min(ans, j+1);
								}
							}
						}
					}
				}else{
					for(int j=0;j<ans;j++){
						if(j==0){
							if(a[i]>=m){
								if(ans==0){
									ans = i+1;
								}else{
									ans = Math.min(ans, i+1);
								}
							}
						}else{
							if(a[i]-a[i-j-1]>=m){
								if(ans==0){
									ans = j+1;
								}else{
									ans = Math.min(ans, j+1);
								}
							}
						}
					}
				}
			}else{
				if(a[i]>=m){
					ans = 1;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}*/
