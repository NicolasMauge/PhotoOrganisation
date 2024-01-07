package photorganisation.application.services.dates;

import photorganisation.application.common.LocalUtils;
import photorganisation.domaine.entities.PhotoMetadata;
import photorganisation.infrastructure.filesystem.IOFiles;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateCreationPhotoService implements IDateCreationPhotoService {
	private final IOFiles ioFiles;

	public DateCreationPhotoService(IOFiles ioFiles) {
		this.ioFiles = ioFiles;
	}

	@Override
	public LocalDateTime getDateCreation(File file, PhotoMetadata metadata) {
		LocalDateTime localDateTime = metadata.getCreationDate();
		LocalDateTime localDateTimeFromFilename = LocalUtils.extractDateFromName(file);

		// TODO : il faudra définir le cas des vidéos : est-ce qu'il existe une photo heic pour la vidéo
		if (localDateTime != null) {
			// les metadata suffisent
			if (localDateTimeFromFilename != null && localDateTimeFromFilename.until(localDateTime, ChronoUnit.SECONDS) > 0) {
				System.out.println("Valeurs différentes :");
				System.out.println("> " + localDateTime);
				System.out.println("> " + localDateTimeFromFilename + "<");
			}
			return localDateTime;
		} else if (localDateTimeFromFilename != null) {
			// le nom de la photo est explicite
			System.out.println("From filename " + localDateTimeFromFilename);
			return localDateTimeFromFilename;
		} else {
			// en dernier recours, on prend la date de création du fichier
			System.out.println("From file " + ioFiles.getFileCreationFromFilesystem(file));
			return ioFiles.getFileCreationFromFilesystem(file);
		}
	}
}
