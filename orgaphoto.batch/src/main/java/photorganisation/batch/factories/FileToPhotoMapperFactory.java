package photorganisation.batch.factories;

import photorganisation.application.mappers.FileToPhotoMapper;

public class FileToPhotoMapperFactory {
	public static FileToPhotoMapper get() {
		return new FileToPhotoMapper(
				GpsCoordinateToGeocodeMapperFactory.get(),
				MetadataFromPhotoFactory.get(),
				DateCreationPhotoServiceFactory.get(),
				FileHashMD5Factory.get());
	}
}
