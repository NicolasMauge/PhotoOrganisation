package photorganisation.application.directories;

import photorganisation.application.common.PhotoUtils;
import photorganisation.application.mappers.FileToPhotoMapper;
import photorganisation.domaine.entities.DirectoryEntity;
import photorganisation.domaine.entities.PhotoEntity;

import java.util.ArrayList;
import java.util.List;

public class ProcessDirectory implements IProcessDirectory {
    private final IDirectoryService directoryService;

    public ProcessDirectory(IDirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @Override
    public void processDirectory(String directory) {
        DirectoryEntity directoryEntity = directoryService.listFilesFromDirectory(directory);

        List<PhotoEntity> photoToProcess = new ArrayList<>();
        List<DirectoryEntity> directoriesToProcess = new ArrayList<>();
        directoryEntity.getListePhotosInDirectory()
                .forEach(file -> {
                    System.out.println(file + " :");
                    if(file.isFile()) {
                        if(PhotoUtils.isPhoto(file)) {
                            System.out.println("-> photo");
                            photoToProcess.add(FileToPhotoMapper.FileToPhotoEntity(file));


                        }
                        else {
                            System.out.println("-> pas une photo");
                        }

                    } else {
                        System.out.println("directory");
                    }

                        }
                );

        System.out.println("---------------");

        photoToProcess.forEach(photoEntity -> System.out.println(photoEntity.getDateCreation()));
    }
}
