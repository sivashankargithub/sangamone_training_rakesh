package pkg1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class R1 {
	public static String encrypt1(String input1) throws IOException {
		File f1 = new File("input1.txt");
		Scanner sc1 = new Scanner(f1);
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		String line1 = "";
		String[] arr1 = null;
		String s1= input1;
		String char1 = "";
		String s2 = "";
		int pos1 = 0;
		while(sc1.hasNext()) {
			line1 = sc1.nextLine();
			arr1 = line1.split(",");
			list1.add(arr1[0]);
			list2.add(arr1[1]);
		}
		for(int j = 0; j < s1.length(); j ++) {
			char1 = s1.substring(j,j+1);
			pos1 = list1.indexOf(char1);
			s2 = s2 + list2.get(pos1);
		}
		return s2;
	}
	
	public static String decrypt1(String input1) throws IOException {
		String s2 = input1;
		String line1 = "";
		String char1 = "";
		String output1 = "";
		int pos1 = 0;
		int len1 = s2.length();
		String[] arr1 = null;
		File f2 = new File("Input1.txt");
		Scanner sc2 = new Scanner(f2);
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		while(sc2.hasNext()) {
			line1 = sc2.nextLine();
			arr1 = line1.split(",");
			list1.add(arr1[0]);
			list2.add(arr1[1]);
		}
			
		for(int i =0;i < len1;i+=2) {
			char1 = s2.substring(i, i+2);
			pos1 = list2.indexOf(char1);
			output1 = output1 + list1.get(pos1);
		}
		return output1;
	}
		
	public static void main(String[] args) throws IOException {
		String input1 = "Rakesh";
		String  s2= "";
		String output1 = "";
		s2 = encrypt1(input1);
		output1 = decrypt1(s2);
		System.out.println(s2);
		System.out.println(output1);
	}
}