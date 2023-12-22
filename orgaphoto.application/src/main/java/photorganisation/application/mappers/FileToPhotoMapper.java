package photorganisation.application.mappers;

import photorganisation.application.common.Utils;
import photorganisation.domaine.entities.PhotoEntity;
import photorganisation.infrastructure.metadata.MetadataFromPhoto;

import java.io.File;

public class FileToPhotoMapper {
    public static PhotoEntity FileToPhotoEntity(File file) {
        return new PhotoEntity(
                file,
                file.getName(),
                file.getAbsolutePath(),
                Utils.getExtension(file.getName()),
                MetadataFromPhoto.getMetadataFromPhoto(file).getCreationDate()
        );
    }
}
