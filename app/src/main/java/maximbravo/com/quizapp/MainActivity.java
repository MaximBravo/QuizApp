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


    public void refresh (View view) {
        entry = Questions.getEntry(questionNumber);
        TextView questionTextView = (TextView) findViewById(R.id.question);
        RadioButton a1 = (RadioButton) findViewById(R.id.answer_1);
        RadioButton a2 = (RadioButton) findViewById(R.id.answer_2);
        RadioButton a3 = (RadioButton) findViewById(R.id.answer_3);
        RadioButton a4 = (RadioButton) findViewById(R.id.answer_4);
        TextView questionHeader = (TextView) findViewById(R.id.question_header);
        Button submit = (Button) findViewById(R.id.submit_button);
        Button next = (Button) findViewById(R.id.next_button);
        Button start = (Button) findViewById(R.id.start_button);
        RadioGroup rg = (RadioGroup) findViewById(R.id.answer_box);
        TextView scoreText = (TextView) findViewById(R.id.score_text);
        TextView resultsText = (TextView) findViewById(R.id.results);

        a1.setTextColor(Color.BLACK);
        a2.setTextColor(Color.BLACK );
        a3.setTextColor(Color.BLACK );
        a4.setTextColor(Color.BLACK );
        if(selected != null || first) {

            submit.setEnabled(true);
            if (questionNumber < 10) {
                next.setEnabled(false);

                questionTextView.setVisibility(View.VISIBLE);
                questionTextView.setText(entry[0]);
                a1.setVisibility(View.VISIBLE);
                a1.setText(entry[1]);
                a2.setVisibility(View.VISIBLE);
                a2.setText(entry[2]);
                a3.setVisibility(View.VISIBLE);
                a3.setText(entry[3]);
                a4.setVisibility(View.VISIBLE);
                a4.setText(entry[4]);
                questionHeader.setVisibility(View.VISIBLE);
                questionHeader.setText("Question #" + questionNumber + " of 10!");
                submit.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                start.setVisibility(View.INVISIBLE);
                resultsText.setText("");
                rg.clearCheck();


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
        TextView resultsText = (TextView) findViewById(R.id.results);

        RadioButton a1 = (RadioButton) findViewById(R.id.answer_1);
        RadioButton a2 = (RadioButton) findViewById(R.id.answer_2);
        RadioButton a3 = (RadioButton) findViewById(R.id.answer_3);
        RadioButton a4 = (RadioButton) findViewById(R.id.answer_4);
        Button submit = (Button) findViewById(R.id.submit_button);
        Button next = (Button) findViewById(R.id.next_button);
        if(selected != null) {
            if (numberChoice.equals(rightChoice)) {
                resultsText.setText("Correct!");
                selected.setTextColor(Color.parseColor("#388E3C"));

                submit.setEnabled(false);
                next.setEnabled(true);
                score++;
            } else {
                resultsText.setText("Incorrect!");
                if(entry[5] == "1"){

                    a1.setTextColor(Color.parseColor("#388E3C"));
                }
                if(entry[5] == "2"){
                    a2.setTextColor(Color.parseColor("#388E3C"));
                }
                if(entry[5] == "3"){
                    a3.setTextColor(Color.parseColor("#388E3C"));
                }
                if(entry[5] == "4"){
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
