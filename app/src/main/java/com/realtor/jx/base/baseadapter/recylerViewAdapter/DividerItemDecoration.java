package com.realtor.jx.base.baseadapter.recylerViewAdapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * author: sundong
 * created at 2017/4/24 15:35
 * 自定义RecyclerView分割线
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int ORIENTATION_VERTICAL = 0;
    public static final int ORIENTATION_HORIZONTAL = 1;
    private int mOrientation;
    private int mDividerThickness;
    private Paint mPaint;
    private Context mContext;
    private boolean hasLast = false;

    public DividerItemDecoration(Context context, int orientation, int color, int thickness) {
        this.mContext = context;
        this.mOrientation = orientation;
        mDividerThickness = dp2px(mContext, thickness);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.FILL);
    }


    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }

    public void setDividerThickness(int mDividerThickness) {
        this.mDividerThickness = mDividerThickness;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == ORIENTATION_HORIZONTAL) {
            drawHorizontal(c, parent, state);
        } else {
            drawVertical(c, parent, state);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();

        for (int i = 0; i <(hasLast ? childCount : childCount - 1); i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams =
                    (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + mDividerThickness;
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent, RecyclerView.State state) {
        // 对于水平方向的分割线，两端的位置是不变的，可以直接通过RecyclerView来获取
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        // 这里获取的是一屏的Item数量
        int childCount = parent.getChildCount();

        // 分割线从Item的底部开始绘制，且在最后一个Item底部不绘制
        for (int i = 0; i < (hasLast ? childCount : childCount - 1); i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams =
                    (RecyclerView.LayoutParams) child.getLayoutParams();
            // 有的Item布局会设置layout_marginXXX
            int top = child.getBottom() + layoutParams.bottomMargin;
            int bottom = top + mDividerThickness;
            c.drawRect(left, top, right, bottom, mPaint);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == ORIENTATION_HORIZONTAL) {
            outRect.set(0, 0, 0, mDividerThickness);
        } else {
            outRect.set(0, 0, mDividerThickness, 0);
        }
    }

    private int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics());
    }
}
