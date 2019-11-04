package com.fansup.fplus.model;

import com.fansup.fplus.contract.MainContract;

public class MainModel implements MainContract.Model {
    @Override
    public void demoModel(ModelListener modelListener) {
        modelListener.completed("mvp test");
    }
}
