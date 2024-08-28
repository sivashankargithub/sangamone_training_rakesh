package pkg1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateParse1 {
	public static void main(String[] args) {
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate ld1 = LocalDate.now();
		String today = ld1.format(dtf1);
		System.out.println(today);
		LocalDate parsedDate = LocalDate.parse(today, dtf1);
		System.out.println(parsedDate);
	}
}
