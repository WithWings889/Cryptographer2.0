package com.example.ryptographer.ui.crypto;

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

public class CryptoFragment extends Fragment {

    private CryptoViewModel cryptoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cryptoViewModel =
                new ViewModelProvider(this).get(CryptoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crypto, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        cryptoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}