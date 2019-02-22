package com.example.rushikeshbirwatkar.supercook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    String mainrecipe;
    int positionofrecipes;
    WebView webview;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        fab=findViewById(R.id.floatingbtn);

        Intent intent=getIntent();
        mainrecipe=intent.getStringExtra("keyforecipes");
        positionofrecipes=intent.getIntExtra("keyforposition",100);

        final ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);

        webview=findViewById(R.id.webview);
        webview.loadUrl(mainrecipe);

        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sharingurl=mainrecipe;
                Uri uri=Uri.parse(sharingurl);
                Intent shareIntent=new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Recipes");
                shareIntent.putExtra(Intent.EXTRA_TEXT,sharingurl);
                //shareIntent.putExtra(Intent.EXTRA_STREAM,uri);
                startActivity(Intent.createChooser(shareIntent,"Share recipes Using..."));

            }
        });


        webview.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(view.VISIBLE);
              //  getSupportActionBar().setTitle(view.getTitle());
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(Main3Activity.this, "Page Loaded Successfully", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }

           /* @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                if(url.contains("facebook"))
                {
                    Toast.makeText(Main3Activity.this, "facebook is", Toast.LENGTH_SHORT).show();
                    return true;
                }else
                {
                    return false;
                }

            }*/
        }
        );
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack())
            webview.goBack();
        else
            super.onBackPressed();


    };




    }


