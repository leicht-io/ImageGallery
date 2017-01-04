package app.ltaps.imagegallery.Utils;

import android.content.Context;

import app.ltaps.imagegallery.R;

/**
 * Created by Christian on 04-01-2017.
 * Edited by Christian on 04-01-2016.
 */

@SuppressWarnings("unused")
public class LanguageHelper {

    private String outOf;
    private String noImagesAvailable;
    private Context context;

    public LanguageHelper(Context context) {
        this.context = context;
    }

    public LanguageHelper setOutOf(String outOf) {
        this.outOf = outOf;
        return this;
    }

    public LanguageHelper setNoImagesAvailable(String noImagesAvailable) {
        this.noImagesAvailable = noImagesAvailable;
        return this;
    }

    public String getNoImagesAvailable() {
        if (this.noImagesAvailable == null) {
            return context.getString(R.string.no_images_available);
        }
        return this.noImagesAvailable;
    }

    public String getOutOf() {
        if (this.outOf == null) {
            return context.getString(R.string.out_of);
        }
        return " " + this.outOf + " ";
    }

}
