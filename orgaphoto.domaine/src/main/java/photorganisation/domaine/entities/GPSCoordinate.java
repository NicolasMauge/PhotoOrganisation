package photorganisation.domaine.entities;

public class GPSCoordinate {
	private String latitude;
	private String longitude;

	public GPSCoordinate(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public GPSCoordinate() {
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "GPSCoordinate{" +
				"latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				'}';
	}
}
