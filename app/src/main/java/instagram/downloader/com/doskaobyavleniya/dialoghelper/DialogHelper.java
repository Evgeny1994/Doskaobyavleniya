package instagram.downloader.com.doskaobyavleniya.dialoghelper;

import android.app.Activity;
import android.app.AlertDialog;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.TextView;


import instagram.downloader.com.doskaobyavleniya.R;



/**
 * Created by Евгений on 22.12.2022.
 */

public class DialogHelper {



    public static Activity activity;



    public DialogHelper(Activity act) {

        activity = act;
    }




    public static Activity getActivity() {
        return activity;
    }



    //функция
    public void createSignDialog(int index) {
        AlertDialog.Builder mDialogBuildr = new AlertDialog.Builder(getActivity());

        LayoutInflater li = LayoutInflater.from(getActivity());
        View promptsView = li.inflate(R.layout.sign_dialog, null);
        mDialogBuildr.setView(promptsView);
        TextView textView = promptsView.findViewById(R.id.tvSignTitle);
        textView.setText(getActivity().getResources().getString(R.string.ac_sign_up));







        AlertDialog alertDialog = mDialogBuildr.create();
        alertDialog.show();





    //    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
   //     LayoutInflater inflater = LayoutInflater.from(getContext());

   //     View su = inflater.inflate(R.layout.sign_dialog, null);


//        builder.setView(su);
//        builder.show();






       // AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
       // LayoutInflater inflater = LayoutInflater.from(getContext());
        //установить кастом вью
       //final View su = inflater.inflate(R.layout.sign_dialog, null, false);
       // TextView textView = su.findViewById(R.id.tvSignTitle);
       // if (index == DialogConst.SIGN_UP_STATE) {
       //     textView.setText(getContext().getResources().getString(R.string.ac_sign_up));


    //    } else {

    //    }
    //    builder.setView(su);
    //    builder.show();
    }

}

