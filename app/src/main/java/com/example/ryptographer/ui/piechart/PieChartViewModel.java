package com.example.ryptographer.ui.piechart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PieChartViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PieChartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}