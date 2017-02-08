package com.weiggle.github.bottomdialog.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.weiggle.github.bottomdialog.R;

/**
 * Created by weiggle on 2017/2/8.
 */

public class ShareDialog extends BaseBottomDialog implements View.OnClickListener {


    private TextView weixin,wxFriend,qq,weibo;
    private TextView cancel;
    private OnShareListener mShareListener;

    public ShareDialog(Context context) {
        super(context);

        mContext = context;
    }

    public ShareDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        if(mShareListener != null) {
            switch (v.getId()) {
                case R.id.share_weixin:
                    mShareListener.onSelectedShare(0);
                    break;
                case R.id.share_friend:
                    mShareListener.onSelectedShare(1);
                    break;
                case R.id.share_qq:
                    mShareListener.onSelectedShare(2);
                    break;
                case R.id.share_weibo:
                    mShareListener.onSelectedShare(3);
                    break;
                default:
                    break;
            }
        }

        dismiss();
    }

    @Override
    View setRootView() {
        mParams.height = mContext.getResources().getDisplayMetrics().heightPixels/5*2;
        mWindow.setAttributes(mParams);
        mContent = getLayoutInflater().inflate(R.layout.share_layout,null);
        return mContent;
    }

    @Override
    void initView() {

        weixin = (TextView) findViewById(R.id.share_weixin);
        wxFriend = (TextView) findViewById(R.id.share_friend);
        qq = (TextView) findViewById(R.id.share_qq);
        weibo = (TextView) findViewById(R.id.share_weibo);
        cancel = (TextView) findViewById(R.id.share_cancel);

        weixin.setOnClickListener(this);
        wxFriend.setOnClickListener(this);
        qq.setOnClickListener(this);
        weibo.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    public void setShareListener(OnShareListener shareListener) {
        mShareListener = shareListener;
    }

    public interface OnShareListener{
        void onSelectedShare(int pos);
    }

}
