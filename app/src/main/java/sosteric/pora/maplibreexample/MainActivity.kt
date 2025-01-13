package sosteric.pora.maplibreexample

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.maplibre.android.MapLibre
import org.maplibre.android.annotations.MarkerOptions
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapLibreMap
import org.maplibre.android.maps.MapView
import org.maplibre.android.style.layers.FillLayer
import org.maplibre.android.style.layers.PropertyFactory.*
import org.maplibre.android.style.layers.SymbolLayer
import org.maplibre.android.style.sources.GeoJsonSource
import sosteric.pora.maplibreexample.databinding.ActivityMainBinding
import sosteric.pora.mylibrary.Location
import java.util.*

class MainActivity : AppCompatActivity() {
    val geoJson = """
    {
  "type": "FeatureCollection",
  "properties": {
    "name": "Maribor"
  },
  "features": [
    {
      "type": "Feature",
      "properties": {
        "name": "Prezihova ulica"
      },
      "geometry": {
        "type": "MultiLineString",
        "coordinates": [
          [
            [
              15.63851,
              46.561034
            ],
            [
              15.638105,
              46.559885
            ]
          ],
          [
            [
              15.638368,
              46.560652
            ],
            [
              15.640035,
              46.560271
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Smetanova ulica"
      },
      "geometry": {
        "type": "MultiLineString",
        "coordinates": [
          [
            [
              15.638105,
              46.559885
            ],
            [
              15.641695,
              46.559086
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Strossmayerjeva ulica"
      },
      "geometry": {
        "type": "MultiLineString",
        "coordinates": [
          [
            [
              15.641695,
              46.559086
            ],
            [
              15.642067,
              46.560404
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Gosposvetska cesta"
      },
      "geometry": {
        "type": "MultiLineString",
        "coordinates": [
          [
            [
              15.642067,
              46.560404
            ],
            [
              15.63851,
              46.561034
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Shotel"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.639203221499757,
                46.55970334393874
              ],
              [
                15.638855795318722,
                46.559772772589504
              ],
              [
                15.638912177594705,
                46.55987391277854
              ],
              [
                15.639057268346525,
                46.559839354547876
              ],
              [
                15.63915399460499,
                46.560057139547865
              ],
              [
                15.639332276390356,
                46.56003888226086
              ],
              [
                15.639203221499757,
                46.55970334393874
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "III. Gimnazija"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.639662470052444,
                46.5596237959046
              ],
              [
                15.639385656512982,
                46.559683008524516
              ],
              [
                15.639531329321645,
                46.56001534658982
              ],
              [
                15.639157781091196,
                46.560104326833525
              ],
              [
                15.63929789893947,
                46.56042024208084
              ],
              [
                15.639882677828112,
                46.560284836847124
              ],
              [
                15.639749781413952,
                46.55999503707384
              ],
              [
                15.640162639987805,
                46.55990327800719
              ],
              [
                15.64039778484617,
                46.560378104101375
              ],
              [
                15.640696197384374,
                46.56031585295745
              ],
              [
                15.640798518242065,
                46.560504293636555
              ],
              [
                15.640898727515479,
                46.560494262485506
              ],
              [
                15.64078208896493,
                46.56021707475912
              ],
              [
                15.640626145934823,
                46.56024366195061
              ],
              [
                15.640359809289281,
                46.55968611442997
              ],
              [
                15.640084148978977,
                46.55973474223506
              ],
              [
                15.640139303443409,
                46.55982749525504
              ],
              [
                15.639834854234946,
                46.55989952774053
              ],
              [
                15.639662470052444,
                46.5596237959046
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Prezihova ulica 12"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.638460113702665,
                46.560052456702934
              ],
              [
                15.63828754001033,
                46.560098845501145
              ],
              [
                15.638339527428363,
                46.56026319994433
              ],
              [
                15.63852574438652,
                46.56022123557798
              ],
              [
                15.638460113702665,
                46.560052456702934
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Prezihova ulica 16"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.639176480412981,
                46.56030354248446
              ],
              [
                15.638988127353995,
                46.56035119433799
              ],
              [
                15.639026762121642,
                46.56044815853768
              ],
              [
                15.639221840284705,
                46.560388721985504
              ],
              [
                15.639176480412981,
                46.56030354248446
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Gosposvetska cesta 19-B"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.638808960517105,
                46.560612981830225
              ],
              [
                15.6385730210954,
                46.56066657229793
              ],
              [
                15.638667757590516,
                46.56087865314411
              ],
              [
                15.638908558255187,
                46.56082295249442
              ],
              [
                15.638808960517105,
                46.560612981830225
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Gosposvetska cesta 19-A"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.639346891527955,
                46.56068443647533
              ],
              [
                15.638890668564411,
                46.56078584809794
              ],
              [
                15.638940664759046,
                46.56088897986417
              ],
              [
                15.639389388921586,
                46.560786708596595
              ],
              [
                15.639346891527955,
                46.56068443647533
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "racunalnisko programiranje in svetovanje"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.639556180265794,
                46.560637728349
              ],
              [
                15.639345656715935,
                46.56068532706138
              ],
              [
                15.639393097143392,
                46.56078644636638
              ],
              [
                15.639603983155155,
                46.56073759564748
              ],
              [
                15.639556180265794,
                46.560637728349
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Gosposvetska cesta 15"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.639961846026893,
                46.56054870588068
              ],
              [
                15.639557503272556,
                46.560636768908545
              ],
              [
                15.639605112218302,
                46.560738663855574
              ],
              [
                15.639997385708847,
                46.56064967856221
              ],
              [
                15.63998129218974,
                46.56058974043146
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Gosposvetska cesta 11"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.640108315371025,
                46.56031983454386
              ],
              [
                15.639882619983176,
                46.560370693899046
              ],
              [
                15.63998129218974,
                46.56058974043146
              ],
              [
                15.64021452593424,
                46.56053696430419
              ],
              [
                15.640108315371025,
                46.56031983454386
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "round"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.641281868757492,
                46.56036933302591
              ],
              [
                15.641281982317594,
                46.56036932619456
              ],
              [
                15.641282092427227,
                46.560369305908054
              ],
              [
                15.641282195740768,
                46.56036927278279
              ],
              [
                15.64128228911909,
                46.56036922782528
              ],
              [
                15.641282369724937,
                46.560369172401515
              ],
              [
                15.641282435109138,
                46.56036910819551
              ],
              [
                15.641282483285035,
                46.560369037158175
              ],
              [
                15.641282512788822,
                46.5603689614479
              ],
              [
                15.64128252272404,
                46.560368883365115
              ],
              [
                15.641282512788822,
                46.56036880528233
              ],
              [
                15.641282483285032,
                46.56036872957206
              ],
              [
                15.641282435109135,
                46.56036865853471
              ],
              [
                15.64128236972493,
                46.560368594328715
              ],
              [
                15.641282289119083,
                46.56036853890496
              ],
              [
                15.641282195740764,
                46.56036849394744
              ],
              [
                15.641282092427224,
                46.56036846082218
              ],
              [
                15.641281982317592,
                46.560368440535676
              ],
              [
                15.641281868757492,
                46.56036843370432
              ],
              [
                15.641281755197394,
                46.560368440535676
              ],
              [
                15.641281645087762,
                46.56036846082218
              ],
              [
                15.64128154177422,
                46.56036849394744
              ],
              [
                15.641281448395901,
                46.56036853890496
              ],
              [
                15.641281367790056,
                46.560368594328715
              ],
              [
                15.641281302405849,
                46.56036865853471
              ],
              [
                15.641281254229954,
                46.56036872957206
              ],
              [
                15.641281224726164,
                46.56036880528233
              ],
              [
                15.641281214790945,
                46.560368883365115
              ],
              [
                15.641281224726164,
                46.5603689614479
              ],
              [
                15.64128125422995,
                46.560369037158175
              ],
              [
                15.641281302405847,
                46.56036910819551
              ],
              [
                15.641281367790048,
                46.560369172401515
              ],
              [
                15.641281448395896,
                46.56036922782528
              ],
              [
                15.641281541774218,
                46.56036927278279
              ],
              [
                15.641281645087759,
                46.560369305908054
              ],
              [
                15.64128175519739,
                46.56036932619456
              ],
              [
                15.641281868757492,
                46.56036933302591
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Strossmayerjeva ulica 17"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.641313361666967,
                46.56043607746525
              ],
              [
                15.641985181150568,
                46.56031760715063
              ],
              [
                15.641816014722657,
                46.55978730311646
              ],
              [
                15.641636218739958,
                46.5598016412979
              ],
              [
                15.641637465762324,
                46.55983759193523
              ],
              [
                15.641552769342464,
                46.5598518247696
              ],
              [
                15.6415968736157,
                46.56002768177458
              ],
              [
                15.641710676025372,
                46.5600102022166
              ],
              [
                15.641763810175021,
                46.560209298482505
              ],
              [
                15.641267434932377,
                46.560297822765584
              ],
              [
                15.641313361666967,
                46.56043607746525
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Strossmayerjeva ulica 11"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.641657399827597,
                46.55931012101587
              ],
              [
                15.64149869711756,
                46.55933633871734
              ],
              [
                15.641667316530725,
                46.55987643559219
              ],
              [
                15.641826229653532,
                46.559846387264066
              ],
              [
                15.641657399827597,
                46.55931012101587
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Gosposvetska cesta 5"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.641579967250534,
                46.55988753394554
              ],
              [
                15.641143746497914,
                46.559954041989585
              ],
              [
                15.641079263820862,
                46.559751906037825
              ],
              [
                15.640891499445875,
                46.55978189925338
              ],
              [
                15.640997705479753,
                46.56010531699261
              ],
              [
                15.641616002730894,
                46.5600114235362
              ],
              [
                15.641579967250534,
                46.55988753394554
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "Sers"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.64137839459929,
                46.55951242706003
              ],
              [
                15.641034275545856,
                46.55957254725419
              ],
              [
                15.640920391506182,
                46.55936631452435
              ],
              [
                15.64063684589082,
                46.559417619463254
              ],
              [
                15.640854066440918,
                46.55987315919011
              ],
              [
                15.640937861926686,
                46.559849725469775
              ],
              [
                15.640944047626611,
                46.55967005431776
              ],
              [
                15.64106877646735,
                46.559645004832795
              ],
              [
                15.64115230729416,
                46.559812377157506
              ],
              [
                15.641474054762519,
                46.55974230649605
              ],
              [
                15.64137839459929,
                46.55951242706003
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "lastovka"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.641254336505751,
                46.5592334379527
              ],
              [
                15.64113906703964,
                46.559258266185616
              ],
              [
                15.641165453871462,
                46.5593146074733
              ],
              [
                15.641279334652316,
                46.559290256679546
              ],
              [
                15.641254336505751,
                46.5592334379527
              ]
            ]
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
        "name": "3DVA"
      },
      "geometry": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                15.641580163698059,
                46.559187797786414
              ],
              [
                15.641515120106904,
                46.55919932461207
              ],
              [
                15.641521825575744,
                46.55922514481506
              ],
              [
                15.641589551371016,
                46.55921315690404
              ],
              [
                15.641580163698059,
                46.559187797786414
              ]
            ]
          ]
        ]
      }
    }
  ]
}
    """

    private lateinit var binding: ActivityMainBinding
    private var locations = mutableListOf<Location>()

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

            map.setStyle("https://api.maptiler.com/maps/basic-v2/style.json?key=edLZt73rEDhxduO04K4w") { style ->
                map.cameraPosition = CameraPosition.Builder()
                    .target(LatLng(46.558870, 15.637961))
                    .zoom(15.0)
                    .build()

                showMarkers(locations.size)
                addGeoJsonLayer(mapLibreMap)
            }
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
        locations.add(Location(46.55916438086847, 15.638205299929304, "FERI", "Fakulteta za Elektrotehniko in Računalništvo", UUID.randomUUID().toString()))
        locations.add(Location(46.559457238497714, 15.63925494021757, "FS", "Fakulteta za Strojništvo", UUID.randomUUID().toString()))
        locations.add(Location(46.563677914633594, 15.624264240774403, "FNM", "Fakulteta za Naravoslovje in Matematiko", UUID.randomUUID().toString()))
        locations.add(Location(46.56281185042472, 15.646055665346537, "FP", "Pravna fakulteta", UUID.randomUUID().toString()))
        locations.add(Location(46.5548922787966, 15.647145824223292, "MF", "Medicinska fakulteta", UUID.randomUUID().toString()))
        locations.add(Location(46.56197554442562, 15.652450035025074, "EPF", "Ekonomsko Poslovna Fakulteta", UUID.randomUUID().toString()))
        locations.add(Location(46.55923838881618, 15.643262049213327, "Rektorat", "Rektorat univerze v Mariboru", UUID.randomUUID().toString()))
    }

    private fun addGeoJsonLayer(mapLibreMap: MapLibreMap) {
        mapLibreMap.getStyle { style ->
            val geoJsonSource = GeoJsonSource("geojson-source", geoJson)
            style.addSource(geoJsonSource)

            val geoJsonLayer = SymbolLayer("geojson-layer", "geojson-source").apply {
                withProperties(
                    textField("{name}"),
                    textSize(12f),
                    textOffset(arrayOf(0f, 1.5f)),
                    textAnchor("top")
                )
            }

            style.addLayer(geoJsonLayer)

            val fillLayer = FillLayer("fill-layer", "geojson-source").apply {
                withProperties(
                    fillColor("#FF0000"),
                    fillOpacity(0.5f)
                )
            }
            style.addLayer(fillLayer)

            mapLibreMap.cameraPosition = CameraPosition.Builder()
                .target(LatLng(46.55916438086847, 15.638205299929304))  // A point from your GeoJSON
                .zoom(14.0)  // Zoom level
                .build()
        }
    }

}
