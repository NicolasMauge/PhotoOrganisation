package photorganisation.infrastructure.filesystem;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileHashMD5 {
	public FileHashMD5() {
	}

	public String getFileHashMD5(File file) {
		try {
			byte[] data = Files.readAllBytes(Paths.get(file.getPath()));

			try {
				byte[] hash = MessageDigest.getInstance("MD5").digest(data);
				return new BigInteger(1, hash).toString(16);
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException();
			}
		} catch (IOException e) {
			return "";
		}
	}
}
