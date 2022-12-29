package instagram.downloader.com.doskaobyavleniya.account;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import instagram.downloader.com.doskaobyavleniya.MainActivity;
import instagram.downloader.com.doskaobyavleniya.R;



/**
 * Created by Евгений on 27.12.2022.
 */

public class AccountHelper {
    public  Activity activity;
    public static MainActivity mActivity;
    public static Context context;

    public AccountHelper(Context cont, Activity act, MainActivity mAc) {
        context = cont;
        activity = act;
        mActivity = mAc;
    }


///убрал статик
    public  Activity getActivity() {
        return activity;
    }



    public static MainActivity getMainActivity() {
        return mActivity;
    }


    //Сдесь ошибка   нужно исправить


   public static void signUpWithEmail(String email, String password) {
      //  String s = email;
   //     String s1 = password;
        Log.i("email", email);
        Log.i("password", password);
       // if (email.isEmpty() && password.isEmpty()) {
        //    Log.i("email", email);
        //    Log.i("password", password);

         //   getMainActivity().mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
         //       @Override
         //       public void onComplete(Task<AuthResult> task) {
         //           if (task.isSuccessful()) {
         //               sendEmailVerification(task.getResult().getUser());
         //               mActivity.uiUpdate(task.getResult().getUser());
         //           }
          //          else
          //          {
          //              Toast.makeText(getMainActivity(), "Не удалось зарегистрироваться", Toast.LENGTH_SHORT).show();
          //          }
          //      }
       //     });

     //   } else {
     //       Toast.makeText(getActivity(), "Не удалось зарегистрироваться", Toast.LENGTH_SHORT).show();

    //    }
    }


    //Вход
    public static   void signInWithEmail(String email, String password) {

            Log.i("emailVHOD", email);
            Log.i("passwordVHOD", password);

      //      getMainActivity().mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
   //             @Override
    //            public void onComplete(Task<AuthResult> task) {
      //              if (task.isSuccessful()) {
      //                  getMainActivity().uiUpdate(task.getResult().getUser());
    //                } else {
   //                     Toast.makeText(getMainActivity(), "Ошибка входа", Toast.LENGTH_SHORT).show();
   //                 }
 //               }
 //           });
 ///       }


   //     } else {
  //          Toast.makeText(getActivity(), "Не удалось зарегистрироваться", Toast.LENGTH_SHORT).show();

        }
    }


