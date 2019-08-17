package dapdog96.tipcalculator2;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.widget.RelativeLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText bill_amount;
    private EditText tip_percent;
    private float total_w_tip = 0;
    private float rounded_total = 0;
    private float round_amount;
    private TextView new_tip_percent;
    private TextView new_total_w_tip;
    private float tip_amount = 0;
    private Button calculateTip;
    private TextView lblBillAmount;
    private TextView lblPercent;
    private TextView lblTip;
    private TextView lblTotal;
    private float tip_percent_after_round;
    private float total;
    private Button resetTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout background = (RelativeLayout) findViewById(R.id.activity_main);
        Resources res = getResources();
        final TypedArray myImages = res.obtainTypedArray(R.array.myImages);
        final Random random = new Random();


            int randomInt = random.nextInt(myImages.length());
            int drawableID = myImages.getResourceId(randomInt, -1);
            background.setBackgroundResource(drawableID);



        bill_amount = (EditText) findViewById(R.id.txtBillAmount);
        tip_percent = (EditText) findViewById(R.id.txtPercent);
        new_tip_percent = (TextView) findViewById(R.id.txtTip);
        new_total_w_tip = (TextView) findViewById(R.id.txtTotal);
        lblTip = (TextView) findViewById(R.id.lblAmountToTip);
        lblTotal = (TextView) findViewById(R.id.lblTotal);
        calculateTip = (Button) findViewById(R.id.btnCalculate);
        resetTip = (Button) findViewById(R.id.btnReset);
        calculateTip.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (bill_amount.getText().toString().equals("") || bill_amount.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Must Enter Something", Toast.LENGTH_LONG).show();
                    return;
                }

                String billAmountString = bill_amount.getText().toString();
                float billAmountInt = Float.parseFloat(billAmountString);
                String tipPercentString = tip_percent.getText().toString();
                float tipPercentInt = Float.parseFloat(tipPercentString);

                tipPercentInt = tipPercentInt / 100;
                tip_amount = billAmountInt * tipPercentInt;
                total_w_tip = tip_amount + billAmountInt;
                rounded_total = Math.round(total_w_tip);
                round_amount = rounded_total - total_w_tip;
                tip_percent_after_round = round_amount + tip_amount;
                total = billAmountInt + tip_percent_after_round;
                new_tip_percent.setText(String.valueOf(String.format("%.2f",tip_percent_after_round)));
                new_total_w_tip.setText(String.valueOf(String.format("%.2f",total)));

            }
        });
        resetTip.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


            }
        });

    }
}


