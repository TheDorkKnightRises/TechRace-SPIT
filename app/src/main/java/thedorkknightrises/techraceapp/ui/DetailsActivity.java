package thedorkknightrises.techraceapp.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String location = bundle.getString("location");
        String clue = bundle.getString("clue");
        String location_text = bundle.getString("location_desc");
        collapsingToolbarLayout.setTitle(location);
        if (clue == null)
            findViewById(R.id.clue_card).setVisibility(View.GONE);
        else
            clue_desc.setText(clue);
        location_desc.setText(location_text);
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
}
