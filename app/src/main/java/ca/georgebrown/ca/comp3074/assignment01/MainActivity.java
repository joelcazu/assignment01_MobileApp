package ca.georgebrown.ca.comp3074.assignment01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView totalText,taxText;
    private EditText numHours;
    private EditText valueRate;
    private Button bCalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalText = findViewById(R.id.text_totalpay);
        taxText = findViewById(R.id.text_tax);
        numHours = findViewById(R.id.edit_hours);
        valueRate = findViewById(R.id.edit_rate);
        bCalculator = findViewById(R.id.btn_calculate);

        bCalculator.setOnClickListener(new View.OnClickListener() {

            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View view) {
                int no_of_hours = Integer.parseInt(String.valueOf(numHours.getText()));
                double hourly_rate = Double.parseDouble(valueRate.getText().toString());
                double pay ;
                double tax = 0;

                if (no_of_hours <= 40) {
                    pay = no_of_hours * hourly_rate;
                    tax = pay * 0.18;
                    totalText.setText("Total pay : $ " + pay);


                } else {

                    pay = (no_of_hours - 40) * hourly_rate * 1.5 + (40 * hourly_rate);
                    tax = pay * 0.18;
                    totalText.setText("Total pay : $ " + pay);

                }
                taxText.setText(String.format("Tax : $ %.2f", tax));

            }

        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_about:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
        }
        return true;

    }
}