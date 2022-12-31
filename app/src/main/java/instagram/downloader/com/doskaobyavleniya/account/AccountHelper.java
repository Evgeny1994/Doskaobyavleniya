package instagram.downloader.com.doskaobyavleniya.account;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import instagram.downloader.com.doskaobyavleniya.MainActivity;



/**
 * Created by Евгений on 27.12.2022.
 */

public class AccountHelper {
    public static Activity activity;
    public static MainActivity mActivity;
    public static Context context;
    public static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public AccountHelper(Context cont, Activity act, MainActivity mAc) {
        context = cont;
        activity = act;
        mActivity = mAc;
    }


    public static Context getContext() {
        return AccountHelper.context;
    }

    public static Context setContext() {
        return context;
    }

///убрал статик
    public static Activity getActivity() {
        return activity;
    }



    public static MainActivity getMainActivity() {
        return mActivity;
    }


    //Сдесь ошибка   нужно исправить


   public static void signUpWithEmail(String email, String password) {
        Log.i("email", email);
       Log.i("password", password);

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                       // Toast.makeText(getMainActivity(), "Успешно ", Toast.LENGTH_SHORT).show();
         //               sendEmailVerification(task.getResult().getUser());
         //               mActivity.uiUpdate(task.getResult().getUser());
                        System.out.println("Успешно");
                    }
                    else
                    {
                      //Log.i("Ошібка","");
                        Toast toast = Toast.makeText(AccountHelper.context,"Не удалось зарегистрироваться", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            });
    }


    //Вход
    public static   void signInWithEmail(String email, String password) {

            Log.i("emailVHOD", email);
            Log.i("passwordVHOD", password);

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        System.out.println("Успешно");

                       // Toast.makeText(getMainActivity(), "Успешно", Toast.LENGTH_SHORT).show();
                      //  getMainActivity().uiUpdate(task.getResult().getUser());
                    } else {
                        System.out.println("ошибка входа");
                       // Toast.makeText(getMainActivity(), "Ошибка входа", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


