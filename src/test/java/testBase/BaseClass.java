package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j	

public class BaseClass {

	public  WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browser"})
	
	public void setup(String os , String br) throws IOException
	{
		//Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
	
		
	
			switch(br.toLowerCase())
			{	
			case "chrome" : driver= new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		
		driver.get(p.getProperty("appUrl2"));// reading url from properties file.
		
		//driver.get("http://localhost/opencart/opencart/upload/index.php");
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() throws Exception
	{
		Thread.sleep(5000);
		driver.quit();
	}
	//Dynamically entering the value
			public String randomeString()
			{
				String generatedString  = RandomStringUtils.randomAlphabetic(5); //it will generate 5 randome alpha characcters
				return generatedString;
			}
			public String randomeNumber()
			{
				String generatedNum  = RandomStringUtils.randomNumeric(10); //it will generate 5 randome Numbers 
				return generatedNum;
			}
			
			public String randomeAlphaNumeric()
			{
				String generatedString  = RandomStringUtils.randomAlphabetic(5); //it will generate 5 randome alpha characcters			return generatedNum;
				String generatedNum  = RandomStringUtils.randomNumeric(10); //it will generate 5 randome Numbers 
				return (generatedString+"_"+generatedNum);
			}
			
			public String captureScreen(String tname)
			{
				String timestamp = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
				
				TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
				
				File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
				
				String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_" + timestamp +".png";
				File targetFile = new File(targetFilePath);
				sourceFile.renameTo(targetFile);
				return targetFilePath;
			}
			
			
			
}
