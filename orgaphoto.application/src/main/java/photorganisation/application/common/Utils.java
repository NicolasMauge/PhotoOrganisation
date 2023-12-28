package photorganisation.application.common;

import org.apache.commons.io.FilenameUtils;

public class Utils {
    public static String getExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }
}
