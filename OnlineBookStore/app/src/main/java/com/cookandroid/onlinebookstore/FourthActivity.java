package com.cookandroid.onlinebookstore;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.widget.VideoView;

public class FourthActivity extends Activity {
    Button minusBtn, plusBtn, purchaseBtn, cancelBtn, vidBtn, reviewBtn;
    TextView countTv;
    int counts;
    int reviewcnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);

        minusBtn = (Button) findViewById(R.id.minus);
        countTv = (TextView) findViewById(R.id.count);
        plusBtn = (Button) findViewById(R.id.plus);
        purchaseBtn = (Button) findViewById(R.id.purchase);
        cancelBtn = (Button) findViewById(R.id.cancel);
        vidBtn = (Button) findViewById(R.id.video);
        reviewBtn = (Button) findViewById(R.id.review);

        vidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/jDDaeXOZc40"));
                startActivity(intent);
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counts = Integer.parseInt(countTv.getText().toString());
                if (counts <= 1) {
                    Toast.makeText(FourthActivity.this, "최소 수량은 1입니다.", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(FourthActivity.this, "최대 수량은 5입니다.", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder dlg = new AlertDialog.Builder(FourthActivity.this);
                dlg.setTitle("품절 알림");
                dlg.setMessage("품절인 상품입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(FourthActivity.this);
                dlg.setTitle("취소");
                dlg.setMessage("취소 버튼을 눌렀습니다.");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(FourthActivity.this, "홈 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FourthActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reviewcnt++;
                if (reviewcnt == 1) {
                    Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(FourthActivity.this, "이미 리뷰를 작성한 도서입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

