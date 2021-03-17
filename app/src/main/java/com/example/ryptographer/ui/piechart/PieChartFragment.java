package com.example.ryptographer.ui.piechart;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ryptographer.R;

public class PieChartFragment extends Fragment {

    private PieChartViewModel pieChartViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pieChartViewModel =
                new ViewModelProvider(this).get(PieChartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        pieChartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    static void drawPieChart(Bitmap bmp, int[] colors, int[] slices){
        //canvas to draw on it
         Canvas canvas = new Canvas(bmp);
         RectF box = new RectF(2, 2,bmp.getWidth()-2 , bmp.getHeight()-2);
        //get value for 100%
         int sum = 0;
         for (int slice : slices) {
         sum += slice;
         }
        // initalize painter
         Paint paint = new Paint();
         paint.setAntiAlias(true);
         paint.setStyle(Paint.Style.STROKE);
         paint.setStrokeWidth(1f);
         paint.setStyle(Paint.Style.FILL_AND_STROKE);
         float start = 0;
        // draw slices
         for(int i =0; i < slices.length; i++){
         paint.setColor(colors[i]); float angle;
         angle = ((360.0f / sum) * slices[i]);
         canvas.drawArc(box, start, angle, true, paint);
         start += angle; }
         }

}