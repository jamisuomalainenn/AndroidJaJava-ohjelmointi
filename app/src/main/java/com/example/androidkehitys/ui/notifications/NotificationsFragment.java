package com.example.androidkehitys.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.androidkehitys.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final NumberPicker numPicker = binding.numberpickerMainPicker;
        numPicker.setMinValue(0);
        numPicker.setMaxValue(60);





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