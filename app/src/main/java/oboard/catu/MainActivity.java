package oboard.catu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.coolapk.market.util.AuthUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import android.widget.EditText;

public class MainActivity extends Activity {

    String token;
    EditText text;
    Handler handler;

    Runnable n = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            //更新界面
            text.setText(text.getText().toString() + "\n丢失:\n" + token);
        }
    };

    Runnable y = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            //更新界面
            text.setText(text.getText().toString() + "\n已发送:\n" + token);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = findViewById(R.id.text);
        handler = new Handler();
    }

    @SuppressLint("SetTextI18n")
    public void o(View view) {
        token = AuthUtils.getAS(UUID.randomUUID().toString());

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    HttpURLConnection http = (HttpURLConnection) new URL("http://l.w568w.ml/api/coolapk.php?token=" + token).openConnection();
                    http.setRequestMethod("POST");
                    http.setUseCaches(false);
                    http.connect();
                    http.getInputStream();
                    handler.post(y);
                } catch (Exception e) {
                    handler.post(n);
                }
            }
        }.start();

    }
}
