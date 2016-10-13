package thedorkknightrises.techraceapp.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import thedorkknightrises.techraceapp.R;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar_detail)
    Toolbar toolbar;
    @BindView(R.id.detail_toolbar_collapse)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.location_desc)
    TextView location_desc;
    @BindView(R.id.clue_desc)
    TextView clue_desc;
    @BindView(R.id.bg_img)
    ImageView bg_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT > 21) setupWindowAnimations();

        Bundle bundle = getIntent().getExtras();
        String location = bundle.getString("location");
        String clue = bundle.getString("clue");
        String location_text = bundle.getString("location_desc");
        int image_resource = bundle.getInt("image", 0);
        collapsingToolbarLayout.setTitle(location);
        if (clue == null)
            findViewById(R.id.clue_card).setVisibility(View.GONE);
        else
            clue_desc.setText(Html.fromHtml(clue));
        location_desc.setText(Html.fromHtml(location_text));
        if (image_resource != 0)
            Glide.with(this)
                    .load(image_resource)
                    .crossFade()
                    .into(bg_img);
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
