package com.eather.momo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.contain_fragment)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            Contain contain = new Contain();
            contain.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.contain_fragment,contain).commit();
        }
    }

    public void buttonclick(View view)
    {
        Contain contain = (Contain) getSupportFragmentManager().findFragmentById(R.id.contain_fragment);

        contain.onStart();

    }
}
