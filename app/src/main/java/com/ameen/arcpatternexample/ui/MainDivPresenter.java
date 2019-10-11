package com.ameen.arcpatternexample.ui;

import com.ameen.arcpatternexample.repo.DataBase;
import com.ameen.arcpatternexample.repo.model.NumberModel;

public class MainDivPresenter implements MainDivContract.MainDivPresenter{

    private NumberModel mNumberModel;
    private MainDivContract.MainDivView mainDivView;

    MainDivPresenter(MainDivContract.MainDivView mainDivView) {
        this.mainDivView = mainDivView;
        mNumberModel = new DataBase().getNumbers();
    }

    @Override
    public void getDivResult() {
        if(mNumberModel.getSecondNum() > 0) {
            float result = mNumberModel.getFirstNum() / mNumberModel.getSecondNum();
            mainDivView.onDivClicked(result);
        }
    }
}
