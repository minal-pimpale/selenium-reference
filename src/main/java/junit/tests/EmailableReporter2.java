package junit.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;



/**
 * Reporter that generates a single-page HTML report of the test results.
 * <p>
 * Based on an earlier implementation by Paul Mendelson.
 * </p>
 * 
 * @author Abraham Lin
 */
public class EmailableReporter2 implements IReporter {
	private static final Logger LOG = Logger.getLogger(EmailableReporter2.class);

	protected PrintWriter writer, summaryWriter;
	boolean bWriteCustomSummary=true;
	int iFailed=0, iPassed=0, iSkipped=0;
	
	protected List<SuiteResult> suiteResults = Lists.newArrayList();

	// Reusable buffer
	private StringBuilder buffer = new StringBuilder();

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		try {
			writer = createWriter(outputDirectory, "emailable-report1.html");   
			summaryWriter = createWriter(outputDirectory, "test-env-details.html");
		} catch (IOException e) {
			LOG.error("Unable to create output file", e);
			return;
		}
		for (ISuite suite : suites) {
			suiteResults.add(new SuiteResult(suite));

		}

		writeDocumentStart();
		writeHead();
		writeBody(xmlSuites,suites);        
		writeDocumentEnd();
		writer.close();
	}  


	protected PrintWriter createWriter(String outdir, String fileName) throws IOException {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, fileName))));
	}

	protected void writeDocumentStart() {
		writer.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		writer.print("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	}

	protected void writeHead() {

		writer.print("<head>");
		writer.print("<title>TestNG Report for dealvector</title>");
		writeStylesheet();
		writer.print("</head>");
	}

	protected void writeStylesheet() {
		writer.print("<style type=\"text/css\">");
		writer.print("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		writer.print("th,td {border:1px solid #009;padding:.25em .5em}");
		writer.print("th {vertical-align:bottom}");
		writer.print("td {vertical-align:top}");
		writer.print("table a {font-weight:bold}");
		writer.print("div.status-bar {background-color: #FFFFFF;border: 5px ridge #808080;padding-left: 10px;width: 181px; z-index: 2; text-align: center; margin: 10px; position: relative;left: 500px;}");
		writer.print(".stripe td {background-color: #E6EBF9}");
		writer.print(".num {text-align:right}");
		writer.print(".passedodd td {background-color: #3F3}");
		writer.print(".passedeven td {background-color: #0A0}");
		writer.print(".skippedodd td {background-color: #DDD}");
		writer.print(".skippedeven td {background-color: #CCC}");
		writer.print(".failedodd td,.attn {background-color: #F33}");
		writer.print(".failedeven td,.stripe .attn {background-color: #D00}");
		writer.print(".stacktrace {white-space:pre;font-family:monospace}");
		writer.print(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		writer.print("</style>");
	}
	
	protected String getStatusDiv() {
		String htmlStart = "<div class=\"status-bar\"><p style=\"font-weight=bold\">SUMMARY</p>";
		String svgFailed =		"<svg width=\"50\" height=\"80\">"+
				"<circle fill='#990000' stroke='black' r='17' cy='25' cx='25' stroke-width='3'/>"+
				"<text fill='white' dy='30' dx='17'><tspan fill='white' font-weight='bold'>%s</tspan></text>"+
				"<text fill='black' dy='60' dx='5'><tspan fill='black' font-weight='normal'>Failed</tspan></text>"+
				"</svg>";
				
		String svgPassed = "<svg width='50' height='80'>"+						
				"<circle fill='#090' stroke-width='3' stroke='black' r='17' cy='25' cx='25'/>"+
				"<text fill='black' dy='30' dx='17'><tspan fill='white' font-weight='bold'>%s</tspan></text>"+
				"<text fill='black' dy='60' dx='5'><tspan fill='black' font-weight='normal'>Passed</tspan></text>"+		    
				"</svg>";
		String svgSkipped = "<svg height='80' width='60'>"+
				"<circle cx='25' cy='25' r='17' stroke='black' stroke-width='3' fill='#CC9900'/>"+
				"<text dx='17' dy='30' fill='white'><tspan font-weight='bold' fill='white'>%s</tspan></text>"+
				"<text dx='0' dy='60' fill='black'><tspan font-weight='normal' fill='black'>Skipped</tspan></text>"+
				"</svg></div>"; 

		String sFailed, sPassed, sSkipped;
		String sFinalHtml = htmlStart;
		sFailed = Integer.toString(iFailed);
		 
		if(iFailed < 9) {
			sFinalHtml = sFinalHtml + String.format(svgFailed.replace("dx='17'","dx='20'"),Integer.toString(iFailed));
		}
		else {
			sFinalHtml = sFinalHtml + String.format(svgFailed,Integer.toString(iFailed));
		}
		
		
		if(iPassed < 9) {
			sFinalHtml = sFinalHtml + String.format(svgPassed.replace("dx='17'","dx='20'"),Integer.toString(iPassed));
		}
		else {
			sFinalHtml = sFinalHtml + String.format(svgPassed,Integer.toString(iPassed));
		}
		
		if(iSkipped < 9) {
			sFinalHtml = sFinalHtml + String.format(svgSkipped.replace("dx='17'","dx='20'"),Integer.toString(iSkipped));
		}
		else {
			sFinalHtml = sFinalHtml + String.format(svgSkipped,Integer.toString(iSkipped));
		}
		
		return sFinalHtml + "</div>";			
	
	}
	
	protected void writeBody(List<XmlSuite> xmlSuites, List<ISuite> suites) {
		writer.print("<body>");
	//	writeTestParamsTbl();
		writeSummaryHTML();             // Creates a short html file with test perams
		if (bWriteCustomSummary) writeFlowSummary(xmlSuites,suites);
		writeSuiteSummary();
//		writeScenarioSummary();
//		writeScenarioDetails();
		writer.print("</body>");
	}

	protected void writeTestParamsTbl() {
		
	String tableFormat = "<br><br><table id='shortSummary'>%s</table>";
	String header = "<tr><th>Test Parameter</th><th>Details</th></tr>";
	String rowFormat = "<tr><td>%s</td><td>%s</td></tr>";
	String tblContents = "";

/*		String envDetails = Util.testConfig.getProperty(ConfigKeys.OS) +" "+ Util.testConfig.getProperty(ConfigKeys.OS_VERSION) + "," +
				Util.testConfig.getProperty(ConfigKeys.BROWSER) + " " +Util.testConfig.getProperty(ConfigKeys.BROWSER_VERSION);
*/			
	
	
	tblContents = tblContents + header;
//	tblContents = tblContents + String.format(rowFormat,"Build",Util.testConfig.getProperty(ConfigKeys.COMMIT));
//	tblContents = tblContents + String.format(rowFormat,"Env", envDetails);
	tblContents = String.format(tableFormat, tblContents);
	
	writer.print(tblContents);
		
	}
	
	
	protected void writeSummaryHTML() {
		
		String tableFormat = "<br><br><table id='shortSummary'>%s</table>";
		String header = "<tr><th>Test Parameter</th><th>Details</th></tr>";
		String rowFormat = "<tr><td>%s</td><td>%s</td></tr>";
		String tblContents = "";	
		
/*		String envDetails = Util.testConfig.getProperty(ConfigKeys.OS) +" "+ Util.testConfig.getProperty(ConfigKeys.OS_VERSION) + "," +
				Util.testConfig.getProperty(ConfigKeys.BROWSER) + " " +Util.testConfig.getProperty(ConfigKeys.BROWSER_VERSION);
*/		
		tblContents = tblContents + header;
//		tblContents = tblContents + String.format(rowFormat,"Build",Util.testConfig.getProperty(ConfigKeys.COMMIT));
//		tblContents = tblContents + String.format(rowFormat,"Env", envDetails);
		tblContents = String.format(tableFormat, tblContents);
		
		summaryWriter.print(tblContents);
		summaryWriter.close();
			
	}
	
	protected void writeDocumentEnd() {
		writer.print("</html>");
	}


	protected void writeFlowSummary(List<XmlSuite> xmlSuites, List<ISuite> suites) {
		System.out.println("Creating report");

		StringBuffer stb = new StringBuffer(); 
		StringBuffer sb = new StringBuffer();		
		String curTest="";
		String SPACE="&nbsp;";

		for (ISuite suite: suites) {
			System.out.println("Current suite"+suite.getName());
			System.out.println("Method count "+suite.getAllInvokedMethods().size());
			
			for(IInvokedMethod method: suite.getAllInvokedMethods()) {
				System.out.println("Name:"+method.getTestMethod().getMethodName());
				System.out.println("Status:"+method.getTestResult().getStatus());
				if(method.isTestMethod()) {
					
					boolean bStaffFlow = (Arrays.binarySearch(method.getTestMethod().getGroups(), "verifyMissingVotesDetailsDvAdmin") > -1);

					String newTestName = deCamelCase(method.getTestMethod().getInstance().getClass().getSimpleName());
					System.out.println(newTestName);
					String testDesc="";					
					
					/*try {							
						Descriptions desc = new Descriptions(method.getTestMethod().getInstance().getClass().getSimpleName());						
						testDesc = SPACE+"<text><i><b>Desc:</b>"+SPACE+desc.description+"<i></text>";
					}
					catch(Exception e) {
						if (!testDesc.equals("")) {
							testDesc= SPACE+"<text><i><b>Desc:</b>"+SPACE+testDesc+"<i></text>";
						}
						
					}*/
					
//					if (!curTest.equals(newTestName)) {
//						curTest = newTestName;
////						sb.append(String.format("<tr><td colspan=\"1\">%s</td><td colspan=\"3\">%s</td</tr>",newTestName, testDesc));
//						
//						sb.append(String.format("<tr><td colspan=\"1\">%s",newTestName));
//					}
//					sb.append(String.format("<tr><td colspan=\"1\">%s</td><td colspan=\"3\">%s</td</tr>",newTestName, stb.append(getStatus(method))));
//					sb.append(String.format("<tr><td colspan=\"1\">%s</td><td colspan=\"3\">%s</td</tr>",newTestName, testDesc));
//					stb.append(getStatus(method));
//					System.out.println("Pass count:"+iPassed);
//					System.out.println("Failed count:"+iFailed);
					
					stb.append(getStatus(method,newTestName));
					
				}					

			}
		}		

		// print student flow
		writer.print(getStatusDiv());

//		if (sb.toString().trim().isEmpty()) {
//			writer.print("<br><i>No tests for this flow have been run</i><br><br>");
//		}
//		else {
////			writer.print("<table id='Deal Center Flow' width=\"100%\" border=\"1\">");
////			writer.print("<tbody>");
////			// writer.print("<tr><th colspan=\"4\" align=\"center\">Student Flow</th></tr>");
////			writer.print("<tr><th width=\"20%\">Scenario</th><th width=\"30%\">Test Case</th><th width=\"10%\">Result</th><th width=\"40%\">Details/Logs</th></tr>");
////			writer.print(sb.toString());
////			writer.print("</tbody>");
////			writer.print("</table><br><br>");
//			// print student flow
//			writer.print("<table id='staff_flow' width=\"100%\" border=\"1\">");
//			writer.print("<tbody>");
//		}

			

		if (stb.toString().trim().isEmpty()) {
			writer.print("<br><i>No tests for this flow run</i><br><br>");
		}
		else {
			// writer.print("<tr><th colspan=\"4\" align=\"center\">Staff Flow</th></tr>");
			writer.print("<table id='staff_flow' width=\"100%\" border=\"1\">");
			writer.print("<tbody>");
			writer.print("<tr><th width=\"20%\">Module</th><th width=\"30%\">Scenario</th><th width=\"10%\">Result</th><th width=\"40%\">Details/Logs</th></tr>");
//			writer.print(sb.toString());
			writer.print(stb.toString());
			writer.print("</tbody>");
			writer.print("</table><br><br>");
		}
		System.out.println(stb.toString());
	}


	private String getStatus(IInvokedMethod method, String newTestName) {

		ITestResult result = method.getTestResult();
		String methodName = deCamelCase(method.getTestResult().getMethod().getMethodName());		
		int i=result.getStatus();
		String log="", errorLog="";		

		String rowFormat = "<tr><td></td><td>"+ methodName +"</td><td>%s</td><td>%s</td></tr>";
	    String rowFormatWithStyle = "<tr %s><td>" +newTestName + "</td><td>"+ methodName +"</td><td>%s</td><td>%s</td></tr>";

		// Reporter.getOutput(result);    --- Can be used later..

		if((null!=Reporter.getOutput()) && Reporter.getOutput(result).size()>0) {
			log = Reporter.getOutput(result).toString();
			if (log.length()>150) {
				log = log.substring(0, 150) + "...";
			}
		}	

		if(i>1){			
			if (null!=result.getThrowable()) errorLog = result.getThrowable().getMessage();
			if (errorLog.length()>150) {
				errorLog = errorLog.substring(0,150) + "...";
			}
			
		}

		if(i==1){
			iPassed++;
			return String.format(rowFormatWithStyle,"class=\"passedeven\"","PASS","");		
			
		}
		else if (i==2) {
			iFailed++;
			return String.format(rowFormatWithStyle,"class=\"attn\"","FAIL",errorLog);		

		}
		else if (i==3){
			iSkipped++;
			return String.format(rowFormatWithStyle,"class=\"attn\"","SKIPPED",errorLog);			
		}	

		return String.format(rowFormatWithStyle,"class=\"attn\"","UNKNOWN!!",log + "<br>" + errorLog);	
	}


	protected void writeSuiteSummary() {
		NumberFormat integerFormat = NumberFormat.getIntegerInstance();
		NumberFormat decimalFormat = NumberFormat.getNumberInstance();

		int totalPassedTests = 0;
		int totalSkippedTests = 0;
		int totalFailedTests = 0;
		long totalDuration = 0;

		writer.print("<table id='summary'>");
		writer.print("<tr>");
		writer.print("<th>Test</th>");
		writer.print("<th># Passed</th>");
		writer.print("<th># Skipped</th>");
		writer.print("<th># Failed</th>");
		writer.print("<th>Time (ms)</th>");
		writer.print("<th>Included Groups</th>");
		writer.print("<th>Excluded Groups</th>");
		writer.print("</tr>");

		int testIndex = 0;
		for (SuiteResult suiteResult : suiteResults) {

			writer.print("<tr><th colspan=\"7\">");
			writer.print(Utils.escapeHtml(suiteResult.getSuiteName()));
			writer.print("</th></tr>");


			for (TestResult testResult : suiteResult.getTestResults()) {

				int passedTests = testResult.getPassedTestCount();
				int skippedTests = testResult.getSkippedTestCount();
				int failedTests = testResult.getFailedTestCount();
				long duration = testResult.getDuration();

				writer.print("<tr");
				if ((testIndex % 2) == 1) {
					writer.print(" class=\"stripe\"");
				}
				writer.print(">");

				buffer.setLength(0);
				writeTableData(buffer.append("<a href=\"#t").append(testIndex)
						.append("\">")
						.append(Utils.escapeHtml(testResult.getTestName()))
						.append("</a>").toString());
				writeTableData(integerFormat.format(passedTests), "num");
				writeTableData(integerFormat.format(skippedTests),
						(skippedTests > 0 ? "num attn" : "num"));
				writeTableData(integerFormat.format(failedTests),
						(failedTests > 0 ? "num attn" : "num"));
				writeTableData(decimalFormat.format(duration), "num");
				writeTableData(testResult.getIncludedGroups());
				writeTableData(testResult.getExcludedGroups());

				writer.print("</tr>");

				totalPassedTests += passedTests;
				totalSkippedTests += skippedTests;
				totalFailedTests += failedTests;
				totalDuration += duration;

				testIndex++;
			}
		}

		// Print totals if there was more than one test
		if (testIndex > 1) {
			writer.print("<tr>");
			writer.print("<th>Total</th>");
			writeTableHeader(integerFormat.format(totalPassedTests), "num");
			writeTableHeader(integerFormat.format(totalSkippedTests),
					(totalSkippedTests > 0 ? "num attn" : "num"));
			writeTableHeader(integerFormat.format(totalFailedTests),
					(totalFailedTests > 0 ? "num attn" : "num"));
			writeTableHeader(decimalFormat.format(totalDuration), "num");
			writer.print("<th colspan=\"2\"></th>");
			writer.print("</tr>");
		}

		writer.print("</table>");
	}

	/**
	 * Writes a summary of all the test scenarios.
	 */
	protected void writeScenarioSummary() {
		writer.print("<table>");
		writer.print("<thead>");
		writer.print("<tr>");
		writer.print("<th>Class</th>");
		writer.print("<th>Method</th>");
		writer.print("<th>Start</th>");
		writer.print("<th>Time (ms)</th>");
		writer.print("</tr>");
		writer.print("</thead>");

		int testIndex = 0;
		int scenarioIndex = 0;
		for (SuiteResult suiteResult : suiteResults) {
			writer.print("<tbody><tr><th colspan=\"4\">");
			writer.print(Utils.escapeHtml(suiteResult.getSuiteName()));
			writer.print("</th></tr></tbody>");

			for (TestResult testResult : suiteResult.getTestResults()) {
				writer.print("<tbody id=\"t");
				writer.print(testIndex);
				writer.print("\">");


				String testName = Utils.escapeHtml(testResult.getTestName());

				scenarioIndex += writeScenarioSummary(testName
						+ " &#8212; failed (configuration methods)",
						testResult.getFailedConfigurationResults(), "failed",
						scenarioIndex);
				scenarioIndex += writeScenarioSummary(testName
						+ " &#8212; failed", testResult.getFailedTestResults(),
						"failed", scenarioIndex);
				scenarioIndex += writeScenarioSummary(testName
						+ " &#8212; skipped (configuration methods)",
						testResult.getSkippedConfigurationResults(), "skipped",
						scenarioIndex);
				scenarioIndex += writeScenarioSummary(testName
						+ " &#8212; skipped",
						testResult.getSkippedTestResults(), "skipped",
						scenarioIndex);
				scenarioIndex += writeScenarioSummary(testName
						+ " &#8212; passed", testResult.getPassedTestResults(),
						"passed", scenarioIndex);

				writer.print("</tbody>");

				testIndex++;
			}
		}

		writer.print("</table>");
	}

	/**
	 * Writes the scenario summary for the results of a given state for a single
	 * test.
	 */
	private int writeScenarioSummary(String description,
			List<ClassResult> classResults, String cssClassPrefix,
			int startingScenarioIndex) {
		int scenarioCount = 0;
		if (!classResults.isEmpty()) {
			writer.print("<tr><th colspan=\"4\">");
			writer.print(description);
			writer.print("</th></tr>");

			int scenarioIndex = startingScenarioIndex;
			int classIndex = 0;
			for (ClassResult classResult : classResults) {
				String cssClass = cssClassPrefix
						+ ((classIndex % 2) == 0 ? "even" : "odd");

				buffer.setLength(0);

				int scenariosPerClass = 0;
				int methodIndex = 0;
				for (MethodResult methodResult : classResult.getMethodResults()) {
					List<ITestResult> results = methodResult.getResults();
					int resultsCount = results.size();
					assert resultsCount > 0;

					ITestResult firstResult = results.iterator().next();
					String methodName = Utils.escapeHtml(firstResult
							.getMethod().getMethodName());
					long start = firstResult.getStartMillis();
					long duration = firstResult.getEndMillis() - start;

					// The first method per class shares a row with the class
					// header
					if (methodIndex > 0) {
						buffer.append("<tr class=\"").append(cssClass)
						.append("\">");

					}

					// Write the timing information with the first scenario per
					// method
					buffer.append("<td><a href=\"#m").append(scenarioIndex)
					.append("\">").append(methodName)
					.append("</a></td>").append("<td rowspan=\"")
					.append(resultsCount).append("\">").append(start)
					.append("</td>").append("<td rowspan=\"")
					.append(resultsCount).append("\">")
					.append(duration).append("</td></tr>");
					scenarioIndex++;

					// Write the remaining scenarios for the method
					for (int i = 1; i < resultsCount; i++) {
						buffer.append("<tr class=\"").append(cssClass)
						.append("\">").append("<td><a href=\"#m")
						.append(scenarioIndex).append("\">")
						.append(methodName).append("</a></td></tr>");
						scenarioIndex++;
					}

					scenariosPerClass += resultsCount;
					methodIndex++;
				}

				// Write the test results for the class
				writer.print("<tr class=\"");
				writer.print(cssClass);
				writer.print("\">");
				writer.print("<td rowspan=\"");
				writer.print(scenariosPerClass);
				writer.print("\">");
				writer.print(Utils.escapeHtml(classResult.getClassName()));
				writer.print("</td>");
				writer.print(buffer);

				classIndex++;
			}
			scenarioCount = scenarioIndex - startingScenarioIndex;
		}
		return scenarioCount;
	}

	/**
	 * Writes the details for all test scenarios.
	 */
	protected void writeScenarioDetails() {
		int scenarioIndex = 0;
		for (SuiteResult suiteResult : suiteResults) {
			for (TestResult testResult : suiteResult.getTestResults()) {
				writer.print("<h2>");
				writer.print(Utils.escapeHtml(testResult.getTestName()));
				writer.print("</h2>");

				scenarioIndex += writeScenarioDetails(
						testResult.getFailedConfigurationResults(),
						scenarioIndex);
				scenarioIndex += writeScenarioDetails(
						testResult.getFailedTestResults(), scenarioIndex);
				scenarioIndex += writeScenarioDetails(
						testResult.getSkippedConfigurationResults(),
						scenarioIndex);
				scenarioIndex += writeScenarioDetails(
						testResult.getSkippedTestResults(), scenarioIndex);
				scenarioIndex += writeScenarioDetails(
						testResult.getPassedTestResults(), scenarioIndex);
			}
		}
	}

	/**
	 * Writes the scenario details for the results of a given state for a single
	 * test.
	 */
	private int writeScenarioDetails(List<ClassResult> classResults,
			int startingScenarioIndex) {
		int scenarioIndex = startingScenarioIndex;

		for (ClassResult classResult : classResults) {
			String className = classResult.getClassName();
			for (MethodResult methodResult : classResult.getMethodResults()) {
				List<ITestResult> results = methodResult.getResults();
				assert !results.isEmpty();

				String label = Utils
						.escapeHtml(className
								+ "#"
								+ results.iterator().next().getMethod()
								.getMethodName());
				for (ITestResult result : results) {
					writeScenario(scenarioIndex, label, result);
					scenarioIndex++;
				}
			}
		}

		return scenarioIndex - startingScenarioIndex;
	}

	/**
	 * Writes the details for an individual test scenario.
	 */
	private void writeScenario(int scenarioIndex, String label,
			ITestResult result) {
		writer.print("<h3 id=\"m");
		writer.print(scenarioIndex);
		writer.print("\">");
		writer.print(label);
		writer.print("</h3>");

		writer.print("<table class=\"result\">");

		// Write test parameters (if any)
		Object[] parameters = result.getParameters();
		int parameterCount = (parameters == null ? 0 : parameters.length);
		if (parameterCount > 0) {
			writer.print("<tr class=\"param\">");
			for (int i = 1; i <= parameterCount; i++) {
				writer.print("<th>Parameter #");
				writer.print(i);
				writer.print("</th>");
			}
			writer.print("</tr><tr class=\"param stripe\">");
			for (Object parameter : parameters) {
				writer.print("<td>");
				writer.print(Utils.escapeHtml(Utils.toString(parameter)));
				writer.print("</td>");
			}
			writer.print("</tr>");
		}

		// Write reporter messages (if any)
		List<String> reporterMessages = Reporter.getOutput(result);
		for (int i=0;i<reporterMessages.size();i++) {
			reporterMessages.set(i,Jsoup.parse(reporterMessages.get(i)).text());
		}

		if (!reporterMessages.isEmpty()) {
			writer.print("<tr><th");
			if (parameterCount > 1) {
				writer.print(" colspan=\"");
				writer.print(parameterCount);
				writer.print("\"");
			}
			writer.print(">Passed Cases</th></tr>");

			writer.print("<tr><td");
			if (parameterCount > 1) {
				writer.print(" colspan=\"");
				writer.print(parameterCount);
				writer.print("\"");
			}
			writer.print(">");
			writeReporterMessages(reporterMessages);
			writer.print("</td></tr>");
		}

		// Write exception (if any)
		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			writer.print("<tr><th");
			if (parameterCount > 1) {
				writer.print(" colspan=\"");
				writer.print(parameterCount);
				writer.print("\"");
			}
			writer.print(">");
			writer.print((result.getStatus() == ITestResult.SUCCESS ? "Expected Exception"
					: "Exception"));
			writer.print("</th></tr>");

			writer.print("<tr><td");
			if (parameterCount > 1) {
				writer.print(" colspan=\"");
				writer.print(parameterCount);
				writer.print("\"");
			}
			writer.print(">");
			writeStackTrace(throwable);
			writer.print("</td></tr>");
		}

		writer.print("</table>");
		writer.print("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");
	}

	protected void writeReporterMessages(List<String> reporterMessages) {
		writer.print("<div class=\"messages\">");
		Iterator<String> iterator = reporterMessages.iterator();
		assert iterator.hasNext();
		writer.print(Utils.escapeHtml(iterator.next()));
		while (iterator.hasNext()) {
			writer.print("<br/>");
			writer.print(Utils.escapeHtml(iterator.next()));
		}
		writer.print("</div>");
	}

	protected void writeStackTrace(Throwable throwable) {
		writer.print("<div class=\"stacktrace\">");
		writer.print(Utils.stackTrace(throwable, true)[0]);
		writer.print("</div>");
	}

	/**
	 * Writes a TH element with the specified contents and CSS class names.
	 * 
	 * @param html
	 *            the HTML contents
	 * @param cssClasses
	 *            the space-delimited CSS classes or null if there are no
	 *            classes to apply
	 */
	protected void writeTableHeader(String html, String cssClasses) {
		writeTag("th", html, cssClasses);
	}

	/**
	 * Writes a TD element with the specified contents.
	 * 
	 * @param html
	 *            the HTML contents
	 */
	protected void writeTableData(String html) {
		writeTableData(html, null);
	}

	/**
	 * Writes a TD element with the specified contents and CSS class names.
	 * 
	 * @param html
	 *            the HTML contents
	 * @param cssClasses
	 *            the space-delimited CSS classes or null if there are no
	 *            classes to apply
	 */
	protected void writeTableData(String html, String cssClasses) {
		writeTag("td", html, cssClasses);
	}

	/**
	 * Writes an arbitrary HTML element with the specified contents and CSS
	 * class names.
	 * 
	 * @param tag
	 *            the tag name
	 * @param html
	 *            the HTML contents
	 * @param cssClasses
	 *            the space-delimited CSS classes or null if there are no
	 *            classes to apply
	 */
	protected void writeTag(String tag, String html, String cssClasses) {
		writer.print("<");
		writer.print(tag);
		if (cssClasses != null) {
			writer.print(" class=\"");
			writer.print(cssClasses);
			writer.print("\"");
		}
		writer.print(">");
		writer.print(html);
		writer.print("</");
		writer.print(tag);
		writer.print(">");
	}

	/**
	 * Groups {@link TestResult}s by suite.
	 */
	protected static class  SuiteResult {
		private final String suiteName;
		private final List<TestResult> testResults = Lists.newArrayList();

		public SuiteResult(ISuite suite) {
			suiteName = suite.getName();
			for (ISuiteResult suiteResult : suite.getResults().values()) {
				testResults.add(new TestResult(suiteResult.getTestContext()));
			}
		}

		public String getSuiteName() {
			return suiteName;
		}

		/**
		 * @return the test results (possibly empty)
		 */
		public List<TestResult> getTestResults() {
			return testResults;
		}
	}

	/**
	 * Groups {@link ClassResult}s by test, type (configuration or test), and
	 * status.
	 */
	protected static class TestResult {
		/**
		 * Orders test results by class name and then by method name (in
		 * lexicographic order).
		 */
		protected static final Comparator<ITestResult> RESULT_COMPARATOR = new Comparator<ITestResult>() {
			public int compare(ITestResult o1, ITestResult o2) {
				int result = o1.getTestClass().getName()
						.compareTo(o2.getTestClass().getName());
				if (result == 0) {
					result = o1.getMethod().getMethodName()
							.compareTo(o2.getMethod().getMethodName());
				}
				return result;
			}
		};

		private final String testName;
		private final List<ClassResult> failedConfigurationResults;
		private final List<ClassResult> failedTestResults;
		private final List<ClassResult> skippedConfigurationResults;
		private final List<ClassResult> skippedTestResults;
		private final List<ClassResult> passedTestResults;
		private final int failedTestCount;
		private final int skippedTestCount;
		private final int passedTestCount;
		private final long duration;
		private final String includedGroups;
		private final String excludedGroups;

		public TestResult(ITestContext context) {
			testName = context.getName();

			Set<ITestResult> failedConfigurations = context
					.getFailedConfigurations().getAllResults();
			Set<ITestResult> failedTests = context.getFailedTests()
					.getAllResults();
			Set<ITestResult> skippedConfigurations = context
					.getSkippedConfigurations().getAllResults();
			Set<ITestResult> skippedTests = context.getSkippedTests()
					.getAllResults();
			Set<ITestResult> passedTests = context.getPassedTests()
					.getAllResults();

			failedConfigurationResults = groupResults(failedConfigurations);
			failedTestResults = groupResults(failedTests);
			skippedConfigurationResults = groupResults(skippedConfigurations);
			skippedTestResults = groupResults(skippedTests);
			passedTestResults = groupResults(passedTests);

			failedTestCount = failedTests.size();
			skippedTestCount = skippedTests.size();
			passedTestCount = passedTests.size();

			duration = context.getEndDate().getTime()
					- context.getStartDate().getTime();

			includedGroups = formatGroups(context.getIncludedGroups());
			excludedGroups = formatGroups(context.getExcludedGroups());
		}

		/**
		 * Groups test results by method and then by class.
		 */
		protected List<ClassResult> groupResults(Set<ITestResult> results) {
			List<ClassResult> classResults = Lists.newArrayList();
			if (!results.isEmpty()) {
				List<MethodResult> resultsPerClass = Lists.newArrayList();
				List<ITestResult> resultsPerMethod = Lists.newArrayList();

				List<ITestResult> resultsList = Lists.newArrayList(results);
				Collections.sort(resultsList, RESULT_COMPARATOR);
				Iterator<ITestResult> resultsIterator = resultsList.iterator();
				assert resultsIterator.hasNext();

				ITestResult result = resultsIterator.next();
				resultsPerMethod.add(result);

				String previousClassName = result.getTestClass().getName();
				String previousMethodName = result.getMethod().getMethodName();
				while (resultsIterator.hasNext()) {
					result = resultsIterator.next();

					String className = result.getTestClass().getName();
					if (!previousClassName.equals(className)) {
						// Different class implies different method
						assert !resultsPerMethod.isEmpty();
						resultsPerClass.add(new MethodResult(resultsPerMethod));
						resultsPerMethod = Lists.newArrayList();

						assert !resultsPerClass.isEmpty();
						classResults.add(new ClassResult(previousClassName,
								resultsPerClass));
						resultsPerClass = Lists.newArrayList();

						previousClassName = className;
						previousMethodName = result.getMethod().getMethodName();
					} else {
						String methodName = result.getMethod().getMethodName();
						if (!previousMethodName.equals(methodName)) {
							assert !resultsPerMethod.isEmpty();
							resultsPerClass.add(new MethodResult(resultsPerMethod));
							resultsPerMethod = Lists.newArrayList();

							previousMethodName = methodName;
						}
					}
					resultsPerMethod.add(result);
				}
				assert !resultsPerMethod.isEmpty();
				resultsPerClass.add(new MethodResult(resultsPerMethod));
				assert !resultsPerClass.isEmpty();
				classResults.add(new ClassResult(previousClassName,
						resultsPerClass));
			}
			return classResults;
		}

		public String getTestName() {
			return testName;
		}

		/**
		 * @return the results for failed configurations (possibly empty)
		 */
		public List<ClassResult> getFailedConfigurationResults() {
			return failedConfigurationResults;
		}

		/**
		 * @return the results for failed tests (possibly empty)
		 */
		public List<ClassResult> getFailedTestResults() {
			return failedTestResults;
		}

		/**
		 * @return the results for skipped configurations (possibly empty)
		 */
		public List<ClassResult> getSkippedConfigurationResults() {
			return skippedConfigurationResults;
		}

		/**
		 * @return the results for skipped tests (possibly empty)
		 */
		public List<ClassResult> getSkippedTestResults() {
			return skippedTestResults;
		}

		/**
		 * @return the results for passed tests (possibly empty)
		 */
		public List<ClassResult> getPassedTestResults() {
			return passedTestResults;
		}

		public int getFailedTestCount() {
			return failedTestCount;
		}

		public int getSkippedTestCount() {
			return skippedTestCount;
		}

		public int getPassedTestCount() {
			return passedTestCount;
		}

		public long getDuration() {
			return duration;
		}

		public String getIncludedGroups() {
			return includedGroups;
		}

		public String getExcludedGroups() {
			return excludedGroups;
		}

		/**
		 * Formats an array of groups for display.
		 */
		protected String formatGroups(String[] groups) {
			if (groups.length == 0) {
				return "";
			}

			StringBuilder builder = new StringBuilder();
			builder.append(groups[0]);
			for (int i = 1; i < groups.length; i++) {
				builder.append(", ").append(groups[i]);
			}
			return builder.toString();
		}
	}

	/**
	 * Groups {@link MethodResult}s by class.
	 */
	protected static class ClassResult {
		private final String className;
		private final List<MethodResult> methodResults;

		/**
		 * @param className
		 *            the class name
		 * @param methodResults
		 *            the non-null, non-empty {@link MethodResult} list
		 */
		public ClassResult(String className, List<MethodResult> methodResults) {
			this.className = className;
			this.methodResults = methodResults;
		}

		public String getClassName() {
			return className;
		}

		/**
		 * @return the non-null, non-empty {@link MethodResult} list
		 */
		public List<MethodResult> getMethodResults() {
			return methodResults;
		}
	}

	/**
	 * Groups test results by method.
	 */
	protected static class MethodResult {
		private final List<ITestResult> results;

		/**
		 * @param results
		 *            the non-null, non-empty result list
		 */
		public MethodResult(List<ITestResult> results) {
			this.results = results;
		}

		/**
		 * @return the non-null, non-empty result list
		 */
		public List<ITestResult> getResults() {
			return results;
		}
	}

	private static String deCamelCase(String s) {
		String sRet = s.replaceAll(
				String.format("%s|%s|%s",
						"(?<=[A-Z])(?=[A-Z][a-z])",
						"(?<=[^A-Z])(?=[A-Z])",
						"(?<=[A-Za-z])(?=[^A-Za-z])"
						),
						" "
				);

		return sRet.substring(0, 1).toUpperCase() + sRet.substring(1);
	}

}

