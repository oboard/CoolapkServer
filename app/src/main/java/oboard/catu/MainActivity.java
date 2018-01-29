package oboard.catu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.coolapk.market.util.AuthUtils;
import java.util.UUID;
import android.widget.EditText;

public class MainActivity extends Activity 
{
    
    EditText text;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (EditText)findViewById(R.id.text);
    }
    
    public void o(View view) {
        text.setText(AuthUtils.getAS(new ApplicationProxy(getApplication()), UUID.randomUUID().toString()));
    }
}
