package ee.sergeypaltsev.draganddropcircle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawScene scene = new DrawScene(this);
        setContentView(scene);
    }
}
