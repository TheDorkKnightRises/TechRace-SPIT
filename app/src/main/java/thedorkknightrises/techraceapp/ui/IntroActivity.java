package thedorkknightrises.techraceapp.ui;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.NavigationPolicy;
import com.heinrichreimersoftware.materialintro.app.OnNavigationBlockedListener;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

import thedorkknightrises.techraceapp.R;

/**
 * Created by Samriddha Basu on 8/10/2016.
 */
public class IntroActivity extends com.heinrichreimersoftware.materialintro.app.IntroActivity {
    private boolean unlocked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setSkipEnabled(false);
        setFinishEnabled(true);
        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.app_desc)
                .image(R.mipmap.ic_launcher)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(CodeFragment.newInstance())
                .build());
        addSlide(new SimpleSlide.Builder()
                .title(R.string.camera)
                .description(R.string.camera_desc)
                .image(R.mipmap.ic_launcher)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .permission(Manifest.permission.CAMERA)
                .build());

        setNavigationPolicy(new NavigationPolicy() {
            @Override
            public boolean canGoForward(int position) {
                if (position == 1) {
                    SharedPreferences pref = getSharedPreferences("Prefs", IntroActivity.MODE_PRIVATE);
                    unlocked = pref.getBoolean("unlocked", false);
                    return unlocked;
                }
                return true;
            }

            @Override
            public boolean canGoBackward(int position) {
                return true;
            }
        });

        /* Add a listener to detect ehen users try to go to a page they can't go to */
        addOnNavigationBlockedListener(new OnNavigationBlockedListener() {
            @Override
            public void onNavigationBlocked(int position, int direction) {
                switch (position) {
                    case 1:
                        Toast.makeText(getApplicationContext(), getString(R.string.locked_toast), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), getString(R.string.camera_toast), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
