package pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class PassageSorting1 {
	public static List<String> sortedList(String fileName) throws FileNotFoundException{
		File f1 = new File(fileName);
		Scanner sc1 = new Scanner(f1);
		List<String> list1 = new ArrayList<>();
		List<String> list2 = List.of("!","@","#","$","%","^","&","*","(",")","_","+","{","}",";","'",",",".","?","/",":","<",">","[","]","|","\"","â","€","œ");
		List<String> list3 = new ArrayList<>();
		Set<String> set1 = new HashSet<>();
		String line1 = "";
		String s1 = "";
		while(sc1.hasNext()) {
			line1 = sc1.nextLine();
			if(!line1.equals("")) {
				for(String ele : list2) {
					line1 = line1.replace(ele,"");
				}
				String[] arr1 = line1.split(" ");
				for(String ele : arr1) {
					list3.add(ele);
				}
			}
		}
		sc1.close();
		set1.addAll(list3);
		list3.clear();
		list3.addAll(set1);
		Collections.sort(list3);
		return list3;	
	}
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		List<String> list1 = new ArrayList<>();
		list1 = sortedList("Passage1.txt");
		List<String> list2 = new ArrayList<>();
		List<String> temp1 = new ArrayList<>();
		String char1 = "";
		
		int num1=65;
		char c1;
		for(int i= num1; i< num1 +26;i++) {
			c1 = (char)(i);
			char1 = String.valueOf(c1);
			list2.add(char1);	
		}
		num1 = 97;
		for(int i= num1; i< num1 +26;i++) {
			c1 = (char)(i);
			char1 = String.valueOf(c1);
			list2.add(char1);	
		}
		for( int i = 0; i < list2.size()/2;i++) {
			String s1 = list2.get(i);
			String fName1 = "sorted_"+ s1 + ".txt";
			FileWriter fw1 = new FileWriter(fName1);
			temp1 = list1.stream().filter(w -> w.substring(0,1).equalsIgnoreCase(s1)).collect(Collectors.toList());
			for(String ele2: temp1) {
				fw1.write(ele2);
				fw1.write("\n");
			}
			fw1.close();
		}
	}
}