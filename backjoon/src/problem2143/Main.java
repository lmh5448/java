package problem2143;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static void map_put(HashMap<Long, Long> map, long num){
		if(map.containsKey((Object)num)){
			map.put(num,map.get((Object)num)+1);
		}else{
			map.put(num, (long) 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> n_array = new ArrayList<Integer>();
		ArrayList<Integer> m_array = new ArrayList<Integer>();
		
		HashMap<Long, Long> n_map = new HashMap<>();
		HashMap<Long, Long> m_map = new HashMap<>();		
		
		int n = sc.nextInt();
		while(n-- >0){
			n_array.add(sc.nextInt());
		}
		
		int m = sc.nextInt();
		while(m-- >0){
			m_array.add(sc.nextInt());
		}
		
		for(int i=0;i<n_array.size();i++){
			long sum = 0;
			for(int j=i;j<n_array.size();j++){
				sum+=n_array.get(j);
				map_put(n_map,sum);
			}
		}
		for(int i=0;i<m_array.size();i++){
			long sum = 0;
			for(int j=i;j<m_array.size();j++){
				sum+=m_array.get(j);
				map_put(m_map,sum);
			}
		}
		
//		////
//		System.out.println("n_map");
//		for(long i : n_map.keySet()){
//			System.out.println("key : "+i+", value : "+n_map.get(i));
//		}
//		System.out.println("m_map");
//		for(long i : m_map.keySet()){
//			System.out.println("key : "+i+", value : "+m_map.get(i));
//		}
//		////
//		System.out.println(n_map.size());
//		System.out.println(m_map.size());
//		////
		
		BigInteger ans = BigInteger.ZERO;
		for(long i : n_map.keySet()){
			if(m_map.containsKey((Object)(t-i))){
				ans = ans.add(BigInteger.valueOf(m_map.get(t-i)*n_map.get(i)));
			}
		}
		System.out.println(ans);
	}
}
