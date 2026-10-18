package com.example.scoreboard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    TextView tvScoreA;
    TextView tvScoreB;

    boolean isGame = true;
    Button btnA3, btnA2, btnA1, btnAm1, btnB3, btnB2, btnB1, btnBm1, btnEnd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnWhistle = findViewById(R.id.btnWhistle);
        btnWhistle.setOnClickListener(v -> Toast.makeText(MainActivity.this, "המשחק התחיל!", Toast.LENGTH_SHORT).show());
        tvScoreA = findViewById(R.id.tvScoreA);

        btnA3 = findViewById(R.id.btnA3);
        btnA2 = findViewById(R.id.btnA2);
        btnA1 = findViewById(R.id.btnA1);
        btnAm1 = findViewById(R.id.btnAm1);
        btnB3 = findViewById(R.id.btnB3);
        btnB2 = findViewById(R.id.btnB2);
        btnB1 = findViewById(R.id.btnB1);
        btnBm1 = findViewById(R.id.btnBm1);


        btnAm1.setOnClickListener(v ->   {
                    if (scoreA > 0) {
                        scoreA = scoreA - 1;
                        tvScoreA.setText(String.valueOf(scoreA));
                    }

                    else { Toast.makeText(MainActivity.this, "אי אפשר לרדת מתחת לאפס", Toast.LENGTH_SHORT).show(); }
                });

        btnA3.setOnClickListener(v -> {
                scoreA = scoreA + 3;
                tvScoreA.setText(String.valueOf(scoreA));
            });

        btnA2.setOnClickListener(v -> {
            scoreA = scoreA + 2;
            tvScoreA.setText(String.valueOf(scoreA));
        });


        btnA1.setOnClickListener(v ->{
                scoreA = scoreA + 1;
                tvScoreA.setText(String.valueOf(scoreA));
        });

        tvScoreB = findViewById(R.id.tvScoreB);



        btnB3.setOnClickListener(v -> {
            scoreB  += 3;
            tvScoreB.setText(String.valueOf(scoreB));
        });

        btnB2.setOnClickListener(v -> {
            scoreB  += 2;
            tvScoreB.setText(String.valueOf(scoreB));
        });

        btnB1.setOnClickListener(v -> {
            scoreB  += 1;
            tvScoreB.setText(String.valueOf(scoreB));
        });

        btnBm1.setOnClickListener(v -> {
            if (scoreB > 0) {
                scoreB = scoreB - 1;
                tvScoreB.setText(String.valueOf(scoreB));
            }

            else { Toast.makeText(MainActivity.this, "אי אפשר לרדת מתחת לאפס", Toast.LENGTH_SHORT).show(); }
        });




        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener( v -> {
        scoreA = 0;
        scoreB = 0;
        tvScoreA.setText("0");
        tvScoreB.setText("0");

        if (!isGame) {isGame = true; endStartGame();}
        });


        btnEnd = findViewById(R.id.btnEnd);
        btnEnd.setEnabled(isGame);

        btnEnd.setOnClickListener(v -> {
            isGame = false;
            endStartGame();

            String winner;
            if (scoreA > scoreB) {
                winner = getString(R.string.group1_name) + " ניצחה!";
            } else if (scoreB > scoreA) {
                winner = getString(R.string.group2_name) + " ניצחה!";
            } else {
                winner = "תיקו!";
            }

            Toast.makeText(MainActivity.this, winner, Toast.LENGTH_SHORT).show();
        });    }
    protected void endStartGame()
    {
        btnEnd.setEnabled(isGame);
        btnA3.setEnabled(isGame);
        btnA2.setEnabled(isGame);
        btnA1.setEnabled(isGame);
        btnAm1.setEnabled(isGame);
        btnB3.setEnabled(isGame);
        btnB2.setEnabled(isGame);
        btnB1.setEnabled(isGame);
        btnBm1.setEnabled(isGame);
    }
}