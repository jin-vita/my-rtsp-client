package org.easydarwin.player.simpleplayer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.easydarwin.video.EasyPlayerClient;

public class MainActivity extends AppCompatActivity {

    EasyPlayerClient client1;
    EasyPlayerClient client2;
    EasyPlayerClient client3;
    EasyPlayerClient client4;

    ResultReceiver mResultReceiver1;
    ResultReceiver mResultReceiver2;
    ResultReceiver mResultReceiver3;
    ResultReceiver mResultReceiver4;

    RelativeLayout container1;
    RelativeLayout container2;
    RelativeLayout container3;
    RelativeLayout container4;

    TextureView textureView1;
    TextureView textureView2;
    TextureView textureView3;
    TextureView textureView4;

    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    ProgressBar progressBar4;

    LinearLayout buttonContainer1;
    LinearLayout buttonContainer2;
    LinearLayout buttonContainer3;
    LinearLayout buttonContainer4;

    EditText input1;
    EditText input2;
    EditText input3;
    EditText input4;

    Button viewButton1;
    Button viewButton2;
    Button viewButton3;
    Button viewButton4;

    boolean playing1 = false;
    boolean playing2 = false;
    boolean playing3 = false;
    boolean playing4 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initReceiver();


    }

    public void initView() {

        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);
        container3 = findViewById(R.id.container3);
        container4 = findViewById(R.id.container4);

        textureView3 = findViewById(R.id.textureView3);
        textureView4 = findViewById(R.id.textureView4);

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);

        buttonContainer1 = findViewById(R.id.buttonContainer1);
        buttonContainer2 = findViewById(R.id.buttonContainer2);
        buttonContainer3 = findViewById(R.id.buttonContainer3);
        buttonContainer4 = findViewById(R.id.buttonContainer4);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);

        viewButton1 = findViewById(R.id.viewButton1);
        viewButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playing1) {
                    stopClient(0);
                } else {
                    startClient(0);
                }
            }
        });

        viewButton2 = findViewById(R.id.viewButton2);
        viewButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playing2) {
                    stopClient(1);
                } else {
                    startClient(1);
                }
            }
        });

        viewButton3 = findViewById(R.id.viewButton3);
        viewButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playing3) {
                    stopClient(2);
                } else {
                    startClient(2);
                }
            }
        });

        viewButton4 = findViewById(R.id.viewButton4);
        viewButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playing4) {
                    stopClient(3);
                } else {
                    startClient(3);
                }
            }
        });

    }

    public void initReceiver() {

        mResultReceiver1 = new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                super.onReceiveResult(resultCode, resultData);

                if (resultCode == EasyPlayerClient.RESULT_VIDEO_DISPLAYED) {
                    Log.d("Main", "Receiver1 : RESULT_VIDEO_DISPLAYED");

                    progressBar1.setVisibility(View.INVISIBLE);
                    input1.setVisibility(View.INVISIBLE);
                    viewButton1.setText("중지");

                } else if (resultCode == EasyPlayerClient.RESULT_VIDEO_SIZE) {
                    int mWidth = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_WIDTH);
                    int mHeight = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_HEIGHT);

                    Log.d("Main", "Receiver1 : RESULT_VIDEO_SIZE " + mWidth + ", " + mHeight);

                } else if (resultCode == EasyPlayerClient.RESULT_TIMEOUT) {
                    Log.d("Main", "Receiver1 : RESULT_TIMEOUT");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_AUDIO) {
                    Log.d("Main", "Receiver1 : RESULT_UNSUPPORTED_AUDIO");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_VIDEO) {
                    Log.d("Main", "Receiver1 : RESULT_UNSUPPORTED_VIDEO");

                } else if (resultCode == EasyPlayerClient.RESULT_EVENT) {
                    int errorCode = resultData.getInt("errorcode");
                    int state = resultData.getInt("state");
                    String msg = resultData.getString("event-msg");

                    Log.d("Main", "Receiver1 : RESULT_EVENT " + errorCode + ", " + state + ", " + msg);

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_BEGIN) {
                    Log.d("Main", "Receiver1 : RESULT_RECORD_BEGIN");

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_END) {
                    Log.d("Main", "Receiver1 : RESULT_RECORD_END");

                }
            }
        };


        mResultReceiver2 = new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                super.onReceiveResult(resultCode, resultData);

                if (resultCode == EasyPlayerClient.RESULT_VIDEO_DISPLAYED) {
                    Log.d("Main", "Receiver2 : RESULT_VIDEO_DISPLAYED");

                    progressBar2.setVisibility(View.INVISIBLE);
                    input2.setVisibility(View.INVISIBLE);
                    viewButton2.setText("중지");

                } else if (resultCode == EasyPlayerClient.RESULT_VIDEO_SIZE) {
                    int mWidth = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_WIDTH);
                    int mHeight = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_HEIGHT);

                    Log.d("Main", "Receiver2 : RESULT_VIDEO_SIZE " + mWidth + ", " + mHeight);

                } else if (resultCode == EasyPlayerClient.RESULT_TIMEOUT) {
                    Log.d("Main", "Receiver2 : RESULT_TIMEOUT");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_AUDIO) {
                    Log.d("Main", "Receiver2 : RESULT_UNSUPPORTED_AUDIO");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_VIDEO) {
                    Log.d("Main", "Receiver2 : RESULT_UNSUPPORTED_VIDEO");

                } else if (resultCode == EasyPlayerClient.RESULT_EVENT) {
                    int errorCode = resultData.getInt("errorcode");
                    int state = resultData.getInt("state");
                    String msg = resultData.getString("event-msg");

                    Log.d("Main", "Receiver2 : RESULT_EVENT " + errorCode + ", " + state + ", " + msg);

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_BEGIN) {
                    Log.d("Main", "Receiver2 : RESULT_RECORD_BEGIN");

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_END) {
                    Log.d("Main", "Receiver2 : RESULT_RECORD_END");

                }
            }
        };


        mResultReceiver3 = new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                super.onReceiveResult(resultCode, resultData);

                if (resultCode == EasyPlayerClient.RESULT_VIDEO_DISPLAYED) {
                    Log.d("Main", "Receiver3 : RESULT_VIDEO_DISPLAYED");

                    progressBar3.setVisibility(View.INVISIBLE);
                    input3.setVisibility(View.INVISIBLE);
                    viewButton3.setText("중지");

                } else if (resultCode == EasyPlayerClient.RESULT_VIDEO_SIZE) {
                    int mWidth = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_WIDTH);
                    int mHeight = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_HEIGHT);

                    Log.d("Main", "Receiver3 : RESULT_VIDEO_SIZE " + mWidth + ", " + mHeight);

                } else if (resultCode == EasyPlayerClient.RESULT_TIMEOUT) {
                    Log.d("Main", "Receiver3 : RESULT_TIMEOUT");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_AUDIO) {
                    Log.d("Main", "Receiver3 : RESULT_UNSUPPORTED_AUDIO");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_VIDEO) {
                    Log.d("Main", "Receiver3 : RESULT_UNSUPPORTED_VIDEO");

                } else if (resultCode == EasyPlayerClient.RESULT_EVENT) {
                    int errorCode = resultData.getInt("errorcode");
                    int state = resultData.getInt("state");
                    String msg = resultData.getString("event-msg");

                    Log.d("Main", "Receiver3 : RESULT_EVENT " + errorCode + ", " + state + ", " + msg);

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_BEGIN) {
                    Log.d("Main", "Receiver3 : RESULT_RECORD_BEGIN");

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_END) {
                    Log.d("Main", "Receiver3 : RESULT_RECORD_END");

                }
            }
        };


        mResultReceiver4 = new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                super.onReceiveResult(resultCode, resultData);

                if (resultCode == EasyPlayerClient.RESULT_VIDEO_DISPLAYED) {
                    Log.d("Main", "Receiver4 : RESULT_VIDEO_DISPLAYED");

                    progressBar4.setVisibility(View.INVISIBLE);
                    input4.setVisibility(View.INVISIBLE);
                    viewButton4.setText("중지");


                } else if (resultCode == EasyPlayerClient.RESULT_VIDEO_SIZE) {
                    int mWidth = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_WIDTH);
                    int mHeight = resultData.getInt(EasyPlayerClient.EXTRA_VIDEO_HEIGHT);

                    Log.d("Main", "Receiver4 : RESULT_VIDEO_SIZE " + mWidth + ", " + mHeight);

                } else if (resultCode == EasyPlayerClient.RESULT_TIMEOUT) {
                    Log.d("Main", "Receiver4 : RESULT_TIMEOUT");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_AUDIO) {
                    Log.d("Main", "Receiver4 : RESULT_UNSUPPORTED_AUDIO");

                } else if (resultCode == EasyPlayerClient.RESULT_UNSUPPORTED_VIDEO) {
                    Log.d("Main", "Receiver4 : RESULT_UNSUPPORTED_VIDEO");

                } else if (resultCode == EasyPlayerClient.RESULT_EVENT) {
                    int errorCode = resultData.getInt("errorcode");
                    int state = resultData.getInt("state");
                    String msg = resultData.getString("event-msg");

                    Log.d("Main", "Receiver4 : RESULT_EVENT " + errorCode + ", " + state + ", " + msg);

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_BEGIN) {
                    Log.d("Main", "Receiver4 : RESULT_RECORD_BEGIN");

                } else if (resultCode == EasyPlayerClient.RESULT_RECORD_END) {
                    Log.d("Main", "Receiver4 : RESULT_RECORD_END");

                }
            }
        };

    }

    public void startClient(int index) {

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        if (index == 0) {
            textureView1 = new TextureView(this);
            textureView1.setLayoutParams(params);
            container1.addView(textureView1);
            buttonContainer1.bringToFront();

            String url = input1.getText().toString();
            if (!TextUtils.isEmpty(url)) {
                client1 = new EasyPlayerClient(this, textureView1, mResultReceiver1, null);
                client1.play(url);

                progressBar1.setVisibility(View.VISIBLE);
                playing1 = true;
            }

        } else if (index == 1) {
            textureView2 = new TextureView(this);
            textureView2.setLayoutParams(params);
            container2.addView(textureView2);
            buttonContainer2.bringToFront();

            String url = input2.getText().toString();
            if (!TextUtils.isEmpty(url)) {
                client2 = new EasyPlayerClient(this, textureView2, mResultReceiver2, null);
                client2.play(url);

                progressBar2.setVisibility(View.VISIBLE);
                playing2 = true;
            }

        } else if (index == 2) {
            textureView3 = new TextureView(this);
            textureView3.setLayoutParams(params);
            container3.addView(textureView3);
            buttonContainer3.bringToFront();

            String url = input3.getText().toString();
            if (!TextUtils.isEmpty(url)) {
                client3 = new EasyPlayerClient(this, textureView3, mResultReceiver3, null);
                client3.play(url);

                progressBar3.setVisibility(View.VISIBLE);
                playing3 = true;
            }

        } else if (index == 3) {
            textureView4 = new TextureView(this);
            textureView4.setLayoutParams(params);
            container4.addView(textureView4);
            buttonContainer4.bringToFront();

            String url = input4.getText().toString();
            if (!TextUtils.isEmpty(url)){
                client4 = new EasyPlayerClient(this, textureView4, mResultReceiver4, null);
                client4.play(url);

                progressBar4.setVisibility(View.VISIBLE);
                playing4 = true;
            }

        }

    }


    public void stopClient(int index) {
        if (index == 0) {
            client1.pause();
            client1.stop();
            playing1 = false;
            progressBar1.setVisibility(View.INVISIBLE);

            input1.setVisibility(View.VISIBLE);
            viewButton1.setText("시작");

            container1.removeView(textureView1);
        } else if (index == 1) {
            client2.pause();
            client2.stop();
            playing2 = false;
            progressBar2.setVisibility(View.INVISIBLE);

            input2.setVisibility(View.VISIBLE);
            viewButton2.setText("시작");

            container2.removeView(textureView2);
        } else if (index == 2) {
            client3.pause();
            client3.stop();
            playing3 = false;
            progressBar3.setVisibility(View.INVISIBLE);

            input3.setVisibility(View.VISIBLE);
            viewButton3.setText("시작");

            container3.removeView(textureView3);
        } else if (index == 3) {
            client4.pause();
            client4.stop();
            playing4 = false;
            progressBar4.setVisibility(View.INVISIBLE);

            input4.setVisibility(View.VISIBLE);
            viewButton4.setText("시작");

            container4.removeView(textureView4);
        }
    }

}
