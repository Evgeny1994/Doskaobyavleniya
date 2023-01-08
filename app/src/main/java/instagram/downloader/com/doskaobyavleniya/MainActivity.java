package instagram.downloader.com.doskaobyavleniya;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import instagram.downloader.com.doskaobyavleniya.account.AccountHelper;
import instagram.downloader.com.doskaobyavleniya.dialoghelper.DialogConst;
import instagram.downloader.com.doskaobyavleniya.dialoghelper.DialogHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Context context;
    public static TextView textView;
    public static Resources res;

    DialogHelper nc = new DialogHelper(this, this);
    AccountHelper accountHelper = new AccountHelper(this,this, this);
    public FirebaseAuth mAuth = FirebaseAuth.getInstance();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = findViewById(R.id.tvAccountEmail);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();
        MainActivity.context = getApplicationContext();
       // APP_NAME = getResources().getString(R.string.default_web_client_id);
        res = getResources();




        //  FloatingActionButton fab =  findViewById(R.id.fab);
        //     fab.setOnClickListener(new View.OnClickListener() {
        //          @Override
        //          public void onClick(View view) {
        //              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                      .setAction("Action", null).show();
        //          }
        //       });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //добавлено


        View header =navigationView.getHeaderView(0);
        textView = header.findViewById(R.id.tvAccountEmail);

    }

  public static Resources getRes() {
        return res;
  }


    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == accountHelper.signInRequestCode)
        {
           // Log.d("myLog","Sign in result");
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

                GoogleSignInAccount account = null;
                try {
                    account = task.getResult(ApiException.class);
                } catch (ApiException e) {
                    e.printStackTrace();
                }
                if (account != null) {
                    AccountHelper.signInFirebaseWithGoogle(account.getIdToken());
                }
            }
        else {
            Log.d("myLog","fatal Exception");
        }



        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart() {
        super.onStart();
    uiUpdate(mAuth.getCurrentUser());
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public static Context getContext() {
        return MainActivity.context;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.id_my_ads) {
            Toast toast = Toast.makeText(getApplicationContext(), "Вы нажали кнопку 1", Toast.LENGTH_LONG);
            toast.show();

        } else if (id == R.id.id_my_car) {

        } else if (id == R.id.id_pc) {

        } else if (id == R.id.id_my_smart) {

        } else if (id == R.id.id_dm) {

        } else if (id == R.id.id_sign_up) {

            nc.createSignDialog(DialogConst.SIGN_UP_STATE);


        } else if (id == R.id.id_sign_in) {

            nc.createSignDialog(DialogConst.SIGN_IN_STATE);

        } else if (id == R.id.id_sign_out) {
            uiUpdate(null);
            mAuth.signOut();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    public static   void uiUpdate(FirebaseUser user) {
        if (user != null)
        {
            textView.setText(user.getEmail());
        }
        else
        {
            textView.setText("Войдите или зарегистрируйтесь");
        }

    }


}

