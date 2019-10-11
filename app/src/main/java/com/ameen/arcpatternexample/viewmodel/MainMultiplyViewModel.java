package com.ameen.arcpatternexample.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ameen.arcpatternexample.repo.DataBase;
import com.ameen.arcpatternexample.repo.model.NumberModel;

public class MainMultiplyViewModel extends ViewModel {

    public MutableLiveData<Integer> mMutableLiveData = new MutableLiveData<>();

    public void getMulResult() {
        NumberModel mNumberModel = getNumbersFromDataBase();
        int result = mNumberModel.getFirstNum() * mNumberModel.getSecondNum();

        mMutableLiveData.setValue(result);
    }

    private NumberModel getNumbersFromDataBase() {
        return new DataBase().getNumbers();
    }
}
