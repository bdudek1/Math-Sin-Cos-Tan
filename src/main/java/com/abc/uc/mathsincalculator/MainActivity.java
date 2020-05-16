package com.abc.uc.mathsincalculator;

//import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.reward.RewardItem;
//import com.google.android.gms.ads.reward.RewardedVideoAd;
//import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity /*implements RewardedVideoAdListener*/ {
    //private RewardedVideoAd mRewardedVideoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MobileAds.initialize(this, "ca-app-pub-2337287186342241~2785979087");

//        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(MainActivity.this);
//        mRewardedVideoAd.setRewardedVideoAdListener(this);
//        loadRewardedVideoAd();


        Button buttonSinCalc = (Button) findViewById(R.id.buttonsin);
        Button buttonArcCalc = (Button) findViewById(R.id.buttonarc);
        Button buttonHiperbolic = (Button) findViewById(R.id.buttonhiperbolic);
        Button buttonLaws = (Button) findViewById(R.id.buttonlaw);
        Button buttonHiperbolicLaws = (Button) findViewById(R.id.buttonhiperboliclaw);
        Button buttonEquations = (Button) findViewById(R.id.buttonEquations);



        buttonSinCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SinActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonArcCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArcActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonLaws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LearnActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonHiperbolic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Hiperbolic.class);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonHiperbolicLaws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HiperbolicEquations.class);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonEquations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setMessage("You need to watch a short ad to enter equations section").setView(R.layout.ad_dialog)
//                        .setPositiveButton("Watch ad", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                if (mRewardedVideoAd.isLoaded()) {
//                                    mRewardedVideoAd.show();
//                                }
//
//                            }
//                        })
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//
//                            }
//                        });
//                builder.create().show();
        Intent intent = new Intent(MainActivity.this, EquationsActivity.class);
        MainActivity.this.startActivity(intent);
            }
        });
    }

//    private void loadRewardedVideoAd() {
//        mRewardedVideoAd.loadAd("ca-app-pub-2337287186342241/8485735815",
//                new AdRequest.Builder().build());
//    }

    @Override
    public void onResume() {
        //mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        //mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        //mRewardedVideoAd.destroy(this);
        super.onDestroy();
        //loadRewardedVideoAd();
    }

//    @Override
//    public void onRewarded(RewardItem reward) {
//        Intent intent = new Intent(MainActivity.this, EquationsActivity.class);
//        MainActivity.this.startActivity(intent);
//        loadRewardedVideoAd();
//        // Reward the user.
//    }

//    @Override
//    public void onRewardedVideoAdLeftApplication() {
//        loadRewardedVideoAd();
//    }
//
//
//    @Override
//    public void onRewardedVideoAdFailedToLoad(int errorCode) {
//        loadRewardedVideoAd();
//    }
//
//    @Override
//    public void onRewardedVideoAdLoaded() {
//    }
//
//    @Override
//    public void onRewardedVideoAdOpened() {
//    }
//
//    @Override
//    public void onRewardedVideoStarted() {
//    }
//
//    @Override
//    public void onRewardedVideoCompleted() {
//        loadRewardedVideoAd();
//    }
//
//    @Override
//    public void onRewardedVideoAdClosed() {
//        // Load the next rewarded video ad.
//        loadRewardedVideoAd();
//    }
}
