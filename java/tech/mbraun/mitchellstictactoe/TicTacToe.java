package tech.mbraun.mitchellstictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicTacToe extends AppCompatActivity {

    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);


        //HUD stuff

        Button playBtn = (Button) findViewById(R.id.PlayBtn);
        playBtn.setVisibility(View.VISIBLE);
        playBtn.setBackgroundColor(Color.TRANSPARENT);

        Button scoreBtn = (Button) findViewById(R.id.ScoreBtn);
        scoreBtn.setVisibility(View.VISIBLE);
        scoreBtn.setBackgroundColor(Color.TRANSPARENT);

        Button exitBtn = (Button) findViewById(R.id.exitBtn);
        exitBtn.setVisibility(View.VISIBLE);
        exitBtn.setBackgroundColor(Color.TRANSPARENT);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TicTacToe.this, choosingTheCharacter.class );
                startActivity(intent);

            }
        });
        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TicTacToe.this, Score.class );
                startActivity(intent);

            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.exit(0);

            }
        });

        sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);

        if(sharedPref.getString("xScore", "").equals("") && sharedPref.getString("oScore", "").equals("")) {

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("xScore", "X: 0");
            editor.putString("oScore", "O: 0");
            editor.commit();
        }


    }
}
