package photorganisation.batch.factories;

import photorganisation.infrastructure.filesystem.MovePhoto;

public class MovePhotoFactory {
	public static MovePhoto get() {
		return new MovePhoto(IOFilesFactory.get());
	}
}
