package org.despotic.ahand.seekbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
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


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //set max 50 if isChecked, otherwise set max 100
                seekBar.setMax(isChecked?50:100);

                //set value label to reflect changes
                valueLabel.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //set label to progress value
                NumberFormat nf = NumberFormat.getInstance();
                valueLabel.setText(nf.format(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }
}
