package com.example.kidseduc.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kidseduc.R;
import com.example.kidseduc.controllers.LessonController;
import com.example.kidseduc.controllers.UserController;
import com.example.kidseduc.models.Lesson;
import com.example.kidseduc.utils.LessonListAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LessonListActivity extends AppCompatActivity {
    private LessonController lessonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);
        try{
            init();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void init()throws Exception{
        lessonController = LessonController.getLessonController();
        lessonController.setContext(this);
        lessonController.getLessonList(getString(R.string.app_api) + getString(R.string.app_api_lessons));
    }

    public void showList(){
        final ListView listView = (ListView) findViewById(R.id.lesson_list);
        listView.setAdapter(new LessonListAdapter(this, lessonController.getLessons()));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Lesson lesson = (Lesson) o;
                Intent intent = new Intent(LessonListActivity.this, LoginActivity.class);
                if(lesson.isPicture()){
                    intent = new Intent(LessonListActivity.this, PictureActivity.class);
                }
                if(lesson.isVideo()){
                    intent = new Intent(LessonListActivity.this, VideoActivity.class);
                }
                if(lesson.isWeb()){
                    intent = new Intent(LessonListActivity.this, HtmlActivity.class);
                }
                intent.putExtra("LESSON",(Serializable) lesson);
                startActivity(intent);
                Toast.makeText(LessonListActivity.this, "Selected :" + " " + lesson, Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Lesson> getListData() {
        List<Lesson> list = new ArrayList<Lesson>();
        Lesson chiffres = new Lesson("Les Chiffres", "image", " 1,2,3,4,5,6,7,...","blablabla");
        Lesson couleurs = new Lesson("Les couleurs", "video", "rouge, vert, bleu","blablbla");
        Lesson pays = new Lesson("Les pays","html",  "Madagascar, France,...", "blablblabl");

        list.add(chiffres);
        list.add(couleurs);
        list.add(pays);

        return list;
    }
}