package com.example.nurmemet.iconfont;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nurmemet on 9/23/2016.
 */

public class BaseActivity extends AppCompatActivity {
    private final static String FONT_URL = "iconfont/iconfont.ttf";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initFont();
        super.onCreate(savedInstanceState);
    }


    private void initFont() {
        final Typeface iconfont = Typeface.createFromAsset(getAssets(), FONT_URL);
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                AppCompatDelegate delegate = getDelegate();
                View view = delegate.createView(parent, name, context, attrs);
                if (view != null && view instanceof TextView) {
                    TextView textView = (TextView) view;
                    textView.setTypeface(iconfont);
                }
                return view;
            }
        });
    }
}
