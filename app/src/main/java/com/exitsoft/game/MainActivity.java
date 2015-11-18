package com.exitsoft.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
//    ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);
    ArrayList<Integer> queue = new ArrayList<Integer>();
    ArrayList<ImageButton> btnList = new ArrayList<ImageButton>();

    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    ImageButton btn5;

    int score = 0;
    int combo = 0;
    int highScore;
    TextView scoreView;
    TextView comboView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!getHighScore().equals("NULL")) highScore = Integer.parseInt(getHighScore());

        scoreView = (TextView) findViewById(R.id.scoreView);
        comboView = (TextView) findViewById(R.id.comboView);

        btn1 = (ImageButton) findViewById(R.id.imageButton);
        btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn4 = (ImageButton) findViewById(R.id.imageButton4);
        btn5 = (ImageButton) findViewById(R.id.imageButton5);

        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);
        btnList.add(btn5);



        for(int i = 0; i < 5; i++){
            if((int)(Math.random() * 20) == 1) queue.add(4);
            else {
                int rndInt = (int) (Math.random() * 4);
                queue.add(rndInt);
            }
        }

        refreshImage();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        int action = event.getAction();


        if(action == MotionEvent.ACTION_DOWN){



            if(event.getX() < width/2){

//                Toast toast = Toast.makeText(this, "왼쪽쪽 입력.", Toast.LENGTH_SHORT);
//                toast.show();

                // item
                if(queue.get(0) == 4){
                    int tmp = (int) (Math.random()*4);
                    for(int i = 0; i < 5; i++) queue.set(i, tmp);
                }
                // bomb
                else if(queue.get(0) == 5){

                }
                else if(queue.get(0)%2 == 0){
                    score += 100;
                    combo++;
                }
                else{
                    if(highScore < score) saveHighScore();
                    highScore = Integer.parseInt(getHighScore());
                    score = 0;
                    combo = 0;
                }


            }
            else{
                // item
                if(queue.get(0) == 4){
                    int tmp = (int) (Math.random()*4);
                    for(int i = 0; i < 5; i++) queue.set(i, tmp);
                }
                // bomb
                else if(queue.get(0) == 5){

                }
                else if(queue.get(0)%2 == 1){
                    score += 100;
                    combo++;
                }
                else{
                    if(highScore < score) saveHighScore();
                    highScore = Integer.parseInt(getHighScore());
                    score = 0;
                    combo = 0;
                }

            }

            queue.remove(0);
            if((int)(Math.random() * 20) == 1) queue.add(4);
            else {
                int rndInt = (int) (Math.random() * 4);
                queue.add(rndInt);
            }
            refreshImage();



        }

        return super.onTouchEvent(event);
    }

    public void refreshImage(){
        for(int i = 0; i < btnList.size(); i++){
            int rndInt = queue.get(i);
            ImageButton curBtn = btnList.get(i);
            switch (rndInt){
                case 0:
                    curBtn.setImageResource(R.drawable.char01);
                    break;
                case 1:
                    curBtn.setImageResource(R.drawable.char02);
                    break;
                case 2:
                    curBtn.setImageResource(R.drawable.char03);
                    break;
                case 3:
                    curBtn.setImageResource(R.drawable.char04);
                    break;
                case 4:
                    curBtn.setImageResource(R.drawable.item);
                    break;
                case 5:
                    curBtn.setImageResource(R.drawable.bomb);
                    break;
            }
        }
        if(combo == 0) comboView.setVisibility(View.INVISIBLE);
        else {
            comboView.setVisibility(View.VISIBLE);
            comboView.setText(combo + " Combo!");
        }
        scoreView.setText("Your Score\n"+ score +"점\n"+"High Score\n" + highScore + "점");

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

    private void saveHighScore(){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("highScore", String.valueOf(score));
        editor.commit();
    }

    private String getHighScore(){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        return pref.getString("highScore", "NULL").toString();
    }
}
