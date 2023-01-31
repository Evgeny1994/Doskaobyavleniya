package instagram.downloader.com.doskaobyavleniya.utils;




import android.content.Context;

import com.fxn.pix.Pix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import instagram.downloader.com.doskaobyavleniya.act.EditAdsAct;

/**
 * Created by Евгений on 30.01.2023.
 */

public class ImagePicker {

    public static void getImages(AppCompatActivity context, Integer imageCounter)
    {
        Pix.start( context, 3,3);

    }
}
