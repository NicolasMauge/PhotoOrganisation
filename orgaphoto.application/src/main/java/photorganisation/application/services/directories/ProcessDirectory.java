package photorganisation.application.services.directories;

import photorganisation.application.common.PhotoUtils;
import photorganisation.application.mappers.FileToPhotoMapper;
import photorganisation.domaine.entities.DirectoryEntity;
import photorganisation.domaine.entities.PhotoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ProcessDirectory implements IProcessDirectory {
	private final IDirectoryService directoryService;
	private final FileToPhotoMapper mapper;

	public ProcessDirectory(IDirectoryService directoryService, FileToPhotoMapper mapper) {
		this.directoryService = directoryService;
		this.mapper = mapper;
	}

	@Override
	public List<CompletableFuture<PhotoEntity>> processDirectory(String directory) {
		DirectoryEntity directoryEntity = directoryService.createDirectoryEntityFromPath(directory);

		List<CompletableFuture<PhotoEntity>> photoToProcess = new ArrayList<>();
		List<DirectoryEntity> directoriesToProcess = new ArrayList<>();

		System.out.println("Répertoire : "+directory);
		directoryEntity.listePhotosInDirectory()
				.forEach(fileOrDirectory -> {
							if (fileOrDirectory.isFile()) {
								if (PhotoUtils.isPhoto(fileOrDirectory)) {
									System.out.println("-> photo");
									photoToProcess.add(CompletableFuture.supplyAsync(() ->
											mapper.FileToPhoto(fileOrDirectory))
									);
								}
							} else {
								directoriesToProcess.add(directoryService.createDirectoryEntityFromPath(fileOrDirectory.getPath()));
							}
						}
				);

		directoriesToProcess.forEach(directoryToProcess ->
				photoToProcess.addAll(processDirectory(directoryToProcess.directoryPath())));

		return photoToProcess;
	}
}
