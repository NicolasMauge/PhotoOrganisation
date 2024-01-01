package photorganisation.batch.factories;

import photorganisation.infrastructure.filesystem.FileHashMD5;

public class FileHashMD5Factory {
	public static FileHashMD5 get() {
		return new FileHashMD5();
	}
}
