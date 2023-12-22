package photorganisation.domaine.entities;

import java.io.File;
import java.time.LocalDate;

public class PhotoEntity {
    private final File file;
    private final String photoName;
    private final String photoDirectory;
    private final String extension;
    private final LocalDate dateCreation;

    public PhotoEntity(File file, String photoName, String photoDirectory, String extension, LocalDate dateCreation) {
        this.file = file;
        this.photoName = photoName;
        this.photoDirectory = photoDirectory;
        this.extension = extension;
        this.dateCreation = dateCreation;
    }

    public File getFile() {
        return file;
    }

    public String getPhotoName() {
        return photoName;
    }

    public String getPhotoDirectory() {
        return photoDirectory;
    }

    public String getExtension() {
        return extension;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }
}
