package problem9613;

import java.util.Scanner;

//최소공배수
public class Main {
	//첫줄도 공약수를 구한것..
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		for(int i=0;i<count;i++){
			int sum =0;
			String[] temp = sc.nextLine().split(" ");
			int[] num = new int[temp.length];
			int numSize = num.length;
			for(int j=0;j<numSize;j++){
				num[j] = Integer.parseInt(temp[j]);
			}
			for(int j=0;j<numSize-1;j++){
				for(int k=j+1;k<numSize;k++){
					if(num[j]>num[k]){
						sum+=gcd(num[j],num[k]);
					}else if(num[j]<num[k]){
						sum+=gcd(num[k],num[j]);
					}
				}
			}
			System.out.println(sum);
		}
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		for(int i=0;i<count;i++){
			int sum =0;
			String[] temp = sc.nextLine().split(" ");
			int[] num = new int[temp.length];
			int numSize = num.length;
			for(int j=0;j<numSize;j++){
				num[j] = Integer.parseInt(temp[j]);
			}
			for(int j=1;j<numSize-1;j++){
				for(int k=j+1;k<numSize;k++){
					if(num[j]>num[k]){
						sum+=gcd(num[j],num[k]);
					}else if(num[j]<num[k]){
						sum+=gcd(num[k],num[j]);
					}
				}
			}
			System.out.println(sum);
		}
	}
	
	public static int gcd(int num1,int num2){
		if(num2 == 0)return num1;
		return gcd(num2,num1%num2);
	}
}