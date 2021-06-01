package com.example.ryptographer.ui.crypto;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.Telephony.Mms.Part.FILENAME;

public class CryptoViewModel extends ViewModel {

    private final int N = 4;
    private final int CODEC = 0;
    private final int CODEW = 1;
    private final int DECODEC = 2;
    private final int DECODEW = 3;

    private final static String FILE_NAME = "content.txt";

    private MutableLiveData<Integer> encodedC, decodedC, encodedW, decodedW;

    public CryptoViewModel() {
        encodedW = new MutableLiveData<>(0);
        encodedC = new MutableLiveData<>(0);
        decodedC = new MutableLiveData<>(0);
        decodedW = new MutableLiveData<>(0);
    }

    public void addEncodedC(){ encodedC.setValue(encodedC.getValue() + 1); }
    public void addEncodedW(){ encodedW.setValue(encodedW.getValue() + 1); }
    public void addDecodedC(){ decodedC.setValue(decodedC.getValue() + 1); }
    public void addDecodedW(){ decodedW.setValue(decodedW.getValue() + 1); }

    public LiveData<Integer> getEncodedC() {
        return encodedC;
    }
    public LiveData<Integer> getEncodedW() {
        return encodedW;
    }
    public LiveData<Integer> getDecodedC() {
        return decodedC;
    }
    public LiveData<Integer> getDecodedW() {
        return decodedW;
    }

//    public void addEncodedC(){ count[CODEC]++; }
//    public void addEncodedW(){ count[CODEW]++; }
//    public void addDecodedC(){ count[DECODEC]++; }
//    public void addDecodedW(){ count[DECODEW]++; }

    //public int[] getCount(){return count;}


}