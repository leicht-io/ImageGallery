package app.ltaps.imagegallery.Models;

/**
 * Created by Christian on 21-12-2016.
 * Edited by Christian on 21-12-2016.
 */

public class GalleryImage {
    private String imageUrl;
    private boolean isCenter = false;

    public boolean isCenter() {
        return isCenter;
    }

    public void setCenter(boolean center) {
        isCenter = center;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}