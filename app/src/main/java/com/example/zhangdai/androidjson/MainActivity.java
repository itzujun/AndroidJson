package com.example.zhangdai.androidjson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhangdai.androidjson.Activity.FastJsonActivity;
import com.example.zhangdai.androidjson.Activity.GsonActivity;
import com.example.zhangdai.androidjson.Activity.NativeJsonPraseActivity;
import com.example.zhangdai.androidjson.Activity.OkhttpJsonActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button json;
    private Button GSON;
    private Button FastJson;
    private Button NetWoekJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();//初始化控件
    }


    private void findViews() {
        json = (Button)findViewById( R.id.json );
        GSON = (Button)findViewById( R.id.GSON );
        FastJson = (Button)findViewById( R.id.FastJson );
        NetWoekJson = (Button)findViewById( R.id.NetWoekJson );

        json.setOnClickListener( this );
        GSON.setOnClickListener( this );
        FastJson.setOnClickListener( this );
        NetWoekJson.setOnClickListener( this );
    }

    /**
     * 按钮监听处理
     */
    @Override
    public void onClick(View v) {
        if ( v == json ) {
            // 测解析json
            Intent jsonintent=new Intent(MainActivity.this,NativeJsonPraseActivity.class);
            startActivity(jsonintent);
        } else if ( v == GSON ) {
            // 测试解析Gson
            Intent jsonintent=new Intent(MainActivity.this,GsonActivity.class);
            startActivity(jsonintent);
        } else if ( v == FastJson ) {
            // 测试解析FastJson
            Intent jsonintent=new Intent(MainActivity.this,FastJsonActivity.class);
            startActivity(jsonintent);
        } else if ( v == NetWoekJson ) {
            // 测试解析网络Json
            Intent okhttpjson=new Intent(MainActivity.this,OkhttpJsonActivity.class);
            startActivity(okhttpjson);
        }
    }

}
