package com.example.mvppractice.presenter;

import android.graphics.Bitmap;

import com.example.mvppractice.callback.DownloadImageCallback;
import com.example.mvppractice.model.ImageDownloader;
import com.example.mvppractice.view.IMainActivity;

public class MainPresenter implements IMainPresenter{
    private static final String TAG = "MainPresenter";
    private final IMainActivity view;
    private final DownloadImageCallback callback = new DownloadImageCallback() {
        @Override
        public void onDownloadSuccess(Bitmap bitmap) {
            //goi ham setBitmap de hien thi anh len view
            setBitmap(bitmap);
        }

        @Override
        public void onDownloadFailed(String message) {
            //gui thong bao loi vef cho view
            view.onDownloadImageFailed(message);
        }
    };

    public MainPresenter(IMainActivity view) {
        this.view = view;
    }

    public void getImage(String link) {
        //yeu cau model tai anh
        ImageDownloader.downloadImage(link, callback);
    }

    public void setBitmap(Bitmap bitmap) {
        //hien thi anh len view
       view.displayImage(bitmap);
    }
}
