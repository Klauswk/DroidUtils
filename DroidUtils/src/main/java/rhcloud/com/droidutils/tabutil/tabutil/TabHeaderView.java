package rhcloud.com.droidutils.tabutil.tabutil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import rhcloud.com.droidutils.R;
import rhcloud.com.droidutils.tabutil.tabutil.interfaces.Closeable;


/**
 * @author <a href="https://github.com/Klauswk">Klaus Klein</a>
 * @version 1.0
 * @since 1.0
 */

public class TabHeaderView extends LinearLayout {

    private TextView tvTitle;
    private ImageView ivIcon;
    private ImageButton ibClose;
    private OnClickListener onClosePressed;

    public TabHeaderView(@NonNull Context context) {
        super(context);
        setTag(this);
    }

    public TabHeaderView(@NonNull Context context, @NonNull TabFragment tabFragment) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.droidutils_tab_view, this);

        ivIcon = (ImageView) findViewById(R.id.icon);
        tvTitle = (TextView) findViewById(R.id.text1);
        ibClose = (ImageButton) findViewById(R.id.ibClose);

        if (tabFragment.getTitle() == null) {
            throw new NullPointerException("Title can't be null");
        }

        tvTitle.setText(tabFragment.getTitle());

        if (tabFragment.getDrawable() != null) {
            ivIcon.setImageDrawable(tabFragment.getDrawable());
        } else {
            ivIcon.setVisibility(View.GONE);
        }

        if (tabFragment.getFragment() == null) {
            throw new NullPointerException("Fragment can't be null");
        }

        ibClose.setVisibility(tabFragment.getFragment() instanceof Closeable ? View.VISIBLE : View.GONE);
        setTag(hashCode());

        tabFragment.setTabHeaderView(this);
    }

    public TabHeaderView(@NonNull Context context, @NonNull TabFragment tabFragment, @Nullable OnClickListener onClosePressed) {
        this(context, tabFragment);
        if(onClosePressed != null){
            setOnClosePressed(onClosePressed);
        }
    }

    public TabHeaderView(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
    }

    public ImageView getIvIcon() {
        return ivIcon;
    }

    public void setIvIcon(ImageView ivIcon) {
        this.ivIcon = ivIcon;
    }

    public ImageButton getIbClose() {
        return ibClose;
    }

    public void setIbClose(ImageButton ibClose) {
        this.ibClose = ibClose;
    }

    public OnClickListener getOnClosePressed() {
        return onClosePressed;
    }

    public void setOnClosePressed(OnClickListener onClosePressed) {
        this.onClosePressed = onClosePressed;
        if (ibClose.getVisibility() == View.VISIBLE) {
            ibClose.setTag(getTag());
            ibClose.setOnClickListener(onClosePressed);
        }
    }
}
