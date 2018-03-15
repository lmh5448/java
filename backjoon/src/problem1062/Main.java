package problem1062;

import java.util.*;

public class Main {
	static int n;
	static int k;
	static String[] ss;
	static boolean[] alp = new boolean[26];
	static int ans = 0;
	static int go(int index,int k){
		if(k<0)return 0;
		if(index==26){
			return count();
		}
		alp[index] = true;
		int t1 = go(index+1,k-1);
		ans = Math.max(ans, t1);
		alp[index] = false;
		if(index!='a'-'a' && index!='n'-'a' && index!='t'-'a' && index!='i'-'a' && index!='c'-'a'){
			t1 = go(index+1,k);
		}
		ans = Math.max(ans, t1);
		return 0;
	}
	
	static int count(){
		int ans=0;
		for(int i=0;i<n;i++){
			boolean check = true;
			for(int j=0;j<ss[i].length();j++){
				if(!alp[ss[i].charAt(j)-'a']){
					check = false;
					break;
				}
			}
			if(check)ans++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();
		ss = new String[n];
		for(int i=0;i<n;i++){
			ss[i] = sc.nextLine();
		}
		go(0,k);
		System.out.println(ans);
	}
}
