package msu.elder.Fragments;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import msu.elder.R;


public class SelectGameFragment extends Fragment {

   ImageButton btnMCGame, btnYNGame, btnCreateGame;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_select_game, container, false);
      // Inflate the layout for this fragment
      btnMCGame = (ImageButton) view.findViewById(R.id.btnMCGame);
      btnYNGame = (ImageButton) view.findViewById(R.id.btnYNGame);
      btnCreateGame = (ImageButton) view.findViewById(R.id.btnCreateGame);


      return super.onCreateView(inflater, container, savedInstanceState);
   }
}
