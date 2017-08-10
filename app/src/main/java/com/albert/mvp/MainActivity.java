package com.albert.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    @BindView(R.id.familyText)
    TextView familyTextView;

    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenter(new DataRepository());
        presenter.attachView(this);
        presenter.loadFamilyNames();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFamilyNames(List<String> data) {
        familyTextView.setText(data.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detachView();
    }
}
