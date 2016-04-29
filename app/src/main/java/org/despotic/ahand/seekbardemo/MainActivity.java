package org.despotic.ahand.seekbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity  {

    private SeekBar seekBar;
    private Switch mSwitch;
    private TextView valueLabel;
    private TextView touchText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get widgets
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        mSwitch = (Switch) findViewById(R.id.switch1);
        valueLabel = (TextView) findViewById(R.id.valueLabel);
        touchText = (TextView) findViewById(R.id.touchTextView);


/**************SWITCH LISTENER**/
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //set max 50 if isChecked, otherwise set max 100
                seekBar.setMax(isChecked?50:100);

                //set value label to reflect changes
                valueLabel.setText(String.valueOf(seekBar.getProgress()));

            }

        });


/****************SEEKBAR LISTENER**/
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //set label to progress value
                NumberFormat nf = NumberFormat.getInstance();
                valueLabel.setText(nf.format(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                touchText.setText("Seek bar touched");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                touchText.setText("");
            }

        });

    }
}
