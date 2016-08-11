package thedorkknightrises.techraceapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;


public class ScannerFragment extends Fragment {
    private FloatingActionButton fab;

    private OnFragmentInteractionListener mListener;

    public ScannerFragment() {
        // Required empty public constructor
    }

    public static ScannerFragment newInstance(String param1, String param2) {
        ScannerFragment fragment = new ScannerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scanner, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterReveal();
            }
        });

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_collapse);
        Toolbar toolbar = (Toolbar) collapsingToolbarLayout.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());

            TextView head = new TextView(getContext());
            head.setText(R.string.action_help);
            head.setTextSize(24);
            head.setTextColor(Color.WHITE);
            head.setPadding(0, 0, 0, 16);

            TextView textView = new TextView(getContext());
            textView.setText(R.string.scan_help);
            textView.setTextSize(20);
            textView.setPadding(0, 0, 0, 16);

            Button button = new Button(getContext());
            button.setText(R.string.scan_manual);
            button.setTextColor(getResources().getColor(R.color.colorAccent));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetDialog.dismiss();

                    final BottomSheetDialog bottomSheet = new BottomSheetDialog(getContext());

                    TextView textView = new TextView(getContext());
                    textView.setText(R.string.manual_desc);
                    textView.setTextSize(20);

                    final EditText codeText = new EditText(getContext());

                    Button button = new Button(getContext());
                    button.setText(R.string.action_confirm);
                    button.setTextColor(getResources().getColor(R.color.colorAccent));
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scanned(codeText.getText().toString());
                            codeText.setText("");
                            bottomSheet.dismiss();
                        }
                    });

                    LinearLayout linearLayout = new LinearLayout(getContext());
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setBackgroundColor(Color.DKGRAY);
                    linearLayout.setPadding(48, 64, 48, 64);
                    linearLayout.addView(textView);
                    linearLayout.addView(codeText);
                    linearLayout.addView(button);

                    bottomSheetDialog.setTitle(R.string.action_help);
                    bottomSheetDialog.setContentView(linearLayout);
                    bottomSheetDialog.setCanceledOnTouchOutside(true);
                    bottomSheetDialog.show();
                }
            });

            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setBackgroundColor(Color.DKGRAY);
            linearLayout.setPadding(48, 48, 48, 64);
            linearLayout.addView(head);
            linearLayout.addView(textView);
            linearLayout.addView(button);

            bottomSheetDialog.setTitle(R.string.action_help);
            bottomSheetDialog.setContentView(linearLayout);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            bottomSheetDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } /*else {
            throw new RuntimeException(context.toString()+ " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void startScan() {
        /**
         * Build a new MaterialBarcodeScanner
         */
        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(getActivity())
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withBackfacingCamera()
                .withText("Scanning...")
                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {
                        scanned(barcode.displayValue);
                    }
                })
                .build();
        materialBarcodeScanner.startScan();

    }

    void enterReveal() {
        if (Build.VERSION.SDK_INT >= 21) {

            final View myView = getActivity().findViewById(R.id.view);
            // get the center for the clipping circle
            int cx = (fab.getLeft() + fab.getRight()) / 2;
            int cy = (fab.getTop() + fab.getBottom()) / 2;

            // get the final radius for the clipping circle
            int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

            // create the animator for this view (the start radius is zero)
            Animator anim =
                    ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);


            myView.setVisibility(View.VISIBLE);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    startScan();
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.GONE);
                }
            });
            anim.setDuration(500);
            anim.start();
        } else startScan();
    }

    private void scanned(String code) {
        if (!code.equals("")) {
            Toast.makeText(getContext(), code, Toast.LENGTH_SHORT).show();
            if (code.startsWith("http")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(code));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(i);
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
