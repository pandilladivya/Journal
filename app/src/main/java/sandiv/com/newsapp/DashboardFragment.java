package sandiv.com.newsapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardFragment extends Fragment {

    private EditText mInputData;
    private Button mInputDataSubmit;
	public DashboardFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        mInputData = (EditText) rootView.findViewById(R.id.input_data);
        mInputDataSubmit = (Button) rootView.findViewById(R.id.input_data_submit);

        mInputDataSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("articles");
                //
                myRef.setValue(mInputData.getText().toString());
            }
        });
        return rootView;
    }

}
