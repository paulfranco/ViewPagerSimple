package co.paulfran.paulfranco.viewpagersimple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomPagerAdapter extends PagerAdapter{

    private static final String TAG = CustomPagerAdapter.class.getSimpleName();

    private Context context;
    private List<DataModel> itemList;

    private LayoutInflater inflater;

    public CustomPagerAdapter(Context context, List<DataModel> itemList) {

            this.context = context;
            this.itemList = itemList;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // This method returns the count of itemList
    @Override
    public int getCount() {
        return itemList.size();
    }

    // This method checks whether View is associated with object or Object is associated with Page View i.e. view or not
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    // This method is responsible to instatiating each of the items present inside the ViewPager
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Log.i(TAG, "Instatiation for position " + position + " [Item " + (position+1) + "]");

        // Get the View of the single View Pager Item
        View itemView = inflater.inflate(R.layout.viewpager_item, container, false);

        // Locate the ImageView and TextView
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        TextView textView = (TextView) itemView.findViewById(R.id.textViewItem);

        // Get the DataModel for the current position
        DataModel dataModel = itemList.get(position);

        // Set the Data for the Image and Text
        imageView.setImageResource(dataModel.imageId);
        textView.setText(dataModel.title);

        // Add viewpager_item.xml to View Pager
        container.addView(itemView);

        return itemView;
    }

    @Override
    // Object is itemView
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.i(TAG, "Destroy Item at position " + position + " [Item " + (position+1) + "]");
        // Remove view of viewpager_item.xml from ViewPager container
        container.removeView((FrameLayout) object);
    }



}
