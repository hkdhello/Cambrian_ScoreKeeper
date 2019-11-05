package ca.davidpellegrini.scorekeepersolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.TextView.OnEditorActionListener;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View.OnKeyListener;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
        implements OnEditorActionListener, OnClickListener,
        OnCheckedChangeListener {

    private EditText billAmountEditText;
    private TextView teamA_textview, teamB_textview, teamA_score_textview, teamB_score_textview;
    private Button increase_TeamA_Button3, increase_TeamB_Button, decrease_TeamA_Button, decrease_TeamB_Button;
    private RadioButton rad_1, rad_2, rad_3;
    //THIS LINE
    private RadioGroup rad_group;
    private String scoreAString = "";
    private String scoreBString = "";
    private int scoreA = 0;
    private int scoreB = 0;
    private int scoreChange = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA_score_textview = (TextView) findViewById(R.id.teamA_score_textview);
        teamB_score_textview = (TextView) findViewById(R.id.teamB_score_textview);
        increase_TeamA_Button3 = (Button) findViewById(R.id.increase_TeamA_Button3);
        increase_TeamB_Button = (Button) findViewById(R.id.increase_TeamB_Button);

        decrease_TeamA_Button = (Button) findViewById(R.id.decrease_TeamA_Button);
        decrease_TeamB_Button = (Button) findViewById(R.id.decrease_TeamB_Button);
        rad_1 = (RadioButton) findViewById(R.id.rad_1);
        rad_2 = (RadioButton) findViewById(R.id.rad_2);
        rad_3 = (RadioButton) findViewById(R.id.rad_3);

        //THESE LINES
        rad_group = (RadioGroup) findViewById(R.id.rad_group);
        rad_group.setOnCheckedChangeListener(this);

        teamA_score_textview.setOnEditorActionListener(this);
        teamB_score_textview.setOnEditorActionListener(this);
        increase_TeamA_Button3.setOnClickListener(this);
        increase_TeamB_Button.setOnClickListener(this);
        decrease_TeamB_Button.setOnClickListener(this);
        decrease_TeamA_Button.setOnClickListener(this);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            teamA_score_textview.setText("10");
            teamB_score_textview.setText("10");
        }
        return false;
    }
//    public void setScoreA(){}
//    public void set
//    public void calculateAndDisplay() {
//        scoreAString = teamA_score_textview.getText().toString();
//        scoreBString = teamB_score_textview.getText().toString();
//        int teamA_score_textview;
//        int teamB_score_textview;
//        if (scoreAString.equals("")) {
//            teamA_score_textview = 0;
//        } else if (scoreBString.equals("")) {
//            teamB_score_textview = 0;
//        } else {
//            teamA_score_textview = Integer.parseInt(scoreAString);
//            teamB_score_textview = Integer.parseInt(scoreBString);
//
//        }
//        int tipAmount = billAmount * tipPercent;
//        float totalAmount = billAmount + tipAmount;
//        NumberFormat currency = NumberFormat.getCurrencyInstance();
//        tipTextView.setText(currency.format(tipAmount));
//        totalTextView.setText(currency.format(totalAmount / numPeople));
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.decrease_TeamA_Button:
                scoreA = Integer.parseInt(teamA_score_textview.getText().toString());
                scoreA = scoreA - scoreChange;
                teamA_score_textview.setText(Integer.toString(scoreA));
//                calculateAndDisplay();
                break;


            case R.id.decrease_TeamB_Button:
                scoreB = Integer.parseInt(teamB_score_textview.getText().toString());
                scoreB = scoreB - scoreChange;
                teamB_score_textview.setText(Integer.toString(scoreB));
//                calculateAndDisplay();
                break;
            case R.id.increase_TeamA_Button3:
                scoreA = Integer.parseInt(teamA_score_textview.getText().toString());
                scoreA = scoreA + scoreChange;
                teamA_score_textview.setText(Integer.toString(scoreA));
//                calculateAndDisplay();
                break;

            case R.id.increase_TeamB_Button:
                scoreB = Integer.parseInt(teamB_score_textview.getText().toString());
                scoreB = scoreB + scoreChange;
                teamB_score_textview.setText(Integer.toString(scoreB));
//                calculateAndDisplay();
                break;
            /*default:
                Default is like the else in an if statement
                With onClick it can be dangerous because it
                    will run when something other than our
                    button is clicked
                break;
             */
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.e("checkedId: ", Integer.toString(checkedId));
        switch (checkedId) {
            case R.id.rad_1:
            default:
                scoreChange = 1;
                break;
            case R.id.rad_2:
                scoreChange = 2;
                break;
            case R.id.rad_3:
                scoreChange = 3;
                break;
        }
//        calculateAndDisplay();
    }
}

//    @Override
//    public boolean onKey(View view, int keyCode, KeyEvent event) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_ENTER:
//            case KeyEvent.KEYCODE_DPAD_CENTER:
////                calculateAndDisplay();
//
//                //hide the keyboard
//                InputMethodManager imm = (InputMethodManager)
//                        getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(billAmountEditText.getWindowToken(), 0);
//
//                return true;
//        }
//        return false;
//    }
//}

//    @Override
//    public void onPause(){
//        Editor editor = savedValues.edit();
//        editor.putString("teamA_score_textview", teamA_score_textview);
//        editor.putFloat("teamB_score_textview", teamB_score_textview);
//        editor.commit();
//
//        super.onPause();
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//
//        billAmountString = savedValues.getString("billAmountString", "" );
//        tipPercent = savedValues.getFloat("tipPercent", 0.15f);
//    }
//}
//

