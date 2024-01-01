package photorganisation.application.services.dates;

import photorganisation.domaine.entities.PhotoMetadata;

import java.io.File;
import java.time.LocalDateTime;

public interface IDateCreationPhotoService {
	LocalDateTime getDateCreation(File file, PhotoMetadata metadata);
}
