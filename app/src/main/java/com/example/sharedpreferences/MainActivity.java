package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editText_name,editText_password;
    Button button;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controler();
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        editText_name.setText(sharedPreferences.getString("taikhoan",""));
        editText_password.setText(sharedPreferences.getString("matkhau",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked",false));





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editText_name.getText().toString().trim();
                String password = editText_password.getText().toString().trim();

                if (username.equals("tuong") && password.equals("1234")){
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    ///neu co check
                    if (checkBox.isChecked()){
                        SharedPreferences.Editor editor  = sharedPreferences.edit();
                        editor.putString("taikhoan", username);
                        editor.putString("matkhau",password);
                        editor.putBoolean("checkbook",true);
                        editor.commit();

                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checkbook");
                        editor.commit();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Loi dang nhap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void controler() {
        editText_name = findViewById(R.id.editText_name);
        editText_password = findViewById(R.id.editText_password);
        button = findViewById(R.id.button);
        checkBox = findViewById(R.id.checkBox);
    }



}
