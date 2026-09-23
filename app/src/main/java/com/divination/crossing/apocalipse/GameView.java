package com.divination.crossing.apocalipse;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;



public class GameView extends View {


    private final Paint paint =
            new Paint(Paint.ANTI_ALIAS_FLAG);



    private Hero igor;

    private BattleSystem battleSystem;

    private EffectManager effectManager;

    private DamageManager damageManager;





    public GameView(Context context){


        super(context);



        paint.setTypeface(
                android.graphics.Typeface.DEFAULT_BOLD
        );



        GameManager manager =
                GameManager.getInstance();



        igor =
                manager.getIgor();



        battleSystem =
                manager.getBattleSystem();



        effectManager =
                battleSystem.getEffectManager();



        damageManager =
                battleSystem.getDamageManager();





        // ==========================
        // SPRITE MANAGER
        // ==========================


        SpriteManager spriteManager =
                SpriteManager.getInstance(
                        getContext()
                );



        spriteManager.loadSprites();



        igor.getCharacterSprite()
                .setIdle(
                        spriteManager.getIgorIdle()
                );


    }







    @Override
    protected void onDraw(
            Canvas canvas
    ){


        super.onDraw(canvas);



        int width =
                getWidth();


        int height =
                getHeight();




        igor.updateSprite();





        canvas.drawColor(
                Color.rgb(
                        12,
                        15,
                        18
                )
        );




        paint.setColor(
                Color.WHITE
        );


        paint.setTextSize(28);



        canvas.drawText(
                "DIVINATION CROSSING APOCALIPSE",
                25,
                50,
                paint
        );





        paint.setColor(
                Color.rgb(
                        25,
                        45,
                        35
                )
        );



        canvas.drawRect(
                0,
                80,
                width,
                height,
                paint
        );





        float playerX =
                width * 0.30f;



        float playerY =
                height * 0.55f;





        igor.getCharacterSprite()
                .setPosition(
                        playerX,
                        playerY
                );




        igor.getCharacterSprite()
                .draw(
                        canvas,
                        paint
                );






        paint.setStyle(
                Paint.Style.STROKE
        );


        paint.setStrokeWidth(
                4
        );



        paint.setColor(
                Color.rgb(
                        180,
                        60,
                        220
                )
        );



        canvas.drawCircle(
                playerX,
                playerY,
                52,
                paint
        );



        paint.setStyle(
                Paint.Style.FILL
        );






        drawEnemy(
                canvas,
                width * 0.65f,
                height * 0.50f
        );



        drawEnemy(
                canvas,
                width * 0.78f,
                height * 0.62f
        );





        drawHud(
                canvas
        );





        drawButton(
                canvas,
                40,
                height - 100,
                110,
                height - 35,
                "◀"
        );



        drawButton(
                canvas,
                120,
                height - 100,
                190,
                height - 35,
                "▶"
        );



        drawButton(
                canvas,
                width - 210,
                height - 105,
                width - 100,
                height - 35,
                "ATK"
        );



        drawButton(
                canvas,
                width - 95,
                height - 145,
                width - 25,
                height - 75,
                "SKILL"
        );


    }







    private void drawHud(
            Canvas canvas
    ){


        paint.setColor(
                Color.DKGRAY
        );



        canvas.drawRect(
                30,
                95,
                330,
                125,
                paint
        );



        paint.setColor(
                Color.rgb(
                        190,
                        25,
                        45
                )
        );



        canvas.drawRect(
                30,
                95,
                260,
                125,
                paint
        );



        paint.setColor(
                Color.WHITE
        );



        paint.setTextSize(
                20
        );



        canvas.drawText(
                "IGOR LV." + igor.getLevel(),
                30,
                155,
                paint
        );


    }







    private void drawEnemy(
            Canvas canvas,
            float x,
            float y
    ){


        paint.setColor(
                Color.rgb(
                        150,
                        35,
                        45
                )
        );



        canvas.drawCircle(
                x,
                y,
                28,
                paint
        );


    }







    private void drawButton(
            Canvas canvas,
            float left,
            float top,
            float right,
            float bottom,
            String text
    ){


        paint.setColor(
                Color.rgb(
                        45,
                        45,
                        55
                )
        );



        canvas.drawRoundRect(
                left,
                top,
                right,
                bottom,
                14,
                14,
                paint
        );



        paint.setColor(
                Color.WHITE
        );



        paint.setTextSize(
                22
        );



        canvas.drawText(
                text,
                left + 15,
                top + 40,
                paint
        );


    }


}
