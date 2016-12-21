package app.ltaps.imagegallery.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import app.ltaps.imagegallery.R;

/**
 * Created by Christian on 21-12-2016.
 * Edited by Christian on 21-12-2016.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView galleryImage;

    public ImageViewHolder(View view) {
        super(view);

        galleryImage = (ImageView) view.findViewById(R.id.gallery_image);
    }
}