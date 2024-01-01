package photorganisation.infrastructure.metadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import photorganisation.domaine.entities.GPSCoordinate;
import photorganisation.domaine.entities.PhotoMetadata;
import photorganisation.infrastructure.common.DateUtils;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


public class MetadataFromPhoto {
	private final String ORIGINAL_DATE_TAG = "Date/Time Original";
	private final String GPS_TAG_LATITUDE = "GPS Latitude";
	private final String GPS_TAG_LONGITUDE = "GPS Longitude";

	public PhotoMetadata getMetadataFromPhoto(File file) {
		PhotoMetadata photoMetadata = new PhotoMetadata();
		GPSCoordinate gpsCoordinate = new GPSCoordinate();

		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);

			metadata
					.getDirectories()
					.forEach(d -> d.getTags()
							.forEach(tag -> {
								// System.out.println("-------------");
								// System.out.println(tag.getTagName());
								// System.out.println(tag.getDescription());
								switch (tag.getTagName()) {
									case ORIGINAL_DATE_TAG:
										LocalDateTime originalDate = DateUtils.stringToLocalDateTime(tag.getDescription());
										photoMetadata.setCreationDate(originalDate);
										break;

									case GPS_TAG_LATITUDE:
										gpsCoordinate.setLatitude(tag.getDescription());
										break;

									case GPS_TAG_LONGITUDE:
										gpsCoordinate.setLongitude(tag.getDescription());
										break;
								}
							})
					);

			if(gpsCoordinate.getLatitude() != null && gpsCoordinate.getLongitude() != null) {
				photoMetadata.setGpsCoordinate(gpsCoordinate);
			}
		} catch (ImageProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return photoMetadata;
	}

}
