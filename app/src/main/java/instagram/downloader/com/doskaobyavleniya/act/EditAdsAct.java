package instagram.downloader.com.doskaobyavleniya.act;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

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
    DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ads);
        TextView tvCountry = findViewById(R.id.tvCountry);
        Intent intent = getIntent();
        String fName = intent.getStringExtra("fname");
        //System.out.println(fName);
       tvCountry.setText(fName);




      //  tvCountry = findViewById(R.id.tvCountry);

        //spCountry = findViewById(R.id.counrySearch);
        //country = findViewById(R.id.country);
      //  ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CityHelper.getAllCountries(this));
      //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      /// country.setAdapter(adapter);
        ArrayList<String> listCountry = CityHelper.getAllCountries(this);
        DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);
        dialog.showSpinnerDialog(this, listCountry);
    }

    public  Context getContext() {
        return EditAdsAct.context;
    }

    public void init()
    {

    }


    public void onClickSelectCountry(View view) {

       ArrayList<String> listCountry = CityHelper.getAllCountries(this);
      //  DialogSpinnerHelper dialog = new DialogSpinnerHelper(this);
        dialog.showSpinnerDialog(this, listCountry);
    }
}
