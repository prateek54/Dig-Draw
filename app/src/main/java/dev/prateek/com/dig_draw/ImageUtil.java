package dev.prateek.com.dig_draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by prateek on 19-05-2018.
 */

//To invert colors of input finger touch digit

public class ImageUtil {

    private static final ColorMatrix INVERTED = new ColorMatrix(
            new float[] {
                    -1,  0,  0,  0, 255,
                    0, -1,  0,  0, 255,
                    0,  0, -1,  0, 255,
                    0,  0,  0,  1,   0
            });

    private static final ColorFilter COLOR_FILTER = new ColorMatrixColorFilter(INVERTED);

    private ImageUtil() {}

    public static Bitmap invert(Bitmap image) {
        Bitmap inverted = Bitmap.createBitmap(image.getWidth(), image.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(inverted);
        Paint paint = new Paint();
        paint.setColorFilter(COLOR_FILTER);
        canvas.drawBitmap(image, 0, 0, paint);
        return inverted;
    }

}