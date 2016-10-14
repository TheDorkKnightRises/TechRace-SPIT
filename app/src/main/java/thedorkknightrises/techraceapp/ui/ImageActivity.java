package thedorkknightrises.techraceapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import thedorkknightrises.techraceapp.R;

/**
 * Created by Samriddha Basu on 10/15/2016.
 */

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("ImageViewer", "ImageViewer started");
        List<String> path = intent.getData().getPathSegments();
        ImageView image = (ImageView) findViewById(R.id.imageViewer);
        if (path.get(0).equals("clue")) {
            Glide.with(this).load(R.drawable.clue_img)
                    .crossFade()
                    .into(image);
        } else {
            int img = Integer.parseInt(path.get(0));
            Glide.with(this).load(img)
                    .crossFade()
                    .into(image);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer);

        Log.d("ImageViewer", "ImageViewer started");
        onNewIntent(getIntent());
    }

    public void close(View v) {
        onBackPressed();
    }
}
