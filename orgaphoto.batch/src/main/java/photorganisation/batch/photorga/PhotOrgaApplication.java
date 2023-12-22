package photorganisation.batch.photorga;

import photorganisation.application.directories.IProcessDirectory;
import photorganisation.application.directories.ProcessDirectory;
import photorganisation.batch.configuration.PropertyConfig;
import photorganisation.batch.factories.DirectoryServiceFactory;

public class PhotOrgaApplication {
	public static void main(String[] args) {
		PropertyConfig propertyConfig = PropertyConfig.getInstance("application.properties");

		System.out.println(propertyConfig.getDirectoryToProcess());
		System.out.println(propertyConfig.getRootDirectory());

		IProcessDirectory directoryService = new ProcessDirectory(DirectoryServiceFactory.get());
		directoryService.processDirectory("/Users/nicolasmauge/Downloads/test/");
	}
}
