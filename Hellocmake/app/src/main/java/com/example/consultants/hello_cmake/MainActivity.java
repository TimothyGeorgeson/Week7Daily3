package com.example.consultants.hello_cmake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView tvSum;
    private TextView tv;
    private EditText etNum1;
    private EditText etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = findViewById(R.id.sample_text);
        tvSum = findViewById(R.id.tvSum);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        tv.setText(stringFromJNI());

    }

    public void onAdd(View view) {
        tvSum.setText(sumFromJNI(Integer.parseInt(etNum1.getText().toString()),
                Integer.parseInt(etNum2.getText().toString())));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String sumFromJNI(int a, int b);
}
