package photorganisation.application.mappers;

import photorganisation.application.common.LocalUtils;
import photorganisation.application.services.dates.IDateCreationPhotoService;
import photorganisation.domaine.entities.PhotoEntity;
import photorganisation.domaine.entities.PhotoMetadata;
import photorganisation.infrastructure.filesystem.FileHashMD5;
import photorganisation.infrastructure.metadata.MetadataFromPhoto;

import java.io.File;


public class FileToPhotoMapper {
    private final GPSCoordinateToGeocodeMapper gpsCoordinateToGeocodeMapper;
    private final MetadataFromPhoto metadataFromPhoto;
    private final IDateCreationPhotoService dateCreationPhotoService;
    private final FileHashMD5 fileHashMD5;

    public FileToPhotoMapper(GPSCoordinateToGeocodeMapper gpsCoordinateToGeocodeMapper, MetadataFromPhoto metadataFromPhoto, IDateCreationPhotoService dateCreationPhotoService, FileHashMD5 fileHashMD5) {
        this.gpsCoordinateToGeocodeMapper = gpsCoordinateToGeocodeMapper;
        this.metadataFromPhoto = metadataFromPhoto;
        this.dateCreationPhotoService = dateCreationPhotoService;
        this.fileHashMD5 = fileHashMD5;
    }

    public PhotoEntity FileToPhoto(File file) {
        PhotoMetadata metadata = metadataFromPhoto.getMetadataFromPhoto(file);

        return new PhotoEntity(
                file,
                file.getName(),
                file.getAbsolutePath(),
                LocalUtils.getExtension(file.getName()).toLowerCase(),
                dateCreationPhotoService.getDateCreation(file, metadata),
                gpsCoordinateToGeocodeMapper.GPSCoordinateToGeocode(metadata.getGpsCoordinate()),
                fileHashMD5.getFileHashMD5(file)
        );
    }
}
