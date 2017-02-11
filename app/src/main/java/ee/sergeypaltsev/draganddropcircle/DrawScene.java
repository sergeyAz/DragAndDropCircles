package ee.sergeypaltsev.draganddropcircle;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by user on 04.02.2017.
 */

public class DrawScene extends View {
    Paint canvasPaint;
    Paint circlePaint;

    float currentX = 100;
    float currentY = 100;
    float radius = 70;

    boolean circleMovable = false;

    public DrawScene(Context context) {
        super(context);
        canvasPaint = new Paint();
        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(Color.YELLOW);
        circlePaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas sceneCanvas) {
        super.onDraw(sceneCanvas);
        sceneCanvas.drawPaint(canvasPaint);
        drawCircle(sceneCanvas);
    }

    private void drawCircle(Canvas sceneCanvas) {
        circlePaint.setColor(Color.BLUE);
        sceneCanvas.drawCircle(currentX, currentY, radius, circlePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                float a = event.getX(0) - currentX;
                float b = event.getY(0) - currentY;
                if (Math.hypot(a,b)<=radius){
                circleMovable = true;
            }
            break;
            }
            case MotionEvent.ACTION_UP: {
                circleMovable = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {

                if (circleMovable) {
                    currentX = event.getX(0);
                    currentY = event.getY(0);
                }

            }

            break;
        }
        this.postInvalidate();
        return true;
    }
}


