package instagram.downloader.com.doskaobyavleniya.dialoghelper;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.account.AccountHelper;


/**
 * Created by Евгений on 22.12.2022.
 */

public class DialogHelper {
    public Context context;
    public  Activity activity;
    public  AccountHelper accountHelper;
    public DialogHelper(Context con, Activity act) {
        context = con;
        activity = act;
    }
    public Context getContext() {
        return context;
    }
    public  Activity getActivity() {
        return activity;
    }
    //функция
    public void createSignDialog(final int index) {
        final AlertDialog.Builder mDialogBuildr = new AlertDialog.Builder(getActivity());
        LayoutInflater li = LayoutInflater.from(getActivity());
         View promptsView = li.inflate(R.layout.sign_dialog, null);
        mDialogBuildr.setView(promptsView);
        setDialogState(index, promptsView);


           final EditText editText1 = promptsView.findViewById(R.id.edSignEmail);
           final EditText editText2 = promptsView.findViewById(R.id.edSignPassword);
           final TextView tvDialogMessage = promptsView.findViewById(R.id.tvDialogMessage);
        Button button3 = promptsView.findViewById(R.id.btSignUpIn);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnClickSignUpIn(index);
            }

            public void setOnClickSignUpIn(int index) {
                // alertDialog.dismiss();
                if (index == DialogConst.SIGN_UP_STATE) {
                    if (editText1.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Ошибка", Toast.LENGTH_LONG).show();
                    } else {
                        String a = editText1.getText().toString();
                        String b = editText2.getText().toString();
                        // System.out.println(a);
                        accountHelper.signUpWithEmail(a, b);
                    }
                }

                        if (index == DialogConst.SIGN_IN_STATE)
                        {
                        if (editText1.getText().toString().isEmpty()) {
                            Toast.makeText(getContext(), "Ошибка", Toast.LENGTH_LONG).show();
                        } else {
                            String c = editText1.getText().toString();
                            String p = editText2.getText().toString();
                            accountHelper.signInWithEmail(c, p);
                        }
                        }
            }
        });

        //кнопка сброса пароля
        Button button4 = promptsView.findViewById(R.id.btForgetP);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///почитать
                accountHelper.mAuth.sendPasswordResetEmail(editText1.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getActivity(), R.string.email_reset_password_was_sent, Toast.LENGTH_LONG ).show();
                        }
                        else
                        {
                            tvDialogMessage.setVisibility(View.VISIBLE);
                        }
                    }


                });
            }
        });
        //
        SignInButton button5 = promptsView.findViewById(R.id.btGoogleSignIn);
//        Button button5 = promptsView.findViewById(R.id.btGoogleSignIn);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountHelper.signInWithGoogle();
            }
        });



            final AlertDialog alertDialog = mDialogBuildr.create();
            alertDialog.show();
    }

    private void setDialogState(int index, View promptsView) {
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
            Button btForgetP = promptsView.findViewById(R.id.btForgetP);
           btForgetP.setVisibility(View.VISIBLE);
        }
    }

}

