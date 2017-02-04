package ee.sergeypaltsev.draganddropcircle;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by user on 04.02.2017.
 */

public class DrawScene extends View {
    Paint canvasPaint;
    Paint circlePaint;

    float currentX = 100;
    float currentY = 100;

    boolean circleMovable = false;

    public DrawScene(Context context){
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
    private void drawCircle(Canvas sceneCanvas){
        circlePaint.setColor(Color.BLUE);
        sceneCanvas.drawCircle(currentX, currentY, 100, circlePaint);
    }
}
