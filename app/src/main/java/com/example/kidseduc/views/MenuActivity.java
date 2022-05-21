package com.example.kidseduc.views;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kidseduc.NavbarActivity;
import com.example.kidseduc.R;

import java.io.Serializable;

public class MenuActivity extends Fragment {
    ImageView lesson_item;
    ImageView quizz_item;
    ImageView extra_item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_menu, null);
        lesson_item = (ImageView) root.findViewById(R.id.lesson_item);
        quizz_item = (ImageView) root.findViewById(R.id.quizz_item);
        extra_item = (ImageView) root.findViewById(R.id.extra_item);
        lessonListener();
        return root;

    }

    /**
     * Ecoute évènement sur le boutton lesson
     */
    private void lessonListener(){
        lesson_item.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("Click Lesson", "lessons's list");
                Intent intent = new Intent(getActivity(), LessonListActivity.class);
               // intent.putExtra("destination",(Serializable) new MenuActivity());
                startActivity(intent);
            }
        });
    }



}