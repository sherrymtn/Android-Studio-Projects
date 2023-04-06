package com.ching.pong;

import android.graphics.RectF;

public class Ball {

    private final RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private final float mBallWidth;
    private final float mBallHeight;

    public Ball(int screenX) {

        mBallWidth = screenX / 100;
        mBallHeight = screenX / 100;

        mRect = new RectF();
    }

    RectF getRect() {
        return mRect;
    }

    void update(long fps) {
        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);

        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top + mBallHeight;
    }

    void reverseYVelocity() {
        mYVelocity = -mYVelocity;
    }

    void reverseXVelocity() {
        mXVelocity = -mXVelocity;
    }

    void reset(int x, int y) {
        mRect.left = x / 2;
        mRect.top = 0;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = mBallHeight;

        mYVelocity = -(y / 3);
        mXVelocity = (x / 2);
    }

    void increaseVelocity() {
        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity * 1.1f;
    }

    void batBounce(RectF batPosition) {
        // Detect the center of the bat
        float batCenter = batPosition.left + (batPosition.width() / 2);

        // Center of the ball
        float ballCenter = mRect.left + (mBallWidth / 2);

        // Where the ball hit?
        float relativeIntersect = (batCenter - ballCenter);

        // bounce direction
        if(relativeIntersect < 0) {
            // Go right
            mXVelocity = Math.abs(mXVelocity);
        } else {
            // Go left
            mXVelocity = -Math.abs(mXVelocity);
        }

        // Horizontal left or right, reverse the vertical direction of the ball to go up
        reverseYVelocity();
    }



}













