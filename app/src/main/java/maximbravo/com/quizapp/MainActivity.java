package maximbravo.com.quizapp;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private String[] entry;
    private TextView questionTextView;
    private RadioButton a1;
    private RadioButton a2;
    private RadioButton a3;
    private RadioButton a4;
    private TextView questionHeader;
    private Button submit;
    private Button next;
    private Button start;
    private RadioGroup rg;
    private TextView scoreText;
    private TextView resultsText;
    private RadioButton selected;
    private String numberChoice;
    private String rightChoice;
    private int questionNumber = 1;
    private int score = 0;
    private boolean first = true;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer_1:
                if (checked) {
                    selected = (RadioButton) findViewById(R.id.answer_1);
                    numberChoice = "1";
                }
                    break;
            case R.id.answer_2:
                if (checked) {
                    selected = (RadioButton) findViewById(R.id.answer_2);
                    numberChoice = "2";
                }
                    break;
            case R.id.answer_3:
                if (checked) {
                    selected = (RadioButton) findViewById(R.id.answer_3);
                    numberChoice = "3";
                }
                    break;
            case R.id.answer_4:
                if (checked) {
                    selected = (RadioButton) findViewById(R.id.answer_4);
                    numberChoice = "4";
                }
                    break;
        }
    }

    public void startApp(View view){
        questionTextView = (TextView) findViewById(R.id.question);
        a1 = (RadioButton) findViewById(R.id.answer_1);
        a2 = (RadioButton) findViewById(R.id.answer_2);
        a3 = (RadioButton) findViewById(R.id.answer_3);
        a4 = (RadioButton) findViewById(R.id.answer_4);
        questionHeader = (TextView) findViewById(R.id.question_header);
        submit = (Button) findViewById(R.id.submit_button);
        next = (Button) findViewById(R.id.next_button);
        start = (Button) findViewById(R.id.start_button);
        rg = (RadioGroup) findViewById(R.id.answer_box);
        scoreText = (TextView) findViewById(R.id.score_text);
        resultsText = (TextView) findViewById(R.id.results);

        questionTextView.setVisibility(View.VISIBLE);
        a1.setVisibility(View.VISIBLE);
        a2.setVisibility(View.VISIBLE);
        a3.setVisibility(View.VISIBLE);
        a4.setVisibility(View.VISIBLE);
        questionHeader.setVisibility(View.VISIBLE);
        submit.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);

        entry = Questions.getEntry(questionNumber);
        questionTextView.setText(entry[0]);
        a1.setText(entry[1]);
        a2.setText(entry[2]);
        a3.setText(entry[3]);
        a4.setText(entry[4]);
        rightChoice = entry[5];
        questionNumber++;
        selected = null;
    }

    public void refresh (View view) {
        entry = Questions.getEntry(questionNumber);
        rg.clearCheck();
        a1.setEnabled(true);
        a2.setEnabled(true);
        a3.setEnabled(true);
        a4.setEnabled(true);
        a1.setTextColor(Color.BLACK);
        a2.setTextColor(Color.BLACK );
        a3.setTextColor(Color.BLACK );
        a4.setTextColor(Color.BLACK );
        if(selected != null) {
            submit.setEnabled(true);
            if (questionNumber < 10) {
                next.setEnabled(false);
                questionTextView.setText(entry[0]);
                a1.setText(entry[1]);
                a2.setText(entry[2]);
                a3.setText(entry[3]);
                a4.setText(entry[4]);
                questionHeader.setText("Question #" + questionNumber + " of 10!");
                resultsText.setText("");
                rightChoice = entry[5];
            } else {
                questionTextView.setVisibility(View.GONE);
                questionHeader.setVisibility(View.GONE);
                rg.setVisibility(View.GONE);
                resultsText.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                start.setVisibility(View.GONE);
                scoreText.setText("Your final score is " + score + " out of 10!");

            }

            questionNumber++;
            first = false;
            selected = null;
        } else {
            Toast toast = Toast.makeText(this, "You must choose an option.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void submit (View view){
        a1.setEnabled(false);
        a2.setEnabled(false);
        a3.setEnabled(false);
        a4.setEnabled(false);
        if(selected != null) {
            if (numberChoice.equals(rightChoice)) {
                resultsText.setText("Correct!");
                selected.setTextColor(Color.parseColor("#388E3C"));
                submit.setEnabled(false);
                next.setEnabled(true);
                score++;
            } else {
                resultsText.setText("Incorrect!");
                if(rightChoice.equals("1")){
                    a1.setTextColor(Color.parseColor("#388E3C"));
                }
                if(rightChoice.equals("2")){
                    a2.setTextColor(Color.parseColor("#388E3C"));
                }
                if(rightChoice.equals("3")){
                    a3.setTextColor(Color.parseColor("#388E3C"));
                }
                if(rightChoice.equals("4")){
                    a4.setTextColor(Color.parseColor("#388E3C"));
                }
                selected.setTextColor(Color.parseColor("#C62828"));
                submit.setEnabled(false);
                next.setEnabled(true);
            }
        } else {
            Toast toast = Toast.makeText(this, "You must choose an option.", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
