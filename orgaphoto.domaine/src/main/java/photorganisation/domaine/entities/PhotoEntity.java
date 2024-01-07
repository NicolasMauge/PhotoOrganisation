package photorganisation.domaine.entities;

import java.io.File;
import java.time.LocalDateTime;

public record PhotoEntity(File file,
						  String photoName,
						  String photoDirectory,
						  String extension,
						  LocalDateTime dateCreation,
						  String geocode,
						  String fileHashCode) {
}
