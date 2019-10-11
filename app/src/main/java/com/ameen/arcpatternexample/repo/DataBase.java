package com.ameen.arcpatternexample.repo;

import com.ameen.arcpatternexample.repo.model.NumberModel;

public class DataBase {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
