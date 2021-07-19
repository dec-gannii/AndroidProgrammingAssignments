package com.cookandroid.onlinebookstore;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class SecondActivity extends Activity {
    Button minusBtn, plusBtn, purchaseBtn, cancelBtn, reviewBtn;
    TextView countTv;
    int counts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        minusBtn = (Button) findViewById(R.id.minus);
        countTv = (TextView) findViewById(R.id.count);
        plusBtn = (Button) findViewById(R.id.plus);
        purchaseBtn = (Button) findViewById(R.id.purchase);
        cancelBtn = (Button) findViewById(R.id.cancel);
        reviewBtn = (Button) findViewById(R.id.review);

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 counts = Integer.parseInt(countTv.getText().toString());
                if (counts <= 1) {
                    Toast.makeText(SecondActivity.this, "최소 수량은 1입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    counts--;
                    String sum = String.valueOf(counts);
                    countTv.setText(sum);
                }
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counts = Integer.parseInt(countTv.getText().toString());
                if (counts >= 5) {
                    Toast.makeText(SecondActivity.this, "최대 수량은 5입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    counts++;
                    String sum = String.valueOf(counts);
                    countTv.setText(sum);
                }
            }
        });

        purchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SecondActivity.this);
                dlg.setTitle("품절 알림");
                dlg.setMessage("품절인 상품입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SecondActivity.this);
                dlg.setTitle("취소");
                dlg.setMessage("취소 버튼을 눌렀습니다.");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this, "홈 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        reviewBtn.setClickable(false);
    }
}

