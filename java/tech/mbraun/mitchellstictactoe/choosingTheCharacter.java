package tech.mbraun.mitchellstictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class choosingTheCharacter extends AppCompatActivity {
    public static boolean XisTrueOisFalse = false;
    public static boolean switchAI2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_the_character);

        configureBackButton();

        Button xBtn = findViewById(R.id.xBtnChoosing);
        xBtn.setVisibility(View.VISIBLE);
        xBtn.setBackgroundColor(Color.TRANSPARENT);

        Button oBtn = findViewById(R.id.oBtnChoosing);
        oBtn.setVisibility(View.VISIBLE);
        oBtn.setBackgroundColor(Color.TRANSPARENT);

        Button aiBtn = findViewById(R.id.aiBtn);






        xBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XisTrueOisFalse = true;

                    Intent intent = new Intent(choosingTheCharacter.this, game.class);
                    startActivity(intent);

            }
        } );

        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XisTrueOisFalse = false;

                    Intent intent = new Intent(choosingTheCharacter.this, game.class);
                    startActivity(intent);

            }
        } );

        aiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(choosingTheCharacter.this, AI.class);
                startActivity(intent);

            }
        } );





    }

    private void configureBackButton() {
        Button backBtn = (Button) findViewById(R.id.backBtnChoosing);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );




    }

}
