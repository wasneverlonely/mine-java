package com.was.mine.widget.roll.hintview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import com.was.mine.utils.WindowUtils;

/**
 * Created by Mr.Jude on 2016/1/10.
 */
public class ColorPointHintView extends ShapeHintView {
    private int focusColor;
    private int normalColor;

    public ColorPointHintView(Context context, int focusColor, int normalColor) {
        super(context);
        this.focusColor = focusColor;
        this.normalColor = normalColor;
    }

    @Override
    public Drawable makeFocusDrawable() {
        GradientDrawable dot_focus = new GradientDrawable();
        dot_focus.setColor(focusColor);
        dot_focus.setCornerRadius(WindowUtils.Dp2Px(getContext(), 4));
        dot_focus.setSize(WindowUtils.Dp2Px(getContext(), 8), WindowUtils.Dp2Px(getContext(), 8));
        return dot_focus;
    }

    @Override
    public Drawable makeNormalDrawable() {
        GradientDrawable dot_normal = new GradientDrawable();
        dot_normal.setColor(normalColor);
        dot_normal.setCornerRadius(WindowUtils.Dp2Px(getContext(), 4));
        dot_normal.setSize(WindowUtils.Dp2Px(getContext(), 8), WindowUtils.Dp2Px(getContext(), 8));
        return dot_normal;
    }
}
