package app.futured.haulersample.draggable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.Nullable;
import app.futured.hauler.DragDirection;
import app.futured.hauler.HaulerView;
import app.futured.hauler.OnDragDismissedListener;
import app.futured.haulersample.R;

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
