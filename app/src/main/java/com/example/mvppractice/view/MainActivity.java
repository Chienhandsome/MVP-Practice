package com.example.mvppractice.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvppractice.databinding.ActivityMainBinding;
import com.example.mvppractice.presenter.IMainPresenter;
import com.example.mvppractice.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding viewBinding;
    private IMainPresenter mainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        mainPresenter = new MainPresenter(this);

        setUpViewEvent();
    }

    private void setUpViewEvent() {
        viewBinding.button.setOnClickListener(v -> onButtonClicked());
    }

    private void onButtonClicked() {
        String link = viewBinding.editText.getText().toString();
        Log.d(TAG, "onButtonClicked: " + link);
        mainPresenter.getImage(link);
    }

    @Override
    public void displayImage(Bitmap bitmap) {
        //nhan bitmap tu presenter
        if (bitmap == null ){
            Log.d(TAG, "bitmap is null");
        }
        if (viewBinding == null){
            Log.d(TAG, "displayImage: viewBinding is null");

        }else {
            Log.d(TAG, "displayImage: bitmap is not null");
            //hien thi anh
            viewBinding.imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onDownloadImageFailed(String message) {
        //case tai anh that bai
        Toast.makeText(this, "Tai that bai\n" +message, Toast.LENGTH_SHORT).show();
    }
}