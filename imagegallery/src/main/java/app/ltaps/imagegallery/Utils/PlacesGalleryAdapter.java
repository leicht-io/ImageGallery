package app.ltaps.imagegallery.Utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import app.ltaps.imagegallery.Models.GalleryImage;
import app.ltaps.imagegallery.R;
import app.ltaps.imagegallery.ViewHolders.ImageViewHolder;

/**
 * Created by Christian on 21-12-2016.
 * Edited by Christian on 21-12-2016.
 */

public class PlacesGalleryAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private List<GalleryImage> gallery = new ArrayList<>();
    private Context context;
    private ImageView parent;
    private TextView size;
    private RecyclerView recyclerView;
    private String currentImageUrl = "";
    private OnClickCallback onClickCallback;
    private int standardMargin = 0;

    public PlacesGalleryAdapter(Context context, List<String> gallery, ImageView parent, TextView size, RecyclerView recyclerView) {
        this.parent = parent;
        this.context = context;
        this.size = size;
        this.recyclerView = recyclerView;
        this.standardMargin = ScreenUtils.convertDpToPixel(context, 2);

        for (int i = 0; i < gallery.size(); i++) {
            GalleryImage galleryImage = new GalleryImage();
            galleryImage.setImageUrl(gallery.get(i));
            if (i == 0) {
                galleryImage.setCenter(true);
                currentImageUrl = galleryImage.getImageUrl();
                populateParentImage();
            } else {
                galleryImage.setCenter(false);
            }
            this.gallery.add(galleryImage);
        }

        setSizeText(1);
        showImage();
    }

    public void setCallback(OnClickCallback onClickCallback) {
        this.onClickCallback = onClickCallback;
    }

    private void setSizeText(int current) {
        this.size.setText(current + context.getString(R.string.out_of) + String.valueOf(this.gallery.size()));
    }

    private void populateParentImage() {
        Picasso.with(context)
                .load(currentImageUrl)
                .transform(new RoundedTransformation(20, 0))
                .into(parent, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        Picasso.with(context)
                                .load(R.drawable.no_image)
                                .transform(new RoundedTransformation(20, 0))
                                .into(parent);
                    }
                });
    }

    private void showImage() {
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCallback.OnClick(currentImageUrl);
            }
        });
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gallery, viewGroup, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder viewHolder, final int i) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        if (i == 0) {
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = standardMargin;
            layoutParams.leftMargin = 0;
        } else if (i == gallery.size() - 1) {
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = standardMargin;
        } else {
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = standardMargin;
            layoutParams.leftMargin = standardMargin;
        }
        viewHolder.galleryImage.setLayoutParams(layoutParams);

        viewHolder.galleryImage.setColorFilter(0x77ffffff, PorterDuff.Mode.SRC_ATOP);
        viewHolder.galleryImage.invalidate();

        if (gallery.get(i).isCenter()) {
            viewHolder.galleryImage.clearColorFilter();
            viewHolder.galleryImage.invalidate();
        }

        viewHolder.galleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i > 0 && i < gallery.size()) {
                    recyclerView.smoothScrollToPosition(i);
                }
                updateCenter(i, viewHolder.galleryImage);

                currentImageUrl = gallery.get(i).getImageUrl();

                populateParentImage();
            }
        });

        Picasso.with(this.context)
                .load(gallery.get(i).getImageUrl())
                .transform(new RoundedTransformation(20, 0))
                .into(viewHolder.galleryImage, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        Picasso.with(context)
                                .load(R.drawable.no_image)
                                .transform(new RoundedTransformation(20, 0))
                                .into(viewHolder.galleryImage);
                    }
                });

    }

    private void updateCenter(int center, ImageView imageView) {
        for (GalleryImage galleryImage : gallery) {
            galleryImage.setCenter(false);
        }

        gallery.get(center).setCenter(true);

        if (gallery.get(center).isCenter()) {
            imageView.clearColorFilter();
            imageView.invalidate();
        }

        setSizeText(center + 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return gallery.size();
    }

}


