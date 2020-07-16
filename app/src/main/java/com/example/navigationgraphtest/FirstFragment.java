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
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    private Context mContext;
    private ImageView openDraw;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = view.getContext();

        final NavController navController = Navigation.findNavController(view);

        Button btnGoSecond = view.findViewById(R.id.btnGoSecond);
        openDraw = view.findViewById(R.id.openFirst);

        btnGoSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(view.getContext(), "This is me first", Toast.LENGTH_SHORT).show();

                navController.navigate(R.id.action_firstFragment_to_secondFragment);

            }
        });

        // This callback will only be called when MyFragment is at least Started.
        /* OnBackPressedCallback callback = new OnBackPressedCallback(true *//* enabled by default *//*) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event

                Toast.makeText(mContext, "Calling Back", Toast.LENGTH_SHORT).show();
                requireActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);*/

        openDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(mContext, "click open", Toast.LENGTH_SHORT).show();
                ((MainActivity) mContext).openDrawer();
            }
        });

    }


}




