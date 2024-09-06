package kr.pointpub.sample;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import kr.pointpub.sdk.feature.config.PointPub;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.et_uid);
                String uid = editText.getText().toString();
                if (!TextUtils.isEmpty(uid)) {
                    PointPub.INSTANCE.startOfferWall(MainActivity.this, uid);
                } else {
                    PointPub.INSTANCE.startOfferWall(MainActivity.this, "123456789");
                }
            }
        });
    }
}