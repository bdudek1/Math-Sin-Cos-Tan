package com.abc.uc.mathsincalculator;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;



public class LearnActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(getApplicationContext());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        TextView space;
        space = new TextView(this);
        space.setText("");
        space.setTextSize(16);

        TextView spacetan;
        spacetan = new TextView(this);
        spacetan.setText("");
        spacetan.setTextSize(16);

        TextView space2;
        space2 = new TextView(this);
        space2.setText("");
        space2.setTextSize(16);

        TextView space3;
        space3 = new TextView(this);
        space3.setText("");
        space3.setTextSize(16);

        TextView space4;
        space4 = new TextView(this);
        space4.setText("");
        space4.setTextSize(16);

        TextView space5;
        space5 = new TextView(this);
        space5.setText("");
        space5.setTextSize(16);

        TextView space6;
        space6 = new TextView(this);
        space6.setText("");
        space6.setTextSize(16);

        TextView space7;
        space7 = new TextView(this);
        space7.setText("");
        space7.setTextSize(16);

        TextView space8;
        space8 = new TextView(this);
        space8.setText("");
        space8.setTextSize(16);


        TextView law1;
        law1 = new TextView(this);
        law1.setText(Html.fromHtml("sin<sup>2</sup>(a) + cos<sup>2</sup>(a) = 1"));
        law1.setTextSize(16);

        TextView lawTan;
        lawTan = new TextView(this);
        lawTan.setText(Html.fromHtml("tan(a) = sin(a)/cos(a)"));
        lawTan.setTextSize(16);

        TextView lawCot;
        lawCot = new TextView(this);
        lawCot.setText(Html.fromHtml("cot(a) = cos(a)/sin(a)"));
        lawCot.setTextSize(16);

        TextView law2;
        law2 = new TextView(this);
        law2.setText(Html.fromHtml("sin(a + b) = sin(a)*cos(b) + sin(b)*cos(a)"));
        law2.setTextSize(16);

        TextView law3;
        law3 = new TextView(this);
        law3.setText(Html.fromHtml("sin(a - b) = sin(a)*cos(b) - sin(b)*cos(a)"));
        law3.setTextSize(16);

        TextView law4;
        law4 = new TextView(this);
        law4.setText(Html.fromHtml("cos(a + b) = cos(a)*cos(b) - sin(b)*sin(a)"));
        law4.setTextSize(16);

        TextView law5;
        law5 = new TextView(this);
        law5.setText(Html.fromHtml("cos(a - b) = cos(a)*cos(b) + sin(b)*sin(a)"));
        law5.setTextSize(16);

        TextView law6;
        law6 = new TextView(this);
        law6.setText(Html.fromHtml("sin(a) + sin(b) = 2*sin((a + b)/2)*cos((a - b)/2)"));
        law6.setTextSize(16);

        TextView law7;
        law7 = new TextView(this);
        law7.setText(Html.fromHtml("sin(a) - sin(b) = 2*cos((a + b)/2)*sin((a - b)/2)"));
        law7.setTextSize(16);

        TextView law8;
        law8 = new TextView(this);
        law8.setText(Html.fromHtml("sin(a)*sin(b) = 1/2*[cos(a - b) - cos(a + b)]"));
        law8.setTextSize(16);

        TextView law9;
        law9 = new TextView(this);
        law9.setText(Html.fromHtml("cos(a)*cos(b) = 1/2*[cos(a - b) + cos(a + b)]"));
        law9.setTextSize(16);

        TextView law10;
        law10 = new TextView(this);
        law10.setText(Html.fromHtml("sin(2a) = 2*sin(a)*cos(a)"));
        law10.setTextSize(16);

        TextView law11;
        law11 = new TextView(this);
        law11.setText(Html.fromHtml("cos(2a) = 1 - sin<sup>2</sup>(a)"));
        law11.setTextSize(16);

        TextView law12;
        law12 = new TextView(this);
        law12.setText(Html.fromHtml("tan(2a) = 2*tan(a)/(1 - tan<sup>2</sup>(a))"));
        law12.setTextSize(16);

        TextView law13;
        law13 = new TextView(this);
        law13.setText(Html.fromHtml("cot(2a) = (cot<sup>2</sup>(a) - 1)/2*cot(a)"));
        law13.setTextSize(16);

        TextView law14;
        law14 = new TextView(this);
        law14.setText(Html.fromHtml("tan(a + b) = (tan(a) + tan(b))/(1 - tan(a)*tan(b))"));
        law14.setTextSize(16);

        TextView law15;
        law15 = new TextView(this);
        law15.setText(Html.fromHtml("tan(a - b) = (tan(a) - tan(b))/(1 + tan(a)*tan(b))"));
        law15.setTextSize(16);

        TextView law16;
        law16 = new TextView(this);
        law16.setText(Html.fromHtml("cos(a) + cos(b) = 2*cos((a + b)/2)*cos((a - b)/2)"));
        law16.setTextSize(16);

        TextView law17;
        law17 = new TextView(this);
        law17.setText(Html.fromHtml("cos(a) - cos(b) = -2*sin((a + b)/2)*sin((a - b)/2)"));
        law17.setTextSize(16);

        TextView law18;
        law18 = new TextView(this);
        law18.setText(Html.fromHtml("sin(a)*cos(b) = 1/2*[sin(a + b) + sin(a - b)]"));
        law18.setTextSize(16);

        TextView law19;
        law19 = new TextView(this);
        law19.setText(Html.fromHtml("sin(b)*cos(a) = 1/2*[sin(a + b) - sin(a - b)]"));
        law19.setTextSize(16);

        TextView law20;
        law20 = new TextView(this);
        law20.setText(Html.fromHtml("sin(a/2) = \u00b1" + "\u221a" + "[(1 - cos(a))/2]"));
        law20.setTextSize(16);

        TextView law21;
        law21 = new TextView(this);
        law21.setText(Html.fromHtml("cos(a/2) = \u00b1" + "\u221a" + "[(1 + cos(a))/2]"));
        law21.setTextSize(16);

        TextView law22;
        law22 = new TextView(this);
        law22.setText(Html.fromHtml("tan(a/2) = \u00b1" + "\u221a" + "[(1 - cos(a))/(1 + cos(a))]"));
        law22.setTextSize(16);

        TextView law23;
        law23 = new TextView(this);
        law23.setText(Html.fromHtml("cot(a/2) = \u00b1" + "\u221a" + "[(1 + cos(a))/(1 - cos(a))]"));
        law23.setTextSize(16);

        linearLayout.addView(law1);
        linearLayout.addView(spacetan);
        linearLayout.addView(lawTan);
        linearLayout.addView(lawCot);
        linearLayout.addView(space);
        linearLayout.addView(law2);
        linearLayout.addView(law3);
        linearLayout.addView(law4);
        linearLayout.addView(law5);
        linearLayout.addView(space2);
        linearLayout.addView(law6);
        linearLayout.addView(law7);
        linearLayout.addView(space3);
        linearLayout.addView(law8);
        linearLayout.addView(law9);
        linearLayout.addView(space4);
        linearLayout.addView(law10);
        linearLayout.addView(law11);
        linearLayout.addView(law12);
        linearLayout.addView(law13);
        linearLayout.addView(space5);
        linearLayout.addView(law14);
        linearLayout.addView(law15);
        linearLayout.addView(space6);
        linearLayout.addView(law16);
        linearLayout.addView(law17);
        linearLayout.addView(space7);
        linearLayout.addView(law18);
        linearLayout.addView(law19);
        linearLayout.addView(space8);
        linearLayout.addView(law20);
        linearLayout.addView(law21);
        linearLayout.addView(law22);
        linearLayout.addView(law23);

        scrollView.addView(linearLayout);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);


    }
}
