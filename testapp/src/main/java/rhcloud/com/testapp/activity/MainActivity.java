package rhcloud.com.testapp.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rhcloud.com.droidutils.tabutil.tabutil.Tab;
import rhcloud.com.droidutils.tabutil.tabutil.TabFragment;
import rhcloud.com.testapp.R;
import rhcloud.com.testapp.fragment.AddTabFragment;
import rhcloud.com.testapp.fragment.TestFragment;

public class MainActivity extends AppCompatActivity {

    private Tab tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createMainTab();
    }

    private void createMainTab(){
        tab = new Tab(this,R.id.tabBody,R.id.tabLayout);
        tab.addTab(new TestFragment(),"Expenses").addTab(AddTabFragment.getInstance(tab.getTabService()),"Add Tab",getResources().getDrawable(android.R.drawable.ic_menu_add));
    }

    public void addTab(TabFragment tabFragment){
        tab.addTab(tabFragment);
    }

    public void removeTab(Fragment fragment){
        tab.removeTab(fragment);
    }
}
