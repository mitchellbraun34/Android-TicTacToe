package tech.mbraun.mitchellstictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static tech.mbraun.mitchellstictactoe.choosingTheCharacter.XisTrueOisFalse;



public class game extends AppCompatActivity {

    public static String[][] board = new String[4][4];
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        resetBoard();

        final TextView winnerView = findViewById(R.id.winnerView);


        final Button btnUpperRight = findViewById(R.id.btnUpperRight);
        btnUpperRight.setVisibility(View.VISIBLE);
        btnUpperRight.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xUpperRight = findViewById(R.id.xUpperRight);
        final ImageView oUpperRight = findViewById(R.id.oUpperRight);

        final Button btnUpperMid = findViewById(R.id.btnUpperMid);
        btnUpperMid.setVisibility(View.VISIBLE);
        btnUpperMid.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xUpperMid = findViewById(R.id.xUpperMid);
        final ImageView oUpperMid = findViewById(R.id.oUpperMid);

        final Button btnUpperLeft = findViewById(R.id.btnUpperLeft);
        btnUpperLeft.setVisibility(View.VISIBLE);
        btnUpperLeft.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xUpperLeft = findViewById(R.id.xUpperLeft);
        final ImageView oUpperLeft = findViewById(R.id.oUpperLeft);

        final Button btnMiddleRight = findViewById(R.id.btnMidRight);
        btnMiddleRight.setVisibility(View.VISIBLE);
        btnMiddleRight.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xMiddleRight = findViewById(R.id.xMidRight);
        final ImageView oMiddleRight = findViewById(R.id.oMidRight);

        final Button btnMiddleMid = findViewById(R.id.btnMidMid);
        btnMiddleMid.setVisibility(View.VISIBLE);
        btnMiddleMid.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xMiddleMid = findViewById(R.id.xMidMid);
        final ImageView oMiddleMid = findViewById(R.id.oMidMid);

        final Button btnMiddleLeft = findViewById(R.id.btnMidLeft);
        btnMiddleLeft.setVisibility(View.VISIBLE);
        btnMiddleLeft.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xMiddleLeft = findViewById(R.id.xMidLeft);
        final ImageView oMiddleLeft = findViewById(R.id.oMidLeft);

        final Button btnLowerRight = findViewById(R.id.btnLowerRight);
        btnLowerRight.setVisibility(View.VISIBLE);
        btnLowerRight.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xLowerRight = findViewById(R.id.xLowerRight);
        final ImageView oLowerRight = findViewById(R.id.oLowerRight);

       final  Button btnLowerMid = findViewById(R.id.btnLowerMid);
        btnLowerMid.setVisibility(View.VISIBLE);
        btnLowerMid.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xLowerMid = findViewById(R.id.xLowerMid);
        final ImageView oLowerMid = findViewById(R.id.oLowerMid);

        final Button btnLowerLeft = findViewById(R.id.btnLowerLeft);
        btnLowerLeft.setVisibility(View.VISIBLE);
        btnLowerLeft.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xLowerLeft = findViewById(R.id.xLowerLeft);
        final ImageView oLowerLeft = findViewById(R.id.oLowerLeft);

        Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                 xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                 xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);


            configureBackButton();

            btnUpperLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(XisTrueOisFalse == true && xUpperLeft.getVisibility() == View.INVISIBLE && oUpperLeft.getVisibility() == View.INVISIBLE)
                    {
                        xUpperLeft.setVisibility(View.VISIBLE);
                        XisTrueOisFalse = false;
                        Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                                xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                                xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                    }
                    if(XisTrueOisFalse == false && xUpperLeft.getVisibility() == View.INVISIBLE && oUpperLeft.getVisibility() == View.INVISIBLE)
                    {
                        oUpperLeft.setVisibility(View.VISIBLE);
                        XisTrueOisFalse = true;
                        Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                                xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                                xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                    }

                    gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight);

                }
            });
            btnUpperMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xUpperMid.getVisibility() == View.INVISIBLE && oUpperMid.getVisibility() == View.INVISIBLE)
                {
                    xUpperMid.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xUpperMid.getVisibility() == View.INVISIBLE && oUpperMid.getVisibility() == View.INVISIBLE)
                {
                    oUpperMid.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight);


            }
        });
        btnUpperRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xUpperRight.getVisibility() == View.INVISIBLE && oUpperRight.getVisibility() == View.INVISIBLE)
                {
                    xUpperRight.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xUpperRight.getVisibility() == View.INVISIBLE && oUpperRight.getVisibility() == View.INVISIBLE)
                {
                    oUpperRight.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight);


            }
        });
        btnMiddleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xMiddleLeft.getVisibility() == View.INVISIBLE && oMiddleLeft.getVisibility() == View.INVISIBLE)
                {
                    xMiddleLeft.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xMiddleLeft.getVisibility() == View.INVISIBLE && oMiddleLeft.getVisibility() == View.INVISIBLE)
                {
                    oMiddleLeft.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight);


            }
        });
        btnMiddleMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xMiddleMid.getVisibility() == View.INVISIBLE && oMiddleMid.getVisibility() == View.INVISIBLE)
                {
                    xMiddleMid.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xMiddleMid.getVisibility() == View.INVISIBLE && oMiddleMid.getVisibility() == View.INVISIBLE)
                {
                    oMiddleMid.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                    gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight);


            }
        });
        btnMiddleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xMiddleRight.getVisibility() == View.INVISIBLE && oMiddleRight.getVisibility() == View.INVISIBLE)
                {
                    xMiddleRight.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xMiddleRight.getVisibility() == View.INVISIBLE && oMiddleRight.getVisibility() == View.INVISIBLE)
                {
                    oMiddleRight.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight);


            }
        });
        btnLowerLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xLowerLeft.getVisibility() == View.INVISIBLE && oLowerLeft.getVisibility() == View.INVISIBLE)
                {
                    xLowerLeft.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xLowerLeft.getVisibility() == View.INVISIBLE && oLowerLeft.getVisibility() == View.INVISIBLE)
                {
                    oLowerLeft.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight);


            }
        });
        btnLowerMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xLowerMid.getVisibility() == View.INVISIBLE && oLowerMid.getVisibility() == View.INVISIBLE)
                {
                    xLowerMid.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xLowerMid.getVisibility() == View.INVISIBLE && oLowerMid.getVisibility() == View.INVISIBLE)
                {
                    oLowerMid.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight);


            }
        });
        btnLowerRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(XisTrueOisFalse == true && xLowerRight.getVisibility() == View.INVISIBLE && oLowerRight.getVisibility() == View.INVISIBLE)
                {
                    xLowerRight.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = false;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }
                if(XisTrueOisFalse == false && xLowerRight.getVisibility() == View.INVISIBLE && oLowerRight.getVisibility() == View.INVISIBLE)
                {
                    oLowerRight.setVisibility(View.VISIBLE);
                    XisTrueOisFalse = true;
                    Board( xUpperLeft,  oUpperLeft, xUpperMid,  oUpperMid, xUpperRight,  oUpperRight,
                            xMiddleLeft,  oMiddleLeft,  xMiddleMid,  oMiddleMid,  xMiddleRight,oMiddleRight,
                            xLowerLeft,  oLowerLeft,  xLowerMid,  oLowerMid,  xLowerRight, oLowerRight);
                }

                gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight);


            }
        });




    }

    private void configureBackButton() {
        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XisTrueOisFalse = false;
                resetBoard();

                finish();
            }
        });

    }

    public boolean gameOver(TextView winnerView, Button btnUpperLeft,
                            Button btnUpperMid, Button btnUpperRight, Button btnMiddleLeft, Button btnMiddleMid, Button btnMiddleRight,
                            Button btnLowerLeft, Button btnLowerMid, Button btnLowerRight)
    {
        if(board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }

        if(board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }

        if(board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }

        if(board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }

        if(board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }

        if(board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }

        if(board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }

        if(board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X")
        {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O")
        {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            return true;
        }
        if(     (board[0][0] != null) && (board[0][1] != null) && (board[0][2] != null) &&
            (board[1][0] != null) && (board[1][1] != null) && (board[1][2] != null) &&
            (board[2][0] != null) && (board[2][1] != null) && (board[2][2] != null))

    {
        winnerView.setText("Draw!");

        resetBoard();
        disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);

        return true;
    }
        return false;
    }

    public void Board(ImageView xUpperLeft, ImageView oUpperLeft, ImageView xUpperMid, ImageView oUpperMid, ImageView xUpperRight, ImageView oUpperRight,
                            ImageView xMiddleLeft, ImageView oMiddleLeft, ImageView xMiddleMid, ImageView oMiddleMid, ImageView xMiddleRight, ImageView oMiddleRight,
                            ImageView xLowerLeft, ImageView oLowerLeft, ImageView xLowerMid, ImageView oLowerMid, ImageView xLowerRight, ImageView oLowerRight)
    {



        if(xUpperLeft.getVisibility() == View.VISIBLE)
            board[0][0]="X";
        if(oUpperLeft.getVisibility() == View.VISIBLE)
            board[0][0]="O";

        if(xUpperMid.getVisibility() == View.VISIBLE)
            board[0][1]="X";
        if(oUpperMid.getVisibility() == View.VISIBLE)
            board[0][1]="O";

        if(xUpperRight.getVisibility() == View.VISIBLE)
            board[0][2]="X";
        if(oUpperRight.getVisibility() == View.VISIBLE)
            board[0][2]="O";

        if(xMiddleLeft.getVisibility() == View.VISIBLE)
            board[1][0]="X";
        if(oMiddleLeft.getVisibility() == View.VISIBLE)
            board[1][0]="O";

        if(xMiddleMid.getVisibility() == View.VISIBLE)
            board[1][1]="X";
        if(oMiddleMid.getVisibility() == View.VISIBLE)
            board[1][1]="O";

        if(xMiddleRight.getVisibility() == View.VISIBLE)
            board[1][2]="X";
        if(oMiddleRight.getVisibility() == View.VISIBLE)
            board[1][2]="O";

        if(xLowerLeft.getVisibility() == View.VISIBLE)
            board[2][0]="X";
        if(oLowerLeft.getVisibility() == View.VISIBLE)
            board[2][0]="O";

        if(xLowerMid.getVisibility() == View.VISIBLE)
            board[2][1]="X";
        if(oLowerMid.getVisibility() == View.VISIBLE)
            board[2][1]="O";

        if(xLowerRight.getVisibility() == View.VISIBLE)
            board[2][2]="X";
        if(oLowerRight.getVisibility() == View.VISIBLE)
            board[2][2]="O";

        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                System.out.println(board[i][j]);
            }
            System.out.println();
        }


    }

    public void resetBoard()
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++) {
                board[i][j] = null;

            }

        }
    }
    public void disableButtons(Button btnUpperLeft, Button btnUpperMid, Button btnUpperRight,
                               Button btnMiddleLeft, Button btnMiddleMid, Button btnMiddleRight,
                               Button btnLowerLeft, Button btnLowerMid, Button btnLowerRight)
    {
        btnUpperLeft.setEnabled(false);
        btnUpperMid.setEnabled(false);
        btnUpperRight.setEnabled(false);
        btnMiddleLeft.setEnabled(false);
        btnMiddleMid.setEnabled(false);
        btnMiddleRight.setEnabled(false);
        btnLowerLeft.setEnabled(false);
        btnLowerMid.setEnabled(false);
        btnLowerRight.setEnabled(false);
    }
    public void updateScoreX()
    {
        sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        System.out.println(sharedPref.getString("xScore", ""));
        int currentScore = Integer.parseInt(
                sharedPref.getString("xScore", "")
                        .substring(
                                (sharedPref.getString("xScore", "").lastIndexOf(' ')+1)
                                ,
                                (sharedPref.getString("xScore", "").length())
                        ));
        currentScore = currentScore + 1;
        System.out.println(currentScore);
        editor.putString("xScore", "X: " + currentScore);
        editor.commit();
    }
    public void updateScoreO()
    {
        sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        System.out.println(sharedPref.getString("oScore", ""));
        int currentScore = Integer.parseInt(
                sharedPref.getString("oScore", "")
                .substring(
                (sharedPref.getString("oScore", "").lastIndexOf(' ')+1)
                ,
                (sharedPref.getString("oScore", "").length())
                ));
        currentScore = currentScore + 1;
        System.out.println(currentScore);
        editor.putString("oScore", "O: " + currentScore);
        editor.commit();



    }





}
