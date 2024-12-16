package sosteric.pora.maplibreexample

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import org.maplibre.android.MapLibre
import org.maplibre.android.annotations.MarkerOptions
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapLibreMap
import org.maplibre.android.maps.MapView
import sosteric.pora.maplibreexample.databinding.ActivityMainBinding
import sosteric.pora.mylibrary.Location
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var locations = mutableListOf<Location>()

    // Declare a variable for MapView
    private lateinit var mapView: MapView
    private lateinit var mapLibreMap: MapLibreMap

    override fun onCreate(savedInstanceState: Bundle?) {
        createLocations()

        super.onCreate(savedInstanceState)

        MapLibre.getInstance(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapView = binding.mapView

        mapView.getMapAsync { map ->
            mapLibreMap = map

            map.setStyle("https://api.maptiler.com/maps/basic-v2/style.json?key=edLZt73rEDhxduO04K4w")
            map.cameraPosition = CameraPosition.Builder().target(LatLng(46.558870, 15.637961)).zoom(15.0).build()

            showMarkers(locations.size)
        }
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    private fun showMarkers(amount: Int) {
        if (!this::mapLibreMap.isInitialized || mapView.isDestroyed) {
            return
        }
        mapLibreMap.clear()
        showGlMarkers()
    }
    private fun showGlMarkers() {
        val markerOptionsList: MutableList<MarkerOptions> = ArrayList()

        for (i in 0 until locations.size) {
            val currentLandmark = locations[i]
            val latLng = LatLng(currentLandmark.latitude, currentLandmark.longitude)
            markerOptionsList.add(
                MarkerOptions()
                    .position(latLng)
                    .title(currentLandmark.name)
                    .snippet(currentLandmark.description)
            )
        }
        mapLibreMap.addMarkers(markerOptionsList)
    }

    private fun createLocations() {
        locations.add(Location(46.55916438086847, 15.638205299929304,"FERI", "Fakulteta za Elektrotehniko in Računalništvo", UUID.randomUUID().toString() ))
        locations.add(Location(46.559457238497714, 15.63925494021757,"FS", "Fakulteta za Strojništvo", UUID.randomUUID().toString() ))
        locations.add(Location(46.563677914633594, 15.624264240774403,"FNM", "Fakulteta za Naravoslovje in Matematiko", UUID.randomUUID().toString() ))
        locations.add(Location(46.56281185042472, 15.646055665346537,"FP", "Pravna fakulteta", UUID.randomUUID().toString() ))
        locations.add(Location(46.5548922787966, 15.647145824223292,"MF", "Medicinska fakulteta", UUID.randomUUID().toString() ))
        locations.add(Location(46.56197554442562, 15.652450035025074,"EPF", "Ekonomsko Poslovna Fakulteta", UUID.randomUUID().toString() ))
        locations.add(Location(46.55923838881618, 15.643262049213327,"Rektorat", "Rektorat univerze v Mariboru", UUID.randomUUID().toString() ))
    }
}