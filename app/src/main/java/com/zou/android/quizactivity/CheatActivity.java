package com.zou.android.quizactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private Boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue=getIntent().getBooleanExtra("answer_is_true",false);
        initView();
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }
                else {
                    mAnswerTextView.setText(R.string.false_button);
                }
            }
        });
    }

    private void initView() {
        mAnswerTextView= (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer= (Button) findViewById(R.id.show_answer_button);
    }
}
