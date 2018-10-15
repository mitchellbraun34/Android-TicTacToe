package tech.mbraun.mitchellstictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AI extends AppCompatActivity {
    public static String[][] board = new String[4][4];
    SharedPreferences sharedPref;
    final String myTurn = "X";
    final String compTurn = "O";
    public static int moves;
    private int[][] preferredMoves = {
            {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
            {0, 1}, {1, 0}, {1, 2}, {2, 1}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);

        resetBoard();

        System.out.println("Moves : " + moves);
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

        final Button btnLowerMid = findViewById(R.id.btnLowerMid);
        btnLowerMid.setVisibility(View.VISIBLE);
        btnLowerMid.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xLowerMid = findViewById(R.id.xLowerMid);
        final ImageView oLowerMid = findViewById(R.id.oLowerMid);

        final Button btnLowerLeft = findViewById(R.id.btnLowerLeft);
        btnLowerLeft.setVisibility(View.VISIBLE);
        btnLowerLeft.setBackgroundColor(Color.TRANSPARENT);
        final ImageView xLowerLeft = findViewById(R.id.xLowerLeft);
        final ImageView oLowerLeft = findViewById(R.id.oLowerLeft);

        Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
        configureBackButton();

        btnUpperLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xUpperLeft.getVisibility() == View.INVISIBLE && oUpperLeft.getVisibility() == View.INVISIBLE){
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                xUpperLeft.setVisibility(View.VISIBLE);


                setMoves(1);


                Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                        xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                        xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                if (moves > 2)
                    gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight);

                if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight) == true)
                    gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight);
                else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                        btnLowerMid, btnLowerRight) == false)
                    compTurn();
                updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                        xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                        xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                if (moves > 2)
                    gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight);
            }

            }
        });
        btnUpperMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xUpperMid.getVisibility() == View.INVISIBLE && oUpperMid.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    xUpperMid.setVisibility(View.VISIBLE);


                    setMoves(1);

                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);


                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                }


            }
        });
        btnUpperRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xUpperRight.getVisibility() == View.INVISIBLE && oUpperRight.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    xUpperRight.setVisibility(View.VISIBLE);


                    setMoves(1);


                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                }

            }
        });
        btnMiddleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( xMiddleLeft.getVisibility() == View.INVISIBLE && oMiddleLeft.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    xMiddleLeft.setVisibility(View.VISIBLE);


                    setMoves(1);


                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                }


            }
        });
        btnMiddleMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xMiddleMid.getVisibility() == View.INVISIBLE && oMiddleMid.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    xMiddleMid.setVisibility(View.VISIBLE);


                    setMoves(1);


                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);


                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                }


            }
        });
        btnMiddleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xMiddleRight.getVisibility() == View.INVISIBLE && oMiddleRight.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    xMiddleRight.setVisibility(View.VISIBLE);


                    setMoves(1);


                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                }



            }
        });
        btnLowerLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xLowerLeft.getVisibility() == View.INVISIBLE && oLowerLeft.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    xLowerLeft.setVisibility(View.VISIBLE);


                    setMoves(1);


                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                }


            }
        });
        btnLowerMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xLowerMid.getVisibility() == View.INVISIBLE && oLowerMid.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    xLowerMid.setVisibility(View.VISIBLE);


                    setMoves(1);


                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    else if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                }

            }
        });
        btnLowerRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xLowerRight.getVisibility() == View.INVISIBLE && oLowerRight.getVisibility() == View.INVISIBLE) {
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    if (xLowerRight.getVisibility() == View.INVISIBLE && oLowerRight.getVisibility() == View.INVISIBLE)
                        xLowerRight.setVisibility(View.VISIBLE);

                    setMoves(1);

                    Board(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);

                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);

                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == true)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                    if (gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                            btnLowerMid, btnLowerRight) == false)
                        compTurn();
                    updateGUI(xUpperLeft, oUpperLeft, xUpperMid, oUpperMid, xUpperRight, oUpperRight,
                            xMiddleLeft, oMiddleLeft, xMiddleMid, oMiddleMid, xMiddleRight, oMiddleRight,
                            xLowerLeft, oLowerLeft, xLowerMid, oLowerMid, xLowerRight, oLowerRight);
                    if (moves > 2)
                        gameOver(winnerView, btnUpperLeft, btnUpperMid, btnUpperRight, btnMiddleLeft, btnMiddleMid, btnMiddleRight, btnLowerLeft,
                                btnLowerMid, btnLowerRight);
                }


            }
        });
        System.out.println("MOVES: " + moves);

        if(moves == 1)
        {
            firstMove();
        }



    }

    public void Board(ImageView xUpperLeft, ImageView oUpperLeft, ImageView xUpperMid, ImageView oUpperMid, ImageView xUpperRight, ImageView oUpperRight,
                      ImageView xMiddleLeft, ImageView oMiddleLeft, ImageView xMiddleMid, ImageView oMiddleMid, ImageView xMiddleRight, ImageView oMiddleRight,
                      ImageView xLowerLeft, ImageView oLowerLeft, ImageView xLowerMid, ImageView oLowerMid, ImageView xLowerRight, ImageView oLowerRight) {


        if (xUpperLeft.getVisibility() == View.VISIBLE)
            board[0][0] = "X";
        if (oUpperLeft.getVisibility() == View.VISIBLE)
            board[0][0] = "O";

        if (xUpperMid.getVisibility() == View.VISIBLE)
            board[0][1] = "X";
        if (oUpperMid.getVisibility() == View.VISIBLE)
            board[0][1] = "O";

        if (xUpperRight.getVisibility() == View.VISIBLE)
            board[0][2] = "X";
        if (oUpperRight.getVisibility() == View.VISIBLE)
            board[0][2] = "O";

        if (xMiddleLeft.getVisibility() == View.VISIBLE)
            board[1][0] = "X";
        if (oMiddleLeft.getVisibility() == View.VISIBLE)
            board[1][0] = "O";

        if (xMiddleMid.getVisibility() == View.VISIBLE)
            board[1][1] = "X";
        if (oMiddleMid.getVisibility() == View.VISIBLE)
            board[1][1] = "O";

        if (xMiddleRight.getVisibility() == View.VISIBLE)
            board[1][2] = "X";
        if (oMiddleRight.getVisibility() == View.VISIBLE)
            board[1][2] = "O";

        if (xLowerLeft.getVisibility() == View.VISIBLE)
            board[2][0] = "X";
        if (oLowerLeft.getVisibility() == View.VISIBLE)
            board[2][0] = "O";

        if (xLowerMid.getVisibility() == View.VISIBLE)
            board[2][1] = "X";
        if (oLowerMid.getVisibility() == View.VISIBLE)
            board[2][1] = "O";

        if (xLowerRight.getVisibility() == View.VISIBLE)
            board[2][2] = "X";
        if (oLowerRight.getVisibility() == View.VISIBLE)
            board[2][2] = "O";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }
            System.out.println();
        }


    }

    public boolean gameOver(TextView winnerView, Button btnUpperLeft,
                            Button btnUpperMid, Button btnUpperRight, Button btnMiddleLeft, Button btnMiddleMid, Button btnMiddleRight,
                            Button btnLowerLeft, Button btnLowerMid, Button btnLowerRight) {
        if (board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if (board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if (board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") {
            winnerView.setText("X Wins!");
            resetBoard();
            updateScoreX();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        if (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O") {
            winnerView.setText("O Wins!");
            resetBoard();
            updateScoreO();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }

        if(     (board[0][0] != null) && (board[0][1] != null) && (board[0][2] != null) &&
                (board[1][0] != null) && (board[1][1] != null) && (board[1][2] != null) &&
                (board[2][0] != null) && (board[2][1] != null) && (board[2][2] != null))

        {
            winnerView.setText("Draw!");
            System.out.println("End Moves is: " + moves);
            resetBoard();
            disableButtons(btnUpperLeft, btnUpperMid, btnUpperRight,  btnMiddleLeft,  btnMiddleMid,  btnMiddleRight,  btnLowerLeft,  btnLowerMid, btnLowerRight);
            moves = 0;
            return true;
        }
        return false;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;

            }

        }
        moves = 0;
    }

    private void configureBackButton() {
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setBackgroundColor(Color.TRANSPARENT);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                resetBoard();
            }
        });


    }

    public void updateScoreX()  {
        sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        System.out.println(sharedPref.getString("xScore", ""));
        int currentScore = Integer.parseInt(
                sharedPref.getString("xScore", "")
                        .substring(
                                (sharedPref.getString("xScore", "").lastIndexOf(' ') + 1)
                                ,
                                (sharedPref.getString("xScore", "").length())
                        ));
        currentScore = currentScore + 1;
        System.out.println(currentScore);
        editor.putString("xScore", "X: " + currentScore);
        editor.commit();
    }

    public void updateScoreO() {
        sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        System.out.println(sharedPref.getString("oScore", ""));
        int currentScore = Integer.parseInt(
                sharedPref.getString("oScore", "")
                        .substring(
                                (sharedPref.getString("oScore", "").lastIndexOf(' ') + 1)
                                ,
                                (sharedPref.getString("oScore", "").length())
                        ));
        currentScore = currentScore + 1;
        System.out.println(currentScore);
        editor.putString("oScore", "O: " + currentScore);
        editor.commit();


    }

    public List<int[]> generateMoves()
    {
        List<int[]> possibleMoves = new ArrayList<int[]>();

        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(board[i][j] == null)
                {
                    possibleMoves.add(new int[]{i, j});
                }
            }
        }
        return possibleMoves;
    }

    public int[] minimax(int depth, String player)
    {
        List<int[]> nextMoves = generateMoves();

        // mySeed is maximizing; while oppSeed is minimizing
        int bestScore = (player == myTurn) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0) {
            // Gameover or depth reached, evaluate score
            bestScore = evaluate();
        } else {
            for (int[] move : nextMoves) {
                // Try this move for the current "player"
                System.out.println(1);
                board[move[0]][move[1]] = player;
                if (player == myTurn) {  // mySeed (computer) is maximizing player
                    currentScore = minimax(depth - 1, compTurn)[0];
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                } else {  // oppSeed is minimizing player
                    currentScore = minimax(depth - 1, myTurn)[0];
                    if (currentScore < bestScore) {
                        bestScore = currentScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                }
                // Undo move
                board[move[0]][move[1]] = null;
            }
        }
        return new int[] {bestScore, bestRow, bestCol};

    }

    int[] move()
    {
        int[] result = minimax(1, myTurn); // depth, max turn
        return new int[] {result[1], result[2]};   // row, col
    }

    public void compTurn()
    {
        int[] compLocation = move();
        System.out.print(" " + compLocation[0] + " " + compLocation[1]);
        board[compLocation[0]][compLocation[1]] = "O";

    }


    private int evaluate() {
        int score = 0;
        // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
        score += evaluateLine(0, 0, 0, 1, 0, 2);  // row 0
        score += evaluateLine(1, 0, 1, 1, 1, 2);  // row 1
        score += evaluateLine(2, 0, 2, 1, 2, 2);  // row 2
        score += evaluateLine(0, 0, 1, 0, 2, 0);  // col 0
        score += evaluateLine(0, 1, 1, 1, 2, 1);  // col 1
        score += evaluateLine(0, 2, 1, 2, 2, 2);  // col 2
        score += evaluateLine(0, 0, 1, 1, 2, 2);  // diagonal
        score += evaluateLine(0, 2, 1, 1, 2, 0);  // alternate diagonal
        return score;
    }


    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
        int score = 0;

        // First cell
        if (board[row1][col1] == myTurn) {
            score = 1;
        } else if (board[row1][col1] == compTurn) {
            score = -1;
        }

        // Second cell
        if (board[row2][col2] == myTurn) {
            if (score == 1) {   // cell1 is mySeed
                score = 10;
            } else if (score == -1) {  // cell1 is oppSeed
                return 0;
            } else {  // cell1 is empty
                score = 1;
            }
        } else if (board[row2][col2] == compTurn) {
            if (score == -1) { // cell1 is oppSeed
                score = -10;
            } else if (score == 1) { // cell1 is mySeed
                return 0;
            } else {  // cell1 is empty
                score = -1;
            }
        }

        // Third cell
        if (board[row3][col3] == myTurn) {
            if (score > 0) {  // cell1 and/or cell2 is mySeed
                score *= 10;
            } else if (score < 0) {  // cell1 and/or cell2 is oppSeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = 1;
            }
        } else if (board[row3][col3] == compTurn) {
            if (score < 0) {  // cell1 and/or cell2 is oppSeed
                score *= 10;
            } else if (score > 1) {  // cell1 and/or cell2 is mySeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = -1;
            }
        }
        return score;
    }

    public void updateGUI(ImageView xUpperLeft, ImageView oUpperLeft, ImageView xUpperMid, ImageView oUpperMid, ImageView xUpperRight, ImageView oUpperRight,
                          ImageView xMiddleLeft, ImageView oMiddleLeft, ImageView xMiddleMid, ImageView oMiddleMid, ImageView xMiddleRight, ImageView oMiddleRight,
                          ImageView xLowerLeft, ImageView oLowerLeft, ImageView xLowerMid, ImageView oLowerMid, ImageView xLowerRight, ImageView oLowerRight)
    {
        if(board[0][0] == "O")
        {
            oUpperLeft.setVisibility(View.VISIBLE);
        }
        if(board[0][1] == "O")
        {
            oUpperMid.setVisibility(View.VISIBLE);
        }
        if(board[0][2] == "O")
        {
            oUpperRight.setVisibility(View.VISIBLE);
        }
        if(board[1][0] == "O")
        {
            oMiddleLeft.setVisibility(View.VISIBLE);
        }
        if(board[1][1] == "O")
        {
            oMiddleMid.setVisibility(View.VISIBLE);
        }
        if(board[1][2] == "O")
        {
            oMiddleRight.setVisibility(View.VISIBLE);
        }
        if(board[2][0] == "O")
        {
            oLowerLeft.setVisibility(View.VISIBLE);
        }
        if(board[2][1] == "O")
        {
            oLowerMid.setVisibility(View.VISIBLE);
        }
        if(board[2][2] == "O")
        {
            oLowerRight.setVisibility(View.VISIBLE);
        }
    }
    public int[] firstMove() {
        for (int[] move : preferredMoves) {
            if (board[move[0]][move[1]] == myTurn) {
                return move;
            }
        }
        assert false : "No empty cell?!";
        return null;
    }

   public void disableButtons(Button btnUpperLeft,
                   Button btnUpperMid, Button btnUpperRight, Button btnMiddleLeft, Button btnMiddleMid, Button btnMiddleRight, Button btnLowerLeft, Button btnLowerMid, Button btnLowerRight)
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

    public void setMoves(int move)
    {
        moves = moves + move;
    }
}

