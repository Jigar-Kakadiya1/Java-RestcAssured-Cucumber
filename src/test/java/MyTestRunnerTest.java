import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//plugin = {"pretty", "html:target/cucumber.html"}
@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"com.example.cucumber.steps","com.example.cucumber.config"},
        features="classpath:features",
        plugin={"pretty","json:target/cucumber.json"})

public class MyTestRunnerTest {
    @AfterClass
    public static void generateReport() {
        System.out.println("====== start generating html report =====");
        File reportOutputDirectory = new File("target/cucumber-html-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "RestAssured Test Report");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }

    @Test
    public void name() {
    }
}
