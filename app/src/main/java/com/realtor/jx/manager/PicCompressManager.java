package com.realtor.jx.manager;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.orhanobut.logger.Logger;
import com.realtor.jx.netcore.LoadingDialog;

import java.io.File;
import java.util.Locale;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * description:
 * autour: Tait
 * created at 2018/1/26 13:41
 */
public class PicCompressManager {
    private LoadingDialog loadingDialog;
    private String imageCompressPath;

    private PicCompressManager() {
        imageCompressPath = getCompressPath();
    }

    private static class SingletonHolder {
        private static PicCompressManager INSTANCE = new PicCompressManager();
    }

    public static PicCompressManager getInstance() {
        return PicCompressManager.SingletonHolder.INSTANCE;
    }

    public String getCompressPath() {
        String path = Environment.getExternalStorageDirectory() + "/Luban/image/";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }

    private String computeSize(String srcPath) {
        int[] size = new int[2];

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;

        BitmapFactory.decodeFile(srcPath, options);
        size[0] = options.outWidth;
        size[1] = options.outHeight;

        return String.format(Locale.CHINA, "图片参数：%d*%d, %dk", size[0], size[1], new File(srcPath).length() >> 10);
    }

    public void compress(Context context, final String picPath, OnCompressResultListener onCompressResultListener) {
        Luban.with(context)
                .load(picPath)
                .ignoreBy(100)
                .setTargetDir(getCompressPath())
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        Logger.d(getFileName(picPath) + "压缩前" + computeSize(picPath));
                        loadingDialog = new LoadingDialog(context);
                        loadingDialog.show();
                    }

                    @Override
                    public void onSuccess(File file) {
                        if (loadingDialog != null)
                            loadingDialog.cancel();
                        Logger.d(getFileName(picPath) + "压缩后" + computeSize(file.getPath()));
                        onCompressResultListener.onSuccess(file.getPath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (loadingDialog != null)
                            loadingDialog.cancel();
                        onCompressResultListener.onError(e);
                    }
                }).launch();
    }

    public interface OnCompressResultListener {
        void onSuccess(String picPath);

        void onError(Throwable e);
    }

    public String getFileName(String filePath) {
        return filePath.substring(filePath.lastIndexOf('/') + 1);
    }

    public void deletePicFromDisk() {
        deleteAllFilesOfDir(new File(imageCompressPath));
    }

    private static void deleteAllFilesOfDir(File path) {
        if (!path.exists())
            return;
        if (path.isFile()) {
            path.delete();
            return;
        }
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
            deleteAllFilesOfDir(files[i]);
        }
        path.delete();
    }
}
