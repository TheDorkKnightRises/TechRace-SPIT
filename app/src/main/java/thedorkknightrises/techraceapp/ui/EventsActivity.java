package thedorkknightrises.techraceapp.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import thedorkknightrises.techraceapp.R;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21)
            setupWindowAnimations();
        ImageView techeshi_logo = (ImageView) findViewById(R.id.techeshi_logo);
        Glide.with(this).load(R.drawable.techeshi_logo)
                .into(techeshi_logo);
        ImageView pokemon_logo = (ImageView) findViewById(R.id.pokemon_logo);
        Glide.with(this).load(R.drawable.pokemon_logo)
                .into(pokemon_logo);
        ImageView lasertag_logo = (ImageView) findViewById(R.id.lasertag_logo);
        Glide.with(this).load(R.drawable.lasertag_logo)
                .into(lasertag_logo);
        ImageView foosball_logo = (ImageView) findViewById(R.id.foosball_logo);
        Glide.with(this).load(R.drawable.foosball_logo)
                .into(foosball_logo);
        ImageView charades_logo = (ImageView) findViewById(R.id.charades_logo);
        Glide.with(this).load(R.drawable.charades_logo)
                .into(charades_logo);
        ImageView vsm_logo = (ImageView) findViewById(R.id.vsm_logo);
        Glide.with(this).load(R.drawable.vsm_logo)
                .into(vsm_logo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(300);
        getWindow().setEnterTransition(slide);
        getWindow().setReenterTransition(slide);
    }
}
