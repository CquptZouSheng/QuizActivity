package com.zou.android.quizactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private Boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    public static final String KEY_INDEX="index";
    public static Boolean mAnswerIsShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue=getIntent().getBooleanExtra("answer_is_true",false);
        mAnswerIsShown=false;
        if (savedInstanceState!=null){
            mAnswerIsShown=savedInstanceState.getBoolean(KEY_INDEX,false);
        }
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
                mAnswerIsShown=true;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_INDEX,mAnswerIsShown);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("answer_shown",mAnswerIsShown);
        setResult(RESULT_OK,intent);
        finish();
    }//返回是否作弊的数据

    private void initView() {
        mAnswerTextView= (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer= (Button) findViewById(R.id.show_answer_button);
    }//初始化View
}
