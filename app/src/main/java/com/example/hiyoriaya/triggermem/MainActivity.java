package com.example.hiyoriaya.triggermem;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnTouchListener{
    private ImageView cri;
    private TextView cric;
    private ImageView heal;
    private TextView healc;
    private  ImageView sta;
    private TextView stac;
    private  ImageView draw;
    private  TextView drawc;
    private  ImageView kan;
    private TextView kanc;
    private  ImageView all;
    private TextView allc;
    int[] con;
    // X軸最低スワイプ距離
    private static final int SWIPE_MIN_DISTANCE = 100;
    // X軸最低スワイプスピード
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    // Y軸の移動距離　これ以上なら横移動を判定しない
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private GestureDetector mGestureDetector;
    private int touchid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGestureDetector = new GestureDetector(this, mOnGestureListener);
        cri = (ImageView)findViewById(R.id.cri);
        cric= (TextView)findViewById(R.id.cric);
        cri.setOnTouchListener(this);
        cric.setOnTouchListener(this);
        sta = (ImageView)findViewById(R.id.stand);
        stac= (TextView)findViewById(R.id.stac);
        sta.setOnTouchListener(this);
        stac.setOnTouchListener(this);
        heal = (ImageView)findViewById(R.id.heal);
        healc= (TextView)findViewById(R.id.healc);
        healc.setOnTouchListener(this);
        heal.setOnTouchListener(this);
        draw = (ImageView)findViewById(R.id.draw);
        drawc= (TextView)findViewById(R.id.drawc);
        drawc.setOnTouchListener(this);
        draw.setOnTouchListener(this);
        kan = (ImageView)findViewById(R.id.kanga);
        kanc= (TextView)findViewById(R.id.kanc);
        kanc.setOnTouchListener(this);
        kan.setOnTouchListener(this);
        all = (ImageView)findViewById(R.id.all);
        allc= (TextView)findViewById(R.id.allc);
        allc.setOnTouchListener(this);
        all.setOnTouchListener(this);
        con = new int[6];
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        touchid = v.getId();
        return mGestureDetector.onTouchEvent(e);
    }

    private final GestureDetector.SimpleOnGestureListener mOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapUp(MotionEvent e){
            switch(touchid){
                case R.id.cri:
                    if(con[0]<16){
                        con[0]++;
                    }else{
                        con[0]=0;
                    }
                    cric.setText(String.valueOf(con[0]));
                    break;
                case R.id.stand:
                    if(con[1]<16){
                        con[1]++;
                    }else{
                        con[1]=0;
                    }
                    stac.setText(String.valueOf(con[1]));
                    break;
                case R.id.heal:
                    if(con[2]<4){
                        con[2]++;
                    }else{
                        con[2]=0;
                    }
                    healc.setText(String.valueOf(con[2]));
                    break;
                case R.id.draw:
                    if(con[3]<16){
                        con[3]++;
                    }else{
                        con[3]=0;
                    }
                    drawc.setText(String.valueOf(con[3]));
                    break;
                case R.id.kanga:
                    if(con[4]<4){
                        con[4]++;
                    }else{
                        con[4]=0;
                    }
                    kanc.setText(String.valueOf(con[4]));
                    break;
                case R.id.all:
                    if(con[5]<16){
                        con[5]++;
                    }else{
                        con[5]=0;
                    }
                    allc.setText(String.valueOf(con[5]));
                    break;
            }
            return false;
        }
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            try {
                // 移動距離・スピードを出力
                float distance_x = Math.abs((event1.getX() - event2.getX()));
                float velocity_x = Math.abs(velocityX);

                switch(touchid){
                    case R.id.cri:
                        // Y軸の移動距離が大きすぎる場合
                        if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                            con[0]=0;
                            cric.setText(String.valueOf(con[0]));
                            break;
                        }
                        // 開始位置から終了位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[0]=0;
                            cric.setText(String.valueOf(con[0]));
                            break;

                        }
                        // 終了位置から開始位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[0]=0;
                            cric.setText(String.valueOf(con[0]));
                            break;
                        }
                    case R.id.stand:
                        // Y軸の移動距離が大きすぎる場合
                        if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                            con[1]=0;
                            stac.setText(String.valueOf(con[1]));
                            break;
                        }
                        // 開始位置から終了位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[1]=0;
                            stac.setText(String.valueOf(con[1]));
                            break;

                        }
                        // 終了位置から開始位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[1]=0;
                            stac.setText(String.valueOf(con[1]));
                            break;
                        }
                    case R.id.heal:
                        // Y軸の移動距離が大きすぎる場合
                        if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                            con[2]=0;
                            healc.setText(String.valueOf(con[2]));
                            break;
                        }
                        // 開始位置から終了位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[2]=0;
                            healc.setText(String.valueOf(con[2]));
                            break;

                        }
                        // 終了位置から開始位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[2]=0;
                            healc.setText(String.valueOf(con[2]));
                            break;
                        }
                    case R.id.draw:
                        // Y軸の移動距離が大きすぎる場合
                        if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                            con[3]=0;
                            drawc.setText(String.valueOf(con[3]));
                            break;
                        }
                        // 開始位置から終了位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[3]=0;
                            drawc.setText(String.valueOf(con[3]));
                            break;

                        }
                        // 終了位置から開始位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[3]=0;
                            drawc.setText(String.valueOf(con[3]));
                            break;
                        }
                    case R.id.kanga:
                        // Y軸の移動距離が大きすぎる場合
                        if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                            con[4]=0;
                            kanc.setText(String.valueOf(con[4]));
                            break;
                        }
                        // 開始位置から終了位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[4]=0;
                            kanc.setText(String.valueOf(con[4]));
                            break;

                        }
                        // 終了位置から開始位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[4]=0;
                            kanc.setText(String.valueOf(con[4]));
                            break;
                        }
                    case R.id.all:
                        // Y軸の移動距離が大きすぎる場合
                        if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                            con[5]=0;
                            allc.setText(String.valueOf(con[5]));
                            break;
                        }
                        // 開始位置から終了位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[5]=0;
                            allc.setText(String.valueOf(con[5]));
                            break;

                        }
                        // 終了位置から開始位置の移動距離が指定値より大きい
                        // X軸の移動速度が指定値より大きい
                        else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            con[5]=0;
                            allc.setText(String.valueOf(con[5]));
                            break;
                        }
                }

            } catch (Exception e) {
                // TODO
            }

            return false;
        }
    };
}
