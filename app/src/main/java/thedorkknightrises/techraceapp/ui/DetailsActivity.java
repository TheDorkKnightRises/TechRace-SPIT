package thedorkknightrises.techraceapp.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
    int image_resource = 0;

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
        image_resource = bundle.getInt("image", 0);
        collapsingToolbarLayout.setTitle(location);
        if (clue == null)
            findViewById(R.id.clue_card).setVisibility(View.GONE);
        else {
            clue_desc.setMovementMethod(LinkMovementMethod.getInstance());
            clue_desc.setText(Html.fromHtml(clue));
        }
        location_desc.setText(Html.fromHtml(location_text));
        if (image_resource != 0)
            Glide.with(this)
                    .load(image_resource)
                    .crossFade()
                    .into(bg_img);
    }

    public void onImageClick(View v) {
        Intent i = new Intent(DetailsActivity.this, ImageActivity.class);
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("image://techrace2k16.image/" + image_resource));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            v.setTransitionName("image");
            Pair participants = new Pair<>(v, ViewCompat.getTransitionName(v));

            ActivityOptionsCompat transitionActivityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            DetailsActivity.this, participants);

            ActivityCompat.startActivity(DetailsActivity.this,
                    i, transitionActivityOptions.toBundle());

        } else {
            ActivityOptionsCompat trans = ActivityOptionsCompat.makeSceneTransitionAnimation(DetailsActivity.this);
            ActivityCompat.startActivity(DetailsActivity.this, i, trans.toBundle());
        }
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
