package org.framework.desktop.po;

import org.framework.desktop.wrapper.ElementPattern;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import static org.framework.desktop.wrapper.ScreenHelper.screen;

public class LinuxPO {

    public LinuxPO getMenu() throws FindFailed {
        ElementPattern elementPattern = new ElementPattern("showApplications.png");
        elementPattern.click();
        return this;
    }

    public LinuxPO getSearch() throws FindFailed {
        ElementPattern elementPattern = new ElementPattern("applicationsSearch.png");
        elementPattern.waitAndClick(3000L);
        return this;
    }

    public void inputText(String text){
        screen.type(text);
        screen.type(Key.ENTER);
    }
}
