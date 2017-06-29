package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yorhp.viewpager.R;

import java.util.ArrayList;

import myview.CyclePagerAdapter;

public class SimpleBannerAdapter extends CyclePagerAdapter {

    private ArrayList<String> images;
    private Context mContext;

    public SimpleBannerAdapter(Context context, ArrayList<String> images) {
        this.mContext = context;
        this.images = images;
    }

    @Override
    public int getRealCount() {
        return images.size();
    }

    @Override
    public View getViewAtRealPosition(final int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_papger, container, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
        Picasso.with(mContext).load(images.get(position%images.size())).into(imageView);
        return convertView;
    }
}