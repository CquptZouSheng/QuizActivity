package com.zou.android.quizactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton,mFalseButton;
    private ImageButton mNextButton,mPreButton;
    private TextView mQuestionTextview;
    private Question mQuestionBank[]=new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initView();
        clickListener();
        updateQuestion();
    }
    private void updateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getTextId();
        mQuestionTextview.setText(question);
    }//更新问题

    private void initView(){
        mQuestionTextview= (TextView) findViewById(R.id.question);
        mTrueButton= (Button) findViewById(R.id.true_button);
        mFalseButton= (Button) findViewById(R.id.false_button);
        mNextButton= (ImageButton) findViewById(R.id.next_button);
        mPreButton= (ImageButton) findViewById(R.id.pre_button);
    }//View初始实例化

    private void clickListener(){
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        });
        mPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=mCurrentIndex-1;
                if (mCurrentIndex==-1){
                    mCurrentIndex=mQuestionBank.length-1;
                }
                updateQuestion();
            }
        });
        mQuestionTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        });
    }//点击事件

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageId=0;
        if (userPressedTrue==answerIsTrue){
            messageId=R.string.correct_toast;
        }
        else{
            messageId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageId,Toast.LENGTH_SHORT).show();
    }
}
