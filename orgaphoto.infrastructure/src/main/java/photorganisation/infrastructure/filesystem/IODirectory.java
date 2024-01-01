package photorganisation.infrastructure.filesystem;

import photorganisation.domaine.entities.DirectoryEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IODirectory {
    public IODirectory() {
    }

    public DirectoryEntity getPhotosInDirectory(String directory) {
        File directoryFile = new File(directory);

        File[] fileList = directoryFile.listFiles();

        return new DirectoryEntity(
                directoryFile,
                directory,
                fileList != null?List.of(fileList):new ArrayList<>());
    }
}
