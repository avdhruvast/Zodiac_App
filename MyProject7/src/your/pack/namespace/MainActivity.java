package your.pack.namespace;

import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnKeyListener,OnClickListener 
{
	EditText et,et1;
	TextView tv;
	Button b1,b2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et=(EditText)findViewById(R.id.editText1);
        et1=(EditText)findViewById(R.id.editText2);
        et.setOnKeyListener(this);
        tv=(TextView)findViewById(R.id.textView1);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }
    String msg,cnt;
    public class MyThread extends Thread
    {
    	@Override
    	public void run() {
    		try{
    		msg=msg.replace(" ", "%20");	
    		String url="http://api.mvaayoo.com/mvaayooapi/MessageCompose?user=tanmays321@gmail.com:tanmay@123&senderID=TEST%20SMS&receipientno="+cnt+"&dcs=0&msgtxt="+msg+"&state=4";
    		URL u=new URL(url);
    		u.openStream();
    		}catch(Exception e)
    		{
    			System.out.println("Exception is "+e);
    		}
    	}
    }
    public void onClick(View arg0) 
    {
    	if(arg0==b1){
    		msg=et.getText().toString();
    		cnt=et1.getText().toString();
    		new MyThread().start();
    		Toast.makeText(this, "Message Sent", Toast.LENGTH_LONG).show();
    	
    	}else if(arg0==b2){
    		finish();
    	}
    }
    public boolean onKey(View arg0, int arg1,
    		KeyEvent arg2) {
    	String s=et.getText().toString();
    	int len=s.length();
    	tv.setText(len+"/160");
    	return true;
    		
    }
}