package com.hly.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/8/15~~~~~~
 * ~~~~~~更改时间:2018/8/15~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class SecondActivity extends AppCompatActivity {
    private Button bt_message, bt1;
    private TextView tv_message;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);

        tv_message = findViewById(R.id.content);
        tv_message.setText("SecondActivity");
        bt_message = findViewById(R.id.btn);
        bt_message.setText("发送事件");
        bt1 = findViewById(R.id.btn1);
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("返回过来的数据"));
                finish();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new MessageEvent("粘性事件"));
                finish();
            }
        });
    }
}
