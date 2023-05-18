package org.framework.desktop.wrapper;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import java.io.File;

import static org.framework.desktop.wrapper.ScreenHelper.screen;


public class ElementPattern {
    private Pattern pattern;

    public ElementPattern(String path) {
        this.pattern = new Pattern(new File("src/main/java/org/framework/desktop/screenShots/" + path).getAbsolutePath());
    }
    public void click() throws FindFailed {
        screen.find(pattern).click();
    }
    public void waitAndClick(double time) throws FindFailed {
        try {
            screen.wait(pattern, time).click();
        } catch (FindFailed e) {
            e.printStackTrace();
        }

    }

    public void rightClick() throws FindFailed {
        screen.find(pattern).rightClick();
    }

    public void waitElement(double time) throws FindFailed {
        screen.wait(pattern, time);
    }

    public boolean isShow() throws FindFailed {
        return screen.find(pattern).isValid();
    }
}
