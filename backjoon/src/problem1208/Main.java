package problem1208;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> a = new ArrayList<>();
	static ArrayList<Integer> b = new ArrayList<>();
	static ArrayList<Integer> asum = new ArrayList<>();
	static ArrayList<Integer> bsum = new ArrayList<>();
	static int n;
	static int s;
	static long ans;
	static int[] array = new int[8000001];
	static void a_go(int index,int sum){
		if(index==a.size()){
			asum.add(sum);
		}else{
			a_go(index+1,sum+a.get(index));
			a_go(index+1,sum);
		}
	}
	
	static void b_go(int index,int sum){
		if(index==b.size()){
			bsum.add(sum);
		}else{
			b_go(index+1,sum+b.get(index));
			b_go(index+1,sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		for(int i=0;i<n;i++){
			if(i%2==0){
				a.add(sc.nextInt());
			}else{
				b.add(sc.nextInt());				
			}
		}
		ans=0;
		a_go(0,0);
		asum.remove(asum.size()-1);
		b_go(0,0);
		bsum.remove(bsum.size()-1);
//		System.out.println("a");
//		for(int temp : a){
//			System.out.print(temp + " ");
//		}
//		System.out.println();
//		System.out.println("b");
//		for(int temp : b){
//			System.out.print(temp + " ");
//		}
//		System.out.println();
//		System.out.println("asum");
//		for(int temp : asum){
//			System.out.print(temp + " ");
//		}
//		System.out.println();
//		System.out.println("bsum");
//		for(int temp : bsum){
//			System.out.print(temp + " ");
//		}
//		System.out.println();
		
		for(int i=0;i<asum.size();i++){
			if(s==asum.get(i)){
				ans++;
			}
			array[asum.get(i)+4000000]++;
		}
		for(int i=0;i<bsum.size();i++){
			if(s==bsum.get(i)){
				ans++;
			}
			if(array[s-bsum.get(i)+4000000]>0){
				ans+=array[s-bsum.get(i)+4000000];
			}
		}
		
//		for(int i=4000000-10;i<4000000+11;i++){
//			System.out.println(i-4000000 + "a : "+array[i]);
//		}
		
		System.out.println(ans);
	}
}