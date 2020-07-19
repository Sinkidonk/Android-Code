package com.parys.alex.movingtouch;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener{

    private TextView textView;
    private int startTouchX;
    private int startTouchY;
    private RelativeLayout.LayoutParams params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moving_touch);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setOnTouchListener(this);

        params = new RelativeLayout.LayoutParams( 300, 200 );
        params.leftMargin = (int) getResources().getDimension(R.dimen.left_margin);
        params.topMargin = (int) getResources().getDimension(R.dimen.top_margin);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int startX = 0;
        int startY = 0;

        switch( action ) {
            case MotionEvent.ACTION_DOWN:
                startX = params.leftMargin;
                startY = params.topMargin;
                startTouchX = ( int ) motionEvent.getX( );
                startTouchY = ( int ) motionEvent.getY( );
                break;
            case MotionEvent.ACTION_MOVE:
                params.leftMargin = startX + ( int ) motionEvent.getX( ) - startTouchX;
                params.topMargin = startY + ( int ) motionEvent.getY( ) - startTouchY;
                textView.setLayoutParams( params );
                break;
        }

        return true;
    }
}
