package com.realtor.jx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.realtor.jx.R;

import java.util.List;

/**
 * description: 合同列表页ViewpagerIndicator
 * autour: Tait
 * created at: 2018/1/6 15:02
 */
public class ContractListPagerIndicator extends LinearLayout {
    private static final String DEFAULT_TXT_NORMAL_COLOR = "#ffcdd4";
    private static final String DEFAULT_TXT_SELECT_COLOR = "#ffffff";
    private static final String DEFAULT_INDICATOR_NORMAL_COLOR = "#d20000";
    private static final String DEFAULT_INDICATOR_SELECT_COLOR = "#ffffff";
    private static final float DEFAULT_TXT_FONT_SIZE = 40;

    private static final int DEFAULT_INDICATOR_HEIGHT = 3;//dp
    private static final int DEFAULT_INDICATOR_MARGIN_BOTTOM = 0;//dp
    private static final int DEFAULT_TAB_COUNT = 2;

    private Paint mPaint;
    private int mTabVisibleCount;
    private int tabWidth;
    private int tabHeight;

    private float mTxtFontSize;
    private int mTxtNormalColor;
    private int mTxtSelectColor;
    private int mIndicatorNormalColor;
    private int mIndicatorSelectColor;
    private int mIndicatorHeight;
    private int mIndicatorMarginBottom;

    private int mLineTranslationX;
    private int childCount;

    private ViewPager mViewPager;
    private OnPageChangeListener mOnPageChangeListener;
    private List<String> mTabTitles;

    public ContractListPagerIndicator(Context context) {
        this(context, null);
    }

    public ContractListPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.ContractListPagerIndicator);
        mTxtFontSize = typedArray.getDimension(R.styleable.ContractListPagerIndicator_txtFontSize, DEFAULT_TXT_FONT_SIZE);
        mTxtNormalColor = typedArray.getColor(R.styleable.ContractListPagerIndicator_txtNormalColor, Color.parseColor(DEFAULT_TXT_NORMAL_COLOR));
        mTxtSelectColor = typedArray.getColor(R.styleable.ContractListPagerIndicator_txtSelectColor, Color.parseColor(DEFAULT_TXT_SELECT_COLOR));
        mIndicatorNormalColor = typedArray.getColor(R.styleable.ContractListPagerIndicator_indicatorNormalColor, Color.parseColor(DEFAULT_INDICATOR_NORMAL_COLOR));
        mIndicatorSelectColor = typedArray.getColor(R.styleable.ContractListPagerIndicator_indicatorSelectColor, Color.parseColor(DEFAULT_INDICATOR_SELECT_COLOR));
        mIndicatorHeight = (int) typedArray.getDimension(R.styleable.ContractListPagerIndicator_indicatorHeight, dp2px(DEFAULT_INDICATOR_HEIGHT));
        mIndicatorMarginBottom = (int) typedArray.getDimension(R.styleable.ContractListPagerIndicator_indicatorMarginBottom, dp2px(DEFAULT_INDICATOR_MARGIN_BOTTOM));
        mTabVisibleCount = typedArray.getInteger(R.styleable.ContractListPagerIndicator_visibleCount, DEFAULT_TAB_COUNT);

        typedArray.recycle();
        tabWidth = getScreenWidth() / mTabVisibleCount;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setPathEffect(new CornerPathEffect(3));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            LayoutParams lp = (LayoutParams) childView.getLayoutParams();
            lp.weight = 0;
            lp.width = tabWidth;
            childView.setLayoutParams(lp);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        mPaint.setStrokeWidth(mIndicatorHeight);
        //画灰线
//        mPaint.setColor(mIndicatorNormalColor);
//        canvas.drawLine(0, tabHeight-5, tabWidth * childCount, tabHeight-5, mPaint);
        //画红线
        mPaint.setColor(mIndicatorSelectColor);
        canvas.drawLine(mLineTranslationX, tabHeight - mIndicatorMarginBottom, mLineTranslationX + tabWidth, tabHeight - mIndicatorMarginBottom, mPaint);
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        tabHeight = h;
    }

    /**
     * 滑动
     *
     * @param position
     * @param offset
     */
    public void scroll(int position, float offset) {
        //红线要移动的距离
        mLineTranslationX = (int) (tabWidth * (offset + position));
        // 容器滚动，当移动到倒数最后一个的时候，开始滚动
        if ((position < (childCount - 2)) && position >= (mTabVisibleCount - 2) && offset > 0 && getChildCount() > mTabVisibleCount) {
            if (mTabVisibleCount != 1) {
                this.scrollTo((position - (mTabVisibleCount - 2)) * tabWidth + (int) (tabWidth * offset), 0);
            } else {// 为count为1时 的特殊处理
                this.scrollTo(position * tabWidth + (int) (tabWidth * offset), 0);
            }
        }
        invalidate();
    }

    /**
     * 设置Tab数据集合
     *
     * @param datas
     */
    public void setTabItemTitles(List<String> datas) {
        // 如果传入的list有值，则移除布局文件中设置的view
        if (datas != null && datas.size() > 0) {
            this.removeAllViews();
            this.mTabTitles = datas;
            childCount = datas.size();
            tabWidth = getScreenWidth() / mTabVisibleCount;
            for (String title : mTabTitles) {
                // 添加view
                addView(generateTextView(title));
            }
        }
        // 设置item的click事件
        setItemClickEvent();
    }

    private TextView generateTextView(String text) {
        TextView tv = new TextView(getContext());
        LayoutParams lp = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        lp.width = getScreenWidth() / mTabVisibleCount;
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(mTxtNormalColor);
        tv.setText(text);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTxtFontSize);
        tv.setLayoutParams(lp);
        return tv;
    }

    /**
     * 高亮文本
     *
     * @param position
     */
    protected void highLightTextView(int position) {
        View view = getChildAt(position);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(mTxtSelectColor);
        }
    }

    /**
     * 重置文本颜色
     */
    private void resetTextViewColor() {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(mTxtNormalColor);
            }
        }
    }

    protected void shadowTextColor(int position, float positionOffset) {
        View preView = getChildAt(position);
        View nextView = null;
        if (position != childCount - 1) {
            nextView = getChildAt(position + 1);
        }
        if (preView instanceof TextView) {
            preView.setAlpha(1 - positionOffset);
        }
        if (nextView != null) {
            if (nextView instanceof TextView) {
                nextView.setAlpha(positionOffset);
            }
        }
    }

    /**
     * 设置点击事件
     */
    public void setItemClickEvent() {
        int cCount = getChildCount();
        for (int i = 0; i < cCount; i++) {
            final int j = i;
            View view = getChildAt(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(j);
                }
            });
        }
    }

    public int getTabVisibleCount() {
        return mTabVisibleCount;
    }

    public void setTabVisibleCount(int mTabVisibleCount) {
        this.mTabVisibleCount = mTabVisibleCount;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public void addOnPageChangeListener(OnPageChangeListener mOnPageChangeListener) {
        this.mOnPageChangeListener = mOnPageChangeListener;
    }

    public interface OnPageChangeListener {

        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        void onPageSelected(int position);

        void onPageScrollStateChanged(int state);
    }

    /**
     * 关联ViewPager
     *
     * @param viewPager
     * @param defaultPos
     */
    public void setUpWithViewPager(ViewPager viewPager, final int defaultPos) {
        this.mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                scroll(position, positionOffset);
//                shadowTextColor(position,positionOffset);
                if (mOnPageChangeListener != null) {
                    mOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }
            }

            @Override
            public void onPageSelected(int position) {
                // 设置字体颜色高亮
                resetTextViewColor();
                highLightTextView(position);
                if (mOnPageChangeListener != null) {
                    mOnPageChangeListener.onPageSelected(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (mOnPageChangeListener != null) {
                    mOnPageChangeListener.onPageScrollStateChanged(state);
                }
            }
        });
        highLightTextView(defaultPos);
        mViewPager.setCurrentItem(defaultPos);
    }

    /**
     * 得到屏幕宽度
     *
     * @return
     */
    public int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * dp 2 px
     *
     * @param dpVal
     */
    protected int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }

    /**
     * sp 2 px
     *
     * @param spVal
     * @return
     */
    protected int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, getResources().getDisplayMetrics());

    }
}
