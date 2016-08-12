package rhcloud.com.testapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import rhcloud.com.droidutils.tabutil.tabutil.TabFragment;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.Closeable;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.FocusOnAdd;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabService;
import rhcloud.com.testapp.R;
import rhcloud.com.testapp.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankCloseableFragment extends Fragment implements Closeable, View.OnClickListener, FocusOnAdd {

    private Button btnCloseTab;

    private TabService service;

    public static BlankCloseableFragment getInstance(TabService service){
        BlankCloseableFragment blankCloseableFragment = new BlankCloseableFragment();
        blankCloseableFragment.setService(service);
        return blankCloseableFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank_closeable, container, false);
        btnCloseTab = (Button) v.findViewById(R.id.btnCloseTab);
        btnCloseTab.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCloseTab:
                service.getOnTabRemove().removeTab(this);
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
