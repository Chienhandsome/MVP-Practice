package com.example.mvppractice.view;

import android.graphics.Bitmap;

public interface IMainActivity {
    void displayImage(Bitmap bitmap);
    void onDownloadImageFailed(String message);
    void runOnUiThread(Runnable runnable);
}
