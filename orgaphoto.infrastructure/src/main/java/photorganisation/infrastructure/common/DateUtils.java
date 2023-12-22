package photorganisation.infrastructure.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static LocalDate stringToLocalDate(String dateInString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
		return LocalDate.parse(dateInString, formatter);
	}
}
