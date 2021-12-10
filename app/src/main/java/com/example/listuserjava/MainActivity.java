package com.example.listuserjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvUsers;
    private ArrayList<Profile> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUsers=findViewById(R.id.rv_users);
        rvUsers.setHasFixedSize(true);
        list.addAll(getListHeroes());
        showRecyclerList();
    }

    public ArrayList<Profile> getListHeroes() {
        String[] dataUser = getResources().getStringArray(R.array.username);
        String[] dataName = getResources().getStringArray(R.array.name);
        String[] dataLoc = getResources().getStringArray(R.array.location);
        String[] dataPhoto = getResources().getStringArray(R.array.avatar);
        String[] dataFollowing = getResources().getStringArray(R.array.following);
        String[] dataFollowers= getResources().getStringArray(R.array.followers);
        String[] dataCompany = getResources().getStringArray(R.array.company);
        String[] dataRepository = getResources().getStringArray(R.array.repository);
//ambil data
//        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.avatar);

        ArrayList<Profile> listUser = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Profile profile = new Profile();
            profile.setName(dataName[i]);
            profile.setUser(dataUser[i]);
            profile.setLocation(dataLoc[i]);
            profile.setPhoto(playerImages[i]);
//            profile.setPhoto(dataPhoto[i]);
            profile.setFollowing(dataFollowing[i]);
            profile.setFollowers(dataFollowers[i]);
            profile.setCompany(dataCompany[i]);
            profile.setRepository(dataRepository[i]);
//            profile.setPhoto(dataPhoto.getResourceId(i, -1));
            listUser.add(profile);
        }
        return listUser;
    }

    private void showRecyclerList() {
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        ListUserAdapter listHeroAdapter = new ListUserAdapter(list);
        rvUsers.setAdapter(listHeroAdapter);
        listHeroAdapter.setOnItemClickCallback(data -> showSelectedHero(data));
    }

    private void showSelectedHero(Profile profile) {
        Toast.makeText(this, "Kamu memilih " + profile.getName(), Toast.LENGTH_SHORT).show();
    }

    private static int[] playerImages = {
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user7,
            R.drawable.user8,
            R.drawable.user9,
            R.drawable.user10
    };

}