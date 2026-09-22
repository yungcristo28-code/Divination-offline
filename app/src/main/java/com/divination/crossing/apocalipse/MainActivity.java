package com.divination.crossing.apocalipse;


import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.content.pm.ActivityInfo;



public class MainActivity extends Activity {



    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ){

        super.onCreate(
                savedInstanceState
        );



        // Tela cheia

        getWindow().setFlags(

                WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN

        );



        // Mantém tela ligada durante batalha

        getWindow().addFlags(

                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON

        );



        // Orientação horizontal

        setRequestedOrientation(

                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        );



        // Inicia o jogo

        setContentView(

                new GameView(this)

        );


    }


}
