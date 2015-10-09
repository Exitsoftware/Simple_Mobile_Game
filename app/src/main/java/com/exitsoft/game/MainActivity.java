package com.exitsoft.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
//    ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);
//        btn1.setImageResource(R.drawable.char02);



//        MainView
//        setContentView(new drawView(this));
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
                btn1.setImageResource(R.drawable.char02);
//                toast.show();
            }
            else{
//                Toast toast = Toast.makeText(this, "오른쪽 입력.", Toast.LENGTH_SHORT);
                btn1.setImageResource(R.drawable.char03);
//                toast.show();
            }


        }

        return super.onTouchEvent(event);
    }

//
//    private class drawView extends View {
//        Paint mPaint;
//        Bitmap char01, char02, char03, char04;
//        drawView(Context context){
//            super(context);
//            char01 = BitmapFactory.decodeResource(getResources(),R.drawable.char01);
//            char02 = BitmapFactory.decodeResource(getResources(),R.drawable.char02);
//            char03 = BitmapFactory.decodeResource(getResources(),R.drawable.char03);
//            char04 = BitmapFactory.decodeResource(getResources(),R.drawable.char04);
//            mPaint = new Paint();
//        }
//
//        protected void onDraw(Canvas canvas){
//            canvas.drawCircle(100,100,90,mPaint);
//            canvas.drawBitmap(char01,100,100,null);
//        }
//    }
//    WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//    2
//    Display display = wm.getDefaultDisplay();
//    3
//            Log.d("display", "w:" + display.getWidth());
//    4
//            Log.d("display", "h:" + display.getHeight())
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
}
