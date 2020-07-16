package com.example.navigationgraphtest;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    private Context mContext;
    private ImageView openDrawer;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = view.getContext();

        final NavController navController = Navigation.findNavController(view);

        Button button = view.findViewById(R.id.btnThird);
        openDrawer = view.findViewById(R.id.openThird);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(v.getContext(), "Go to Home ", Toast.LENGTH_SHORT).show();

                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.firstFragment, true)
                        .build();

                //navController.navigate(R.id.action_thirdFragment_to_firstFragment);
                navController.navigate(R.id.action_thirdFragment_to_firstFragment, null, navOptions);

            }
        });

        openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) mContext).openDrawer();
            }
        });
    }


}
