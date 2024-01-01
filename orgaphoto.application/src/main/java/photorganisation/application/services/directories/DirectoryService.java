package photorganisation.application.services.directories;

import photorganisation.domaine.entities.DirectoryEntity;
import photorganisation.infrastructure.filesystem.IODirectory;

public class DirectoryService implements IDirectoryService {
    private final IODirectory IODirectory;

    public DirectoryService(IODirectory IODirectory) {
        this.IODirectory = IODirectory;
    }


    @Override
    public DirectoryEntity createDirectoryEntityFromPath(String directory) {
        return IODirectory.getPhotosInDirectory(directory);
    }
}
