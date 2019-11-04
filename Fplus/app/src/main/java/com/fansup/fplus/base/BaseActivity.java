package com.fansup.fplus.base;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import com.fansup.fplus.utils.RxLifecycleUtils;
import com.uber.autodispose.AutoDisposeConverter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity {
    private Unbinder mUnbinder;

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
//        setupActivityComponent();
        mUnbinder = ButterKnife.bind(this);
        initView();
        initData();
        initLifecycleObserver(getLifecycle());
    }

//    protected abstract void setupActivityComponent();

    protected <T> AutoDisposeConverter<T> bindLifecycle() {
        return RxLifecycleUtils.bindLifecycle(this);
    }

    protected abstract int getLayoutId();

    @CallSuper
    @MainThread
    protected void initLifecycleObserver(@NonNull Lifecycle lifecycle) {
        presenter.setLifecycleOwner(this);
        lifecycle.addObserver(presenter);
    }

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
        this.mUnbinder = null;
    }

    @MainThread
    @Override
    public void showLoading() {

    }

    @MainThread
    @Override
    public void hideLoading() {

    }
}
