package com.example.recycleview_indicator_search;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {

    private final int indicatorHeight = 10; // Giá trị chiều cao của chỉ báo (10px)
    private final int indicatorWidth = 200; // Giá trị chiều rộng của chỉ báo (200px)
    private final int indicatorMargin = 16; // Lề của chỉ báo (16px)

    public LinePagerIndicatorDecoration(Context context) {
        // bỏ qua việc lấy các giá trị từ dimens.xml
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        // Vị trí và kích thước của chỉ báo
        int left = parent.getPaddingLeft() + indicatorMargin;
        int right = parent.getWidth() - parent.getPaddingRight() - indicatorMargin;
        int top = parent.getHeight() - indicatorHeight - indicatorMargin;
        int bottom = top + indicatorHeight;

        // Vẽ chỉ báo với màu đỏ
        Paint paint = new Paint();
        paint.setColor(Color.RED);  // Màu chỉ báo
        c.drawRect(left, top, right, bottom, paint);
    }
}
