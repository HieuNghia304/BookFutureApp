package com.example.bookfuture.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bookfuture.Model.Photo;
import com.example.bookfuture.R;
import java.util.List;

import com.example.bookfuture.Model.Photo;

public class PhotoAdapter extends PagerAdapter {

    private List<Photo> mListPhoto;

    public PhotoAdapter(List<Photo> mListPhoto) {
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imgPhoto = view.findViewById(R.id.item_photo);
        Photo photo = mListPhoto.get(position);
        imgPhoto.setImageResource(photo.getResourceId());
        //add view
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(mListPhoto!=null)
            return mListPhoto.size();
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
