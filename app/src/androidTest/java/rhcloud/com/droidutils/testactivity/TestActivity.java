package rhcloud.com.droidutils.testactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rhcloud.com.droidutils.tabutil.tabutil.Tab;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */

public final class TestActivity extends AppCompatActivity {

    private Tab tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(rhcloud.com.droidutils.test.R.layout.activity_main);

        if(savedInstanceState == null){
            createMainTab();
        }
    }

    private void createMainTab(){
        tab = Tab.createTab(this, rhcloud.com.droidutils.test.R.id.tabLayout,rhcloud.com.droidutils.test.R.id.tabBody);
    }
}
