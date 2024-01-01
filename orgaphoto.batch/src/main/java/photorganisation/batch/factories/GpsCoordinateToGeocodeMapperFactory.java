package photorganisation.batch.factories;

import photorganisation.application.mappers.GPSCoordinateToGeocodeMapper;

public class GpsCoordinateToGeocodeMapperFactory {
	public static GPSCoordinateToGeocodeMapper get() {
		return new GPSCoordinateToGeocodeMapper();
	}
}
