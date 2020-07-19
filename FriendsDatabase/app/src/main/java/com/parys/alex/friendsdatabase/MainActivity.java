package com.parys.alex.friendsdatabase;


import android.os.Bundle;
import java.util.List;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.widget.Toast;


public class MainActivity extends Activity {
    private List<Friends> friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button addBtn = findViewById(R.id.add);
        Button updateBtn = findViewById(R.id.update);
        Button deleteBtn = findViewById(R.id.delete_button);

        final DatabaseHandler db = new DatabaseHandler(this);

        //Inserting Friends
        //Log.d("Insert: ", "Inserting ..");
        //db.addFriends(new Friends("Ravi", "Ravi@gmail.com"));
        //db.addFriends(new Friends("Srinivas", "Srinivas@gmail.com"));
        //db.addFriends(new Friends("Tommy", "Tommy@gmail.com"));
        //db.addFriends(new Friends("Karthik", "Karthik@gmail.com"));
        String TotalMsg = "";
        TextView textview = (TextView) findViewById(R.id.textview);
        textview.setMovementMethod(new ScrollingMovementMethod());

        friends = db.getAllFriends();

        for (Friends cn : friends) {
            TotalMsg += "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Email: " + cn.getEmail() + "\n";
            // Writing Contacts to log
            //Log.d("Name: ", log);

        }
        textview.setText("Name: " + TotalMsg);



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TotalMsg = "";
                EditText name = (EditText) findViewById(R.id.name);
                EditText email = (EditText) findViewById(R.id.email);
                String Name = name.getText().toString();
                String Email = email.getText().toString();

                if (Name.isEmpty() && Email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "A Name and an email must be entered", Toast.LENGTH_SHORT).show();
                } else {
                    db.addFriends(new Friends(Name, Email));
                    name.setText("");
                    email.setText("");
                    String msg = "";

                    friends = db.getAllFriends();

                    for (Friends cn : friends) {
                        TotalMsg += "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Email: " + cn.getEmail() + "\n";
                        // Writing Contacts to log
                        //Log.d("Name: ", log);

                    }
                    TextView text;
                    text = (TextView)findViewById(R.id.textview);
                    //text.setText("Name: " + TotalMsg);
                    text.setText(TotalMsg);

                }

            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TotalMsg = "";
                EditText id = (EditText) findViewById(R.id.idNum) ;
                EditText name = (EditText) findViewById(R.id.name);
                EditText email = (EditText) findViewById(R.id.email);
                String IDnum = id.getText().toString();
                String Name = name.getText().toString();
                String Email = email.getText().toString();

                if (IDnum.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You must enter an ID number for edit", Toast.LENGTH_SHORT).show();
                } else {
                    int idInt = Integer.parseInt(IDnum);
                    db.updateContact(new Friends(
                            idInt, Name, Email));
                    name.setText("");
                    email.setText("");
                    String msg = "";

                    friends = db.getAllFriends();

                    for (Friends cn : friends) {
                        TotalMsg += "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Email: " + cn.getEmail() + "\n";

                    }
                    TextView text;
                    text = (TextView)findViewById(R.id.textview);
                    //text.setText("Name: " + TotalMsg);
                    text.setText(TotalMsg);

                }

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TotalMsg = "";
                EditText id = (EditText) findViewById(R.id.idNum) ;
                EditText name = (EditText) findViewById(R.id.name);
                EditText email = (EditText) findViewById(R.id.email);
                String IDnum = id.getText().toString();
                String Name = name.getText().toString();
                String Email = email.getText().toString();

                if (IDnum.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You must enter an ID number for edit", Toast.LENGTH_SHORT).show();
                } else {
                    int idInt = Integer.parseInt(IDnum);
                    db.deleteContact(new Friends(idInt, Name, Email));
                    name.setText("");
                    email.setText("");
                    String msg = "";

                    friends = db.getAllFriends();

                    for (Friends cn : friends) {
                        TotalMsg += "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Email: " + cn.getEmail() + "\n";

                    }
                    TextView text;
                    text = (TextView)findViewById(R.id.textview);
                    //text.setText("Name: " + TotalMsg);
                    text.setText(TotalMsg);

                }

            }
        });
        } // End of onCreate
    } // End of MainActivity