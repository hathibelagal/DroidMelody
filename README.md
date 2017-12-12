# DroidMelody

This is an easy-to-use library that simplifies access to music files on Android.

## Usage

```
SongFinder songFinder = new SongFinder(getContextResolver());
songFinder.prepare();

List<SongFinder.Song> songs = songFinder.getAllSongs();
for(SongFinder.Song song:songs) {
  System.out.println(song.getTitle());
  System.out.println(song.getArtist());
}
```
