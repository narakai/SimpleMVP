package com.fansup.fplus.presenter;

import com.fansup.fplus.base.BasePresenter;
import com.fansup.fplus.contract.MainContract;
import com.fansup.fplus.model.MainModel;
import com.fansup.fplus.ui.MainActivity;

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {
    MainModel mainModel = new MainModel();

    public MainPresenter(MainActivity rootView) {
        super(rootView);
    }

    @Override
    public void demoPresenter() {
        mainModel.demoModel(new MainContract.Model.ModelListener() {
            @Override
            public void completed(String test) {
                    mRootView.demoView(test);
            }
        });
    }
}
