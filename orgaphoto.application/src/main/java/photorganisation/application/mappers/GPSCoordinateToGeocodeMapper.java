package photorganisation.application.mappers;

import photorganisation.application.common.LocalUtils;
import photorganisation.domaine.entities.GPSCoordinate;

import java.util.Arrays;


public class GPSCoordinateToGeocodeMapper {
	public String GPSCoordinateToGeocode(GPSCoordinate gpsCoordinate) {
		if (gpsCoordinate != null) {
			Double latitude_dd = gpsDmsDecode(gpsCoordinate.getLatitude());
			Double longitude_dd = gpsDmsDecode(gpsCoordinate.getLongitude());
			return latitude_dd + ", " + longitude_dd;
		}

		return "";
	}

	private Double gpsDmsDecode(String degreMinuteSeconde) {
		String[] decoupage = degreMinuteSeconde.split(" ");
		Double degres = null;
		Double minutes = null;
		Double secondes = null;

		if (LocalUtils.getLastCharacter(decoupage[0]) == '°') {
			degres = Double.valueOf(LocalUtils.getAllCharactersExceptLast(decoupage[0]));
		}

		if (LocalUtils.getLastCharacter(decoupage[1]) == '\'') {
			minutes = Double.valueOf(LocalUtils.getAllCharactersExceptLast(decoupage[1]));
		}

		if (LocalUtils.getLastCharacter(decoupage[2]) == '"') {
			secondes = Double.valueOf(LocalUtils.getAllCharactersExceptLast(replaceCommaByPoint(decoupage[2])));
		}

		String direction = "";
		if (decoupage.length > 3) {
			direction = decoupage[3];
		}
		int signe = Arrays.asList("W", "S").contains(direction) ? -1 : 1;

		if (degres != null && minutes != null && secondes != null) {
			return (degres + minutes / 60 + secondes / 3600) * signe;
		}

		return (double) 0;
	}

	private String replaceCommaByPoint(String stringToProcess) {
		if (stringToProcess.contains(",")) {
			return stringToProcess.replace(",", ".");
		}

		return stringToProcess;
	}
}
