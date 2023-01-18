package instagram.downloader.com.doskaobyavleniya.act;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.dialogs.DialogSpinnerHelper;
import instagram.downloader.com.doskaobyavleniya.utils.CityHelper;


public class EditAdsAct extends AppCompatActivity {
    SearchView spCountry;
    Spinner country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ads);
        //spCountry = findViewById(R.id.counrySearch);
        //country = findViewById(R.id.country);
      //  ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CityHelper.getAllCountries(this));
      //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      /// country.setAdapter(adapter);


        ArrayList<String> listCountry = CityHelper.getAllCountries(this);
        DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);
        dialog.showSpinnerDialog(this, listCountry);







    }
}
