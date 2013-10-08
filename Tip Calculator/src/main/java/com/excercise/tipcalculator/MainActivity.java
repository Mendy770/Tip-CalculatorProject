package com.excercise.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.HashMap;

import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bindUI();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void bindUI() {
        ((Button)findViewById(R.id.tenPercentsButton)).setOnClickListener(buttonClickEventListener);
        ((Button)findViewById(R.id.fifteenPercentsButton)).setOnClickListener(buttonClickEventListener);
        ((Button)findViewById(R.id.twentyPercentButton)).setOnClickListener(buttonClickEventListener);
    }

    View.OnClickListener buttonClickEventListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Map<Integer,Float> map = new HashMap<Integer,Float>() {{
                put(R.id.tenPercentsButton, 0.1f);
                put(R.id.fifteenPercentsButton, 0.15f);
                put(R.id.twentyPercentButton, 0.2f);
            }};
            int viewID = view.getId();
            EditText amountInput = (EditText) findViewById(R.id.amountInput);
            TextView tipAmountDisplay = (TextView) findViewById(R.id.tipAmountDisplay);
            String amount = amountInput.getText().toString();
            NumberFormat format = NumberFormat.getCurrencyInstance();

            try {
                float numericAmount = Float.parseFloat(amount);
                tipAmountDisplay.setText(format.format(numericAmount * map.get(viewID)));
            }
            catch (java.lang.NumberFormatException x ) {
                tipAmountDisplay.setText("Please type a numeric value");
            }
        }
    };
}
