package stepDefinitions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Util {
	ZoneId zoneId = ZoneId.systemDefault();
	LocalDate today = LocalDate.now(zoneId);
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");

	public String departureD() {
		//Departure date is set to tomorrow
		String usefulDate = today.plusDays(1).format(dateFormatter);

		return usefulDate;
	}
	
	public String returnD() {
		//Return is set to tomorrow plus 10 days
		String tenDays = today.plusDays(11).format(dateFormatter);
		
		return tenDays;
	}

}
