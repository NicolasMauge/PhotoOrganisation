package photorganisation.application.services.directories;

import photorganisation.domaine.entities.DirectoryEntity;

public interface IDirectoryService {
    DirectoryEntity createDirectoryEntityFromPath(String directory);
}
