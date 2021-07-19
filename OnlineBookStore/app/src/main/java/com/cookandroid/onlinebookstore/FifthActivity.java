package com.cookandroid.onlinebookstore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FifthActivity extends Activity {
    Button submitBtn;
    EditText edtTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        submitBtn = (Button) findViewById(R.id.submit);
        edtTxt = (EditText) findViewById(R.id.linereview);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtTxt.getText().toString().equals("")) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(FifthActivity.this);
                    dlg.setTitle("제출 완료");
                    dlg.setMessage("리뷰를 작성해주셔서 감사합니다.");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    dlg.show();
                } else {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(FifthActivity.this);
                    dlg.setTitle("공란 제출");
                    dlg.setMessage("한줄평이 작성되지 않았습니다. 한줄평을 입력해주세요.");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
            }
        });

    }
}