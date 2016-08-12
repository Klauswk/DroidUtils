package rhcloud.com.testapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import rhcloud.com.droidutils.tabutil.tabutil.TabFragment;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabService;
import rhcloud.com.testapp.R;
import rhcloud.com.testapp.activity.MainActivity;

/**
 * A fragment with a Google +1 button.
 */
public class AddTabFragment extends Fragment implements View.OnClickListener{

    private Button btnAddNewTab;
    private TabService service;

    public static AddTabFragment getInstance(TabService service){
        AddTabFragment addTabFragment = new AddTabFragment();
        addTabFragment.setService(service);
        return addTabFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_tab_test, container, false);

        btnAddNewTab = (Button) view.findViewById(R.id.btnAddNewTab);
        btnAddNewTab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAddNewTab:
                TabFragment tabFragment = new TabFragment(BlankCloseableFragment.getInstance(service),"Closeable");
                service.getOnAddTab().addTab(tabFragment);
                break;
        }
    }

    public TabService getService() {
        return service;
    }

    public void setService(TabService service) {
        this.service = service;
    }
}
