package photorganisation.application.directories;

import photorganisation.domaine.entities.DirectoryEntity;
import photorganisation.infrastructure.filesystem.IODirectory;

public class DirectoryService implements IDirectoryService {
    private final IODirectory IODirectory;

    public DirectoryService(IODirectory IODirectory) {
        this.IODirectory = IODirectory;
    }


    @Override
    public DirectoryEntity listFilesFromDirectory(String directory) {
        return IODirectory.getPhotosInDirectory(directory);
    }
}
