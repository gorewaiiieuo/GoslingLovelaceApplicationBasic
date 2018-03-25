package guohuayu.com.goslinglovelaceapplicationbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_abstrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_abstrat = findViewById(R.id.tv_abstrat);
        tv_abstrat.setMovementMethod(new ScrollingMovementMethod());
    }
}
