package ch.epfl.sweng.spotOn.localisation;

import android.location.LocationListener;
import android.location.LocationManager;

/**
 * Created by quentin on 23.11.16.
 */

public interface LocationManagerWrapper{

    void requestLocationUpdates(String provider, long minTime, float minDistance, LocationListener listener);

}
