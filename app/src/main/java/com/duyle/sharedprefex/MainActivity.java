package com.duyle.sharedprefex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPass;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getPreferences(MODE_PRIVATE);

        edtUsername = findViewById(R.id.edt_username);
        edtPass = findViewById(R.id.edt_password);

        String userNameOld = pref.getString(KEY_USERNAME, "");
        String passOld = pref.getString(KEY_PASSWORD, "");

        edtUsername.setText(userNameOld);
        edtPass.setText(passOld);


        CheckBox chkRemember = findViewById(R.id.chk_remember);

        Button btnDangnhap = findViewById(R.id.chk_remember);



        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkRemember.isChecked()) {
                    luuDulieuDangNhap ();

                }
            }
        });
    }

    private void luuDulieuDangNhap () {
        String username = edtUsername.getText().toString();
        String password = edtPass.getText().toString();

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);

        editor.apply();
    }

    String KEY_USERNAME = "username";
    String KEY_PASSWORD = "password";
}