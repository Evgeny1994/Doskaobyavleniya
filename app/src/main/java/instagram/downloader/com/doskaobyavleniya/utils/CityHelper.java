package instagram.downloader.com.doskaobyavleniya.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Евгений on 16.01.2023.
 */

public class CityHelper {


    public static ArrayList<String> getAllCountries(Context context) {
        ArrayList<String> tempArray = new ArrayList<String>();
        try {
            InputStream inputStream = context.getAssets().open("countriesToCities.json");
            int size = inputStream.available();
            byte[] bytesArray = new byte[size];
            inputStream.read(bytesArray);

            String jsonFile = new String(bytesArray);
            JSONObject jsonObject = new JSONObject(jsonFile);
            JSONArray countriesNames = jsonObject.names();
            if (countriesNames != null) {
                for (int i = 0; i < countriesNames.length(); i++) {
                    tempArray.add(countriesNames.getString(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tempArray;
    }


    public static ArrayList<String> filterListData(ArrayList<String> list, String searchText) {
        ArrayList<String> tempList = new ArrayList<String>();
       // String su="No result";
        tempList.clear();
        if (searchText == null) {
           // tempList.add(su);
            return tempList;
        }
        for (String selection : list) {


            if (selection.toLowerCase().startsWith(searchText.toLowerCase())) {
                tempList.add(selection);
            }
        }
            if (tempList.size() ==0)
            {
                tempList.add("No result");
            }
        return tempList;

    }
}

