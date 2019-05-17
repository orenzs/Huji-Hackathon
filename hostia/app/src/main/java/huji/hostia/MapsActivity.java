package huji.hostia;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String restaurantId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        restaurantId = getIntent().getStringExtra("restaurantId");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String title = "Sushi";
        LatLng pos = new LatLng(31.774445,35.1910984);
        if (restaurantId == "China town") {
            title = "hamburger";
            pos = new LatLng(31.774445,35.1910984);
        }
        if (restaurantId == "Vitrina") {
            title = "Rice";
            pos = new LatLng(31.773749,35.1700529);
        }
        if (restaurantId == "McDonalds") {
            title = "Rice";
            pos = new LatLng(31.773749,35.1700529);
        }
        if (restaurantId == "CoffeShop") {
            title = "Rice";
            pos = new LatLng(31.773749,35.1700529);
        }
        if (restaurantId == "Adom") {
            title = "Rice";
            pos = new LatLng(31.7752192,35.1409427);
        }
        if (restaurantId == "Black") {
            title = "Black";
            pos = new LatLng(31.7752192,35.1409427);
        }
        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(pos).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 15.0f));
    }
}
