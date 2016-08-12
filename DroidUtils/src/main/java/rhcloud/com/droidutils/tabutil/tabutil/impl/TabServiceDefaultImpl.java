package rhcloud.com.droidutils.tabutil.tabutil.impl;

import java.util.ArrayList;
import java.util.List;

import rhcloud.com.droidutils.tabutil.tabutil.Tab;
import rhcloud.com.droidutils.tabutil.tabutil.TabHeaderView;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.OnAddTab;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.OnTabRemove;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabHeaderUpdater;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabService;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */
public class TabServiceDefaultImpl implements TabService {

    private OnAddTab onAddTab;
    private OnTabRemove onTabRemove;

    public TabServiceDefaultImpl(Tab tab) {

        List<TabHeaderView> tabHeaderViews = new ArrayList<>();
        TabHeaderUpdater tabHeaderUpdater = new TabHeaderUpdaterDefaultImpl(tab.getContext(),tab.getTabBody(),tab.getTabLayout(),tabHeaderViews,tab);
        this.onAddTab = new OnAddTabDefaultImpl(tab.getTabBody(),tabHeaderUpdater);
        this.onTabRemove= new OnTabRemoveDefaultImpl(tab.getContext(),tab.getTabBody(),tabHeaderViews,tabHeaderUpdater);
    }

    @Override
    public OnAddTab getOnAddTab() {
        return onAddTab;
    }

    @Override
    public OnTabRemove getOnTabRemove() {
        return onTabRemove;
    }

}
