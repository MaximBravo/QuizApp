package maximbravo.com.quizapp;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button reset;
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
    private CheckBox checkBox;
    private int questionNumber = 1;
    private int score = 0;
    private boolean first = true;
    boolean checked;
    private ArrayList<Integer> questionPool = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start_button);
    }

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
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        reset = (Button) findViewById(R.id.reset_button);
        questionTextView = (TextView) findViewById(R.id.question);
        a1 = (RadioButton) findViewById(R.id.answer_1);
        a2 = (RadioButton) findViewById(R.id.answer_2);
        a3 = (RadioButton) findViewById(R.id.answer_3);
        a4 = (RadioButton) findViewById(R.id.answer_4);
        questionHeader = (TextView) findViewById(R.id.question_header);
        submit = (Button) findViewById(R.id.submit_button);
        next = (Button) findViewById(R.id.next_button);

        rg = (RadioGroup) findViewById(R.id.answer_box);
        scoreText = (TextView) findViewById(R.id.score_text);
        resultsText = (TextView) findViewById(R.id.results);

        questionTextView.setVisibility(View.VISIBLE);
        rg.setVisibility(View.VISIBLE);
        a1.setVisibility(View.VISIBLE);
        a2.setVisibility(View.VISIBLE);
        a3.setVisibility(View.VISIBLE);
        a4.setVisibility(View.VISIBLE);
        questionHeader.setVisibility(View.VISIBLE);
        submit.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);
        resultsText.setVisibility(View.VISIBLE);
        checkBox.setChecked(false);
        checkBox.setVisibility(View.INVISIBLE);
        questionPool.add(1);
        questionPool.add(2);
        questionPool.add(3);
        questionPool.add(4);
        questionPool.add(5);
        questionPool.add(6);
        questionPool.add(7);
        questionPool.add(8);
        questionPool.add(9);
        questionPool.add(10);
        entry = Questions.getEntry(getQuestion());
        questionTextView.setText(entry[0]);
        questionHeader.setText("Question #1 of 10!");
        a1.setText(entry[1]);
        a2.setText(entry[2]);
        a3.setText(entry[3]);
        a4.setText(entry[4]);
        rightChoice = entry[5];
        next.setEnabled(false);
        selected = null;



    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        checked = ((CheckBox) view).isChecked();
        if(checked){
            start.setEnabled(true);
        }
    }
    public int getQuestion(){
        if(questionPool.size() > 1) {
            int random = (int) (Math.random() * questionPool.size() + 1);
            int ret = questionPool.get(random - 1);
            questionPool.remove(random - 1);
            return ret;
        } else {
            return questionPool.get(0);
        }

    }
    public void refresh (View view) {
        questionNumber++;
        if(questionNumber == 11) {
            questionTextView.setVisibility(View.INVISIBLE);
            questionHeader.setVisibility(View.INVISIBLE);
            rg.setVisibility(View.INVISIBLE);
            resultsText.setVisibility(View.INVISIBLE);
            submit.setVisibility(View.INVISIBLE);
            next.setVisibility(View.INVISIBLE);
            start.setVisibility(View.INVISIBLE);

            reset.setVisibility(View.VISIBLE);
            scoreText.setText("Your final score is " + score + " out of 10!");

        }
        entry = Questions.getEntry(getQuestion());
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

            next.setEnabled(false);
            questionTextView.setText(entry[0]);
            a1.setText(entry[1]);
            a2.setText(entry[2]);
            a3.setText(entry[3]);
            a4.setText(entry[4]);
            questionHeader.setText("Question #" + questionNumber + " of 10!");
            resultsText.setText("");
            rightChoice = entry[5];



            first = false;
            selected = null;
        } else {
            Toast toast = Toast.makeText(this, "You must choose an option.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void reset (View view){
        reset.setVisibility(View.INVISIBLE);
        scoreText.setText("");
        checkBox.setVisibility(View.VISIBLE);
        start.setVisibility(View.VISIBLE);
        start.setEnabled(false);
        score = 0;
        questionNumber = 1;
    }

    public void submit (View view){

        if(selected != null) {
            a1.setEnabled(false);
            a2.setEnabled(false);
            a3.setEnabled(false);
            a4.setEnabled(false);
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
