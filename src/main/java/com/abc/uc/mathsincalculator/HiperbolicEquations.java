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


public class HiperbolicEquations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiperbolic_equations);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(getApplicationContext());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        TextView space;
        space = new TextView(this);
        space.setText("");
        space.setTextSize(16);

        TextView spaceTan;
        spaceTan = new TextView(this);
        spaceTan.setText("");
        spaceTan.setTextSize(16);

        TextView space2;
        space2 = new TextView(this);
        space2.setText("");
        space2.setTextSize(16);

        TextView space3;
        space3 = new TextView(this);
        space3.setText("");
        space3.setTextSize(16);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        TextView law1;
        law1 = new TextView(this);
        law1.setText(Html.fromHtml("sinh(a) = (e<sup>a</sup> - e<sup>-a</sup>)/2"));
        law1.setTextSize(16);

        TextView lawTan;
        lawTan = new TextView(this);
        lawTan.setText(Html.fromHtml("csch(a) = 1/sinh(a) = 2/(e<sup>a</sup> - e<sup>-a</sup>)"));
        lawTan.setTextSize(16);

        TextView lawCot;
        lawCot = new TextView(this);
        lawCot.setText(Html.fromHtml("cosh(a) = (e<sup>a</sup> + e<sup>-a</sup>)/2"));
        lawCot.setTextSize(16);

        TextView law2;
        law2 = new TextView(this);
        law2.setText(Html.fromHtml("sech(a) = 1/cosh(a) = 2/(e<sup>a</sup> + e<sup>-a</sup>)"));
        law2.setTextSize(16);

        TextView law3;
        law3 = new TextView(this);
        law3.setText(Html.fromHtml("tanh(a) = sinh(a)/cosh(a) = (e<sup>a</sup> - e<sup>-a</sup>)/(e<sup>a</sup> + e<sup>-a</sup>)"));
        law3.setTextSize(16);

        TextView law4;
        law4 = new TextView(this);
        law4.setText(Html.fromHtml("coth(a) = 1/tanh(a) = (e<sup>a</sup> + e<sup>-a</sup>)/(e<sup>a</sup> - e<sup>-a</sup>)"));
        law4.setTextSize(16);

        TextView law5;
        law5 = new TextView(this);
        law5.setText(Html.fromHtml("cosh<sup>2</sup>(a) - sinh<sup>2</sup>(a) = 1"));
        law5.setTextSize(16);

        TextView law6;
        law6 = new TextView(this);
        law6.setText(Html.fromHtml("tanh<sup>2</sup>(a) + sech<sup>2</sup>(a) = 1"));
        law6.setTextSize(16);

        TextView law7;
        law7 = new TextView(this);
        law7.setText(Html.fromHtml("coth<sup>2</sup>(a) - csch<sup>2</sup>(a) = 1"));
        law7.setTextSize(16);

        TextView law8;
        law8 = new TextView(this);
        law8.setText(Html.fromHtml("arcsinh(a) = ln(a+" + "\u221a" +"(a<sup>2</sup> + 1))"));
        law8.setTextSize(16);

        TextView law9;
        law9 = new TextView(this);
        law9.setText(Html.fromHtml("arccosh(a) = ln(a"+ "±" + "\u221a" +"(a<sup>2</sup> - 1))"));
        law9.setTextSize(16);

        TextView law10;
        law10 = new TextView(this);
        law10.setText(Html.fromHtml("arctanh(a) = 1/2 ln( (1+a)/(1-a))"));
        law10.setTextSize(16);

        TextView law11;
        law11 = new TextView(this);
        law11.setText(Html.fromHtml("arccsch(a) = ln((1+" + "\u221a" +"(1+a<sup>2</sup>))/a)"));
        law11.setTextSize(16);

        TextView law12;
        law12 = new TextView(this);
        law12.setText(Html.fromHtml("arcsech(a) = ln((1" + "\u00b1" +  "\u221a" + " (1-a<sup>2</sup>)/a)"));
        law12.setTextSize(16);

        TextView law13;
        law13 = new TextView(this);
        law13.setText(Html.fromHtml("arccoth(a) = 1/2 ln((a+1)/(a-1))"));
        law13.setTextSize(16);

        TextView law14;
        law14 = new TextView(this);
        law14.setText(Html.fromHtml("sinh(a) = -i sin(ia)"));
        law14.setTextSize(16);

        TextView law15;
        law15 = new TextView(this);
        law15.setText(Html.fromHtml("csch(a) = i csc(ia)"));
        law15.setTextSize(16);

        TextView law16;
        law16 = new TextView(this);
        law16.setText(Html.fromHtml("cosh(a) = cos(ia)"));
        law16.setTextSize(16);

        TextView law17;
        law17 = new TextView(this);
        law17.setText(Html.fromHtml("sech(a) = sec(ia)"));
        law17.setTextSize(16);

        TextView law18;
        law18 = new TextView(this);
        law18.setText(Html.fromHtml("tanh(a) = -i tan(ia)"));
        law18.setTextSize(16);

        TextView law19;
        law19 = new TextView(this);
        law19.setText(Html.fromHtml("coth(a) = i cot(ia)"));
        law19.setTextSize(16);


        linearLayout.addView(law1);
        linearLayout.addView(lawTan);
        linearLayout.addView(lawCot);
        linearLayout.addView(law2);
        linearLayout.addView(law3);
        linearLayout.addView(law4);
        linearLayout.addView(space);
        linearLayout.addView(law5);
        linearLayout.addView(law6);
        linearLayout.addView(law7);
        linearLayout.addView(space2);
        linearLayout.addView(law8);
        linearLayout.addView(law9);
        linearLayout.addView(law10);
        linearLayout.addView(law11);
        linearLayout.addView(law12);
        linearLayout.addView(law13);
        linearLayout.addView(space3);
        linearLayout.addView(law14);
        linearLayout.addView(law15);
        linearLayout.addView(law16);
        linearLayout.addView(law17);
        linearLayout.addView(law18);
        linearLayout.addView(law19);


        scrollView.addView(linearLayout);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        this.addContentView(scrollView, layoutParams);
    }
}
