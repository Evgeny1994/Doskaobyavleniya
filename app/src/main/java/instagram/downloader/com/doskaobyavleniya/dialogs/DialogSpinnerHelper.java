package instagram.downloader.com.doskaobyavleniya.dialogs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.utils.CityHelper;

public class DialogSpinnerHelper {


    public Activity activity;

    public DialogSpinnerHelper(Activity act) {
        activity = act;
    }

    public Activity getActivity() {
        return activity;
    }


    public void showSpinnerDialog(Context context, ArrayList<String> list) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        LayoutInflater li = LayoutInflater.from(getActivity());
        View promptsView = li.inflate(R.layout.spinner_layout, null);
        RcViewDialogSpinner adapter = new RcViewDialogSpinner(context, dialog);
        RecyclerView rcView = promptsView.findViewById(R.id.rcSpView);
        SearchView sv = promptsView.findViewById(R.id.svSpinner);


        rcView.setLayoutManager(new LinearLayoutManager(context));
        //LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        //rcView.setLayoutManager(layoutManager);

        //Установка адаптера
        rcView.setAdapter(adapter);

        dialog.setView(promptsView);
        adapter.updateAdapter(list);
        setSearchView(adapter, list, sv);
        dialog.show();
    }

    private void setSearchView(final RcViewDialogSpinner adapter, final ArrayList<String> list, SearchView sv) {
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> tempList = CityHelper.filterListData(list, newText);
                adapter.updateAdapter(tempList);
                return true;
            }
        });

    }

}
