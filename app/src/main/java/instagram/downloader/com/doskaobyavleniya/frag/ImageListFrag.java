package instagram.downloader.com.doskaobyavleniya.frag;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.utils.ItemTouchMoveCallback;

import static instagram.downloader.com.doskaobyavleniya.act.EditAdsAct.context;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //ImageListFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 //* Use the {@link ImageListFrag#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageListFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
 //   private static final String ARG_PARAM1 = "param1";
 //   private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
 //   private String mParam1;
 //   private String mParam2;
    //Объявление переменных
    Button bBack;
    RecyclerView rcViewSelectImage;

    public String title;
    public String imageUrl;


    public FragmentCloseInterface onFragClose;
   public ArrayList<String> newList = new ArrayList<>();

    public ImageListFrag(FragmentCloseInterface onFragClose, ArrayList<String> returnValues) {
        this.onFragClose = onFragClose;
    }

    public FragmentCloseInterface getFragCloseInterface() {
        return onFragClose;
    }


    SelectImageRvAdapter adapter = new SelectImageRvAdapter();
    ItemTouchMoveCallback dragCallback = new ItemTouchMoveCallback();
    ItemTouchHelper touchHelper = new ItemTouchHelper(dragCallback);


    //   public ImageListFrag() {
        // Required empty public constructor
 //   }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
 //    * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageListFrag.
     */
    // TODO: Rename and change types and number of parameters
  //  public static ImageListFrag newInstance(String param1, String param2) {
  //      ImageListFrag fragment = new ImageListFrag();
  //      Bundle args = new Bundle();
  //      args.putString(ARG_PARAM1, param1);
  //      args.putString(ARG_PARAM2, param2);
  //      fragment.setArguments(args);
  //      return fragment;
  //  }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
 //       if (getArguments() != null) {
 //           mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.list_image_frag, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcViewSelectImage.findViewById(R.id.rcViewSelectImage);
        rcViewSelectImage.setLayoutManager(new LinearLayoutManager(context));
        rcViewSelectImage.setAdapter(adapter);
        //rcView.setAdapter(adapter);
        ArrayList<ImageListFrag> updateList = new ArrayList<>();
        for (int n=0; n<newList.size(); n++) {
            Log.d("","Пиздец");
            //updateList.add(new SelectImageItem(n, newList[n]));
        }
        //adapter.updateAdapter(updateList);



        bBack = view.findViewById(R.id.bBack);
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(ImageListFrag.this).commit();
            }
        });

    }


    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
   //     if (context instanceof OnFragmentInteractionListener) {
   //         mListener = (OnFragmentInteractionListener) context;
  //      } else {
  //          throw new RuntimeException(context.toString()
  //                  + " must implement OnFragmentInteractionListener");
 //       }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        getFragCloseInterface().onFragClose();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
