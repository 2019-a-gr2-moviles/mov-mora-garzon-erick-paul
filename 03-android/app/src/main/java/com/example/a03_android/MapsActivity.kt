package com.example.a03_android

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.DialogTitle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(),
    OnMapReadyCallback,
    GoogleMap.OnCameraMoveStartedListener,
    GoogleMap.OnCameraMoveListener,
    GoogleMap.OnCameraIdleListener,
    GoogleMap.OnPolylineClickListener,
    GoogleMap.OnPolygonClickListener {


    private lateinit var mMap: GoogleMap

    private var tienePermisosLocalizacion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        solicitarPermisosLocalizacion()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfiguracionMapa(mMap)
        establecerListenersMovimientoMapa(mMap)
        // Add a marker in Sydney and move the camera
        /*val sydney = LatLng(-0.210047, -78.488574)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,17f))*/

        val foch = LatLng(-0.202760, -78.490813)
        val titulo = "Plaza foch"
        val zoom = 17f

        anadirMarcador(foch, titulo)
        moverCamaraConZoom(foch, zoom)

        /*mMap.moveCamera(
            CameraUpdateFactory
                .newLatLngZoom(sydney, 17f)
        )*/

        val poliLineaUno = googleMap
            .addPolyline(
                PolylineOptions()
                    .clickable(true)
                    .add(
                        LatLng(-0.210462, -78.493948),
                        LatLng(-0.208218, -78.490163),
                        LatLng(-0.208583, -78.488940),
                        LatLng(-0.209377, -78.490303)
                    )
            )


        val poligonoUno = googleMap
            .addPolygon(
                PolygonOptions()
                    .clickable(true)
                    .add(
                        LatLng(-0.209431, -78.490078),
                        LatLng(-0.208734, -78.488951),
                        LatLng(-0.209431, -78.488286),
                        LatLng(-0.210085, -78.489745)
                    )
            )
        poligonoUno.fillColor = -0xc771c4

    }

    fun establecerListenersMovimientoMapa(map: GoogleMap) {
        with(map) {
            setOnCameraIdleListener(this@MapsActivity)
            setOnCameraMoveStartedListener(this@MapsActivity)
            setOnCameraMoveListener(this@MapsActivity)
            setOnPolylineClickListener(this@MapsActivity)
            setOnPolygonClickListener(this@MapsActivity)
        }
    }


    fun anadirMarcador(latLng: LatLng, title: String) {
        mMap.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
        )
    }

    fun moverCamaraConZoom(latLng: LatLng, zoom: Float = 10f) {
        mMap.moveCamera(
            CameraUpdateFactory
                .newLatLngZoom(latLng, zoom)
        )
    }

    fun establecerConfiguracionMapa(mapa: GoogleMap) {
        val contexto = this.applicationContext
        with(mapa) {

            val permisoFineLocation = ContextCompat.checkSelfPermission(
                contexto,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED
            if (tienePermiso) {
                mapa.isMyLocationEnabled = true
            }


            this.uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }
    }

    fun solicitarPermisosLocalizacion() {
        val permisoFineLocation = ContextCompat.checkSelfPermission(
            this.applicationContext,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED

        if (tienePermiso) {
            Log.i("mapa", "Tiene permisos de FINE_LOCATION")
            this.tienePermisosLocalizacion = true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1 //Codigo que vamos a esperar
            )
        }
    }

    override fun onCameraMove() {
        Log.i("map", "Me estoy moviendo")
    }

    override fun onCameraIdle() {
        Log.i("map", "Me quedo quieto")

    }

    override fun onCameraMoveStarted(p0: Int) {
        Log.i("map", "Me voy a empezar a mover")

    }

    override fun onPolylineClick(p0: Polyline?) {
        Log.i("map", "polilinea ${p0.toString()}")
    }

    override fun onPolygonClick(p0: Polygon?) {
        Log.i("map", "poligono ${p0.toString()}")
    }


}
