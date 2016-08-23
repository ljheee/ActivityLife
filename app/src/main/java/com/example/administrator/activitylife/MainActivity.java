package com.example.administrator.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";
    private static final String EXTRA_INT = "N" ;
    private static final String EXTRA_INFO = "info";

    int num = 1;
    String info = "init";


    EditText editText;
    SeekBar seekBar;
    TextView textViewText;
    TextView textViewNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate");
        if(savedInstanceState == null){
            //正常启动
        }

        if(savedInstanceState!=null){
            Log.d(TAG,"销毁重建");
            num = savedInstanceState.getInt(EXTRA_INT);
            info = savedInstanceState.getString(EXTRA_INFO);
            textViewText.setText(info);
            textViewNumber.setText(String.valueOf(num));
        }

        editText = (EditText) findViewById(R.id.editText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textViewNumber = (TextView) findViewById(R.id.textView_showN);
        textViewText = (TextView) findViewById(R.id.textView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                num = progress;
                textViewNumber.setText(String.valueOf(num));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     *
     * @param outState  离开时的状态
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");

        outState.putInt(EXTRA_INT, 9);
        outState.putString(EXTRA_INFO, info);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "onRestoreInstanceState");
    }


    /**
     * 点击button执行
     * @param view
     */
    public void doSave(View view) {
        info = editText.getText().toString();

        if(!info.equals("")){
            textViewText.setText(info);
        }
    }

    public void doJump(View view) {
        //跳转活动
        startActivity(new Intent(this,NextActivity.class));
    }


    public void doStart(View view) {
        startService(new Intent(this,MyService.class));
    }

    public void onStop(View view) {
        stopService(new Intent(this,MyService.class));
    }
}
