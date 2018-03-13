package myapp.com.zodiacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        Intent intn=getIntent();
        Bundle b=intn.getExtras();
        String sign=b.getString("sign");
        String horoscope=b.getString("horoscope");
        tv=(TextView)findViewById(R.id.textView);
        iv=(ImageView)findViewById(R.id.imageView13);
        tv.setText(horoscope);
        updateImage(sign);
    }
    void updateImage(String sign){
        switch (sign){
            case "Aries":
                iv.setImageResource(R.drawable.xaries_horoscope);
                break;
            case "Aquarius":
                iv.setImageResource(R.drawable.xaquarius_horoscope);
                break;
            case "Cancer":
                iv.setImageResource(R.drawable.xcancer_horoscope);
                break;
            case "Capricorn":
                iv.setImageResource(R.drawable.xcapricorn_horoscope);
                break;
        }
    }
}
