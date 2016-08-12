package rhcloud.com.droidutils.tabutil.tabutil.impl;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.List;

import rhcloud.com.droidutils.tabutil.tabutil.TabBody;
import rhcloud.com.droidutils.tabutil.tabutil.TabFragment;
import rhcloud.com.droidutils.tabutil.tabutil.TabHeaderView;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.OnTabRemove;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabHeaderUpdater;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */
public class OnTabRemoveDefaultImpl implements OnTabRemove {

    private TabBody tabBody;
    private Context context;
    private List<TabHeaderView> listOfHeaders;
    private TabHeaderUpdater tabHeaderUpdater;

    public OnTabRemoveDefaultImpl(Context context, TabBody tabBody,List<TabHeaderView> listOfHeaders, TabHeaderUpdater tabHeaderUpdater) {
        this.tabBody = tabBody;
        this.context = context;
        this.listOfHeaders = listOfHeaders;
        this.tabHeaderUpdater = tabHeaderUpdater;
    }

    @Override
    public TabFragment removeTabAt(int position) {
        TabFragment removed = tabBody.getTabContainer().removeTabAt(position);
        listOfHeaders.remove(position);
        tabHeaderUpdater.updateTabHeader();
        tabBody.setCurrentItem(position == 0 ? 0 : --position);
        return removed;
    }

    @Nullable
    @Override
    public TabFragment removeTab(Fragment fragment) {
        for(int i = 0; i < tabBody.getTabContainer().getCount() ; i++){
            if(tabBody.getTabContainer().getItem(i).hashCode() == fragment.hashCode()){
                return removeTabAt(i);
            }
        }
        return null;
    }
}
