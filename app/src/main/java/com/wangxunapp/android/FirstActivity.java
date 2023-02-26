package com.wangxunapp.android;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "你点击了Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你点击了Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.加载活动二_item:
                Toast.makeText(this, "已加载活动二", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                String data = "Hello SecondActivity";
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1);
                break;
            case R.id.退出_item:
                Toast.makeText(this, "已退出", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                Toast.makeText(FirstActivity.this, "已进入活动二", Toast.LENGTH_SHORT).show();
                String data = "Hello SecondActivity";
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                Toast.makeText(FirstActivity.this, "打开百度", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}