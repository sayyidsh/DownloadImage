package pro.nanosystems.downloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by sayyid on 31/03/2018.
 */

public class DownloadImage extends AsyncTask<String, Void, Bitmap[]> {


    @Override
    protected Bitmap[] doInBackground(String... strings) {
        try {

              /*  URL image1 = new URL(strings[0]);
                HttpsURLConnection conn = (HttpsURLConnection) image1.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(10000);
                conn.connect();
            InputStream in = conn.getInputStream();

            URL image2 = new URL(strings[1]);
            HttpsURLConnection conn2 = (HttpsURLConnection) image2.openConnection();
            conn2.setRequestMethod("GET");
            conn2.setConnectTimeout(15000);
            conn2.setReadTimeout(10000);
            conn2.connect();
            InputStream in1 = conn2.getInputStream();
            Bitmap[] images =new Bitmap[2];
            images[0] = BitmapFactory.decodeStream(in);
            images[1] = BitmapFactory.decodeStream(in1);
            in.close();
            in1.close();
            conn.disconnect();
            conn2.disconnect();*/
            // Other solution
            Bitmap[] images = new Bitmap[2];
            for (int i = 0; i < 2; i++) {
                HttpsURLConnection conn = (HttpsURLConnection) new URL(strings[i]).openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.connect();
                images[i] = BitmapFactory.decodeStream(conn.getInputStream());
                conn.disconnect();
            }

            return images;

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap[] bitmap) {
        MainActivity.photo.setImageBitmap(bitmap[0]);
        MainActivity.photo2.setImageBitmap(bitmap[1]);
        super.onPostExecute(bitmap);
    }
}
