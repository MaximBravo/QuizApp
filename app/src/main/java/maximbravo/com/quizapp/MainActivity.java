package maximbravo.com.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    boolean checked;
    private Button reset;
    private String[] entry;
    private TextView questionTextView;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    private TextView questionHeader;
    private Button submit;
    private Button next;
    private Button start;
    private EditText f;
    private RadioGroup rg;
    private String name;
    private TextView scoreText;
    private TextView resultsText;
    private RadioButton selectedRadioButton;
    private String radioChoice = "";
    private String rightChoice;
    private CheckBox checkBox;
    private EditText editNameBox;
    private static String fAnswer = "";
    private LinearLayout checkBoxAnswerBox;
    private int questionNumber = 1;
    private int score = 0;
    private ArrayList<String> checkChoice;
    private boolean radio_checked;
    private boolean first = true;
    private ArrayList<Integer> questionPool = new ArrayList<>();
    private Questions question;
    private String questionType;
    private static TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            fAnswer = s.toString();
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void afterTextChanged(Editable s) {
            fAnswer = s.toString();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        start = (Button) findViewById(R.id.start_button);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean radio_checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_answer_1:
                if (radio_checked) {
                    selectedRadioButton = (RadioButton) findViewById(R.id.radio_answer_1);
                    radioChoice = "1";
                }
                break;
            case R.id.radio_answer_2:
                if (radio_checked) {
                    selectedRadioButton = (RadioButton) findViewById(R.id.radio_answer_2);
                    radioChoice = "2";
                }
                break;
            case R.id.radio_answer_3:
                if (radio_checked) {
                    selectedRadioButton = (RadioButton) findViewById(R.id.radio_answer_3);
                    radioChoice = "3";
                }
                break;
            case R.id.radio_answer_4:
                if (radio_checked) {
                    selectedRadioButton = (RadioButton) findViewById(R.id.radio_answer_4);
                    radioChoice = "4";
                }
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean check_checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.check_answer_1:
                if (check_checked){
                    checkChoice.add("1");
                } else {
                    if(checkChoice.contains("1")){
                        checkChoice.remove("1");
                    }
                }
                break;
            case R.id.check_answer_2:
                if (check_checked){
                    checkChoice.add("2");
                } else {
                    if(checkChoice.contains("2")){
                        checkChoice.remove("2");
                    }
                }
                break;
            case R.id.check_answer_3:
                if (check_checked) {
                    checkChoice.add("3");
                } else {
                    if(checkChoice.contains("3")){
                        checkChoice.remove("3");
                    }
                }
                break;
            case R.id.check_answer_4:
                if (check_checked){
                    checkChoice.add("4");
                } else {
                    if(checkChoice.contains("4")){
                        checkChoice.remove("4");
                    }
                }
                break;
        }
    }


    public void refresh(View view) {
        if(view.equals(start)){
            setContentView(R.layout.activity_main);
            questionHeader = (TextView) findViewById(R.id.question_header);
            questionTextView = (TextView) findViewById(R.id.question);
            resultsText = (TextView) findViewById(R.id.results);
            rg = (RadioGroup) findViewById(R.id.radio_answer_group);
            c1 = (CheckBox) findViewById(R.id.check_answer_1);
            c2 = (CheckBox) findViewById(R.id.check_answer_2);
            c3 = (CheckBox) findViewById(R.id.check_answer_3);
            c4 = (CheckBox) findViewById(R.id.check_answer_4);
            r1 = (RadioButton) findViewById(R.id.radio_answer_1);
            r2 = (RadioButton) findViewById(R.id.radio_answer_2);
            r3 = (RadioButton) findViewById(R.id.radio_answer_3);
            r4 = (RadioButton) findViewById(R.id.radio_answer_4);
            checkChoice = new ArrayList<>();
            f = (EditText) findViewById(R.id.free_answer);
            checkBoxAnswerBox = (LinearLayout) findViewById(R.id.checkbox_linearLayout);
            submit = (Button) findViewById(R.id.submit_button);
            next = (Button) findViewById(R.id.next_button);

        }
        if(questionNumber == 11){
            setContentView(R.layout.end);
            scoreText = (TextView) findViewById(R.id.score_text);
            scoreText.setText("Your score is " + score + " out of 10!");
        }
        next.setEnabled(false);
        submit.setEnabled(true);
        checkBoxAnswerBox.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);
        f.setVisibility(View.INVISIBLE);
        rg.clearCheck();
        f.setText("");
        c1.setChecked(false);
        c2.setChecked(false);
        c3.setChecked(false);
        c4.setChecked(false);
        question = new Questions(questionNumber);
        questionType = question.getQuestionType();



        resultsText.setText("");
        switch (questionType) {
            case "c":

                checkBoxAnswerBox.setVisibility(View.VISIBLE);


                c1.setText(question.getQuestionOptions()[0]);
                c2.setText(question.getQuestionOptions()[1]);
                c3.setText(question.getQuestionOptions()[2]);
                c4.setText(question.getQuestionOptions()[3]);

                questionHeader.setText("Question #" + questionNumber + " of 10!");
                questionTextView.setText(question.getQuestion());
                break;
            case "r":


                rg.setVisibility(View.VISIBLE);

                r1.setText(question.getQuestionOptions()[0]);
                r2.setText(question.getQuestionOptions()[1]);
                r3.setText(question.getQuestionOptions()[2]);
                r4.setText(question.getQuestionOptions()[3]);

                questionHeader.setText("Question #" + questionNumber + " of 10!");
                questionTextView.setText(question.getQuestion());
                break;

            case "f":

                f.setVisibility(View.VISIBLE);
                f.addTextChangedListener(textWatcher);

                questionHeader.setText("Question #" + questionNumber + " of 10!");
                questionTextView.setText(question.getQuestion());
                break;
        }

    }

    public void submit(View view) {

        switch (questionType) {
            case "c":
                String finalCheckAnswer = "";
                for(int i = 0; i < checkChoice.size(); i++){
                    finalCheckAnswer += checkChoice.get(i);
                }
                if(finalCheckAnswer.equals(question.getAnswer())){
                    correct();
                } else {
                    incorrect();
                }
                submit.setEnabled(false);
                next.setEnabled(true);
                break;
            case "r":
                if(radioChoice.equals("")){
                    Context context = getApplicationContext();
                    CharSequence text = "You must select an option.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    break;
                }
                if(radioChoice.equals(question.getAnswer())){
                    correct();
                } else {
                    incorrect();
                }
                submit.setEnabled(false);
                next.setEnabled(true);
                break;
            case "f":
                if(fAnswer.equals("")){
                    Context context = getApplicationContext();
                    CharSequence text = "You must select an option.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    break;
                }
                if(fAnswer.equals(question.getAnswer())){
                    correct();
                } else {
                    incorrect();
                }
                submit.setEnabled(false);
                next.setEnabled(true);
                break;
        }
        questionNumber++;

    }

    public void correct(){
        resultsText.setText("Correct!");
        radioChoice = "";
        fAnswer = "";
        checkChoice.clear();
        score++;
    }
    public void incorrect(){
        resultsText.setText("Incorrect");
        radioChoice = "";
        fAnswer = "";
        checkChoice.clear();
    }



}
