package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(FrameworkConstants.getreportPath() + "/" +dateFormat.format(new Date())+".html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName("Automation Report");
        reporter.config().setDocumentTitle("Checking");
        extentReports.attachReporter(reporter);
        return extentReports;
    }

}
