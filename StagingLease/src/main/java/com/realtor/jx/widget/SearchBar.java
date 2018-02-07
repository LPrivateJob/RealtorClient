package com.realtor.jx.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.utils.StringUtil;

/**
 * description:
 * autour: Tait
 * created at 2018/1/9 15:05
 */
public class SearchBar extends LinearLayout {
    private Context mContext;
    private EditText mEtInput;
    private ImageView mIvClear;
    private TextView mTvSearch;
    private OnInteractListener mOnInteractListener;

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(mContext, R.layout.widget_searchbar, this);

        mEtInput = findViewById(R.id.mEtInput);
        findViewById(R.id.mIvClear).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtInput.setText("");
            }
        });
        findViewById(R.id.mTvSearch).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEtInput.getText().toString();
                if (StringUtil.isEmpty(content)) {
                    Toast.makeText(mContext, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (mOnInteractListener != null) {
                        mOnInteractListener.onSearchClick(content);
                    }
                }
            }
        });
    }

    public interface OnInteractListener {
        void onSearchClick(String content);
    }

    public void setOnInteractListener(OnInteractListener mOnInteractListener) {
        this.mOnInteractListener = mOnInteractListener;
    }
}
