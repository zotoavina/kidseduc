package com.example.kidseduc.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kidseduc.R;
import com.example.kidseduc.models.Lesson;

import java.util.List;

public class LessonListAdapter extends BaseAdapter {

    private List<Lesson> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public LessonListAdapter(Context aContext,  List<Lesson> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_lesson_item, null);
            holder = new ViewHolder();
            holder.lessonImage = (ImageView) convertView.findViewById(R.id.lesson_image);
            holder.lessonTitle = (TextView) convertView.findViewById(R.id.lesson_title);
            holder.lessonDescription = (TextView) convertView.findViewById(R.id.lesson_description);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Lesson lesson = this.listData.get(position);
        holder.lessonTitle.setText(lesson.getTitle());
        holder.lessonDescription.setText("Description: " + lesson.getDescription());

        int imageId = this.getMipmapResIdByName(lesson.getType());

        holder.lessonImage.setImageResource(imageId);

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.d("CustomListView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    static class ViewHolder {
        ImageView lessonImage;
        TextView lessonTitle;
        TextView lessonDescription;
    }

}
