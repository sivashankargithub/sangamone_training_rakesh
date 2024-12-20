package pkg1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Callender2025 {
	
	public static void printCallender(int year) throws IOException {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MMM dd yyyy E");
		LocalDate date1 = LocalDate.of(year, 1, 1);
		String output1,part1,part2,part3,fname1;
		int totalDays=0;
		boolean isLeapYear=date1.isLeapYear();
		part1="Callender";
		part2=String.valueOf(year);
		part3=".txt";
		fname1=part1+part2+part3;
		FileWriter fw1=new FileWriter(fname1);
		if(isLeapYear==true) {
			totalDays=366;
		}
		else {
			totalDays=365;
		}
		
		output1 = format1.format(date1);
		fw1.write(output1+"\n");
		System.out.println(output1);
		for(int i=1;i<totalDays;i++) {
			date1 = date1.plusDays(1);
			output1 = format1.format(date1);
			fw1.write(output1+"\n");
			System.out.println(output1);
			LocalDate date2=date1.plusDays(1);
			if(date1.getMonthValue()!=date2.getMonthValue()) {
				fw1.write("\n");
				System.out.println();
			}
		}
		fw1.close();
		
	
		
	}

	public static void main(String[] args) throws IOException{
		printCallender(2025);
	}

}
