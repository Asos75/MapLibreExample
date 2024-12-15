# MapLibreExample

## Osnovno

[MapLibre Native](https://github.com/maplibre/maplibre-native) je knjižnica, ki omogoča prikaz zemljevidov na različnih platformah. Začela je kot fork knjižnice [mapbox-gl-native](https://github.com/mapbox/mapbox-gl-native), preden da so slednji prešli na non-OSS (Open source) licenco.


## Zakaj MapLibre
- MapLibre je odprtokoden in povsem zastonj
- MapLibre omogoča obsežno prilagoditev zemljevidov (kot so slogi ploščic, funkcije in interaktivnost) pri čimer ima uporabnik popoln nadzor nad videzom in funkcionalnostjo.
- Ker je odprtokoden, nismo vezani na enega ponudnika, ki lahko spremeni pogoje uporabe ali pa ceno
- Ima močno odprtokodno skupnost, ki projekt še vedno redno posodablja
- V primerjavi z nekaterimi ponudniki ne zbira podatke o uporabnikih

## Licenca

MapLibre je licenčirana pod [BSD-2 licenco](https://github.com/maplibre/maplibre-native/blob/main/LICENSE.md), ki dovoljuje  

- ✅ poslovno uporabo
- ✅ spreminjanje kode
- ✅ distribucijo
- ✅ uporabo za lastne potrebe

Ne pride pa z 
- ❌ Odgovornosjo
- ❌ Garancijo

## Vzdrževanje projekta
Map libre ima nekaj več kot 300 programerjev, ki so pripomogli, h glavni branži projekta, ki ima skoraj vsak teden  več kot 10 commitov.

![image](https://github.com/user-attachments/assets/56b35901-40f0-4b5c-be9f-955b2cddae75)

## Primeri uporabe

### Osnovni zemljevid

Za osnovni zemljevid moramo ustvariti postavitev:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <org.maplibre.android.maps.MapView
        android:id="@+id/mapView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:ignore="SpeakableTextPresentCheck"
        tools:layout_editor_absoluteX="138dp"
        tools:layout_editor_absoluteY="126dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

```kt
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Declare a variable for MapView
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapLibre.getInstance(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapView = binding.mapView

        mapView.getMapAsync { map ->
            map.setStyle("https://demotiles.maplibre.org/style.json")
            map.cameraPosition = CameraPosition.Builder().target(LatLng(0.0,0.0)).zoom(1.0).build()
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
}
```

<img src="https://github.com/user-attachments/assets/d2bf11e4-0bdd-48ff-9ec5-2627e891d044" alt="Basic Map" width="300">

### Spreminjanje stila zemljevida

S spodnjo funkcijo lahko spremenimo stil zemljevida, vire za stile lahko pridobimo na strani [MapTiler](https://cloud.maptiler.com/maps/)

```kt
        mapView.getMapAsync { map ->
            map.setStyle("https://api.maptiler.com/maps/basic-v2/style.json?key=edLZt73rEDhxduO04K4w")
            map.cameraPosition = CameraPosition.Builder().target(LatLng(46.558870, 15.637961)).zoom(15.0).build()
        }
```

<div>
    <img src="https://github.com/user-attachments/assets/62847fa5-fed1-475b-a980-4a2366ad254a" alt="Street Map" width="300" />
    <img src="https://github.com/user-attachments/assets/51321d7f-6541-4f5e-bbec-cfa58a4c4270" alt="Satellite Map" width="300" />
</div>

### Dodajanje markerjev

MapLibre omogoča dodajanje markerjev na zemljevid, ki uporabljajo MapLibre različico LatLng komponente, markerjem lahko dodamo še naslov in opis

```kt
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

//OTHER FUNCTIONS

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

```

<img src="https://github.com/user-attachments/assets/63d69ec7-a857-4e90-b630-9b6c3ccc292d" alt="Marker Map" width="300" />
