package com.exitsoft.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MainView
        setContentView(new drawView(this));
    }

    private class drawView extends View {
        Paint mPaint;
        Bitmap char01, char02, char03, char04;
        drawView(Context context){
            super(context);
            char01 = BitmapFactory.decodeResource(getResources(),R.drawable.char01);
            char02 = BitmapFactory.decodeResource(getResources(),R.drawable.char02);
            char03 = BitmapFactory.decodeResource(getResources(),R.drawable.char03);
            char04 = BitmapFactory.decodeResource(getResources(),R.drawable.char04);
            mPaint = new Paint();
        }

        protected void onDraw(Canvas canvas){
            canvas.drawCircle(100,100,90,mPaint);
            canvas.drawBitmap(char01,100,100,null);
        }
    }
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
