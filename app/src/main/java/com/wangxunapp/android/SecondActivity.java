package com.wangxunapp.android;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.view.menu.BaseMenuPresenter;

public class SecondActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        editText = (EditText) findViewById(R.id.edit_text);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton_1);
<<<<<<< HEAD
=======
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio1 = (RadioButton) findViewById(R.id.radio_1);
                Toast.makeText(getApplicationContext(), "你选了:" + radio1.getText(), Toast.LENGTH_SHORT).show();
                RadioButton radio2 = (RadioButton) findViewById(R.id.radio_2);
                Toast.makeText(getApplicationContext(), "你选了:" + radio2.getText(), Toast.LENGTH_SHORT).show();
            }
        });
>>>>>>> dev
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity", data);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_3:
                        String inputText = editText.getText().toString();
                        Toast.makeText(SecondActivity.this, inputText, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                Toast.makeText(SecondActivity.this, "拨打电话：10086", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
<<<<<<< HEAD
                    Toast.makeText(SecondActivity.this, "按钮打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, "按钮关闭", Toast.LENGTH_SHORT).show();
=======
                    Toast.makeText(SecondActivity.this, "按钮" + toggle.getTextOn(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, "按钮" + toggle.getTextOff(), Toast.LENGTH_SHORT).show();
>>>>>>> dev
                }
            }
        });
    }
}