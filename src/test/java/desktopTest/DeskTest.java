package desktopTest;

import org.framework.desktop.bo.SpotifyBO;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class DeskTest {
    private SpotifyBO spotifyBO = new SpotifyBO();

    @Test
    public void createPlaylistTest() throws FindFailed, InterruptedException {
        spotifyBO.menu();
        spotifyBO.openApplication("Spotify");
        spotifyBO.createPlaylist();
        spotifyBO.exitApplication();
    }

    @Test(dependsOnMethods = "createPlaylistTest")
    public void addMusicToLikeTest() throws FindFailed {
        spotifyBO.menu();
        spotifyBO.openApplication("Spotify");
        spotifyBO.search("Lucky Twice - Lucky");
        spotifyBO.addMusicToLike();
        spotifyBO.exitApplication();
    }

    @Test(dependsOnMethods = "addMusicToLikeTest")
    public void deletePlaylistTest() throws FindFailed, InterruptedException {
        spotifyBO.menu();
        spotifyBO.openApplication("Spotify");
        spotifyBO.deletePlaylist();
        spotifyBO.exitApplication();
    }

}
