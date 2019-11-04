package com.fansup.fplus.contract;

public interface MainContract {
    interface View{
        void demoView(String test);
    }

    interface Presenter{
        void demoPresenter();
    }

    interface Model{
        void demoModel(ModelListener modelListener);

        interface ModelListener{
            void completed(String test);
        }
    }
}
