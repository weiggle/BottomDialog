package com.weiggle.github.bottomdialog.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.weiggle.github.bottomdialog.R;
import com.weiggle.github.bottomdialog.widget.ShareDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareDialog dialog = new ShareDialog(MainActivity.this);
                dialog.show();
            }
        });

    }
}
