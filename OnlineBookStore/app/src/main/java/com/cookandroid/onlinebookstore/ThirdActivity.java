package com.cookandroid.onlinebookstore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {
    Button logoBtn, loginBtn, settingBtn;
    View dialogView;
    ImageButton imgBtn;
    EditText id_str, password;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        info = (TextView) findViewById(R.id.myInfo);

        imgBtn = (ImageButton) findViewById(R.id.book8_img);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });

        logoBtn = (Button) findViewById(R.id.logo);
        logoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        loginBtn = (Button) findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogView = (View) View.inflate(ThirdActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(ThirdActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setView(dialogView);


                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        id_str = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        password = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                        final String id = id_str.getText().toString();

                        if (!id_str.getText().toString().equals("") && !password.getText().toString().equals("")) {
                            if (loginBtn.getText().toString().equals("로그인")) {
                                loginBtn.setText("로그아웃");
                                info.setText(id + "님의 화면입니다.");
                                Toast.makeText(ThirdActivity.this, id + "님 반갑습니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                loginBtn.setText("로그인");
                                info.setText("비회원 화면입니다.");
                                Toast.makeText(ThirdActivity.this, id + "님 감사합니다.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            AlertDialog.Builder dlg = new AlertDialog.Builder(ThirdActivity.this);
                            dlg.setTitle("공백 오류");
                            dlg.setMessage("공백이 존재합니다. 이름과 이메일을 모두 입력해주세요.");
                            dlg.setPositiveButton("확인", null);
                            dlg.show();
                        }
                    }
                });

                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

        settingBtn = (Button) findViewById(R.id.setting);

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] versionArray = new String[]{"brown", "pink", "green", "blue"};

                AlertDialog.Builder dlg = new AlertDialog.Builder(ThirdActivity.this);
                dlg.setTitle("테마 설정");
                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (versionArray[which] == "brown") {
                            logoBtn.setTextColor(Color.parseColor("#DBBC9D"));
                            dlg.setSingleChoiceItems(versionArray, which,null);
                        } else if (versionArray[which] == "pink") {
                            logoBtn.setTextColor(Color.parseColor("#E8BDBD"));
                            dlg.setSingleChoiceItems(versionArray, which,null);
                        } else if (versionArray[which] == "green") {
                            logoBtn.setTextColor(Color.parseColor("#DAEBAD"));
                            dlg.setSingleChoiceItems(versionArray, which,null);
                        } else if (versionArray[which] == "blue") {
                            logoBtn.setTextColor(Color.parseColor("#A4C8D6"));
                            dlg.setSingleChoiceItems(versionArray, which,null);
                        }
                    }
                });
                dlg.show();
            }
        });
    }


}
