package app.ltaps.imagegallerydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.ltaps.imagegallery.ImageGallery;
import app.ltaps.imagegallery.Utils.OnClickCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageGallery imageGallery = (ImageGallery) findViewById(R.id.imageGallery);
        imageGallery
                .setImages(getImages())
                .setOnLargeImageClickCallback(new OnClickCallback() {
                    @Override
                    public void OnClick(String currentImageUrl) {
                        Toast.makeText(getApplicationContext(), "Clicked image", Toast.LENGTH_LONG).show();
                    }
                })
                .start();
    }

    private List<String> getImages() {
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("http://www.allgoodcleanrecords.com/photo/record_stores/route66/DSC_0172.jpg");
        imageUrls.add("http://www.allgoodcleanrecords.com/photo/record_stores/route66/DSC_0177.jpg");
        imageUrls.add("http://www.allgoodcleanrecords.com/photo/record_stores/route66/DSC_0176.jpg");
        imageUrls.add("http://www.allgoodcleanrecords.com/photo/record_stores/route66/DSC_0180.jpg");
        imageUrls.add("http://www.allgoodcleanrecords.com/photo/record_stores/route66/DSC_0185.jpg");
        imageUrls.add("http://www.allgoodcleanrecords.com/photo/record_stores/route66/DSC_0179.jpg");
        imageUrls.add("http://www.allgoodcleanrecords.com/photo/record_stores/route66/DSC_0179121.jpg");
        return imageUrls;
    }

}
