package mdsplambton.com.loginday3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
RadioButton rbMale,rbFemale;
RadioGroup rgGender;
Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle mBundle = getIntent().getExtras();
        String name =  mBundle.getString("Sohel");
        int id = mBundle.getInt("id");
        Toast.makeText(this, name + id, Toast.LENGTH_SHORT).show();

        rgGender = findViewById(R.id.rgGender);
        rbFemale = findViewById(R.id.rbFemale);
        rbMale = findViewById(R.id.rbMale);
        aSwitch = findViewById(R.id.switch1);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(R.id.rbMale == 1)
                Toast.makeText(HomeActivity.this, "Male", Toast.LENGTH_SHORT).show();

                if(R.id.rbFemale == 1)
                    Toast.makeText(HomeActivity.this, "Female", Toast.LENGTH_SHORT).show();
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(HomeActivity.this, "ON", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HomeActivity.this, "OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
