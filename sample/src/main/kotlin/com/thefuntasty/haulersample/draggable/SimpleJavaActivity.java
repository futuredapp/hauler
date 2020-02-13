package com.thefuntasty.haulersample.draggable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.thefuntasty.hauler.DragDirection;
import com.thefuntasty.hauler.HaulerView;
import com.thefuntasty.hauler.OnDragDismissedListener;
import com.thefuntasty.haulersample.R;

import org.jetbrains.annotations.NotNull;

public class SimpleJavaActivity extends Activity {

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SimpleJavaActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        HaulerView hv = findViewById(R.id.commonHaulerView);
        hv.setOnDragDismissedListener(new OnDragDismissedListener() {
            @Override
            public void onDismissed(@NotNull DragDirection dragDirection) {
                finish();
            }
        });
    }
}
