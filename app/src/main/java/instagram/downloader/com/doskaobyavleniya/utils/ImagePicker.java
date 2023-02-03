package instagram.downloader.com.doskaobyavleniya.utils;




import com.fxn.pix.Options;
import com.fxn.pix.Pix;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by Евгений on 30.01.2023.
 */

public class ImagePicker {


    public static void getImages(AppCompatActivity context, Integer imageCounter)
    {
         final int REQUEST_CODE_GET_IMAGES = 999;
        Options options = Options.init()
                .setRequestCode(REQUEST_CODE_GET_IMAGES)
                .setCount(3)
                .setFrontfacing(false)

                .setSpanCount(4)
                .setMode(Options.Mode.Picture)
                .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)
                .setPath("/pix/Images");
        Pix.start(context, options);


    }
}
