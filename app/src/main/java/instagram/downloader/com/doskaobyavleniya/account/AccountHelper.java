package instagram.downloader.com.doskaobyavleniya.account;
import android.content.Context;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import instagram.downloader.com.doskaobyavleniya.R;
import static instagram.downloader.com.doskaobyavleniya.dialoghelper.DialogHelper.getActivity;


/**
 * Created by Евгений on 27.12.2022.
 */

public class AccountHelper {

   // public static Activity activity;
    public static Context context;
    public static FirebaseAuth mAuth;





    public AccountHelper(Context con) {
        context = con;
    }


 //   public static Activity getActivity() {
 //       return activity;
 //   }

    public static Context getContext() {
        return context;
    }

 //   public static Activity getActivity() {
 //       return activity;
 //   }









    public static void signUpWithEmail(String email, String password) {
        if (email.isEmpty() && password.isEmpty())
        {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    ///СВоя реалізація

                }
            });

        }
        else
        {
            Toast.makeText(getActivity(),"Не удалось зарегистрироваться", Toast.LENGTH_SHORT).show();
        }
    }

    public static void signInWithEmail(String email, String password) {
        if (email.isEmpty() && password.isEmpty())
        {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    /////Своя реадізація

                }
            });

        }
        else
        {
            Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.sign_in_error), Toast.LENGTH_SHORT).show();
        }
    }
}
