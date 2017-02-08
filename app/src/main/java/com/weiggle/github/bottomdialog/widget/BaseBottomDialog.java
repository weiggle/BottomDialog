package com.weiggle.github.bottomdialog.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.weiggle.github.bottomdialog.R;

/**
 * Created by weiggle on 2017/2/8.
 */

public abstract class BaseBottomDialog extends Dialog{

    protected Context mContext;
    protected View mContent;
    protected Window mWindow;
    protected WindowManager.LayoutParams mParams;

    public BaseBottomDialog(Context context) {
        this(context,R.style.BaseBottomDialogAtyle);
    }

    public BaseBottomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(true);

        mWindow = getWindow();
        mWindow.getDecorView().setPadding(0,0,0,0);
        mParams = mWindow.getAttributes();
        mParams.gravity = Gravity.BOTTOM;
        mParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.windowAnimations = R.style.BaseBottomDialogAnim;
        mWindow.setAttributes(mParams);

        mContent = setRootView();
        this.setContentView(mContent);
        initView();

    }


    protected void showView(View v){
        v.setVisibility(View.VISIBLE);
    }

    protected void goneView(View v){
        v.setVisibility(View.GONE);
    }

    abstract View setRootView();
    abstract void initView();


}
