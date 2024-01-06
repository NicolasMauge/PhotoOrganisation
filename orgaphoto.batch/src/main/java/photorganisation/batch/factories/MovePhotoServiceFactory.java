package photorganisation.batch.factories;

import photorganisation.application.services.directories.MovePhotoService;

public class MovePhotoServiceFactory {
	public static MovePhotoService get() {
		return new MovePhotoService(MovePhotoFactory.get());
	}
}
