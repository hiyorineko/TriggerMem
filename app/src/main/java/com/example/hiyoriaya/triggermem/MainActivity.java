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

public class MainActivity extends Activity implements View.OnTouchListener,GestureDetector.OnGestureListener{
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
    int lastTouchX;
    int lastTouchY;
    int currentX;
    int currentY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public boolean onTouch(View v, MotionEvent e) {

        switch(e.getAction()){
            case MotionEvent.ACTION_UP:
                switch (v.getId()){
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

                    case R.id.cric:
                            con[0]=0;
                        cric.setText(String.valueOf(con[0]));
                        break;
                    case R.id.stac:
                        con[1]=0;
                        stac.setText(String.valueOf(con[1]));
                        break;
                    case R.id.healc:
                        con[2]=0;
                        healc.setText(String.valueOf(con[2]));
                        break;
                    case R.id.drawc:
                        con[3]=0;
                        drawc.setText(String.valueOf(con[3]));
                        break;
                    case R.id.kanc:
                        con[4]=0;
                        kanc.setText(String.valueOf(con[4]));
                        break;
                    case R.id.allc:
                        con[5]=0;
                        allc.setText(String.valueOf(con[5]));
                        break;
                }
                break;
        }



        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
