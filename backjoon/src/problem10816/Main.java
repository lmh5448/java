package problem10816;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int temp = sc.nextInt();
			if(map.containsKey(temp)){
				map.put(temp, map.get(temp)+1);
			}else{
				map.put(temp, 1);
			}
		}
		int m = sc.nextInt();
		for(int i=0;i<m;i++){
			int temp = sc.nextInt();
			if(map.containsKey(temp)){
				System.out.print(map.get(temp)+" ");
			}else{
				System.out.print("0 ");
			}
		}
	}
}
