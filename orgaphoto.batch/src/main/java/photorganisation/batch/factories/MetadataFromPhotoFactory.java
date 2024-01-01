package photorganisation.batch.factories;

import photorganisation.infrastructure.metadata.MetadataFromPhoto;

public class MetadataFromPhotoFactory {
	public static MetadataFromPhoto get() {
		return new MetadataFromPhoto();
	}
}
