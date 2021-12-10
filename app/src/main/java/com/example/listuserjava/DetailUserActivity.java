package com.example.listuserjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailUserActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    private ImageView ivProfilFoto;
    private int s_photo;
    private TextView tv_fullname, tv_username, tv_following,tv_followers, tv_company,tv_location,tv_repository;
    private String s_fullname, s_username,  s_location, s_following, s_followers, s_company, s_repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        ActionBar mactionBar = getSupportActionBar();
        mactionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Profile person = intent.getParcelableExtra(EXTRA_PERSON);
//  Bundle bundle = getIntent().getExtras();
        s_fullname = person.getName();
        s_username =person.getUser();
        s_photo = person.getPhoto();
        s_location = person.getLocation();
        s_following = person.getFollowing();
        s_followers = person.getFollowers();
        s_company = person.getCompany();
        s_repository = person.getRepository();

//s_fullname = person.getName(); ini
//       s_fullname = bundle.getString("nama");
//        s_username = bundle.getString("username");
//        s_photo = bundle.getInt("gambar");
//        s_location = bundle.getString("loca");
//        s_following = bundle.getString("flwg");
//        s_followers = bundle.getString("flws");
//        s_company = bundle.getString("com");
//        s_repository = bundle.getString("rep"); sampai sini

        tv_fullname = (TextView) findViewById(R.id.tv_fullname);
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_following = (TextView) findViewById(R.id.tv_following);
        tv_followers = (TextView) findViewById(R.id.tv_followers);
        tv_company = (TextView) findViewById(R.id.tv_company);
        tv_location = (TextView) findViewById(R.id.tv_location);
        tv_repository = (TextView) findViewById(R.id.tv_repository);
        ivProfilFoto = (ImageView) findViewById(R.id.ivProfilFoto);

        tv_fullname.setText(""+s_fullname);
        tv_username.setText(""+s_username);
        tv_following.setText(""+s_following);
        tv_followers.setText(""+s_followers);
//        tv_following.setText(""+s_following);
        tv_company.setText(""+s_company);
        tv_location.setText(""+s_location);
        tv_repository.setText(""+s_repository);

        Glide.with(DetailUserActivity.this)
                .load(s_photo)
                .circleCrop()
                .into(ivProfilFoto);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}