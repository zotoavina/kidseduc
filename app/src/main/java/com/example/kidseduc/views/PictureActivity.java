package com.example.kidseduc.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kidseduc.R;
import com.example.kidseduc.models.Lesson;

public class PictureActivity extends AppCompatActivity {

    ImageView picture;
    String url="https://cdn.futura-sciences.com/buildsv6/images/wide1920/8/5/8/858743bb35_50169458_chien-min.jpg";
    private Lesson lesson = new Lesson("Les chiens","picture",url,"");
    TextView title;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lesson = (Lesson) getIntent().getSerializableExtra("LESSON");
        setContentView(R.layout.activity_picture);
        title = findViewById(R.id.picture_title);
        description = findViewById(R.id.picture_description);

        title.setText(lesson.getTitle());
        description.setText(lesson.getDescription());
        url="https://cdn.futura-sciences.com/buildsv6/images/wide1920/8/5/8/858743bb35_50169458_chien-min.jpg";
         //url = "https://www.santevet.com/upload/admin/images/article/chien2_2/chiot/noms_de_chiens_en_2021.jpg";
        picture = findViewById(R.id.picture);
        //Glide.with(this).load(this.lesson.getContent()).into(picture);
        Glide.with(this).load(lesson.getContent()).into(picture);
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}