package instagram.downloader.com.doskaobyavleniya.act;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fxn.pix.Pix;
import com.fxn.utility.PermUtil;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.dialogs.DialogSpinnerHelper;
import instagram.downloader.com.doskaobyavleniya.frag.FragmentCloseInterface;
import instagram.downloader.com.doskaobyavleniya.frag.ImageListFrag;
import instagram.downloader.com.doskaobyavleniya.utils.CityHelper;
import instagram.downloader.com.doskaobyavleniya.utils.ImagePicker;


public class EditAdsAct extends AppCompatActivity implements FragmentCloseInterface {
    SearchView spCountry;
    Spinner country;
    TextView tvCountry;
    public static Context context;
    TextView tvCity;
    ScrollView scrollViewMain;
    DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);
    public final int REQUEST_CODE_GET_IMAGES = 999;

//    public ImagePicker imagePicker;

    Boolean isImagesPermissionGranted = false;
//    public EditAdsAct(ImagePicker imagePicker) {
//        this.imagePicker = imagePicker;
//    }

//    public ImagePicker getImagePicker() {
//        return imagePicker;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ads);
        final TextView tvCountry = findViewById(R.id.tvCountry);
        tvCity = findViewById(R.id.tvCity);
        scrollViewMain = findViewById(R.id.scrolViewMain);
        Intent intent = getIntent();
        String fName = intent.getStringExtra("fname");
        //System.out.println(fName);
        tvCountry.setText(fName);
       // System.out.println(fName);
        //String selectedCountry = tvCountry.getText().toString();



        //А это уже рабочая кнопка
        tvCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String su = tvCountry.getText().toString();
                Log.i("Переменная равно", su);
            }
        });

        //  tvCountry = findViewById(R.id.tvCountry);

        //spCountry = findViewById(R.id.counrySearch);
        //country = findViewById(R.id.country);
        //  ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CityHelper.getAllCountries(this));
        //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        /// country.setAdapter(adapter);
        //    ArrayList<String> listCountry = CityHelper.getAllCountries(this);
        //    DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);
        //    dialog.showSpinnerDialog(this, listCountry);
    }

    public Context getContext() {
        return EditAdsAct.context;
    }

    public void init() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_GET_IMAGES)
        {
                ArrayList<String> returnValues = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
                    scrollViewMain.setVisibility(View.GONE);
                    FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.place_holder, new ImageListFrag(this, returnValues));
                    fm.commit();
 //               }
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermUtil.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   // ImagePicker.getImages(EditAdsAct.class);
                } else {
                   // isImagesPermissionGranted = true;
                    Toast.makeText(EditAdsAct.this, "Approve permissions to open Pix ImagePicker", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    //Первая кнопка работает нормально
    public void onClickSelectCountry(View view) {
        ArrayList<String> listCountry = CityHelper.getAllCountries(this);
        //  DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);
        dialog.showSpinnerDialog(this, listCountry);

    }


    public void onClickGetImage(View view) {
        scrollViewMain.setVisibility(View.GONE);
        ImagePicker.getImages(this,3);
    }



    public void onFragClose()
    {
        scrollViewMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    // tvCountry.OnClickListener()

 //   public  void onClickSelectCity(View view) {
   //     String selectedCountry = tvCountry.getText().toString();

   //     Log.i("СУКА", selectedCountry);
      //  if (selectedCountry != getString(R.string.select_country))
     //   {
        //String list = null;
          //////  ArrayList<String> listCountry = CityHelper.getAllCities(selectedCountry, this);
           ////////// dialog.showSpinnerDialog(this, listCountry);
   //     }
  //      else
  //      {
  //          Toast.makeText(this,"No country selected", Toast.LENGTH_LONG).show();
  //      }


    }



