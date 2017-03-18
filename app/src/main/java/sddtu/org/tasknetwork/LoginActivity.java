package sddtu.org.tasknetwork;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Dell on 3/16/2017.
 */

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    Button signIn;
    SignInButton googlesignin;
    GoogleApiClient googleApiClient;
    String googlename;
    String email;
    String img_url;
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();

        signIn=(Button)findViewById(R.id.signin);
        googlesignin = (SignInButton) findViewById(R.id.google_butt);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        googlesignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleResult(GoogleSignInResult googleSignInResult) {
        Log.d("TAG", "handleSignInResult:" + googleSignInResult.isSuccess());
        if (googleSignInResult.isSuccess()) {
            GoogleSignInAccount acct = googleSignInResult.getSignInAccount();
            googlename = acct.getDisplayName();
            email = acct.getEmail();
            img_url = acct.getPhotoUrl().toString();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("Name",googlename);
            intent.putExtra("Email",email);
            intent.putExtra("ImageUrl",img_url);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"This is not a valid Google Account",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(),connectionResult.getErrorMessage(),Toast.LENGTH_LONG).show();

    }
}
