package com.gamecodeschool.subhunter;

import android.app.Activity;
import android.view.Window;

import android.os.Bundle;
import android.view.MotionEvent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

public class SubHunter extends Activity {

    int numberHorizontalPixels;
    int numberVerticalPixels;
    int blockSize;
    int gridWidth = 40;
    int gridHeight;
    float horizontalTouched = -100;
    float verticalTouched = -100;
    int subHorizontalPosition;
    int subVerticalPosition;
    boolean hit = false;
    int shotsTaken;
    int distanceFromSub;
    boolean debugging = false;

    // Drawing objects
    ImageView gameView;
    Bitmap blankBitmap;
    Canvas canvas;
    Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Get the current device's screen resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Initialize our size based variables based on the screen resolution
        numberHorizontalPixels = size.x;
        numberVerticalPixels = size.y;
        blockSize = numberHorizontalPixels / gridWidth;
        gridHeight = numberVerticalPixels / blockSize;

        // Initialize drawing objects
        blankBitmap = Bitmap.createBitmap(numberHorizontalPixels, numberVerticalPixels, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(blankBitmap);
        gameView = new ImageView(this);
        paint = new Paint();

        setContentView(gameView);

        Log.d("Debugging", "In onCreate");
        newGame();
        draw();
    }

    void newGame() {
        Random random = new Random();
        subHorizontalPosition = random.nextInt(gridWidth);
        subVerticalPosition = random.nextInt(gridHeight);
        shotsTaken = 0;

        Log.d("Debugging", "In newGame");
    }

    void draw() {
        gameView.setImageBitmap(blankBitmap);

        // fill the screen with white
        canvas.drawColor(Color.argb(255, 255, 255, 255));

        // setColor to black
        paint.setColor(Color.argb(255, 0, 0, 0));

        // Draw grid vertical lines
        for (int i = 0; i < gridWidth; i++) {
            canvas.drawLine(blockSize * i, 0, blockSize * i, numberVerticalPixels, paint);
        }
        // Draw grid horizontal
        for (int i = 0; i < gridHeight; i++) {
            canvas.drawLine(0, blockSize * i, numberHorizontalPixels - 1, blockSize * i, paint);
        }

        // Draw the player's shot
        canvas.drawRect(horizontalTouched * blockSize, verticalTouched * blockSize,
                (horizontalTouched * blockSize) + blockSize,
                (verticalTouched * blockSize) + blockSize,
                paint);

        // Text for score and distance
        paint.setTextSize(blockSize * 2);
        paint.setColor(Color.argb(255, 0, 0, 255));
        canvas.drawText("Shots Taken: " + shotsTaken + " Distance: " + distanceFromSub, blockSize, blockSize * 1.75f, paint);

        Log.d("Debugging", "In draw");
        if (debugging) {
            printDebuggingText();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.d("Debugging", "In onTouchEvent");

        // If the player lift the finger from the screen
        if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
            // passing the coordinate to takeShot()
            takeShot(motionEvent.getX(), motionEvent.getY());
        }

        return true;
    }

    // This will calculate the distance of the player's tap from the sub, miss or hit
    void takeShot(float touchX, float touchY) {
        Log.d("Debugging", "In takeShot");
        shotsTaken++;

        // convert float screen coordinates to int grid coor
        horizontalTouched = (int) touchX / blockSize;
        verticalTouched = (int) touchY / blockSize;

        hit = horizontalTouched == subHorizontalPosition
                && verticalTouched == subVerticalPosition;

        // distance from shot to sub
        int verticalGap = (int) verticalTouched - subVerticalPosition;
        int horizontalGap = (int) horizontalTouched - subHorizontalPosition;

        // pythagorean's theorem to get the resultant
        distanceFromSub = (int) Math.sqrt(Math.pow(horizontalGap, 2) + Math.pow(verticalGap, 2));

        // if hit call bool
        if (hit)
            boom();
        else
            draw();
    }

    void boom() {

        gameView.setImageBitmap(blankBitmap);

        // red color screen
        canvas.drawColor(Color.argb(255, 255, 0, 0));

        // Draw huge white text
        paint.setColor(Color.argb(255, 255, 255, 255));
        paint.setTextSize(blockSize * 10);

        canvas.drawText("BOOM!", blockSize * 4,blockSize * 14, paint);

        // Draw new game prompt
        paint.setTextSize(blockSize * 2);
        canvas.drawText("Take a shot to start again", blockSize * 8, blockSize * 18, paint);

        newGame();

    }

    void printDebuggingText() {
        paint.setTextSize((blockSize));
        canvas.drawText("numberHorizontalPixel = " + numberHorizontalPixels,
                50, blockSize * 3, paint);

        canvas.drawText("numberVerticalPixels = " + numberVerticalPixels,
                50, blockSize * 4, paint);

        canvas.drawText("blockSize = " + blockSize,
                50, blockSize * 5, paint);

        canvas.drawText("gridWidth = " + gridWidth,
                50, blockSize * 6, paint);

        canvas.drawText("gridHeight = " + gridHeight,
                50, blockSize * 7, paint);

        canvas.drawText("horizontalTouched = " + horizontalTouched,
                50, blockSize * 8, paint);

        canvas.drawText("verticalTouched = " + verticalTouched,
                50, blockSize * 9, paint);

        canvas.drawText("subHorizontalPosition = " + subHorizontalPosition,
                50, blockSize * 10, paint);

        canvas.drawText("subVerticalPosition = " + subVerticalPosition,
                50, blockSize * 11, paint);

        canvas.drawText("hit = " + hit,
                50, blockSize * 12, paint);

        canvas.drawText("shotsTaken = " + shotsTaken,
                50, blockSize * 13, paint);

        canvas.drawText("debugging = " + debugging,
                50, blockSize * 14, paint);
    }
}