package reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	public static ExtentSparkReporter htmlReporter;
	  public static ExtentReports extent;
	  public static ExtentTest test;

	  public static void setExtent() throws IOException {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  String path = System.getProperty("user.dir") +"\\src\\main\\java\\reports\\ExtentReports\\"
				  + timeStamp
		            + "TestExecutionReport"
		            + ".html";

	    htmlReporter = new ExtentSparkReporter(
	        path);
	    String xmlpath = System.getProperty("user.dir") + "\\src\\main\\resources\\extent-config.xml";

	    htmlReporter.loadXMLConfig(xmlpath);

	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	    htmlReporter.config().setDocumentTitle("PetStore Automation Report");
	    htmlReporter.config().setReportName("User Module Api Test Report");
	    htmlReporter.config().setTheme(Theme.STANDARD);
	    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	    extent.setSystemInfo("Operating System", System.getProperty("os.name"));
	    extent.setSystemInfo("User Name", System.getProperty("user.name"));
	    extent.setSystemInfo("Environemnt","RestAssured, TestNG");
	    extent.setSystemInfo("Tester","Reyad Hassan");
		
	  }

	  public static void endReport() {
	    extent.flush();
	  }
	  

}
