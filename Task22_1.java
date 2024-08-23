package guvSele;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task22_1 {

	public static void main(String[] args) {

		// Set the path to the ChromeDriver executable

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");

		// Initialize a new instance of the ChromeDriver

		WebDriver driver = new ChromeDriver();

		try {

			// Navigate to the URL

			driver.get("https://the-internet.herokuapp.com/windows");

			// Maximize the browser window

			driver.manage().window().maximize();

			// Store the current window handle (the original window)

			String Originalwindow = driver.getWindowHandle();

			// Click the "Click Here" button to open a new window

			WebElement Click = driver.findElement(By.xpath("//a[@href='/windows/new']"));

			Click.click();

			// Wait for the new window and switch to it

			Set<String> allWindows = driver.getWindowHandles();

			for (String windowHandle : allWindows) {

				if (!windowHandle.equals(Originalwindow)) {

					driver.switchTo().window(windowHandle);

					break;
				}
			}
			
			Thread.sleep(2000);

			WebElement newwindowtext = driver.findElement(By.tagName("h3"));

			if (newwindowtext.getText().equals("New Window")) {

				System.out.println("Text 'New Window' is present on the page.");
			}

			else {

				System.out.println("Text 'New Window' is NOT present on the page.");

			}

			// Close the newly opened window

			driver.close();

			// Switch back to the original window

			driver.switchTo().window(Originalwindow);

			// Verify that the original window is active

			String Pagetitle = driver.getTitle();

			System.out.println("Title of the original page: " + Pagetitle);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			// Close the browser instance

			driver.quit();

		}

	}

}
