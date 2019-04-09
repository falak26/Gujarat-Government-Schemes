package in.ac.charusat.cspit.it.schemes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentSchemes extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<scheme> lstscheme;


    public FragmentSchemes() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.scheme_fragment,container,false);
        myrecyclerview =  (RecyclerView) v.findViewById(R.id.scheme_recyclerview);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),lstscheme);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstscheme = new ArrayList<>();
        lstscheme.add(new scheme("Concession in Food Bill to students studying in Medical and Engineering"));
        lstscheme.add(new scheme("Financial Assistance to Purchase Medical and Engineering Instruments"));
        lstscheme.add(new scheme("Post SSC Scholarship for boys"));
        lstscheme.add(new scheme("Post SSC Scholarship to Girls"));
        lstscheme.add(new scheme("Pre S.S.C Scholarship (Nomadic and Denotified Tribes)"));
        lstscheme.add(new scheme("Pre S.S.C Scholarship (S.E.B.C, E.B.C and Minority)"));
        }
}
