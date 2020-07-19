package com.parys.alex.b1g;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class B1GActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1_g);

        if (savedInstanceState  == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new TeamFragment())
                    .commit();
        }
    }

    public static class TeamFragment extends Fragment {

        public TeamFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            //COLLECT THE DATA FROM MUSIC EVENTS
            String[] teamData = ConferenceSchools.schools;
            List<String> ourSchools = new ArrayList<String>(Arrays.asList(teamData));

            // Now that we have some dummy forecast data, create an ArrayAdapter.
            // The ArrayAdapter will take data from a source (like our dummy forecast) and
            // use it to populate the ListView it's attached to.
            ArrayAdapter<String> schoolEventAdapter =
                    new ArrayAdapter<String>(
                            getActivity(), // The current context (this activity)
                            R.layout.team_item, // The name of the layout ID.
                            R.id.team_item_textView, // The ID of the textView to populate.
                            ourSchools);

            View rootView = inflater.inflate(R.layout.team_fragment, container, false);

            // Get a reference to the ListView, and attach this adapter to it.
            ListView listView = (ListView) rootView.findViewById(R.id.listView_event);
            listView.setAdapter(schoolEventAdapter);

            return rootView;
        }
    }
}


