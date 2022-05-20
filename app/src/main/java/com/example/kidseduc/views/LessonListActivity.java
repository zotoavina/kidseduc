package com.example.kidseduc.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kidseduc.R;
import com.example.kidseduc.models.Lesson;
import com.example.kidseduc.utils.LessonListAdapter;

import java.util.ArrayList;
import java.util.List;

public class LessonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        List<Lesson> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.lesson_list);
        listView.setAdapter(new LessonListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Lesson lesson = (Lesson) o;
                Toast.makeText(LessonListActivity.this, "Selected :" + " " + lesson, Toast.LENGTH_LONG).show();
            }
        });
    }
    private List<Lesson> getListData() {
        List<Lesson> list = new ArrayList<Lesson>();
        Lesson chiffres = new Lesson("Les Chiffres", " 1,2,3,4,5,6,7,...", "image","blablabla");
        Lesson couleurs = new Lesson("Les couleurs", "rouge, vert, bleu", "video","blablbla");
        Lesson pays = new Lesson("Les pays", "Madagascar, France,...", "html", "blablblabl");

        list.add(chiffres);
        list.add(couleurs);
        list.add(pays);

        return list;
    }
}