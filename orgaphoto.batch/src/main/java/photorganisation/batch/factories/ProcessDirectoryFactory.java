package photorganisation.batch.factories;

import photorganisation.application.services.directories.ProcessDirectory;

public class ProcessDirectoryFactory {
	public static ProcessDirectory get() {
		return new ProcessDirectory(
				DirectoryServiceFactory.get(),
				FileToPhotoMapperFactory.get(),
				MovePhotoServiceFactory.get()
		);
	}
}
