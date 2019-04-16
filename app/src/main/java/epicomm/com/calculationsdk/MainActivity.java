package epicomm.com.calculationsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import epicomm.com.calcsdk.Calculation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnSub, btnMul, btnDiv;
    private EditText edtValueOfA, edtValueOfB;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_addition);
        btnSub = findViewById(R.id.btn_substraction);
        btnMul = findViewById(R.id.btn_multiplication);
        btnDiv = findViewById(R.id.btn_division);

        edtValueOfA = findViewById(R.id.edt_value_a);
        edtValueOfB = findViewById(R.id.edt_value_b);

        tvResult = findViewById(R.id.tv_result);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int valueA = 0, valueB = 0;

        try{
            //int i = Integer.parseInt(input);
             valueA = Integer.parseInt(edtValueOfA.getText().toString().trim());
             valueB = Integer.parseInt(edtValueOfB.getText().toString().trim());
        }catch(NumberFormatException ex){ // handle your exception
            ex.printStackTrace();
        }



        switch (v.getId()) {
            case R.id.btn_addition:
                tvResult.setText(""+Calculation.Addition(valueA, valueB));
                break;

            case R.id.btn_substraction:
                tvResult.setText(""+Calculation.Substraction(valueA, valueB));
                break;

            case R.id.btn_multiplication:
                tvResult.setText(""+Calculation.Multiplication(valueA, valueB));
                break;

            case R.id.btn_division:
                if(valueA != 0 && valueB != 0) {
                    tvResult.setText(""+Calculation.Division(valueA, valueB));
                } else {
                    tvResult.setText("Cannot Divide By Zero");
                }
                break;
        }
    }
}