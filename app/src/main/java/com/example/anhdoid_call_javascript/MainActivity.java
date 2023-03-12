package com.example.anhdoid_call_javascript;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private int dataFromJavascript = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new MyJavascriptInterface(), "Android");
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/index.html");

//        // Lặp lại kiểm tra giá trị của biến dataFromJavascript
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (dataFromJavascript != 0) {
//                    Toast.makeText(MainActivity.this, "Dữ liệu mới khi thay đổi: " + dataFromJavascript, Toast.LENGTH_SHORT).show();
//                    handler.removeCallbacksAndMessages(null);
//                } else {
//                    handler.postDelayed(this, 100);
//                }
//            }
//        }, 100);
    }
    public class MyJavascriptInterface {
        @JavascriptInterface
        public void getDataFromJavascript(String data) {
//            TextView textView = findViewById(R.id.myTextView);
//            textView.setText(data);
            Toast.makeText(MainActivity.this, "Data from JavaScript: " + data, Toast.LENGTH_SHORT).show();
//            dataFromJavascript = Integer.parseInt(data);
        }
    }
}