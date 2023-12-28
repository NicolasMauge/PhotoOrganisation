package photorganisation.domaine.entities;

import java.time.LocalDate;

public class PhotoMetadata {
	private LocalDate creationDate;

	public PhotoMetadata(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public PhotoMetadata() {
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
}
