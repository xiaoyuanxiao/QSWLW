package com.qs.qswlw.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;

/**
 * Created by burning on 2017/9/19.
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * -------------------------//┏┓　　　┏┓
 * -------------------------//┏┛┻━━━┛┻┓
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　━　　　┃
 * -------------------------//┃　┳┛　┗┳　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　┻　　　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┗━┓　　　┏━┛
 * -------------------------//┃　　　┃  神兽保佑
 * -------------------------//┃　　　┃  代码无BUG！
 * -------------------------//┃　　　┗━━━┓
 * -------------------------//┃　　　　　　　┣┓
 * -------------------------//┃　　　　　　　┏┛
 * -------------------------//┗┓┓┏━┳┓┏┛
 * -------------------------// ┃┫┫　┃┫┫
 * -------------------------// ┗┻┛　┗┻┛
 */

public class MySwipeRefresh extends SwipeRefreshLayout {
    private static final String TAG = SwipeRefreshView.class.getSimpleName();
    private final View mFooterView;
    private ListView mListView;
    private SwipeRefreshView.OnLoadListener mListener;
    /**
     * 正在加载状态
     */
    private boolean isLoading;

    public MySwipeRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 填充底部加载布局
        mFooterView = View.inflate(context, R.layout.view_footview, null);
        // 表示控件移动的最小距离，手移动的距离大于这个距离才能拖动控件
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        // 获取ListView,设置ListView的布局位置
        if (mListView == null) {
            // 判断容器有多少个孩子
            if (getChildCount() > 0) {
                // 判断第一个孩子是不是ListView
                if (getChildAt(0) instanceof ListView) {
                    // 创建ListView对象
                    mListView = (ListView) getChildAt(0);
                    mListView.addFooterView(mFooterView);
                    mFooterView.setPadding(0, -mFooterView.getMeasuredHeight(), 0, 0);
                }
            }
        }
    }


    /**
     * 在分发事件的时候处理子控件的触摸事件
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (islast())
                    mFooterView.setPadding(0, 0, 0, 0);
                break;
            case MotionEvent.ACTION_UP:
                if (canLoadMore()) {
                    loadData();
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private boolean islast() {
        Log.d("TAG", "getlastPosition()======" + getlastPosition() + "mListView.getAdapter().getCount()" + mListView.getAdapter().getCount());
        return getlastPosition() == mListView.getAdapter().getCount() - 1;
    }

    private int getlastPosition() {
        return mListView.getLastVisiblePosition();
    }

    /**
     * 判断是否满足加载更多条件
     */
    private boolean canLoadMore() {
        return mFooterView.getPaddingTop() >= 0;
    }

    /**
     * 处理加载数据的逻辑
     */
    private void loadData() {
        if (isLoading) {
            System.out.println("加载数据中...");
            return;
        }
        System.out.println("加载数据...");
        if (mListener != null) {
            // 设置加载状态，让布局显示出来
            setLoading(true);
            mListener.onLoad();
        }
    }

    /**
     * 设置加载状态，是否加载传入boolean值进行判断
     *
     * @param loading
     */
    public void setLoading(boolean loading) {
        // 修改当前的状态
        if (mFooterView == null || mListView == null)
            return;
        isLoading = loading;
        if (isLoading) {
            // 显示布局
            //  mListView.addFooterView(mFooterView);
        } else {
            mFooterView.setPadding(0, -mFooterView.getMeasuredHeight(), 0, 0);
            // 重置滑动的坐标

        }
    }

    /**
     * 上拉加载的接口回调
     */
    public interface OnLoadListener {
        void onLoad();
    }

    public void setOnLoadListener(SwipeRefreshView.OnLoadListener listener) {
        this.mListener = listener;
    }
}
