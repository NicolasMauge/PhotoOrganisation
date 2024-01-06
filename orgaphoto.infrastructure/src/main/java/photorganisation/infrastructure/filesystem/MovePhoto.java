package photorganisation.infrastructure.filesystem;

import photorganisation.domaine.entities.PhotoEntity;

import java.io.File;
import java.nio.file.Paths;

public class MovePhoto {
	private final IOFiles ioFiles;

	public MovePhoto(IOFiles ioFiles) {
		this.ioFiles = ioFiles;
	}

	public PhotoEntity move(PhotoEntity photo, String targetName, String targetDirectory) {
		File fileMoved = ioFiles.moveFile(photo.file(), Paths.get(targetDirectory, targetName));

		if(fileMoved != null) {
			return new PhotoEntity(
					fileMoved,
					targetName,
					targetDirectory,
					photo.extension(),
					photo.dateCreation(),
					photo.geocode(),
					photo.fileHashCode()
			);
		}

		return photo;
	}
}
