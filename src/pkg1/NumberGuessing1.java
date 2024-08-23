package pkg1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing1 {

	public static void main(String[] args) {
		int start=0;
		int end=10;
		Random rand1=new Random();
		Scanner sc1 = new Scanner(System.in);
		int randNum1=rand1.nextInt(start,end);
		int input1=end;
		while(input1!=randNum1) {
			System.out.print("Enter a number: ");
			input1=sc1.nextInt();
			if(input1>randNum1) {
				System.out.println("Enter a smaller number!!");
			}
			else if(input1<randNum1){
				System.out.println("Enter a higher number!!");
			}
			else{
				System.out.println("Congragulations! Your guess is correct");
				break;
			}
		}
		

	}

}
