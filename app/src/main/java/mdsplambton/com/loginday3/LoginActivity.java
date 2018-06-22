package mdsplambton.com.loginday3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
private EditText edtUserName;
private EditText edtPassword;
private Button btnLogin;
private CheckBox chkRememberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        SharedPreferences msharedPreferences =this.getSharedPreferences("myPref",MODE_PRIVATE);
        final SharedPreferences.Editor mEditor = msharedPreferences.edit();
    if(msharedPreferences.getString("userid",null) != null){
        edtUserName.setText(msharedPreferences.getString("userid",null));
        edtUserName.setText(msharedPreferences.getString("password",null));
        chkRememberMe.setChecked(true);
    }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if(userName.equals("admin")&&password.equals("admin101"))
                {if (chkRememberMe.isChecked()) {
                    mEditor.putString("userid", userName);
                    mEditor.putString("password", password);
                    //mEditor.commit();

                }
                else {
                    mEditor.remove("userid");
                    mEditor.remove("password");
                }
                    mEd
                    itor.apply();
                    Toast.makeText(getApplicationContext(),"Login Sucess",Toast.LENGTH_LONG).show();
                    Intent mIntent = new Intent(LoginActivity.this,HomeActivity.class);
                    mIntent.putExtra("Name","Sohel Mohammed");
                    mIntent.putExtra("email","mdsp@gmail.com");

                    startActivity(mIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        chkRememberMe = findViewById(R.id.ckRememberMe);
    }
}
