package rhcloud.com.droidutils.tabutil.tabutil.impl;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.View;

import java.util.List;

import rhcloud.com.droidutils.tabutil.tabutil.TabBody;
import rhcloud.com.droidutils.tabutil.tabutil.TabHeaderView;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabHeaderUpdater;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */

public class TabHeaderUpdaterDefaultImpl implements TabHeaderUpdater {

    /**
     * Act has a holder to the views, extends {@link android.support.v4.view.ViewPager}
     */
    private TabBody tabBody;

    /**
     * The tab itself
     */
    private TabLayout tabLayout;
    private Context context;
    private List<TabHeaderView> listOfHeaders;
    private View.OnClickListener closeable;

    public TabHeaderUpdaterDefaultImpl(Context context, TabBody tabBody, TabLayout tabLayout, List<TabHeaderView> listOfHeaders, View.OnClickListener closeable) {
        this.tabBody = tabBody;
        this.tabLayout = tabLayout;
        this.context = context;
        this.listOfHeaders = listOfHeaders;
        this.closeable = closeable;
    }

    @Override
    public void updateTabHeader() {
        for(int i = 0; i < tabBody.getTabContainer().getCount() ; i++){
            if(listOfHeaders.size() <= i){
                TabHeaderView tabView = new TabHeaderView(context, tabBody.getTabContainer().getTabFragment(i), closeable);
                listOfHeaders.add(tabView);
                tabLayout.getTabAt(i).setCustomView(tabView);
            }else{
                tabLayout.getTabAt(i).setCustomView(listOfHeaders.get(i));
            }
        }
    }
}
