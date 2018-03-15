package problem1248;

import java.util.*;

public class Main{
	static int n;
	static int[][] a;
	static int[] result;
	static boolean go(int index){
		if(index == n){
			return true;
		}
		if(a[index][index]==0){
			result[index]=0;
			return check(index) && go(index+1);
		}else{
			for(int i=1;i<=10;i++){
				result[index] = a[index][index] * i;
				if(check(index) && go(index+1)){
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean check(int index){
		int sum = 0;
		for(int i=index;i>=0;i--){
			sum+=result[i];
			if(a[i][index]==0){
				if(sum!=0)return false;
			}else if(a[i][index]>0){
				if(sum<=0)return false;
			}else if(a[i][index]<0){
				if(sum>=0)return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		a = new int[n][n];
		result = new int[n];
		int index = 0;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(s.charAt(index)=='0'){
					a[i][j] = 0;
				}else if(s.charAt(index)=='+'){
					a[i][j] = 1;
				}else{
					a[i][j] = -1;
				}
				index++;
			}
		}
		go(0);
		for(int i=0;i<n;i++){
			System.out.print(result[i]);
			if(i!=n-1)System.out.print(" ");
		}System.out.println();
	}
}

//이것도 시간 초과
/*public class Main{
	static int n;
	static String s;
	static int[] numbers;
	static int[][] a;
	static boolean[] used = new boolean[21];
	static void go(int index){
		if(index>n)return;
		if(index==n){
			int[] plus = new int[n];
			for(int i=0;i<n;i++){
				if(i==0){
					plus[i] = numbers[i];
				}else{
					plus[i] = plus[i-1]+numbers[i];
				}
			}
			int[][] sum = new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=i;j<n;j++){
					if(i==0){
						sum[i][j] = plus[j];
					}else{
						sum[i][j] = plus[j]-plus[i-1];
					}
					if(a[i][j]>0 && sum[i][j]<=0){
						return;
					}
					if(a[i][j]<0 && sum[i][j]>=0){
						return;
					}
					if(a[i][j]==0 && sum[i][j]!=0){
						return;
					}
				}
			}
			for(int i=0;i<n;i++){
				System.out.print(numbers[i]);
				if(i!=n-1)System.out.print(" ");
			}System.out.println();
//			System.out.println(" check ");
//			for(int i=0;i<n;i++){
//				for(int j=0;j<n;j++){
//					System.out.print(sum[i][j]+"\t");
//				}System.out.println();
//			}System.out.println();
			
			System.exit(0);
		}else{
			for(int i=1;i<=10;i++){
				if(!used[numbers[index]+10]){
					numbers[index] = a[index][index] * i;
					used[numbers[index]+10]=true;
					go(index + 1);
					used[numbers[index]+10]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		s = sc.nextLine();
		a = new int[n][n];
		numbers = new int[n];
		int index = 0;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(s.charAt(index)=='0'){
					a[i][j] = 0;
				}else if(s.charAt(index)=='+'){
					a[i][j] = 1;
				}else{
					a[i][j] = -1;
				}
				index++;
			}
		}
		go(0);
//		for(int i=0;i<n;i++){
//			for(int j=0;j<n;j++){
//				System.out.print(a[i][j]+"\t");
//			}System.out.println();
//		}System.out.println();
//		System.out.println(" index : "+index);
		
	}
}*/

//이방법은 시간초과가 된다.
/*public class Main {
	static int n;
	static String s;
	static ArrayList<Integer> array;
	static void go(int index){
		if(index>n)return;
		if(index==n){
			//답확인
			String s1="";
			int[] plus = new int[n];
			for(int i=0;i<n;i++){
				if(i==0){
					plus[i] = array.get(i);
				}else{
					plus[i] = plus[i-1]+array.get(i);
				}
			}
			int[][] sum = new int[n][n];
			int k=0;
			for(int i=0;i<n;i++){
				for(int j=i;j<n;j++){
					if(i==0){
						sum[i][j] = plus[j];
					}else{
						sum[i][j] = plus[j]-plus[i-1];
					}
					if(sum[i][j]==0){
						s1 += "0";
					}else if(sum[i][j]>0){
						s1 += "+";
					}else{
						s1 += "-";
					}
					if(s1.charAt(k)!=s.charAt(k))return;
					k++;
				}
			}

			if(s.equals(s1)){
//				for(int i=0;i<array.size();i++){
//					System.out.print(array.get(i)+" ");
//				}System.out.println();
//				System.out.println("s  : "+s);
//				System.out.println("s1 : "+s1);
				for(int i=0;i<array.size();i++){
					System.out.print(array.get(i));
					if(i!=array.size()-1)System.out.print(" ");
				}System.out.println();
				System.exit(0);
				return;
			}
		}else{
			for(int i=-10;i<=10;i++){
				if(!array.contains((Object)i)){
					array.add(i);
					go(index+1);
					array.remove((Object)i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		s = sc.nextLine();
		array = new ArrayList<Integer>();
		go(0);
	}
}*/
