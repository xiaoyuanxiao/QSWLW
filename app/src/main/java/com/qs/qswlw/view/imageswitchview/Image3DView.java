package com.qs.qswlw.view.imageswitchview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 用于在Image3DSwitchView中显示3D图片。
 *
 * @author guolin
 * @from http://blog.csdn.net/guolin_blog/article/details/17482089
 */
public class Image3DView extends ListView {


    /**
     * 旋转角度的基准值
     */
    private static final float BASE_DEGREE = 60f;
    /**
     * 旋转深度的基准值
     */
    private static final float BASE_DEEP = 150f;
    private Camera mCamera;
    private Matrix mMaxtrix;
    private Bitmap mBitmap;
    /**
     * 当前图片对应的下标
     */
    private int mIndex;
    /**
     * 在前图片在X轴方向滚动的距离
     */
    private int mScrollX;
    /**
     * Image3DSwitchView控件的宽度
     */
    private int mLayoutWidth;
    /**
     * 当前图片的宽度
     */
    private int mWidth;
    /**
     * 当前旋转的角度
     */
    private float mRotateDegree;
    /**
     * 旋转的中心点
     */
    private float mDx;
    /**
     * 旋转的深度
     */
    private float mDeep;

    public Image3DView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCamera = new Camera();
        mMaxtrix = new Matrix();
    }


    /**
     * 初始化Image3DView所需要的信息，包括图片宽度，截取背景图等。
     */
    public void initImageViewBitmap() {
        /*if (mBitmap == null) {
            setDrawingCacheEnabled(true);
            buildDrawingCache();
            mBitmap = getDrawingCache();
        }*/
        mLayoutWidth = Image3DSwitchView.mWidth;
        mWidth = getWidth() + Image3DSwitchView.IMAGE_PADDING * 2;
    }

    /**
     * 设置旋转角度。
     *
     * @param index   当前图片的下标
     * @param scrollX 当前图片在X轴方向滚动的距离
     */
    int lay3 = 0;

    public void setRotateData(int index, int scrollX) {
       /* double v = 1 - Math.cos(mRotateDegree * Math.PI / 180);

        if (mIndex == 3) {
            if (lay3 == 0)
                lay3 = getLeft();
            int xx = (int) (v * mWidth);
            layout(lay3 - xx, getTop(),
                    getRight(), getBottom());
        }*/
        mIndex = index;
        mScrollX = scrollX;
    }

    /**
     * 回收当前的Bitmap对象，以释放内存。
     */
    public void recycleBitmap() {
       /* if (mBitmap != null && !mBitmap.isRecycled()) {
            mBitmap.recycle();
        }*/
    }

//	@Override
//	public void setImageResource(int resId) {
//		super.setImageResource(resId);
//		mBitmap = null;
//		initImageViewBitmap();
//	}
//
//	@Override
//	public void setImageBitmap(Bitmap bm) {
//		super.setImageBitmap(bm);
//		mBitmap = null;
//		initImageViewBitmap();
//	}
//
//	@Override
//	public void setImageDrawable(Drawable drawable) {
//		super.setImageDrawable(drawable);
//		mBitmap = null;
//		initImageViewBitmap();
//	}
//
//	@Override
//	public void setImageURI(Uri uri) {
//		super.setImageURI(uri);
//		mBitmap = null;
//		initImageViewBitmap();
//	}


    @Override
    protected void onDraw(Canvas canvas) {

    }

    final float with = 360f;
    float myx = 0f;

    /**
     * 在这里计算所有旋转所需要的数据。
     */
    private void computeRotateData() {
        float degreePerPix = BASE_DEGREE / mWidth;
        float deepPerPix = BASE_DEEP / ((mLayoutWidth - mWidth) / 2);
        switch (mIndex) {
            case 0:
                mDx = mWidth;
                mRotateDegree = with - (2 * mWidth + mScrollX) * degreePerPix;
                if (mScrollX < -mWidth) {
                    mDeep = 0;
                } else {
                    mDeep = (mWidth + mScrollX) * deepPerPix;
                }
                break;
            case 1:
                if (mScrollX > 0) {
                    mDx = mWidth;
                    mRotateDegree = (with - BASE_DEGREE) - mScrollX * degreePerPix;
                    mDeep = mScrollX * deepPerPix;
                } else {
                    if (mScrollX < -mWidth) {
                        mDx = -Image3DSwitchView.IMAGE_PADDING * 2;
                        mRotateDegree = (-mScrollX - mWidth) * degreePerPix;
                    } else {
                        mDx = mWidth;
                        mRotateDegree = with - (mWidth + mScrollX) * degreePerPix;
                    }
                    mDeep = 0;
                }
                break;
            case 2:
                if (mScrollX > 0) {
                    mDx = mWidth;
                    mRotateDegree = with - mScrollX * degreePerPix;
                    mDeep = 0;
                    if (mScrollX > mWidth) {
                        mDeep = (mScrollX - mWidth) * deepPerPix;
                    }
                } else {
                    mDx = -Image3DSwitchView.IMAGE_PADDING * 2;
                    mRotateDegree = -mScrollX * degreePerPix;
                    mDeep = 0;
                    if (mScrollX < -mWidth) {
                        mDeep = -(mWidth + mScrollX) * deepPerPix;
                    }
                }
                break;
            case 3:
                if (mScrollX < 0) {
                    mDx = -Image3DSwitchView.IMAGE_PADDING * 2;
                    mRotateDegree = BASE_DEGREE - mScrollX * degreePerPix;
                    mDeep = -mScrollX * deepPerPix;
                } else {
                    if (mScrollX > mWidth) {
                        mDx = mWidth;
                        mRotateDegree = with - (mScrollX - mWidth) * degreePerPix;
                    } else {
                        mDx = -Image3DSwitchView.IMAGE_PADDING * 2;
                        mRotateDegree = BASE_DEGREE - mScrollX * degreePerPix;
                    }
                    mDeep = 0;
                }
                break;
            case 4:
                mDx = -Image3DSwitchView.IMAGE_PADDING * 2;
                mRotateDegree = (2 * mWidth - mScrollX) * degreePerPix;
                if (mScrollX > mWidth) {
                    mDeep = 0;
                } else {
                    mDeep = (mWidth - mScrollX) * deepPerPix;
                }
                break;
        }
    }

    /**
     * 判断当前图片是否可见。
     *
     * @return 当前图片可见返回true，不可见返回false。
     */
    private boolean isImageVisible() {
        boolean isVisible = false;
        switch (mIndex) {
            case 0:
                if (mScrollX < (mLayoutWidth - mWidth) / 2 - mWidth) {
                    isVisible = true;
                } else {
                    isVisible = false;
                }
                break;
            case 1:
                if (mScrollX > (mLayoutWidth - mWidth) / 2) {
                    isVisible = false;
                } else {
                    isVisible = true;
                }
                break;
            case 2:
                if (mScrollX > mLayoutWidth / 2 + mWidth / 2
                        || mScrollX < -mLayoutWidth / 2 - mWidth / 2) {
                    isVisible = false;
                } else {
                    isVisible = true;
                }
                break;
            case 3:
                if (mScrollX < -(mLayoutWidth - mWidth) / 2) {
                    isVisible = false;
                } else {
                    isVisible = true;
                }
                break;
            case 4:
                if (mScrollX > mWidth - (mLayoutWidth - mWidth) / 2) {
                    isVisible = true;
                } else {
                    isVisible = false;
                }
                break;
        }
        return isVisible;
    }

    @Override
    public void draw(Canvas canvas) {
        computeRotateData();
        mCamera.save();
        mCamera.translate(0, 0, mDeep);
        mCamera.rotateY(mRotateDegree);
        mCamera.getMatrix(mMaxtrix);
        mCamera.restore();
        mMaxtrix.preTranslate(-mDx, -getHeight() / 2);
        mMaxtrix.postTranslate(mDx, getHeight() / 2);
        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(getWidth() == 0 ? 100 : getWidth(), getHeight() == 0 ? 100 : getHeight(),
                    Bitmap.Config.ARGB_8888);
            mBitmap.eraseColor(color);
        }
        if (mBitmap != null && mBitmap.getWidth() != getWidth() && mBitmap.getHeight() != getHeight()) {
            mBitmap = ThumbnailUtils.extractThumbnail(mBitmap, getWidth() == 0 ? 100 : getWidth(), getHeight() == 0 ? 100 : getHeight());
        }
        canvas.drawBitmap(mBitmap, mMaxtrix, new Paint());
        canvas.concat(mMaxtrix);
        super.draw(canvas);

    }

   /* @Override
    protected void dispatchDraw(Canvas canvas) {
        if (isImageVisible()) {
            computeRotateData();
            mCamera.save();
            mCamera.translate(0, 0, mDeep);
            mCamera.rotateY(mRotateDegree);
            mCamera.getMatrix(mMaxtrix);
            mCamera.restore();
            mMaxtrix.preTranslate(-mDx, -getHeight() / 2);
            mMaxtrix.postTranslate(mDx, getHeight() / 2);
            if (mBitmap == null) {
                mBitmap = Bitmap.createBitmap(getWidth(), getHeight(),
                        Bitmap.Config.ARGB_8888);
                mBitmap.eraseColor(color);
            }
            if (mBitmap != null && mBitmap.getWidth() != getWidth() && mBitmap.getHeight() != getHeight()) {
                mBitmap = ThumbnailUtils.extractThumbnail(mBitmap, getWidth(), getHeight());
            }
            canvas.drawBitmap(mBitmap, mMaxtrix, new Paint());
            canvas.concat(mMaxtrix);
            for (int i = 0; i < getChildCount(); i++) {
                drawChild(canvas, getChildAt(i), getDrawingTime());
            }

        }
    }*/

    public void setmBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    int color = Color.parseColor("#FF0000");

    public void setBColor(int color) {
        this.color = color;
    }
}