package com.example.zgadywanieliczby;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int wylosuj(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

    int min = 0;
    int max = 100;
    int wylosowanaLiczba = 0;
    int licznik = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView proby = findViewById(R.id.proby);
        EditText minimum = findViewById(R.id.min);
        EditText maximum = findViewById(R.id.max);
        EditText liczba = findViewById(R.id.liczba);

        wylosowanaLiczba = wylosuj(min, max);


        Button nowaGra = findViewById(R.id.nowaGra);
        nowaGra.setOnClickListener(v -> {
            try {
                min = Integer.parseInt(String.valueOf(minimum.getText()));
                max = Integer.parseInt(String.valueOf(maximum.getText()));
                wylosowanaLiczba = wylosuj(min, max);
                licznik = 0;
                proby.setText("Liczba prób: " + licznik);
                Toast mytoast = Toast.makeText(getApplicationContext(), "Wylosowano nową liczbę", Toast.LENGTH_SHORT);
                mytoast.show();
            } catch (Exception e) {
                Toast mytoast = Toast.makeText(getApplicationContext(), "Min lub max nie jest poprawną warością liczbową", Toast.LENGTH_SHORT);
                mytoast.show();
            }

        });

        Button sprawdz = findViewById(R.id.sprawdz);
        sprawdz.setOnClickListener(v -> {
            String wynik = "";
            try {

                if (Integer.parseInt(String.valueOf(liczba.getText())) > wylosowanaLiczba) {
                    wynik = "liczba jest za duża";
                } else if (Integer.parseInt(String.valueOf(liczba.getText())) < wylosowanaLiczba) {
                    wynik = "liczba jest za mała";
                } else if (Integer.parseInt(String.valueOf(liczba.getText())) == wylosowanaLiczba) {
                    wynik = "Zgadłeś!";
                }
            } catch (Exception e) {
                wynik = "Wprowadź prawidłową liczbę";
            }
            licznik++;
            proby.setText("Liczba prób: " + licznik);

            Toast mytoast = Toast.makeText(getApplicationContext(), wynik, Toast.LENGTH_SHORT);
            mytoast.show();
        });


    }
}