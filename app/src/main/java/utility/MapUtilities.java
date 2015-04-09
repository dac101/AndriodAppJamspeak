package utility;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import database.Marker;

/**
 * Created by dacorie on 08/04/2015.
 */
public class MapUtilities {
    public static void  setCameraPosition(Marker x,int zoom, GoogleMap googleMap) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(
                        x.getLatitude(),
                        x.getLongitude()))
                .zoom(zoom)
                .build();


        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }

    public static void setMapSetting(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

        // Showing / hiding your current location
        googleMap.setMyLocationEnabled(true);

        // Enable / Disable zooming controls
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        // Enable / Disable my location button
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

        // Enable / Disable Compass icon
        googleMap.getUiSettings().setCompassEnabled(true);

        // Enable / Disable Rotate gesture
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        // Enable / Disable zooming functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        googleMap.getUiSettings().isScrollGesturesEnabled();

        googleMap.getUiSettings().setAllGesturesEnabled(true);
    }

}
