package com.example.boredapp.intro;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class IntroPageConfig {
    @StringRes
    public int titleRes;

    @DrawableRes
    public int imageRes;

    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public IntroPageConfig(@StringRes int titleRes, @DrawableRes int imageRes) {
        this.titleRes = titleRes;
        this.imageRes = imageRes;
    }
}
