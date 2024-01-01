package photorganisation.batch.factories;

import photorganisation.infrastructure.filesystem.IOFiles;

public class IOFilesFactory {
	public static IOFiles get() {
		return new IOFiles();
	}
}
