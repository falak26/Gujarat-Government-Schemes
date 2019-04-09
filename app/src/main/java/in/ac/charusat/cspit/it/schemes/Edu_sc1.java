package in.ac.charusat.cspit.it.schemes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Edu_sc1 extends AppCompatActivity {

    private PDFView pdfView;
    private FirebaseDatabase ref;
    private DatabaseReference dref;
    String scheme,Dept,child;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_sc1);
        Intent i = getIntent();
        scheme = i.getStringExtra("scheme");
        Dept = i.getStringExtra("Dept");
        pdfView = (PDFView) findViewById(R.id.pdfview);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Retriving....");
        dialog.show();

        switch(Dept){
            case "01":child="Education Dept";break;

        }


        dref = ref.getInstance().getReference().child(child);



        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=null;
                switch (scheme){
                    case "01":value = dataSnapshot.child("01").getValue(String.class);break;
                    case "02":value = dataSnapshot.child("02").getValue(String.class);break;
                    case "03":value = dataSnapshot.child("03").getValue(String.class);break;
                    case "04":value = dataSnapshot.child("04").getValue(String.class);break;
                    case "05":value = dataSnapshot.child("05").getValue(String.class);break;
                    case "06":value = dataSnapshot.child("06").getValue(String.class);break;
                }
                new RetrivePdfStream().execute(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Edu_sc1.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }

        });


    }
    class RetrivePdfStream extends AsyncTask<String,Void,InputStream>{

        Edu_sc1 temp ;
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode()== 200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch (IOException e){

            }
            return  inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            super.onPostExecute(inputStream);
            //  Toast.makeText(Edu_sc1.this, "On Poast Execute", Toast.LENGTH_SHORT).show();
            temp = new Edu_sc1();
            dialog.cancel();
            pdfView.fromStream(inputStream).load();

        }
    }
}
