package instagram.downloader.com.doskaobyavleniya.act;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.dialogs.DialogSpinnerHelper;
import instagram.downloader.com.doskaobyavleniya.utils.CityHelper;


public class EditAdsAct extends AppCompatActivity {
    SearchView spCountry;
    Spinner country;
    TextView tvCountry;
    public static Context context;
    TextView tvCity;
    DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ads);
        final TextView tvCountry = findViewById(R.id.tvCountry);
        tvCity = findViewById(R.id.tvCity);
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

     //Первая кнопка работает нормально
    public void onClickSelectCountry(View view) {

        ArrayList<String> listCountry = CityHelper.getAllCountries(this);
        //  DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);
        dialog.showSpinnerDialog(this, listCountry);

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



