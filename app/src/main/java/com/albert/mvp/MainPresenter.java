package com.albert.mvp;

import java.util.List;


public class MainPresenter implements MainContract.Presenter {

    private DataRepository dataRepository;
    private MainContract.View view;

    public MainPresenter(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadFamilyNames() {
        List<String> family = dataRepository.getFamilyNames();
        view.showFamilyNames(family);
    }
}
