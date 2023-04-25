package com.example.androidkehitys.ui.notifications;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.renderscript.ScriptGroup;
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

import java.util.concurrent.TimeUnit;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    CountDownTimer timer;
    int millisekunnit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView aikaText = binding.aikaText;

        final NumberPicker numPicker = binding.numberpickerMainPicker;
        final MaterialButtonToggleGroup buttons = binding.toggleButton;
        numPicker.setMinValue(0);
        numPicker.setMaxValue(60);

        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                aikaText.setText(String.valueOf(numberPicker.getValue()));
                millisekunnit=numberPicker.getValue();
            }
        });

        buttons.addOnButtonCheckedListener(
                new MaterialButtonToggleGroup.OnButtonCheckedListener() {
                    @Override
                    public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                        if (isChecked) {
                            if (checkedId == binding.buttonStart.getId()) {
                                aikaText.setVisibility(View.VISIBLE);  //If user presses 'start' button, the value of seconds comes to visible.
                                timer= new CountDownTimer(millisekunnit*1000+1000, 1000) { //lets put the right values to parameters. CountDownTimer works with milliseconds so that's why the value needs to be multiplied by 1000.

                                    public void onTick(long millisUntilFinished) {  //'onTick()' function runs when countdown is running. Here we set the running value(mins and secs) to the 'aikaText'.
                                        aikaText.setText(""+String.format("%d min, %d sec",
                                                TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                                        millisekunnit=millisekunnit-1;
                                    }
                                    public void onFinish() { //function 'onFinish()' runs when countdown ends.
                                        aikaText.setText("Loppu");

                                    }
                                }.start();
                            } else if (checkedId == binding.buttonPause.getId()) {
                                if (timer!=null){
                                    timer.cancel();
                                }

                            } else if (checkedId == binding.buttonStop.getId()) {

                                if (timer!=null){
                                    timer.cancel();
                                    aikaText.setVisibility(View.INVISIBLE);
                                    aikaText.setText(String.valueOf(0));
                                }

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

