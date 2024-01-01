package photorganisation.domaine.entities;

import java.time.LocalDateTime;

public class PhotoMetadata {
	private LocalDateTime creationDate;
	private GPSCoordinate gpsCoordinate;

	public PhotoMetadata() {
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public GPSCoordinate getGpsCoordinate() {
		return gpsCoordinate;
	}

	public void setGpsCoordinate(GPSCoordinate gpsCoordinate) {
		this.gpsCoordinate = gpsCoordinate;
	}

	@Override
	public String toString() {
		return "PhotoMetadata{" +
				"creationDate=" + creationDate +
				", gpsCoordinate=" + gpsCoordinate +
				'}';
	}
}
