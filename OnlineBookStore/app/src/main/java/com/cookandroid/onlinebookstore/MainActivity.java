package com.cookandroid.onlinebookstore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    Button logoBtn, titleBtn;
    ImageButton imgBtn, categoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleBtn = (Button) findViewById(R.id.book1_title);
        imgBtn = (ImageButton) findViewById(R.id.book1_img);
        logoBtn = (Button) findViewById(R.id.logo);
        categoryBtn = (ImageButton) findViewById(R.id.category);

        logoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        categoryBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String[] versionArray = new String[]{"home", "myPage", "setting"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("category");
                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (versionArray[which] == "home") {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else if (versionArray[which] == "myPage") {
                            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                            startActivity(intent);
                        } else if (versionArray[which] == "setting") {
                            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                            startActivity(intent);
                        }
                    }
                });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });

        titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
