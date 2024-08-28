package com.example.mvppractice.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.mvppractice.callback.DownloadImageCallback;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageDownloader {
    private static final String TAG = "ImageDownloader";
    private static final ExecutorService executors= Executors.newSingleThreadExecutor();
    public static void downloadImage(String link, DownloadImageCallback callback) {
            executors.submit(() -> {
                try {
                    InputStream in = new URL(link).openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(in);

                    //tai xong bitmap, gui bitmap ve cho presenter thong qua callback
                    callback.onDownloadSuccess(bitmap);
                    Log.d(TAG, "downloadImageAndConvertToBitmap success : ");
                } catch (IOException e) {
                    //neu tai that bai, gui thong bao ve presenter thong qua callback
                    callback.onDownloadFailed(e.getMessage());
                    Log.e(TAG, "downloadImage: ",e );
                }
            });
    }
}
