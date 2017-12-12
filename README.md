# DroidMelody

This is an easy-to-use library that simplifies access to music files on Android.

## Usage

If you want to get a list of all songs available on an Android device, all you need is the following code:

```
SongFinder songFinder = new SongFinder(getContentResolver());
songFinder.prepare();

List<SongFinder.Song> songs = songFinder.getAllSongs();
System.out.println(songs.size());
for(SongFinder.Song song:songs) {
    System.out.println(song.getTitle());
    System.out.println(song.getArtist());
}
```

On Android Marshmallow devices, you'll need the `READ_EXTERNAL_STORAGE` permission to access music files on the SD Card. To get the permission, you can use the `MelodyHelper` helper class:

```
// Check if permission available or request
if(MelodyHelper.hasExternalStorageAccess(this)) {
    // Do something
}

...
...

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    if(MelodyHelper.isAccessGranted(requestCode, permissions, grantResults)) {
        // Do something
    }
}
```
