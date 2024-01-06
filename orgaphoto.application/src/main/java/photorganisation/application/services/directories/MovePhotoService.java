package photorganisation.application.services.directories;

import photorganisation.application.common.LocalUtils;
import photorganisation.domaine.entities.PhotoEntity;
import photorganisation.infrastructure.common.DateUtils;
import photorganisation.infrastructure.filesystem.MovePhoto;

public class MovePhotoService {
	private final MovePhoto movePhoto;

	public MovePhotoService(MovePhoto movePhoto) {
		this.movePhoto = movePhoto;
	}

	public PhotoEntity move(PhotoEntity photo) {
		return movePhoto.move(
					photo,
					getTargetName(photo),
					photo.photoDirectory()
				);
	}

	private String getTargetName(PhotoEntity photo) {
		String targetName;
		// est-ce que le nom actuel possède une date ?
		if(LocalUtils.extractDateFromName(photo.file()) != null ) {
			// on tronque le nom du fichier
			targetName = DateUtils.localDateTimeToString(photo.dateCreation()) + "_"+ photo.photoName().substring(16);
		} else {
			targetName = DateUtils.localDateTimeToString(photo.dateCreation()) + photo.photoName();
		}

		// replace : pour gérer notamment les photos qui commencent par _
		return targetName.replace("__", "_").toLowerCase();
	}
}
