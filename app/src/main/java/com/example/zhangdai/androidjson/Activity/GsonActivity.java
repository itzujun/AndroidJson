package com.example.zhangdai.androidjson.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhangdai.androidjson.R;
import com.example.zhangdai.androidjson.javaBean.ShopInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdai on 2017/2/17.
 * GSon解析界面
 *
 */

public class GsonActivity extends Activity implements View.OnClickListener {

    private Button btGsonTojavaobject;
    private Button btGsonTojavalist;
    private Button btGsonJavatojsonobject;
    private Button btGsonJavatojsonarray;
    private TextView tvGsonOrignal;
    private TextView tvGsonLast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        //初始化view
        findViews();
    }


    private void findViews() {
        btGsonTojavaobject = (Button) findViewById(R.id.bt_gson_tojavaobject);
        btGsonTojavalist = (Button) findViewById(R.id.bt_gson_tojavalist);
        btGsonJavatojsonobject = (Button) findViewById(R.id.bt_gson_javatojsonobject);
        btGsonJavatojsonarray = (Button) findViewById(R.id.bt_gson_javatojsonarray);
        // 获取展示数据的对象
        tvGsonOrignal = (TextView) findViewById(R.id.tv_gson_orignal);
        tvGsonLast = (TextView) findViewById(R.id.tv_gson_last);

        btGsonTojavaobject.setOnClickListener(this);
        btGsonTojavalist.setOnClickListener(this);
        btGsonJavatojsonobject.setOnClickListener(this);
        btGsonJavatojsonarray.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btGsonTojavaobject) {
            // （1）将json格式的字符串{}转换为Java对象
            jsonToJavaObjectByGson();
        } else if (v == btGsonTojavalist) {
            // （2）将json格式的字符串[]转换为Java对象的List
            jsonToJavaListByGson();
        } else if (v == btGsonJavatojsonobject) {
            // （3）将Java对象转换为json字符串{}
            javaToJsonObjectByGson();
        } else if (v == btGsonJavatojsonarray) {
            // （4）将Java对象的List转换为json字符串[]
            javaToJsonArrayByGson();
        }
    }

    // （4）将Java对象的List转换为json数组[]
    private void javaToJsonArrayByGson() {

        // 1 获取或创建Java对象
        List<ShopInfo> shops = new ArrayList<>();
        ShopInfo baoyu = new ShopInfo(1, "鲍鱼", 250.0, "baoyu");
        ShopInfo longxia = new ShopInfo(2, "龙虾", 251.0, "longxia");
        shops.add(baoyu);
        shops.add(longxia);
        // 2 生成JSON数据
        Gson gson = new Gson();
        String json = gson.toJson(shops);
        // 3 展示数据
        tvGsonOrignal.setText(shops.toString());
        tvGsonLast.setText(json);
    }

    // （3）将Java对象转换为json字符串{}
    private void javaToJsonObjectByGson() {
        // 1 获取或创建Java对象
        ShopInfo shopInfo = new ShopInfo(1, "鲍鱼", 250.0, "baoyu");

        // 2 生成JSON数据
        Gson gson = new Gson();

        String json = gson.toJson(shopInfo);
        // 3 展示数据
        tvGsonOrignal.setText(shopInfo.toString());
        tvGsonLast.setText(json);
    }

    // （2）将json格式的数组[]转换为Java对象的List
    private void jsonToJavaListByGson() {
        // 1 获取或创建JSON数据
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f1.jpg\",\n" +
                "        \"name\": \"大虾1\",\n" +
                "        \"price\": 12.3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f2.jpg\",\n" +
                "        \"name\": \"大虾2\",\n" +
                "        \"price\": 12.5\n" +
                "    }\n" +
                "]";

        // 2 解析JSON数据
        Gson gson = new Gson();
        List<ShopInfo> shops = gson.fromJson(json, new TypeToken<List<ShopInfo>>() {
        }.getType());
        // 3 展示数据
        tvGsonOrignal.setText(json);
        tvGsonLast.setText(shops.toString());

    }

    // (1）将json格式的对象转换为Java对象
    private void jsonToJavaObjectByGson() {
        // 1 获取或创建JSON数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";

        // 2 解析JSON数据
        Gson gson = new Gson();

        ShopInfo shopInfo = gson.fromJson(json, ShopInfo.class);
        // 3 展示数据
        tvGsonOrignal.setText(json);
        tvGsonLast.setText(shopInfo.toString());
    }


}
