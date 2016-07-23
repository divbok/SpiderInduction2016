package com.example.user.moviesapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private ProgressDialog progress;
    public Retrofit retrofit;
String txt;
    public Button search,next;
    public Observable<Movie> movieObservable;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit=(EditText)findViewById(R.id.edit);
        txt=edit.getText().toString().toLowerCase();
        Button search=(Button)findViewById(R.id.searchbutton);
        Button next=(Button)findViewById(R.id.nextbutton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Grid.class);
                startActivity(intent);
            }
        });
       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               progress=new ProgressDialog(MainActivity.this);
               progress.setMessage("Getting movie");
               progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
               progress.setIndeterminate(true);
               progress.show();

               final Intent j = new Intent(MainActivity.this, Grid.class);
               db = new DatabaseHandler(MainActivity.this);

               retrofit = new Retrofit.Builder()
                       .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                       .addConverterFactory(GsonConverterFactory.create())
                       .baseUrl("http://omdbapi.com/")
                       .build();

               MovieService movieService = retrofit.create(MovieService.class);

               movieObservable = movieService.getMovieData(txt);

               movieObservable.subscribeOn(Schedulers.newThread())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new Observer<Movie>() {
                                      @Override
                                      public void onCompleted() {


                                      }

                                      @Override
                                      public void onError(Throwable e) {

                                      }

                                      @Override
                                      public void onNext(Movie movie) {if(movie.getResponse().equals("True"))
                                      {
                                          db.addMovie(movie);
                                          progress.dismiss();
                                          startActivity(j);
                                      }
                                      else
                                          Toast.makeText(MainActivity.this, "Not Found, Try Again", Toast.LENGTH_SHORT).show();

                                      }
                                  });

           }
       });

}
}

