package com.star.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class TopBar extends RelativeLayout {

    public enum TopBarButton {LEFT_BUTTON, RIGHT_BUTTON}

    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleTextView;

    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;

    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;

    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;

    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;

    private OnTopbarClickListener mOnTopbarClickListener;

    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(0xFFF59563);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Toolbar);

        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = typedArray.getString(R.styleable.TopBar_leftText);

        mRightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = typedArray.getString(R.styleable.TopBar_rightText);

//        mTitleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 10);
        mTitleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        mTitle = typedArray.getString(R.styleable.TopBar_title);

        typedArray.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleTextView = new TextView(context);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        mTitleTextView.setText(mTitle);
        mTitleTextView.setTextColor(mTitleTextColor);
//        mTitleTextView.setTextSize(mTitleTextSize);
        mTitleTextView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleTextView, mTitleParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnTopbarClickListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnTopbarClickListener.rightClick();
            }
        });

    }

    public void setButtonVisiable(TopBarButton myButton, boolean flag) {

        switch (myButton) {
            case LEFT_BUTTON:
                mLeftButton.setVisibility(flag ? View.VISIBLE : View.GONE);
                break;
            case RIGHT_BUTTON:
                mRightButton.setVisibility(flag ? View.VISIBLE : View.GONE);
                break;
            default:
                break;
        }

    }

    public void setOnTopbarClickListener(OnTopbarClickListener onTopbarClickListener) {
        mOnTopbarClickListener = onTopbarClickListener;
    }

    public interface OnTopbarClickListener {
        public void leftClick();
        public void rightClick();
    }

}
