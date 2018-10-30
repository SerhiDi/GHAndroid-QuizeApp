package com.example.trazi.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int Q1_ANSWER = R.id.question_1_answer_2;
    final int Q2_ANSWER = R.id.question_2_answer_1;
    final String Q3_ANSWER = "Apple";
    final int QUESTIONS_AMOUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        int correctAnswers = 0;
        boolean correctAnswer1 = checkRadioButton(R.id.question_1_radio_group, Q1_ANSWER);
        boolean correctAnswer2 = checkRadioButton(R.id.question_2_radio_group, Q2_ANSWER);
        boolean correctAnswer3 = checkEditText(R.id.question_3_edit_text, Q3_ANSWER);

        if (correctAnswer1) {
            correctAnswers++;
        }
        if (correctAnswer2) {
            correctAnswers++;
        }
        if (correctAnswer3) {
            correctAnswers++;
        }
        if (checkQuestion4()) {
            correctAnswers++;
        }
        showResults(correctAnswers);
    }

    private boolean checkQuestion4() {
        CheckBox checkbox1 = checkCheckboxSelected(R.id.question_4_answer_1);
        CheckBox checkbox2 = checkCheckboxSelected(R.id.question_4_answer_2);
        CheckBox checkbox3 = checkCheckboxSelected(R.id.question_4_answer_3);
        return checkbox1.isChecked() && !checkbox2.isChecked() && checkbox3.isChecked();
    }

    private boolean checkEditText(int editTextId, String answer) {
        EditText edittext = (EditText) findViewById(editTextId);
        return edittext.getText().toString().equalsIgnoreCase(answer);
    }

    private boolean checkRadioButton(int radioGroupId, int answerRadioId) {
        RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupId);
        return radioGroup.getCheckedRadioButtonId() == answerRadioId;
    }

    private CheckBox checkCheckboxSelected(int checkBoxId) {
        return findViewById(checkBoxId);
    }

    public void showResults(int correctAnswers) {
        Context context = getApplicationContext();
        CharSequence text = "Your score: " + correctAnswers + "/" + QUESTIONS_AMOUNT;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
