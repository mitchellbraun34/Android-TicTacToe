package tech.mbraun.mitchellstictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Score extends AppCompatActivity{

    public static int xScoreVar = 0;
    public static int oScoreVar = 0;

    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView xScoreView = findViewById(R.id.xScore);
        TextView oScoreView = findViewById(R.id.oScore);




            sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);

            update(xScoreView, oScoreView);
            saveInfo(xScoreView, oScoreView);








        configureBackButton();
    }
    private void configureBackButton() {
        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
        }

        public void update(TextView xScoreView, TextView oScoreView){
            sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);

            String xScore = sharedPref.getString("xScore", "");
            String oScore = sharedPref.getString("oScore", "");

            xScoreView.setText(xScore);
            oScoreView.setText(oScore);

        }

        public void saveInfo(TextView xScoreView, TextView oScoreView)
        {
            sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("xScore", xScoreView.getText().toString());
            editor.putString("oScore", oScoreView.getText().toString());
            editor.commit();



        }



}
