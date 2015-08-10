package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.We

import java.util.Set;

/**
 * Created by Nelson Tapia on 8/10/2015.
 */
public class WindowsPopUp {

    public static WebDriver getHandleToWindow(String title){

        //parentWindowHandle = WebDriverInitialize.getDriver().getWindowHandle(); // save the current window handle.
        WebDriver popup = null;
        Set<String> windowIterator = WebDriverInitialize.getDriver().getWindowHandles();
        System.err.println("No of windows :  " + windowIterator.size());
        for (String s : windowIterator) {
            String windowHandle = s;
            popup = WebDriverInitialize.getDriver().switchTo().window(windowHandle);
            System.out.println("Window Title : " + popup.getTitle());
            System.out.println("Window Url : " + popup.getCurrentUrl());
            if (popup.getTitle().equals(title) ){
                System.out.println("Selected Window Title : " + popup.getTitle());
                return popup;
            }

        }
        System.out.println("Window Title :" + popup.getTitle());
        System.out.println();
        return popup;
    }
}
