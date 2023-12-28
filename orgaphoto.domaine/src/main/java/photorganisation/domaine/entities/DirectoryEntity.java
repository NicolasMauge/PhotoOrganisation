package photorganisation.domaine.entities;

import java.io.File;
import java.util.List;

public class DirectoryEntity {
    private final String directory;
    private final List<File> listePhotosInDirectory;

    public DirectoryEntity(String directory, List<File> listePhotosInDirectory) {
        this.directory = directory;
        this.listePhotosInDirectory = listePhotosInDirectory;
    }

    public String getDirectory() {
        return directory;
    }

    public List<File> getListePhotosInDirectory() {
        return listePhotosInDirectory;
    }
}
