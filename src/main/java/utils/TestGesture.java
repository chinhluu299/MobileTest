package utils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableList;

import driver.DriverManager;
import utils.PageUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver.Directional;


public class TestGesture {
  public enum ScrollDirection {
    UP, DOWN, LEFT, RIGHT
  }
  static double SCROLL_RATIO = 0.5;
  static Duration SCROLL_DUR = Duration.ofMillis(500);
  
  public static void scrollById(String accessID){
    // ((AppiumDriver) DriverManager.getDriver()).findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().accessibilityId(\""+accessID+"\").instance(0));")); 
    for(int i =0; i< 10; i++) {
        try {
            if(PageUtils.isElementPresent(AppiumBy.accessibilityId(accessID))){
                break;
            }
            scroll(ScrollDirection.DOWN, 0.2);
            Thread.sleep(200);
        } catch (Exception e) {
            break;
        }
    }
  }

  public static void scroll(ScrollDirection dir, double scrollRatio) {

      if (scrollRatio < 0 || scrollRatio > 1) {
          throw new Error("Scroll distance must be between 0 and 1");
      }
      Dimension size = ((AppiumDriver) DriverManager.getDriver()).manage().window().getSize();
      System.out.println(size);
      Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
      int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
      int top = midPoint.y - (int) (midPoint.y * scrollRatio);
      //Point Start = new Point(midPoint.x, bottom );
      //Point End = new Point(midPoint.x, top );
      int left = midPoint.x - (int) (midPoint.x * scrollRatio);
      int right = midPoint.x + (int) (midPoint.x * scrollRatio);

      if (dir == ScrollDirection.UP) {
          swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
      } else if (dir == ScrollDirection.DOWN) {
          swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
      } else if (dir == ScrollDirection.LEFT) {
          swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
      } else {
          swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
      }
  }
  protected static void swipe(Point start, Point end, Duration duration) {
      PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
      Sequence swipe = new Sequence(input, 0);
      swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
      swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
      swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
      swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
      ((AppiumDriver) DriverManager.getDriver()).perform(ImmutableList.of(swipe));
  }
}
