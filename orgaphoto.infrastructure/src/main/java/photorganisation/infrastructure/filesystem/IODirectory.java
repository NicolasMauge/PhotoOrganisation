package photorganisation.infrastructure.filesystem;

import photorganisation.domaine.entities.DirectoryEntity;

import java.io.File;
import java.util.List;

public class IODirectory {
    public IODirectory() {
    }

    public DirectoryEntity getPhotosInDirectory(String directory) {
        return new DirectoryEntity(
                directory,
                List.of(new File(directory).listFiles()));
    }
}
