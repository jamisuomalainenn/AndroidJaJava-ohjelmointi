package com.example.androidkehitys.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.androidkehitys.databinding.FragmentNotificationsBinding;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class NotificationsFragment extends Fragment {

private FragmentNotificationsBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final NumberPicker numPicker = binding.numberpickerMainPicker;
        final MaterialButtonToggleGroup buttons = binding.toggleButton;
        numPicker.setMinValue(0);
        numPicker.setMaxValue(60);

        buttons.addOnButtonCheckedListener(
                new MaterialButtonToggleGroup.OnButtonCheckedListener() {
                    @Override
                    public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                        if (isChecked) {
                            if (checkedId == binding.buttonStart.getId()) {

                            } else if (checkedId == binding.buttonPause.getId()) {

                            } else if (checkedId == binding.buttonStop.getId()) {

                            }
                        }
                    }
                });


        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                // Code here executes on main thread after user selects value
            }
        });

        String[] strArray = new String[61];
        for (int i=0; i < strArray.length; i++){
            strArray[i] = i + " s";
        }
        numPicker.setDisplayedValues(strArray);

        return root;




        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

    }



@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

