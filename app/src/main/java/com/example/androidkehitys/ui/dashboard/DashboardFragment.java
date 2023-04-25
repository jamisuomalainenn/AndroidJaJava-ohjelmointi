package com.example.androidkehitys.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.androidkehitys.databinding.FragmentDashboardBinding;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidkehitys.databinding.FragmentDashboardBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.Locale;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    public static final String TAG ="Dashboard";
    TextInputEditText latitudeField;
    TextInputEditText longitudeField;
    TextInputEditText addressField;
    Button searchButton;

    private static final int REQUEST_FINAL_LOCATION=111;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);



        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        latitudeField=binding.latitudeText;
        longitudeField=binding.longitudeText;
        addressField=binding.addressText;
        searchButton=binding.searchButton;

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Log.e(TAG, "onLocationChanged"+String.valueOf(location.getLatitude()));
                latitudeField.setText(String.valueOf(location.getLatitude()));
                longitudeField.setText(String.valueOf(location.getLongitude()));
                addressField.setText(String.valueOf(getAddress(location)));
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };


        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            //checkPermission(String.valueOf(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)), 400);
            String[]permissions=new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

            ActivityCompat.requestPermissions(getActivity(),permissions,REQUEST_FINAL_LOCATION);


            return root;
        }



        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListener);
        Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        if(lastLocation!=null){
            Log.e(TAG,"lastLocation"+ String.valueOf(lastLocation.getLatitude()));
            latitudeField.setText(String.valueOf(lastLocation.getLatitude()));
            longitudeField.setText((String.valueOf(lastLocation.getLongitude())));
            addressField.setText(getAddress(lastLocation));

        }
        else {
            Log.e(TAG,"null");
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri=Uri.parse("geo: "+lastLocation.getLatitude()+", "+lastLocation.getLongitude());
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if(mapIntent.resolveActivity(getContext().getPackageManager())!=null){

                    startActivity(mapIntent);
                }
                Log.i(TAG,String.valueOf(lastLocation));
            }
        });



        return root;
    }

    public void refresh(){

        onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // Function to check and request permission
    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(getContext(), permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] { permission }, requestCode);
        }
        else {

        }
    }



    public String getAddress(Location location){

        try {
            Geocoder geocoder;
            List<Address> addresses;
            Locale finnish = new Locale("fi", "FI");
            geocoder = new Geocoder(getContext(), finnish);
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1); // Here 1 represent maxResults

            String address = addresses.get(0).getAddressLine(0); // getAddressLine returns a line of the address
            // numbered by the given index
            String city = addresses.get(0).getLocality();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();


            return address;
        }
        catch (Exception e) {

            Log.e(TAG, String.valueOf(e));

        }
        return null;
    }



    @Override
    public void onResume(){
        super.onResume();
        Log.e(TAG,"onresume");

        //latitudeField.setText(String.valueOf(location.getLatitude()));
        //longitudeField.setText(String.valueOf(location.getLongitude()));
        //addressField.setText(String.valueOf(getAddress(location)));

    }


}