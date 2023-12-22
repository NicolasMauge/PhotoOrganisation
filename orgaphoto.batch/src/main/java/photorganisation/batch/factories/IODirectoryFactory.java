package photorganisation.batch.factories;

import photorganisation.infrastructure.filesystem.IODirectory;

public class IODirectoryFactory {
    public static IODirectory get() {
        return new IODirectory();
    }
}
