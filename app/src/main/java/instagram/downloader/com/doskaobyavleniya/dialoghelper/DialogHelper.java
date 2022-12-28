package instagram.downloader.com.doskaobyavleniya.dialoghelper;

import android.app.Activity;
import android.app.AlertDialog;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.account.AccountHelper;


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
    public void createSignDialog(final int index) {
        final AlertDialog.Builder mDialogBuildr = new AlertDialog.Builder(getActivity());

        LayoutInflater li = LayoutInflater.from(getActivity());
        View promptsView = li.inflate(R.layout.sign_dialog, null);
        mDialogBuildr.setView(promptsView);
        if (index == DialogConst.SIGN_UP_STATE) {
            TextView textView = promptsView.findViewById(R.id.tvSignTitle);
            textView.setText(getActivity().getResources().getString(R.string.ac_sign_up));
            Button button = promptsView.findViewById(R.id.btSignUpIn);
            button.setText(getActivity().getResources().getString(R.string.sign_up_action));
        } else {
            TextView textView1 = promptsView.findViewById(R.id.tvSignTitle);
            textView1.setText(getActivity().getResources().getString(R.string.ac_sign_in));
            Button button1 = promptsView.findViewById(R.id.btSignUpIn);
            button1.setText(getActivity().getResources().getString(R.string.sign_in_action));
        }



        final EditText editText1 = promptsView.findViewById(R.id.edSignEmail);
        final EditText editText2 = promptsView.findViewById(R.id.edSignPassword);

        Button button3 = promptsView.findViewById(R.id.btSignUpIn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // alertDialog.dismiss();
                if (index == DialogConst.SIGN_UP_STATE)
                {
                    AccountHelper.signUpWithEmail(editText1.getText().toString(), editText2.getText().toString());
                }
                else
                {
                    AccountHelper.signInWithEmail(editText1.getText().toString(), editText2.getText().toString());
                }

            }
        });

        final AlertDialog alertDialog = mDialogBuildr.create();
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

