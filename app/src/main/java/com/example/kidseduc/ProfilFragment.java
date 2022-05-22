package com.example.kidseduc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kidseduc.controllers.UserController;
import com.example.kidseduc.models.Lesson;
import com.example.kidseduc.models.User;
import com.example.kidseduc.utils.LessonListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ProfilFragment extends Fragment {
    private UserController userController;
    private TextView name;
    private TextView age;
    private TextView email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userController = UserController.getUserController();
        View view =  inflater.inflate(R.layout.fragment_profil, null);
        view.setBackgroundColor(34);
        init(view);
        return view;
    }

    private View setStyleBySex(View view){
        view.setBackgroundColor(0xFFF4CFB7);
        ImageView image = view.findViewById(R.id.profil_image);
        image.setImageResource(R.drawable.girl);
        if(userController.getGender()==1){
            view.setBackgroundColor(0xFF6AB3E1);
            image.setImageResource(R.drawable.boy);
        }
        return view;
    }

    private void init(View view){
        name = (TextView) view.findViewById(R.id.profil_name);
        age = (TextView) view.findViewById(R.id.profil_age);
        email = (TextView) view.findViewById(R.id.profil_email);
        setStyleBySex(view);
        bindProfilInformation();
    }

    private void bindProfilInformation(){
        name.setText( "Name: "+userController.getName() );
        email.setText( "Email: "+userController.getEmail());
        age.setText( "Age: "+userController.getAge() + "");
    }
}