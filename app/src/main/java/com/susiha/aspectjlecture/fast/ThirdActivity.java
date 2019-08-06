package com.susiha.aspectjlecture.fast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.susiha.aspectjlecture.R;

public class ThirdActivity extends Activity {

    public static void startActivity(Activity activity){
        Intent intent = new Intent(activity,ThirdActivity.class);
        activity.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
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
