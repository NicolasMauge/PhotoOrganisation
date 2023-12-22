package photorganisation.application.directories;

import photorganisation.domaine.entities.DirectoryEntity;

public interface IDirectoryService {
    DirectoryEntity listFilesFromDirectory(String directory);
}
