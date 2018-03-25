package guohuayu.com.goslinglovelaceapplicationbasic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tv_abstrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_abstrat = findViewById(R.id.tv_abstrat);
        tv_abstrat.setMovementMethod(new ScrollingMovementMethod());

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("ben", Context.MODE_PRIVATE); //create a SharedPreferences object
        String LAN =sharedPreferences.getString("language","");//Get the corresponding data based on key

        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Log.i("language————————",language);
        if(!language.equals("")){
            if(!LAN.equals(language)){
                freshView();//restart MainActivity

            }
        }
        showLanguage(language);
    }

    private void freshView(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    protected void showLanguage(String language) {
        //Setting application language types
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (language.equals("zh")) {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        } else {
            config.locale = Locale.ENGLISH;
        }
        resources.updateConfiguration(config, dm);

        //保存设置语言的类型
        SharedPreferences sharedPreferences = getSharedPreferences("ben", Context.MODE_PRIVATE);//Create SharedPreferences objects
        SharedPreferences.Editor editor = sharedPreferences.edit(); //get the edit object of SharedPreferences
        //Save the type of the set language
        editor.putString("language", language); //Write data to preferences:
        editor.commit();// Submit data to the preferences file:
    }

}
