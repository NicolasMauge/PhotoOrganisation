package photorganisation.infrastructure.common;

import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static LocalDate stringToLocalDate(String dateInString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
		return LocalDate.parse(dateInString, formatter);
	}

	public static LocalDateTime stringToLocalDateTime(String dateInString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
		return LocalDateTime.parse (dateInString, formatter);
	}

	public static LocalDateTime stringToLocalDateTimeWithPattern(String dateInString, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.parse (dateInString, formatter);
	}

	public static LocalDateTime fileTimeToLocalDateTime(FileTime fileTime) {
		return LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());
	}
}
