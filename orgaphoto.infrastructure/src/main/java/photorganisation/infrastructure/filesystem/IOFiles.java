package photorganisation.infrastructure.filesystem;

import photorganisation.infrastructure.common.DateUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;

public class IOFiles {
	public LocalDateTime getFileCreationFromFilesystem(File file) {
		try {
			BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
			return DateUtils.fileTimeToLocalDateTime(attr.creationTime());
		} catch (IOException e) {
			return null;
		}
	}

	public File moveFile(File file, Path targetPath) {
		try {
			Files.move(Paths.get(file.getPath()), targetPath);
			return targetPath.toFile();
		} catch (IOException e) {
			return null;
		}
	}
}
