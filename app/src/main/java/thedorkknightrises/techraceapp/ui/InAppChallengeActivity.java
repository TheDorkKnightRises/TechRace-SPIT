package thedorkknightrises.techraceapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import thedorkknightrises.techraceapp.AppConstants;
import thedorkknightrises.techraceapp.R;

/**
 * Created by Samriddha Basu on 10/15/2016.
 */

public class InAppChallengeActivity extends AppCompatActivity {
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.codeBtn)
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inapp_activity);
        ButterKnife.bind(this);
        final Context context = this;
        final Bundle extras = getIntent().getExtras();
        description.setText(extras.getString(AppConstants.PREFS_INAPP_Q));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (code.getText().toString().equalsIgnoreCase(extras.getString(AppConstants.PREFS_INAPP_A))) {
                    SharedPreferences pref = getSharedPreferences(AppConstants.PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putBoolean(AppConstants.PREFS_INAPP, true);
                    edit.apply();
                    Toast.makeText(context, "Scanner unlocked", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(context, "Incorrect answer", Toast.LENGTH_SHORT).show();
                    code.setText("");
                }
            }
        });
    }
}
