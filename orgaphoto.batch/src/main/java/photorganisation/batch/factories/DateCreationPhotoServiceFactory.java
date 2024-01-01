package photorganisation.batch.factories;

import photorganisation.application.services.dates.DateCreationPhotoService;

public class DateCreationPhotoServiceFactory {
	public static DateCreationPhotoService get() {
		return new DateCreationPhotoService(
				IOFilesFactory.get()
		);
	}
}
