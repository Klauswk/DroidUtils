package rhcloud.com.droidutils.tabutil.tabutil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import rhcloud.com.droidutils.tabutil.tabutil.impl.TabServiceDefaultImpl;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.OnAddTab;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.TabService;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * Class that implements all the functions to simply work with {@link TabLayout}
 *
 * @since 1.0
 * @version 1.0
 */
public class Tab implements View.OnClickListener, OnAddTab{

    /**
     * Act has a holder to the views, extends {@link android.support.v4.view.ViewPager}
     */
    private TabBody tabBody;

    /**
     * The tab itself
     */
    private TabLayout tabLayout;

    private Context context;

    private TabService tabService;

    /**
     * Base constructor.
     * @param activity , must extends {@link FragmentActivity}
     * @param tabViewId , the view id of the {@link TabBody}
     * @param tabLayoutId , the view id of the {@link TabLayout}
     * @since 1.0
     * @version 1.0
     */
    public Tab(@NonNull FragmentActivity activity, @IdRes int tabViewId, @IdRes int tabLayoutId,TabService tabService){
        tabBody = (TabBody) activity.findViewById(tabViewId);
        tabBody.prepare(activity);
        tabLayout = (TabLayout) activity.findViewById(tabLayoutId);
        tabLayout.setupWithViewPager(tabBody);
        context = activity.getBaseContext();
        this.tabService = tabService;
    }

    /**
     * Base constructor.
     * @param activity , must extends {@link FragmentActivity}
     * @param tabBody , the {@link TabBody}
     * @param tabLayout , the {@link TabLayout}
     * @since 1.0
     * @version 1.0
     */
    public Tab(@NonNull FragmentActivity activity, @NonNull TabBody tabBody, @NonNull TabLayout tabLayout,TabService tabService){
        this.tabBody = tabBody;
        tabBody.prepare(activity);
        this.tabLayout = tabLayout;
        this.tabLayout.setupWithViewPager(tabBody);
        this.tabService = tabService;
    }


    /**
     * Base constructor.
     * @param activity , must extends {@link FragmentActivity}
     * @param tabViewId , the view id of the {@link TabBody}
     * @param tabLayoutId , the view id of the {@link TabLayout}
     * @since 1.0
     * @version 1.0
     */
    public Tab(@NonNull FragmentActivity activity, @IdRes int tabViewId, @IdRes int tabLayoutId){
       this(activity,tabViewId,tabLayoutId,null);

        this.tabService = new TabServiceDefaultImpl(this);
    }

    /**
     * Base constructor.
     * @param activity , must extends {@link FragmentActivity}
     * @param tabBody , the {@link TabBody}
     * @param tabLayout , the {@link TabLayout}
     * @since 1.0
     * @version 1.0
     */
    public Tab(@NonNull FragmentActivity activity, @NonNull TabBody tabBody, @NonNull TabLayout tabLayout){
        this(activity,tabBody,tabLayout,null);

        this.tabService = new TabServiceDefaultImpl(this);
    }
    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     *
     * @param activity
     * @param tabViewId
     * @param tabLayoutId
     * @return tab , a new {@link Tab} object.
     * @since 1.0
     * @version 1.0
     */
    public static Tab createTab(@NonNull FragmentActivity activity, @IdRes int tabViewId, @IdRes int tabLayoutId){
        Tab tab = new Tab(activity,tabViewId,tabLayoutId,null);
        tab.setTabService(new TabServiceDefaultImpl(tab));
        return tab;
    }

    /**
     * Getter for the {@link TabBody}
     * @return tabBody
     * @since 1.0
     * @version 1.0
     */
    public TabBody getTabBody() {
        return tabBody;
    }

    /**
     * Setter for the {@link TabBody}
     * @since 1.0
     * @version 1.0
     */
    public void setTabBody(TabBody tabBody) {
        this.tabBody = tabBody;
    }

    /**
     * Getter for the {@link TabLayout}
     * @return tabLayout
     * @since 1.0
     * @version 1.0
     */
    public TabLayout getTabLayout() {
        return tabLayout;
    }

    /**
     * Setter for the {@link TabLayout}
     * @since 1.0
     * @version 1.0
     */
    public void setTabLayout(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TabService getTabService() {
        return tabService;
    }

    public void setTabService(TabService tabService) {
        this.tabService = tabService;
    }

    /**
     * The base addTab method.
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param tabFragment , the {@link TabFragment} that will be added.
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull TabFragment tabFragment){
        tabService.getOnAddTab().addTab(tabFragment,-1);
        return this;
    }

    /**
     * The base addTab method.
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param tabFragment , the {@link TabFragment} that will be added.
     * @param position , the position to add the {@link TabFragment}, -1 will be add to the end
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull TabFragment tabFragment , int position){
        tabService.getOnAddTab().addTab(tabFragment,position);
        return this;
    }

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added. The title will be the {@link Class#getSimpleName()}
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment){
        tabService.getOnAddTab().addTab(new TabFragment(fragment), -1);
        return this;
    }

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added.
     * @param title , the title that will be added.
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title){
        tabService.getOnAddTab().addTab(fragment,title,null);
        return this;
    }

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added.
     * @param title , the title that will be added.
     * @param drawable , the {@link Drawable} that will be added to the top of the title
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title , @Nullable Drawable drawable){
        tabService.getOnAddTab().addTab(new TabFragment(fragment,title,drawable), -1);
        return this;
    }

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added. The title will be the {@link Class#getSimpleName()}
     * @param position , the position to add the {@link TabFragment}, -1 will be add to the end
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, int position){
        tabService.getOnAddTab().addTab(new TabFragment(fragment), position);
        return this;
    }

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added.
     * @param title , the title that will be added.
     * @param position , the position to add the {@link TabFragment}, -1 will be add to the end
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title, int position){
        tabService.getOnAddTab().addTab(fragment,title,null,position);
        return this;
    }

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added.
     * @param title , the title that will be added.
     * @param drawable , the {@link Drawable} that will be added to the top of the title
     * @param position , the position to add the {@link TabFragment}, -1 will be add to the end
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title , @Nullable Drawable drawable, int position){
        tabService.getOnAddTab().addTab(new TabFragment(fragment,title,drawable), position);
        return this;
    }

    @Override
    public void onClick(View view) {
        for(int i = 0; i < tabBody.getTabContainer().getCount() ; i++){
            if(tabLayout.getTabAt(i).getCustomView().getTag().equals(view.getTag())){
                removeTabAt(i);
                return;
            }
        }
    }

    /**
     * Remove and update a {@link TabFragment} at the <code>position</code>
     * @param position to be removed.
     * @return the fragment removed.
     */
    private TabFragment removeTabAt(int position) {
        return tabService.getOnTabRemove().removeTabAt(position);
    }

    /**
     * Remove the <code>fragment</code> from the {@link Tab}
     * @param fragment to be removed.
     * @return the removed fragment or null.
     */
    @Nullable
    public TabFragment removeTab(Fragment fragment){
        return tabService.getOnTabRemove().removeTab(fragment);
    }
}
