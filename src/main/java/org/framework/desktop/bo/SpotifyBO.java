package org.framework.desktop.bo;

import org.framework.desktop.po.LinuxPO;
import org.framework.desktop.po.SpotifyPO;
import org.sikuli.script.FindFailed;

public class SpotifyBO {
    private LinuxPO linuxPO = new LinuxPO();
    public SpotifyPO spotifyPO = new SpotifyPO();
    public void menu() throws FindFailed {
        linuxPO.getMenu();
    }

    public void openApplication(String application) throws FindFailed {
        linuxPO.getSearch();
        linuxPO.inputText(application);
    }

    public void createPlaylist() throws FindFailed, InterruptedException {
        spotifyPO.getCreatePlaylist();
    }
    public void exitApplication() throws FindFailed {
        spotifyPO.exit();
    }

    public void search(String s) throws FindFailed {
        spotifyPO.openSearch(s);
    }

    public void addMusicToLike() throws FindFailed {
        spotifyPO.addMusic();
    }

    public void deletePlaylist() throws FindFailed, InterruptedException {
        spotifyPO.deletePlaylist();
    }
}
