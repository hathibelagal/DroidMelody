package com.progur.musica;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.progur.droidmelody.SongFinder;
import com.progur.droidmelody.MelodyHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(MelodyHelper.hasExternalStorageAccess(this)) {
            start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(MelodyHelper.isAccessGranted(requestCode, permissions, grantResults)) {
            start();
        }
    }

    private void start() {
        SongFinder songFinder = new SongFinder(getContentResolver());
        songFinder.prepare();
        List<SongFinder.Song> songs = songFinder.getAllSongs();
        System.out.println(songs.size());
        for(SongFinder.Song song:songs) {
            System.out.println(song.getTitle());
            System.out.println(song.getArtist());
        }
    }
}
