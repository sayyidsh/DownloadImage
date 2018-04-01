package pro.nanosystems.downloadimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  static ImageView photo, photo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photo = findViewById(R.id.photo);
        photo2 = findViewById(R.id.photo2);


    }

    public void downloadImage(View view) {
        String[] imageURL ={
                "https://http2.mlstatic.com/software-para-telefono-android-zte-blu-samsung-huawei-D_NQ_NP_615051-MLV26570545640_122017-F.jpg",
                "https://www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf"
        };
        new DownloadImage().execute(imageURL);

    }
}
