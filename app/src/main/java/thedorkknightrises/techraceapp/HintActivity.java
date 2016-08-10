package thedorkknightrises.techraceapp;

import android.app.Activity;
import android.os.Bundle;

import eu.davidea.flipview.FlipView;

public class HintActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        FlipView flipView = (FlipView) findViewById(R.id.flipView);
    }
}
