package com.albert.mvp;

import java.util.List;

public interface MainContract {
    interface View extends BaseView {
        void showFamilyNames(List<String> data);
    }

    interface Presenter extends BasePresenter<View> {
        void loadFamilyNames();
    }

}
