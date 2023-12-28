package photorganisation.batch.factories;

import photorganisation.application.directories.DirectoryService;

public class DirectoryServiceFactory {
    public static DirectoryService get() {
        return new DirectoryService(IODirectoryFactory.get());
    }
}
