package com.susiha.aspectjlecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.susiha.aspectjlecture.bean.FirstBean;
import com.susiha.aspectjlecture.fast.ThirdActivity;

public class SecondaryActivity extends Activity {


    public static void startActivity(Activity activity){
        Intent intent = new Intent(activity,SecondaryActivity.class);
        activity.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        findViewById(R.id.secondary_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdActivity.startActivity(SecondaryActivity.this);
            }
        });
        getmFlag();

    }

    private void getmFlag(){
        FirstBean bean = new FirstBean(20);
        bean.getmFlag();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
}
