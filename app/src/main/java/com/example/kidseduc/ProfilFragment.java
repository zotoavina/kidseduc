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
    private User user ;
    private UserController userController;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userController = UserController.getUserController();
        View view =  inflater.inflate(R.layout.fragment_profil, null);
        view.setBackgroundColor(34);
        return view;
    }

    private View setStyleBySex(View view){
        view.setBackgroundColor(18);
        if(user.getSex()==0){
            view.setBackgroundColor(365);
        }
        return view;
    }
}