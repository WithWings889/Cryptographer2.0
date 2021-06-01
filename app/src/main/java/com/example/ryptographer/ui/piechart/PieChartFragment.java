package com.example.ryptographer.ui.piechart;


import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.ryptographer.ui.crypto.CryptoViewModel;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ryptographer.R;

import java.util.ArrayList;


public class PieChartFragment extends Fragment {
    private PieChart pieChart;
    private View root;
    private String stringData;

    final String vowelEnglish = "aeiou";
    final String consonantEnglish = "bcdfghjklmnpqrstvwxyz";
    final String vowelRussian = "аеёиоуыэюя";
    final String consonantRussian = "бвгджзйклмнпрстфхцчшщъь";
    final String vowelUkrainian = "аеєиіїоуюя";
    final String consonantUkrainian = "бвгґджзйклмнпрстфхцчшщь";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_piechart, container, false);
        pieChart = root.findViewById(R.id.pieChart1);

        stringData = PieChartFragmentArgs.fromBundle(getArguments()).getData();

        EditText text = new EditText(getActivity());
        text.setText(stringData);

        if(!stringData.isEmpty()){
            loadPieChart();
            setupPieChart();
        }

        return root;
    }


    private ArrayList<Integer> analiseData(){

        int vowelCount = 0, consonantCount = 0, symbolsCount = 0;
        ArrayList<Integer> result = new ArrayList<>();
        String currentVowel, currentConsonant;

        if(stringData.length() == 0)
            return result;

        if(vowelEnglish.indexOf(stringData.charAt(0)) != -1 || consonantEnglish.indexOf(stringData.charAt(0)) != -1)
        {
            currentConsonant = consonantEnglish;
            currentVowel = vowelEnglish;
        }
        else if(vowelRussian.indexOf(stringData.charAt(0)) != -1 || consonantRussian.indexOf(stringData.charAt(0)) != -1)
        {
            currentConsonant = consonantRussian;
            currentVowel = vowelRussian;
        }
        else
        {
            currentConsonant = consonantUkrainian;
            currentVowel = vowelUkrainian;
        }

        for(int i = 0; i < stringData.length(); ++i)
        {
            if(currentConsonant.indexOf(stringData.charAt(i)) != -1) consonantCount++;
             else if(currentVowel.indexOf(stringData.charAt(i)) != -1)  vowelCount++;
             else symbolsCount++;
        }

        result.add(vowelCount);
        result.add(consonantCount);
        result.add(symbolsCount);
        return result;
    }

    private void setupPieChart(){
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setCenterText("Статистика");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);
    }


    private void loadPieChart(){

        ArrayList<Integer> stringData = analiseData();
        int sum = stringData.get(0) + stringData.get(1) + stringData.get(2);

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry((float)stringData.get(0)/(float)sum, "Vowel"));
        entries.add(new PieEntry((float)stringData.get(1)/(float)sum, "Consonant"));
        entries.add(new PieEntry((float)stringData.get(2)/(float)sum, "Symbol"));

        ArrayList<Integer> colors = new ArrayList<>();
        for(int color: ColorTemplate.MATERIAL_COLORS){
            colors.add(color);
        }
        for(int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Category");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        //data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }
}