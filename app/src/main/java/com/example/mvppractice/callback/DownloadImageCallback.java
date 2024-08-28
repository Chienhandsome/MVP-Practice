package com.example.mvppractice.callback;

import android.graphics.Bitmap;

public interface DownloadImageCallback {
    void onDownloadSuccess(Bitmap bitmap);
    void onDownloadFailed(String message);
}
