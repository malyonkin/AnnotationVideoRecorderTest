package org.example;

import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.annotations.Video;
import org.example.pagewidgets.*;

import org.junit.Rule;
import org.junit.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Simple Selenide Test with PageObjects
 */
public class GoogleTest //https://automation-remarks.com/java-video-recorder-1-0-8/
{
    @Rule
    public VideoRule videoRule = new VideoRule();
    /*
        Указываем директорию для хранения и, ОБЯЗАТЕЛЬНО, формат видео - -Drecorder.type=FFMPEG
        Хрень работает только с jUnit4 (
        mvn test -Dvideo.folder="/System/Volumes/Data/Volumes/Date/temp/" -Dvideo.enabled=true -Dvideo.mode=ANNOTATED -Dvideo.save.mode=ALL -Drecorder.type=FFMPEG
     */

    @Test
    @Video
    public void searchForSelenide() throws InterruptedException {
        // Arrange
        Thread.sleep(2);
        open("https://google.com/ncr");
        Thread.sleep(2);
        // Act
        new GoogleSearch().searchFor("selenide");

        // Assert
        SearchResults results = new SearchResults();
        results.found.shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
