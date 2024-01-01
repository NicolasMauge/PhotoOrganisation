package photorganisation.batch.photorga;

import photorganisation.application.services.directories.IProcessDirectory;
import photorganisation.application.services.directories.ProcessDirectory;
import photorganisation.batch.configuration.PropertyConfig;
import photorganisation.batch.factories.DirectoryServiceFactory;
import photorganisation.batch.factories.FileToPhotoMapperFactory;
import photorganisation.domaine.entities.PhotoEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PhotOrgaApplication {
	public static void main(String[] args) {
		PropertyConfig propertyConfig = PropertyConfig.getInstance("application.properties");

		System.out.println(propertyConfig.getDirectoryToProcess());
		System.out.println(propertyConfig.getRootDirectory());

		IProcessDirectory directoryService = new ProcessDirectory(
				DirectoryServiceFactory.get(),
				FileToPhotoMapperFactory.get()
				);

		List<CompletableFuture<PhotoEntity>> photoToProcess = directoryService
				.processDirectory("/Users/nicolasmauge/Downloads/test/");

		photoToProcess.forEach(photoEntity -> {
					PhotoEntity photo = photoEntity.join();
					System.out.println(photo);
				}
		);
	}
}
