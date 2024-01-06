package photorganisation.application.common;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PhotoUtils {
    private static final List<String> PHOTO_TYPES = Arrays
            .asList("png", "jpg", "jpeg", "tiff", "tif",
                    "gif", "raw", "arw", "heic", "heif",
                    "bmp", "webp");

    public static boolean isPhoto(File file) {
        if(!file.isFile()) {
            return false;
        }

		return PHOTO_TYPES.contains(LocalUtils.getExtension(file.getName()));
	}
}
