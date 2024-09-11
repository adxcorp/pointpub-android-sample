package kr.pointpub.sample;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import kr.pointpub.sdk.PointPub;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.DEBUG) {
            // 디버깅을 위한 로그 활성화
            PointPub.INSTANCE.enableLogTrace();
        }
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.et_uid);
                String uid = editText.getText().toString();
                if (!TextUtils.isEmpty(uid)) {
                    // 포인트펍 실행 (user id값 필수 입력)
                    PointPub.INSTANCE.startOfferWall(MainActivity.this, uid);
                } else {
                    // 포인트펍 실행 (test user)
                    PointPub.INSTANCE.startOfferWall(MainActivity.this, "123456789");
                }
            }
        });
    }
}