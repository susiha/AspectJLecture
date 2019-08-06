package com.susiha.aspectjlecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.susiha.aspectjlecture.bean.FirstBean;

public class SecondaryActivity extends Activity {


    public static void startActivity(Activity activity){
        Intent intent = new Intent(activity,SecondaryActivity.class);
        activity.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        showBean();

    }

    private void showBean(){

        FirstBean bean = new FirstBean(20);

        Log.i("SecondaryActivity",bean.getmFlag()+"");
    }

}
