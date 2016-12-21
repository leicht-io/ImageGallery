package app.ltaps.imagegallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import app.ltaps.imagegallery.Utils.CenterLayoutManager;
import app.ltaps.imagegallery.Utils.OnClickCallback;
import app.ltaps.imagegallery.Utils.PlacesGalleryAdapter;

/**
 * Created by Christian on 21-12-2016.
 * Edited by Christian on 21-12-2016.
 */

public class ImageGallery extends RelativeLayout {
    private Context context;
    private List<String> imageUrls;
    private OnClickCallback onClickCallback;

    public ImageGallery(Context context) {
        super(context);
        init(context);
    }

    public ImageGallery(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageGallery(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImageGallery(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        this.context = context;
        inflate(context, R.layout.image_gallery, this);
    }

    public ImageGallery setImages(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        return this;
    }

    public ImageGallery setOnLargeImageClickCallback(OnClickCallback onClickCallback) {
        this.onClickCallback = onClickCallback;
        return this;
    }

    public void start() {
        if (this.imageUrls == null || this.imageUrls.isEmpty()) {
            throw new IllegalArgumentException("No images");
        } else if (this.context == null) {
            throw new IllegalArgumentException("No context");
        } else {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery);
            recyclerView.setHasFixedSize(true);

            CenterLayoutManager layoutManager = new CenterLayoutManager(context, CenterLayoutManager.HORIZONTAL, false);

            SnapHelper snapHelper = new LinearSnapHelper();
            if (recyclerView.getOnFlingListener() == null) {
                snapHelper.attachToRecyclerView(recyclerView);
            }

            recyclerView.setLayoutManager(layoutManager);
            PlacesGalleryAdapter adapter = new PlacesGalleryAdapter(context, imageUrls, (ImageView) findViewById(R.id.singleImage), (TextView) findViewById(R.id.size), recyclerView);

            if(this.onClickCallback != null) {
                adapter.setCallback(this.onClickCallback);
            }

            recyclerView.setAdapter(adapter);
        }
    }
}
