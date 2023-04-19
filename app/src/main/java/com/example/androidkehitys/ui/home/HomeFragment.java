package com.example.androidkehitys.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidkehitys.GameActivity;
import com.example.androidkehitys.R;
import com.example.androidkehitys.companies.DataActivity;
import com.example.androidkehitys.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    public static final String TAG ="MainActivity";
    private Button testBtn;
    private TextView helloText;
    private Button playBtn;
    private Button searchBtn;
    private EditText searchInput;





private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button button = (Button) root.findViewById(R.id.button);
        helloText = root.findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (helloText.getVisibility() == View.VISIBLE) {
                    helloText.setVisibility(View.INVISIBLE);
                } else {
                    helloText.setVisibility(View.VISIBLE);
                }


            }

        });
        searchBtn = (Button) root.findViewById(R.id.search_button);
        playBtn = (Button) root.findViewById(R.id.game_button);
        searchInput = (EditText) root.findViewById(R.id.company_name);
        playBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "Play game button clicked");


                Intent i = new Intent(v.getContext(), GameActivity.class);
                startActivity(i);
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "SearchCompany -button clicked");


                Intent i = new Intent(v.getContext(), DataActivity.class);
                i.putExtra("value1", searchInput.getText().toString());

                startActivity(i);
            }
        });

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}