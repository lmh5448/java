package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,k = 0;
		int temp = 0;
		int count = 0;
		HashMap<Integer, Boolean> numbers = new HashMap<Integer, Boolean>();
		Set<Integer> set = numbers.keySet();
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i = 0 ; i < n ; i++){
			temp = sc.nextInt();
			numbers.put(temp,false);
		}
		for(Object number : set){
			int key = (int)number;
			key += k;
			if(numbers.containsKey(key)){
				count++;
			}
		}
		System.out.println(count);
	}
}
