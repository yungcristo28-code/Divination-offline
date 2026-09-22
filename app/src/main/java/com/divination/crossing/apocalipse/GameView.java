package com.divination.crossing.apocalipse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {

    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    private Hero igor;
    private BattleSystem battleSystem;
    private EffectManager effectManager;
    public GameView(Context context) {
    super(context);

    paint.setTypeface(
            android.graphics.Typeface.DEFAULT_BOLD
    );


    igor = new Hero(
            "Igor",
            250,
            300,
            1000,
            80,
            20,
            4
    );


    battleSystem =
            new BattleSystem(igor);


    effectManager =
            battleSystem.getEffectManager();
}

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        // Fundo da arena
        canvas.drawColor(Color.rgb(12, 15, 18));

        // Título
        paint.setColor(Color.WHITE);
        paint.setTextSize(32);
        canvas.drawText(
                "DIVINATION CROSSING APOCALIPSE",
                40,
                55,
                paint
        );

        // Arena
        paint.setColor(Color.rgb(25, 45, 35));
        canvas.drawRect(
                0,
                80,
                width,
                height,
                paint
        );

        // Grid da arena
        paint.setColor(Color.rgb(35, 65, 48));
        paint.setStrokeWidth(2);

        for (int x = 0; x < width; x += 80) {
            canvas.drawLine(x, 80, x, height, paint);
        }

        for (int y = 80; y < height; y += 80) {
            canvas.drawLine(0, y, width, y, paint);
        }

        // Igor — personagem provisório
        float playerX = width * 0.35f;
        float playerY = height * 0.58f;

        paint.setColor(Color.rgb(110, 40, 150));
        canvas.drawCircle(playerX, playerY, 38, paint);

        // Aura
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.rgb(180, 60, 220));
        canvas.drawCircle(playerX, playerY, 52, paint);

        paint.setStyle(Paint.Style.FILL);

        // Inimigos provisórios
        drawEnemy(canvas, width * 0.62f, height * 0.48f);
        drawEnemy(canvas, width * 0.72f, height * 0.65f);
        drawEnemy(canvas, width * 0.82f, height * 0.50f);

        // HUD HP
        paint.setColor(Color.DKGRAY);
        canvas.drawRect(30, 100, 330, 125, paint);

        paint.setColor(Color.rgb(190, 25, 45));
        canvas.drawRect(30, 100, 280, 125, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
        canvas.drawText("IGOR  LV.1", 30, 155, paint);

        // Botões de movimento — lado esquerdo
        drawButton(canvas, 35, height - 95, 100, height - 35, "◀");
        drawButton(canvas, 115, height - 95, 180, height - 35, "▶");

        // Ataque
        drawButton(canvas, width - 210, height - 105,
                width - 100, height - 35, "ATK");

        // Skill
        drawButton(canvas, width - 95, height - 145,
                width - 25, height - 75, "SKILL");

        // Texto central
        paint.setColor(Color.WHITE);
        paint.setTextSize(18);
        canvas.drawText(
                "A batalha está começando...",
                width * 0.5f - 110,
                height - 20,
                paint
        );
    }

    private void drawEnemy(Canvas canvas, float x, float y) {
        paint.setColor(Color.rgb(150, 35, 45));
        canvas.drawCircle(x, y, 28, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.rgb(230, 70, 80));
        paint.setStrokeWidth(3);
        canvas.drawCircle(x, y, 34, paint);
        paint.setStyle(Paint.Style.FILL);
    }

    private void drawButton(
            Canvas canvas,
            float left,
            float top,
            float right,
            float bottom,
            String text
    ) {
        paint.setColor(Color.rgb(45, 45, 55));
        canvas.drawRoundRect(
                left,
                top,
                right,
                bottom,
                14,
                14,
                paint
        );

        paint.setColor(Color.WHITE);
        paint.setTextSize(22);

        float textWidth = paint.measureText(text);

        canvas.drawText(
                text,
                (left + right - textWidth) / 2,
                (top + bottom) / 2 + 8,
                paint
        );
    }
}
