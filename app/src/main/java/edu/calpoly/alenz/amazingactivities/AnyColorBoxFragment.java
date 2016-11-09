package edu.calpoly.alenz.amazingactivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnyColorBoxFragment extends ContractFragment<AnyColorBoxFragment.SayHello> {

    private static final String ARG_COLOR = "arg_color";

    public static AnyColorBoxFragment newInstance(int color) {
        AnyColorBoxFragment fragment = new AnyColorBoxFragment();

        Bundle ofJoy = new Bundle();
        ofJoy.putInt(ARG_COLOR, color);

        fragment.setArguments(ofJoy);

        return fragment;
    }

    View mBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Fragments 4 Life", "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");

        View linearLayout = inflater.inflate(R.layout.color_fragment, container, false);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().beginTransaction().remove(AnyColorBoxFragment.this).commit();
                getContract().sayHello();
            }
        });

        int color = getArguments().getInt(ARG_COLOR);
        mBox = linearLayout.findViewById(R.id.box);
        mBox.setBackgroundColor(color);
        return linearLayout;
    }

    public void setColor(int color) {
        mBox.setBackgroundColor(color);
    }


    public interface SayHello {
        void sayHello();
    }
}
