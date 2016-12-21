package app.ltaps.imagegallery.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Christian on 21-12-2016.
 * Edited by Christian on 21-12-2016.
 */

class ScreenUtils {
    static int convertDpToPixel(Context context, int dp) {
        try {
            Resources r = context.getResources();
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
