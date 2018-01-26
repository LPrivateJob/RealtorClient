package com.realtor.jx.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * author: sundong
 * created at 2018/1/26 14:47
 */


public class GlideManager {
    private GlideManager() {
    }

    private static class SingletonHolder {
        private static GlideManager INSTANCE = new GlideManager();
    }

    public static GlideManager getInstance() {
        return GlideManager.SingletonHolder.INSTANCE;
    }

    public static void loadImage(Context context,ImageView imageView,String url){
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
