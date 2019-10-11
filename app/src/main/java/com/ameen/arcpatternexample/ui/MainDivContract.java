package com.ameen.arcpatternexample.ui;


public interface MainDivContract {

    interface MainDivPresenter{
        void getDivResult();
    }


    interface MainDivView {
        void onDivClicked(float result);
    }
}
