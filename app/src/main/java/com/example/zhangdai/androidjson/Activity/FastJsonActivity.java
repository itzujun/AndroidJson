package com.example.zhangdai.androidjson.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.zhangdai.androidjson.R;
import com.example.zhangdai.androidjson.javaBean.ShopInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdai on 2017/2/17.
 * FastJson解析
 */
public class FastJsonActivity extends Activity implements View.OnClickListener {
    private Button btFastjsonTojavaobject;
    private Button btFastjsonTojavalist;
    private Button btFastjsonJavatojsonobject;
    private Button btFastjsonJavatojsonarray;
    private TextView tvFastjsonOrignal;
    private TextView tvFastjsonLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastjson);
        //初始化view
        findViews();
    }


    private void findViews() {
        btFastjsonTojavaobject = (Button) findViewById(R.id.bt_fastjson_tojavaobject);
        btFastjsonTojavalist = (Button) findViewById(R.id.bt_fastjson_tojavalist);
        btFastjsonJavatojsonobject = (Button) findViewById(R.id.bt_fastjson_javatojsonobject);
        btFastjsonJavatojsonarray = (Button) findViewById(R.id.bt_fastjson_javatojsonarray);
        // 获取展示数据的对象
        tvFastjsonOrignal = (TextView) findViewById(R.id.tv_fastjson_orignal);
        tvFastjsonLast = (TextView) findViewById(R.id.tv_fastjson_last);

        btFastjsonTojavaobject.setOnClickListener(this);
        btFastjsonTojavalist.setOnClickListener(this);
        btFastjsonJavatojsonobject.setOnClickListener(this);
        btFastjsonJavatojsonarray.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btFastjsonTojavaobject) {
            // （1）将json格式的字符串{}转换为Java对象
            jsonToJavaObjectByFastJson();
        } else if (v == btFastjsonTojavalist) {
            // （2）将json格式的字符串[]转换为Java对象的List
            jsonToJavaListByFastJson();
        } else if (v == btFastjsonJavatojsonobject) {
            // （3）将Java对象转换为json字符串{}
            javaToJsonObjectByFastJson();
        } else if (v == btFastjsonJavatojsonarray) {
            // （4）将Java对象的List转换为json字符串[]
            javaToJsonArrayByFastJson();
        }
    }


    // （4）将Java对象的List转换为json字符串[]
    private void javaToJsonArrayByFastJson() {
        // 1 创建一个Java集合
        List<ShopInfo> shops = new ArrayList<>();

        ShopInfo baoyu = new ShopInfo(1, "鲍鱼", 250.0, "baoyu");
        ShopInfo longxia = new ShopInfo(2, "龙虾", 251.0, "longxia");

        shops.add(baoyu);
        shops.add(longxia);

        // 2 生成JSON数据
        String json = JSON.toJSONString(shops);

        // 3 显示JSON数据
        tvFastjsonOrignal.setText(shops.toString());
        tvFastjsonLast.setText(json);
    }

    // （3）将Java对象转换为json字符串{}
    private void javaToJsonObjectByFastJson() {
        // 1 创建一个Java对象
        ShopInfo shopInfo = new ShopInfo(1, "鲍鱼", 250.0, "baoyu");

        // 2 生成JSON数据
        String json=JSON.toJSONString(shopInfo);

        // 3 显示数据
        tvFastjsonOrignal.setText(shopInfo.toString());
        tvFastjsonLast.setText(json);
    }

    // （2）将json格式的字符串[]转换为Java对象的List
    private void jsonToJavaListByFastJson() {

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
        List<ShopInfo> shops=JSON.parseArray(json,ShopInfo.class);
        // 3 显示数据
        tvFastjsonOrignal.setText(json);
        tvFastjsonLast.setText(shops.toString());

    }


    // （1）将json格式的字符串{}转换为Java对象
    private void jsonToJavaObjectByFastJson() {
        // 1 获取或创建json数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";

        // 2 解析JSON数据
        ShopInfo shopInfo = JSON.parseObject(json, ShopInfo.class);
        // 3 显示数据
        tvFastjsonOrignal.setText(json);
        tvFastjsonLast.setText(shopInfo.toString());
    }


}