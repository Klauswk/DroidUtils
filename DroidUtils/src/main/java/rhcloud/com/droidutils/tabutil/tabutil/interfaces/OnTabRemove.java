package rhcloud.com.droidutils.tabutil.tabutil.interfaces;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import rhcloud.com.droidutils.tabutil.tabutil.Tab;
import rhcloud.com.droidutils.tabutil.tabutil.TabFragment;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */

public interface OnTabRemove {

    /**
     * Remove and update a {@link TabFragment} at the <code>position</code>
     * @param position to be removed.
     * @return the fragment removed.
     */
    public TabFragment removeTabAt(int position);

    /**
     * Remove the <code>fragment</code> from the {@link Tab}
     * @param fragment to be removed.
     * @return the removed fragment or null.
     */
    @Nullable
    public TabFragment removeTab(Fragment fragment);
}
