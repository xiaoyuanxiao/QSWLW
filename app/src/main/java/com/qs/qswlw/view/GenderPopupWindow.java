package com.qs.qswlw.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qs.qswlw.R;


/**
 * Created by dashen10 on 2015/6/15.
 */
public class GenderPopupWindow extends PopupWindow {
    private TextView mCancel;
    private TextView mFemale;
    private TextView mMale;
    public TextView mTitle;
    View mMenView;
    public GenderPopupWindow(Activity context, View.OnClickListener itemOnClick){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenView = inflater.inflate(R.layout.gender_popup,null);
        mMale = (TextView) mMenView.findViewById(R.id.tv_male);
        mFemale = (TextView) mMenView.findViewById(R.id.tv_female);
        mCancel = (TextView) mMenView.findViewById(R.id.tv_cancel);
        mTitle = (TextView)mMenView.findViewById(R.id.tv_pop_title);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mMale.setOnClickListener(itemOnClick);
        mFemale.setOnClickListener(itemOnClick);

        this.setContentView(mMenView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
//        this.setAnimationStyle(R.style.Anim);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(dw);
        mMenView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    /**
     * 设置名字
     * @param name
     */
    public void setFemaleName(String name) {
        mFemale.setText(name);
    }
    public void setMaleName(String name) {
        mMale.setText(name);
    }
    public void setTitleName(String name) {
        mTitle.setText(name);
    }
}
