package photorganisation.application.common;

import org.apache.commons.io.FilenameUtils;
import photorganisation.infrastructure.common.DateUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class LocalUtils {
    public static String getExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }

    public static LocalDateTime extractDateFromName(File file) {
        String filename = file.getName();

        if(filename.length() >= 15 + getExtension(filename).length() + 1) {
            try {
                return DateUtils.stringToLocalDateTimeWithPattern(filename.substring(0, 15), "yyyyMMdd_HHmmss");
            } catch (DateTimeParseException e) {
                return null;
            }
        }

        return null;
    }

    public static char getLastCharacter(CharSequence charSequence) {
        if(charSequence.isEmpty()) {
            return Character.MIN_VALUE;
        }
        return charSequence.charAt(charSequence.length()-1);
    }

    public static String getAllCharactersExceptLast(CharSequence charSequence) {
        if(charSequence.isEmpty()) {
            return "";
        }
        return (String) charSequence.subSequence(0, charSequence.length()-1);
    }
}
