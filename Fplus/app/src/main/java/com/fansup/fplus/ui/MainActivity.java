package com.fansup.fplus.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.fansup.fplus.R;
import com.fansup.fplus.base.BaseActivity;
import com.fansup.fplus.contract.MainContract;
import com.fansup.fplus.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        presenter = new MainPresenter(this);
        presenter.demoPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void demoView(String test) {
        Toast.makeText(this, test, Toast.LENGTH_LONG).show();
    }
}
