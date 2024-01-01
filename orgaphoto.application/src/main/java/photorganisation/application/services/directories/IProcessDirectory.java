package photorganisation.application.services.directories;

import photorganisation.domaine.entities.PhotoEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IProcessDirectory {
    List<CompletableFuture<PhotoEntity>> processDirectory(String directory);
}
