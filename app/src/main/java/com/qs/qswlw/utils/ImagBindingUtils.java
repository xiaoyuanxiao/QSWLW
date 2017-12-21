package com.qs.qswlw.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.mynet.ReHttpUtils;

/**
 * Created by xiaoyu on 2017/11/29.
 */

public class ImagBindingUtils {

    @BindingAdapter("imgurl")
    public static void bindingImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(ReHttpUtils.getBaseUrl()+url).into(imageView);
    }

}
