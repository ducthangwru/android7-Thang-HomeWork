package homework.android7.ducthangwru.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private ImageView imageView;
    private Spinner spinner;
    private EditText askName;
    private RadioButton rbtMale;
    private RadioButton rbtFemale;
    private Button btTest;
    private Button btOk;
    private Button btOk1;
    private CheckBox checkBox;
    private RatingBar rtbSimple;
    private SeekBar seekBar;
    private SearchView svTest;
    private ProgressBar pb_Test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        setupUI();
    }

    private void getReferences() {
        imageView = (ImageView) findViewById(R.id.imv_logo);
        spinner = (Spinner) findViewById(R.id.sp_fruit);
        askName = (EditText) findViewById(R.id.et_name);
        rbtMale = (RadioButton) findViewById(R.id.rbt_male);
        rbtFemale = (RadioButton) findViewById(R.id.rbt_female);
        btTest = (Button) findViewById(R.id.bt_test);
        btOk = (Button) findViewById(R.id.bt_OK);
        btOk1 = (Button) findViewById(R.id.bt_OK1);
        checkBox = (CheckBox) findViewById(R.id.cb_question);
        rtbSimple = (RatingBar) findViewById(R.id.rtb_simple);
        seekBar = (SeekBar) findViewById(R.id.sb_seekbar);
        svTest = (SearchView) findViewById(R.id.sv_test);
        pb_Test = (ProgressBar) findViewById(R.id.pb_test);
    }

    private void attempClick() {
        Toast.makeText(this, "OK!", Toast.LENGTH_SHORT).show();
        if(checkBox.isChecked()) {
            checkBox.setChecked(false);
            btTest.setText("True");
        }
        else {
            checkBox.setChecked(true);
            btTest.setText("False");
        }
    }

    private void setupUI() {
        imageView.setImageResource(R.drawable.logo);

        String[] fruits = new String[] {
                "Apple",
                "Pinapple",
                "Kiwi",
                "Orange"
        };

        ArrayAdapter<String> fruitArray = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fruits);
        spinner.setAdapter(fruitArray);

        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempClick();
            }
        });

        rbtMale.setChecked(true);

        rtbSimple.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                attempRating();
            }
        });

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setProgress(seekBar.getProgress() + 10);
                svTest.clearFocus();
                svTest.setQuery("", false);
                svTest.setIconified(true);
            }
        });

        svTest.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, String.format("SearchView: onQueryChange: %s", newText));
                return false;
            }
        });

        btOk1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pb_Test.setProgress(pb_Test.getProgress() + 10);
            }
        });
    }

    private void attempRating() {
        Toast.makeText(this, String.format(String.valueOf(rtbSimple.getRating())), Toast.LENGTH_SHORT).show();
    }
}
