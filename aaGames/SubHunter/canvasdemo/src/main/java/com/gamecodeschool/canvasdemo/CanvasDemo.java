package com.gamecodeschool.canvasdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class CanvasDemo extends Activity {
    ImageView myImageView;
    Bitmap myBlankBitmap;
    Canvas myCanvas;
    Paint myPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int widthInPixels = 800;
        int heightInPixels = 600;

        // Create new Bitmap
        myBlankBitmap=Bitmap.createBitmap(widthInPixels, heightInPixels, Bitmap.Config.ARGB_8888);

        // Initialize Canvass and associate it with Bitmap
        myCanvas = new Canvas(myBlankBitmap);

        // Initialize the ImageView and the Paint
        myImageView = new ImageView(this);
        myPaint = new Paint();

        // Wipe Blue color
        myCanvas.drawColor(Color.argb(170, 0, 230, 255));

        // Resize text
        myPaint.setTextSize(100);
        // Change the paint to white
        myPaint.setColor(Color.argb(255, 255, 255, 255));
        // Draw some text
        myCanvas.drawText("Hello World!", 100, 100, myPaint);

        // Change paint to yellow
        myPaint.setColor(Color.argb(255, 100, 100, 255));
        // Draw a circle
        myCanvas.drawCircle(400, 300, 150, myPaint);

        myPaint.setTextSize(100);
        // Change the paint to white
        myPaint.setColor(Color.argb(255, 0, 0, 0));
        // Draw some text
        myCanvas.drawText("Hello Ching!", 115, 570, myPaint);

        // Associate bitmap with imageview
        myImageView.setImageBitmap(myBlankBitmap);

        // Tell android to set the drawing
        setContentView(myImageView);
    }
}