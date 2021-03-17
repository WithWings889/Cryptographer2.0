package com.example.ryptographer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private Spinner spinner;
    private EditText editText, textLeft, textRight;

    private TextView showText;
    private Intent myFileIntent;
    private RadioButton radioButtonCeasar, radioButtonWordCode;

    private ClipboardManager clipboardManager;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

//        spinner = (Spinner) findViewById(R.id.spinner);
//        editText = (EditText) findViewById(R.id.editTextTextMultiLine);
//        textLeft = (EditText) findViewById(R.id.editText_left);
//        textRight = (EditText) findViewById(R.id.editTextText_right);
//        showText = (TextView) findViewById(R.id.textView);
//        ImageButton btnFilePicker = (ImageButton) findViewById(R.id.button_filepicker);
//        ImageButton btnCopy = (ImageButton) findViewById(R.id.button_copy);
//        ImageButton btnSave = (ImageButton) findViewById(R.id.button_save);
//        Button btnCode = (Button) findViewById(R.id.button_code);
//        Button btnDecode = (Button) findViewById(R.id.button_decode);
//        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
//        myFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
//
//        radioButtonCeasar = (RadioButton) findViewById(R.id.radioButton_ceasar);
//        radioButtonWordCode = (RadioButton) findViewById(R.id.radioButton_wordcode);
//        radioButtonCeasar.setChecked(true);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.codes_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        textLeft.setHint(R.string.hint_key_ceaser);
//        textLeft.setInputType(InputType.TYPE_CLASS_NUMBER);
//        textRight.setVisibility(View.INVISIBLE);

//        final Intent chooserIntent = new Intent(this, DirectoryChooserActivity.class);
//
//        final DirectoryChooserConfig config = DirectoryChooserConfig.builder()
//                .newDirectoryName("DirChooserSample")
//                .allowReadOnlyDirectory(true)
//                .allowNewDirectoryNameModification(true)
//                .build();
//
//        chooserIntent.putExtra(DirectoryChooserActivity.EXTRA_CONFIG, config);
//
//// REQUEST_DIRECTORY is a constant integer to identify the request, e.g. 0
//        startActivityForResult(chooserIntent, REQUEST_DIRECTORY);

//        btnFilePicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myFileIntent.setType("*/txt");
//                startActivityForResult(myFileIntent, 10);
//            }
//        });
//
//
//        btnCopy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = showText.getText().toString();
//                clipData = ClipData.newPlainText("text",text);
//                clipboardManager.setPrimaryClip(clipData);
//
//                Toast.makeText(getApplicationContext(),R.string.toast_text_is_copied,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case -1:
//
//                        break;
//                    case R.id.radioButton_ceasar:
//                        textRight.setVisibility(View.INVISIBLE);
//                        textLeft.setHint(R.string.hint_key_ceaser);
//                        textLeft.setInputType(InputType.TYPE_CLASS_NUMBER);
//                        break;
//                    case R.id.radioButton_wordcode:
////                        textRight.setVisibility(View.VISIBLE);
////                        textRight.setHint(R.string.hint_key_wordcode_right);
////                        textLeft.setHint(R.string.hint_key_wordcode_left);
////                        textLeft.setInputType(InputType.TYPE_CLASS_TEXT);
////                        textRight.setInputType(InputType.TYPE_CLASS_TEXT);
//                        textLeft.setHint(R.string.hint_key_wordcode_left);
//                        textLeft.setInputType(InputType.TYPE_CLASS_TEXT);
//                        break;
//                }
//            }
//        });

//        btnCode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String codedText = "";
//
//                String text = editText.getText().toString();
//                String selectedLanguage = spinner.getSelectedItem().toString();
//                if(radioButtonCeasar.isChecked()) {
//                    String key = textLeft.getText().toString();
//                    codedText = Cryptographer.caesarСipher(text, selectedLanguage, Integer.parseInt(key));
//                }
//                else
//                if (radioButtonWordCode.isChecked()) {
////                    String keyRow = textLeft.getText().toString();
////                    String keyCol = textRight.getText().toString();
//                    String key = textLeft.getText().toString();
//                    codedText = Cryptographer.wordCode(text, selectedLanguage, key);
////                    String key = textLeft.getText().toString();
////                    codedText = Cryptographer.wordCode()
//                }
//                showText.setText(codedText);
//            }
//        });
//
//        btnDecode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String decodedText = "";
//                String text = editText.getText().toString();
//                String selectedLanguage = spinner.getSelectedItem().toString();
//                if(radioButtonCeasar.isChecked()) {
//                    String key = textLeft.getText().toString();
//                    decodedText = Cryptographer.caesarCipherDecode(text, selectedLanguage, Integer.parseInt(key));
//                }
//                else
//                if (radioButtonWordCode.isChecked()) {
////                    String keyRow = textLeft.getText().toString();
////                    String keyCol = textRight.getText().toString();
//                    String key = textLeft.getText().toString();
//                    decodedText = Cryptographer.wordCodeDecode(text, selectedLanguage, key);
//                }
//                showText.setText(decodedText);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}