package thedorkknightrises.techraceapp.ui;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.SlideFragment;

import thedorkknightrises.techraceapp.AppConstants;
import thedorkknightrises.techraceapp.R;

/**
 * Created by Samriddha Basu on 8/10/2016.
 */
public class CodeFragment extends SlideFragment {
    private EditText passcode;
    private Button button;
    private boolean unlocked = false;

    public CodeFragment() {
        // Required empty public constructor
    }

    public static CodeFragment newInstance() {
        return new CodeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.intro_code, container, false);

        SharedPreferences pref = getActivity().getSharedPreferences(AppConstants.PREFS,
                IntroActivity.MODE_PRIVATE);
        final SharedPreferences.Editor edit = pref.edit();
        passcode = (EditText) root.findViewById(R.id.code);
        button = (Button) root.findViewById(R.id.codeBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passcode.getText().toString().equals(AppConstants.PASSCODE1)) {
                    unlocked = true;
                    unlocked();
                    edit.putBoolean(AppConstants.PREFS_UNLOCKED, true);
                    edit.putInt(AppConstants.PREFS_GROUP, AppConstants.GROUP1);
                    edit.commit();
                    updateNavigation();
                    Toast.makeText(getContext(), "Unlocked!", Toast.LENGTH_SHORT).show();
                } else if (passcode.getText().toString().equals(AppConstants.PASSCODE2)) {
                    unlocked = true;
                    unlocked();
                    edit.putBoolean(AppConstants.PREFS_UNLOCKED, true);
                    edit.putInt(AppConstants.PREFS_GROUP, AppConstants.GROUP2);
                    edit.commit();
                    updateNavigation();
                    Toast.makeText(getContext(), "Unlocked!", Toast.LENGTH_SHORT).show();
                } else if (passcode.getText().toString().equals(AppConstants.PASSCODE3)) {
                    unlocked = true;
                    unlocked();
                    edit.putBoolean(AppConstants.PREFS_UNLOCKED, true);
                    edit.putInt(AppConstants.PREFS_GROUP, AppConstants.GROUP3);
                    edit.commit();
                    updateNavigation();
                    Toast.makeText(getContext(), "Unlocked!", Toast.LENGTH_SHORT).show();
                } else {
                    passcode.setHintTextColor(Color.RED);
                    passcode.setHint("Incorrect Passcode");
                    passcode.setText("");
                }
            }
        });
        return root;
    }

    @Override
    public boolean canGoForward() {
        return unlocked;
    }

    private void unlocked() {
        passcode.setEnabled(false);
        button.setEnabled(false);
        button.setText("✓");
    }
}
