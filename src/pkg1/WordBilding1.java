package pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordBilding1 {

	public static void main(String[] args) throws FileNotFoundException {
		List<String> list1 = new ArrayList<>();
		List<String> temp1 = new ArrayList<>();
		String line1="";
		String userChoice1="";
		String computerChoice1="";
		String lastChar1="";
		int randNum=0;
		int len1=0;
		int len2=0;
		File f1=new File("dictionary.txt");
		Scanner sc1 = new Scanner(f1);
		Scanner sc2 = new Scanner(System.in);
		Random rand1 = new Random();
		while(sc1.hasNext()) {
			line1=sc1.nextLine();
			list1.add(line1);
		}
		len1=list1.size();
		randNum=rand1.nextInt(0,len1);
		computerChoice1 = list1.get(randNum);
		list1.remove(computerChoice1);
		System.out.println("Computer : "+computerChoice1);
		len2=computerChoice1.length();
		lastChar1 = computerChoice1.substring(len2-1,len2);
		System.out.println(lastChar1);
		while(true) {
			System.out.print("User : ");
			userChoice1=sc2.nextLine();
			if(userChoice1.startsWith(lastChar1) && list1.contains(userChoice1)) {
				list1.remove(userChoice1);
				len2=userChoice1.length();
				String lastChar2=userChoice1.substring(len2-1,len2);
				temp1=list1.stream().filter(w->w.startsWith(lastChar2)).collect(Collectors.toList());
				len1=temp1.size();
				randNum=rand1.nextInt(0,len1);
				computerChoice1=temp1.get(randNum);
				len2=computerChoice1.length();
				lastChar1=computerChoice1.substring(len2-1,len2);
				list1.remove(computerChoice1);
			}
			else {
				System.out.println("Computer Wins");
				break;
			}
			
		}

	}

}
