package com.zou.android.quizactivity;

/**
 * Created by Zou on 2016/9/18.
 */
public class Question {
    private int mTextId;
    private boolean mAnswerTrue;
    public Question(int textId,boolean answerTrue){
        mTextId=textId;
        mAnswerTrue=answerTrue;
    }
    public int getTextId(){
        return mTextId;
    }
    public void setTextId(int textId){
        mTextId=textId;
    }
    public boolean isAnswerTrue(){
        return mAnswerTrue;
    }
    public void setAnswerTrue(boolean answerTrue){
        mAnswerTrue=answerTrue;
    }
}
