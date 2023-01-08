package instagram.downloader.com.doskaobyavleniya.account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

import instagram.downloader.com.doskaobyavleniya.MainActivity;
import instagram.downloader.com.doskaobyavleniya.R;


/**
 * Created by Евгений on 27.12.2022.
 */

public class AccountHelper {
  public static Context context;
  public static Activity activity;
  public static MainActivity mainActivity;
    public static int signInRequestCode;
    public static FirebaseAuth mAuth = FirebaseAuth.getInstance();


    public AccountHelper(Context con, Activity act, MainActivity main) {
        context = con;
        activity = act;
        mainActivity = main;
    }
    public static Context getContext() {
        return context;
    }



    public static Activity getActivity() {
        return activity;
    }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }


    //Регистрация
   public static void signUpWithEmail(String email, String password) {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        sendEmailVerification(task.getResult().getUser());
                       getMainActivity().uiUpdate(task.getResult().getUser());
                    }
                    else
                    {
                        Toast.makeText(MainActivity.getContext(), "Не удалось зарегистрироваться",Toast.LENGTH_LONG).show();
                    }
                }

                private void sendEmailVerification(FirebaseUser user) {
                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.getContext(), getMainActivity().getResources().getString(R.string.sign_verification_done), Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(MainActivity.getContext(), getMainActivity().getResources().getString(R.string.send_verification_error), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            });
    }

    public static GoogleSignInClient getSignInClient() {
        //default_web_view
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(MainActivity.getRes().getString(R.string.default_web_client_id)).build();
        return GoogleSignIn.getClient(MainActivity.context,gso);
    }

    public static void signInWithGoogle() {
       GoogleSignInClient signInClient = getSignInClient();
        Intent intent = signInClient.getSignInIntent();
       getActivity().startActivityForResult(intent,signInRequestCode);
    }

    public static void signInFirebaseWithGoogle(String token) {
        AuthCredential credential = GoogleAuthProvider.getCredential(token, null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(MainActivity.getContext(),"Sign in done", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    //Вход
    public static void signInWithEmail(String email, String password) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        MainActivity.uiUpdate(task.getResult().getUser());

                    } else {
                        Toast.makeText(MainActivity.getContext(), "Неудалось войти", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


