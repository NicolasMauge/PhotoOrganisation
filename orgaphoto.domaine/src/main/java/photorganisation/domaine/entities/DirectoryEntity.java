package photorganisation.domaine.entities;

import java.io.File;
import java.util.List;

public record DirectoryEntity(File file,
							  String directoryPath,
							  List<File> listePhotosInDirectory) {
}
