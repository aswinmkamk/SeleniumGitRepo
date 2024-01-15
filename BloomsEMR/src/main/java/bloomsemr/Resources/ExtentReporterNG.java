package bloomsemr.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "/reports/extentReport.html";
	    System.out.println("Extent Report Path: " + path);

	    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	    reporter.config().setReportName("Blooms Web Automation Results");
	    reporter.config().setDocumentTitle("Blooms Test Results");

	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Software Test Engineer", "Aswin M K");
	    return extent;
	}

}
