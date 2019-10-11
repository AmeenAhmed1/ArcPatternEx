package com.ameen.arcpatternexample.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ameen.arcpatternexample.R;
import com.ameen.arcpatternexample.repo.DataBase;
import com.ameen.arcpatternexample.repo.model.NumberModel;
import com.ameen.arcpatternexample.viewmodel.MainMultiplyViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, MainDivContract.MainDivView {

    //View references
    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    @BindView(R.id.plus_result_textView)
    TextView plusResultTextView;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;

    DataBase mDataBase = new DataBase();
    NumberModel mNumberModel;
    MainDivPresenter mMainDivPresenter;
    MainMultiplyViewModel mainMultiplyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Buttons click listeners
        plusButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);


        //Presenter
        mMainDivPresenter = new MainDivPresenter(this);

        //init the ViewModel
        mainMultiplyViewModel = ViewModelProviders.of(this).get(MainMultiplyViewModel.class);
        mainMultiplyViewModel.mMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mulResultTextView.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            //For MVC Pattern
            case R.id.plus_button:
                mNumberModel = mDataBase.getNumbers();
                plusResultTextView.setText(
                        String.valueOf(mNumberModel.getFirstNum() + mNumberModel.getSecondNum()));
                break;

            //For MVP Pattern
            case R.id.div_button:
                mMainDivPresenter.getDivResult();
                break;

            //For MVVM Pattern
            case R.id.mul_button:
                mainMultiplyViewModel.getMulResult();
                break;


        }
    }

    @Override
    public void onDivClicked(float result) {
        divResultTextView.setText(String.valueOf(result));
    }
}
