package com.star.topbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TopBar mTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopBar = (TopBar) findViewById(R.id.topBar);

        mTopBar.setOnTopbarClickListener(new TopBar.OnTopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_LONG).show();
            }
        });

        mTopBar.setButtonVisiable(TopBar.TopBarButton.LEFT_BUTTON, true);
        mTopBar.setButtonVisiable(TopBar.TopBarButton.RIGHT_BUTTON, true);
    }

}
