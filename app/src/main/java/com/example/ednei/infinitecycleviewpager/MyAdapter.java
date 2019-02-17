package com.example.ednei.infinitecycleviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.ednei.infinitecycleviewpager.R;

public class MyAdapter extends PagerAdapter {

    private Context context;
    private int[]images ={
            R.drawable.ic_capa1,
            R.drawable.ic_capa2,
            R.drawable.ic_capa3,
    };
    LayoutInflater layoutInflater;

    public MyAdapter(Context context){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = null;
        try{
            view = layoutInflater.inflate(R.layout.myadapter, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(images[position]);
            container.addView(view);
        }catch (Exception e){
            e.printStackTrace();; 
            Log.e("MyAdapaterLog","Error"+e.getMessage());
        }

        return view;
    }
}
