package guvSele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task22_2 {

	public static void main(String[] args) {

		// Set the path to the ChromeDriver executable

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");

		// Initialize a new instance of the ChromeDriver

		WebDriver driver = new ChromeDriver();

		try {

			// Navigate to the URL

			driver.get("http://the-internet.herokuapp.com/nested_frames");

			// Maximize the browser window

			driver.manage().window().maximize();

			// Switch to the top frame using the frame's name

			driver.switchTo().frame("frame-top");

			// Verify that there are three frames on the page

			int framescount = driver.findElements(By.tagName("frame")).size();

			if (framescount == 3) {

				System.out.println("The number of frames in the top frame is three");

			} else {

				System.out.println("The number of frames in the top frame is not three");

			}

			// Switch to the left frame using frame's name

			driver.switchTo().frame("frame-left");

			// Verify that the left frame has the text "LEFT"

			WebElement lefttext = driver.findElement(By.xpath("/html/body"));

			if (lefttext.getText().equals("LEFT")) {

				System.out.println("The left frame has the text: LEFT");

			}

			else {

				System.out.println("The left frame does not have the text: LEFT");

			}

			// Switch back to the top frame

			driver.switchTo().parentFrame();

			// Switch to the middle frame using frame's name

			driver.switchTo().frame("frame-middle");

			// Verify that the middle frame has the text "MIDDLE"

			WebElement Middletext = driver.findElement(By.cssSelector("#content"));

			if (Middletext.getText().equals("MIDDLE")) {

				System.out.println("The middle frame has the text: MIDDLE");

			} else {

				System.out.println("The middle frame does not have the text: MIDDLE");

			}

			// Switch back to the top frame

			driver.switchTo().parentFrame();

			// Switch to the right frame using frame's name

			driver.switchTo().frame("frame-right");

			// Verify that the right frame has the text "RIGHT"

			WebElement Righttext = driver.findElement(By.xpath("/html/body"));

			if (Righttext.getText().equals("RIGHT")) {

				System.out.println("The right frame has the text: RIGHT");

			} else {

				System.out.println("The right frame does not have the text: RIGHT");

			}

			// Switch back to the top frame

			driver.switchTo().parentFrame();

			// Switch back to the parent document (default content)

			driver.switchTo().defaultContent();

			// Switch to the bottom frame using frame's name

			driver.switchTo().frame("frame-bottom");

			// Verify that the bottom frame has the text "BOTTOM"

			WebElement Bottomtext = driver.findElement(By.xpath("/html/body"));

			if (Bottomtext.getText().equals("BOTTOM")) {

				System.out.println("The bottom frame has the text: BOTTOM");

			} else {

				System.out.println("The bottom frame does not have the text: BOTTOM");

			}

			// Switch back to the parent document (default content)

			driver.switchTo().defaultContent();

			// Verify that the page title is "Frames"

			String Pagetitles = driver.getTitle();

			if (Pagetitles.equals("Frames")) {

				System.out.println("The page title is correct: " + Pagetitles);

			} else {

				System.out.println("The page title is incorrect: " + Pagetitles);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			// Close the browser

			driver.quit();
		}

	}

}
