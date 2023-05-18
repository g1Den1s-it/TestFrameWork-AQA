package org.framework.desktop.po;

import org.framework.desktop.wrapper.ElementPattern;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.testng.Assert;

import static org.framework.desktop.wrapper.ScreenHelper.screen;

public class SpotifyPO {
    public SpotifyPO getCreatePlaylist() throws FindFailed, InterruptedException {
        ElementPattern playlistPattern = new ElementPattern("add_playlist.png");
        playlistPattern.waitAndClick(10000L);

        ElementPattern createPlaylist = new ElementPattern("create_playlist.png");
        createPlaylist.waitAndClick(10000L);

        ElementPattern playlist = new ElementPattern("playlist_title.png");
        playlist.waitElement(2000);
        Assert.assertTrue(playlist.isShow());
        return this;
    }

    public void exit() throws FindFailed {
        ElementPattern elementPattern = new ElementPattern("exit.png");
        elementPattern.click();
    }

    public void openSearch(String music) throws FindFailed {
        ElementPattern searchButton = new ElementPattern("search_button.png");
        searchButton.waitAndClick(2000);

        ElementPattern searchInput = new ElementPattern("search_input.png");
        searchInput.waitElement(1000);

        screen.type(music);
        screen.type(Key.ENTER);
    }

    public void addMusic() throws FindFailed {
        ElementPattern music = new ElementPattern("music.png");
        music.waitAndClick(2000);

        ElementPattern like = new ElementPattern("like.png");
        like.click();
    }

    public void deletePlaylist() throws FindFailed, InterruptedException {
        ElementPattern playlist = new ElementPattern("playlist.png");
        playlist.waitElement(2000);
        playlist.rightClick();

        ElementPattern deleteList = new ElementPattern("delete_list.png");
        deleteList.waitAndClick(2000);

        ElementPattern deleteButton = new ElementPattern("delete_button.png");
        deleteButton.waitAndClick(2000);
    }
}
