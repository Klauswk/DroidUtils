package rhcloud.com.droidutils.tabutil.tabutil.impl;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import rhcloud.com.droidutils.tabutil.tabutil.Tab;
import rhcloud.com.droidutils.tabutil.tabutil.TabBody;
import rhcloud.com.droidutils.tabutil.tabutil.TabFragment;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.OnAddTab;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabHeaderUpdater;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */

public class OnAddTabDefaultImpl implements OnAddTab {

    private TabBody tabBody;
    private TabHeaderUpdater updateTabHeader;

    public OnAddTabDefaultImpl(TabBody tabBody, TabHeaderUpdater updateTabHeader) {
        this.tabBody = tabBody;
        this.updateTabHeader = updateTabHeader;
    }

    @Override
    public Tab addTab(@NonNull TabFragment tabFragment){
        return addTab(tabFragment,-1);
    }

    @Override
    public Tab addTab(@NonNull TabFragment tabFragment , int position){
        tabBody.addTab(tabFragment,position);
        updateTabHeader.updateTabHeader();
        return null;
    }

    @Override
    public Tab addTab(@NonNull Fragment fragment){
        return addTab(new TabFragment(fragment), -1);
    }

    @Override
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title){
        return addTab(fragment,title,null);
    }

    @Override
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title , @Nullable Drawable drawable){
        return addTab(new TabFragment(fragment,title,drawable), -1);
    }

    @Override
    public Tab addTab(@NonNull Fragment fragment, int position){
        return addTab(new TabFragment(fragment), position);
    }

    @Override
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title, int position){
        return addTab(fragment,title,null,position);
    }

    @Override
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title , @Nullable Drawable drawable, int position){
        return addTab(new TabFragment(fragment,title,drawable), position);
    }

}
