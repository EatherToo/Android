package com.eather.momo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Eather on 2017/11/17.
 */

public class Contain extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        return inflater.inflate(R.layout.contain,container,false);
    }
    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
            // Set article based on saved instance state defined during onCreateView
        updateArticleView();

    }

    public void updateArticleView() {
        TextView article = (TextView) getActivity().findViewById(R.id.maintain);
        article.setText("1jvhjfdnbkdfgoiwhigj854unbjkfbjkahgiualkdbmsgkln");
    }

}
