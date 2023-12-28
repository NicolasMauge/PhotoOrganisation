package photorganisation.infrastructure.metadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import photorganisation.domaine.entities.PhotoMetadata;
import photorganisation.infrastructure.common.DateUtils;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class MetadataFromPhoto {
	private static final String ORIGINAL_DATE_TAG = "Date/Time Original";
	public static PhotoMetadata getMetadataFromPhoto(File file) {
		PhotoMetadata photoMetadata = new PhotoMetadata();

		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			metadata
					.getDirectories()
					.forEach(d -> d.getTags()
							.forEach(tag -> {
								LocalDate originalDate;
								if(tag.getTagName().equals(ORIGINAL_DATE_TAG)) {
									originalDate = DateUtils.stringToLocalDate(tag.getDescription());
									photoMetadata.setCreationDate(originalDate);
								}
							})
					);

			 if(photoMetadata.getCreationDate() == null) {
				System.out.println("!!!!!!!!!!!!!!!");
				metadata
						.getDirectories()
						.forEach(d -> d.getTags()
								.forEach(tag -> {
									System.out.println(tag.getTagName());
									System.out.println(tag.getDescription());
								}));
			}
		} catch (ImageProcessingException | IOException e) {
			throw new RuntimeException(e);
		}

		return photoMetadata;
	}

}
