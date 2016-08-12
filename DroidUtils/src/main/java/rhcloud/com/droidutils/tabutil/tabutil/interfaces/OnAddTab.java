package rhcloud.com.droidutils.tabutil.tabutil.interfaces;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import rhcloud.com.droidutils.tabutil.tabutil.Tab;
import rhcloud.com.droidutils.tabutil.tabutil.TabFragment;

/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */

public interface OnAddTab {

    /**
     * The base addTab method.
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param tabFragment , the {@link TabFragment} that will be added.
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull TabFragment tabFragment);

    /**
     * The base addTab method.
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param tabFragment , the {@link TabFragment} that will be added.
     * @param position , the position to add the {@link TabFragment}, -1 will be add to the end
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull TabFragment tabFragment , int position);

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added. The title will be the {@link Class#getSimpleName()}
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment);

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added.
     * @param title , the title that will be added.
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title);

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added.
     * @param title , the title that will be added.
     * @param drawable , the {@link Drawable} that will be added to the top of the title
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title , @Nullable Drawable drawable);

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added. The title will be the {@link Class#getSimpleName()}
     * @param position , the position to add the {@link TabFragment}, -1 will be add to the end
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, int position);

    /**
     * A <a href="http://www.tutorialspoint.com/design_pattern/factory_pattern.htm">Factory pattern</a> method to create a {@link Tab}
     * @param fragment , the {@link Fragment} that will be added.
     * @param title , the title that will be added.
     * @param position , the position to add the {@link TabFragment}, -1 will be add to the end
     * @since 1.0
     * @version 1.0
     * @return tab
     */
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title, int position);

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
    public Tab addTab(@NonNull Fragment fragment, @Nullable String title , @Nullable Drawable drawable, int position);
}
