package com.example.testtestaddphoto;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link showLocationFolderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class showLocationFolderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public showLocationFolderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment showLocationFolderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static showLocationFolderFragment newInstance(String param1, String param2) {
        showLocationFolderFragment fragment = new showLocationFolderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_show_location_folder, container, false);
        GridView gridView = v.findViewById(R.id.list);
        FolderAdapter adapter = new FolderAdapter();

        File storageDir = new File(Environment.getExternalStorageDirectory() + "/addPhoto/");
        if (!storageDir.exists()) storageDir.mkdirs();
        File[] locationFoldersNames = storageDir.listFiles();
        if (locationFoldersNames.length > 0) {
            for (int i = 0; i < locationFoldersNames.length; i++) {
                adapter.addItem(new Folder(locationFoldersNames[i].getName()));
            }
            gridView.setAdapter(adapter);
//            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(getContext(), position+"번째", Toast.LENGTH_LONG).show();
//                }
//            });
        } else {
            Toast.makeText(getActivity(), "폴더없음!", Toast.LENGTH_LONG).show();
        }
        return v;
    }

}