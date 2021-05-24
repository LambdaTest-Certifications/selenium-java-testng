package magicleapTesting;

import gherkin.lexer.Th;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import com.lambdatest.tunnel.Tunnel;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class magicLeap {
    // stage = bMrsjajNlv6Fnoi7I7ZYOVuHfPZ0PnqyZre0eUrvUJU3KSB14B

    public String username = "vishnukdas";//System.getenv("LT_USERNAME"); //"mohammadasadkhan1";
    public String accesskey = "D3tRgjqJOrG7GKCmdIkafAP7uUbPfiK3SaWXTWdjX3vhglk2yd";//System.getenv("LT_ACCESS_KEY");//"CsbtfqVzuuBShxEgq1K3";
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub" ;//"@eu-central-1-hub.lambdatest.com/wd/hub";
    String status;
    String ResolutionValue;
//    Tunnel t;



    long quitestoptime;
    long totaltime;
    long totaltimeforlocaltest;
    long Nettotalspeedtest;
    long GeolocationTotal;
    long ResolutionTotal;
    long totaltesttimeDuration;
    SessionId session;
    String BrowserValue;
    String versionValue;
    String PlatformValue;
    String FixedIpValue;
    String ResolutionValueCap;
    String TimeZoneValue;
    String GeoLocationValue;
    String hub;
    String TestName;
    String Space = "  ";
    String Tunnel;
    String AllVersions = null;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    LocalDateTime now = LocalDateTime.now();


    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "fixedIp", "resolution", "timezone", "geoLocation", "tunnel"})
    public magicLeap(String browser, String version, String platform, String fixedIp, String resolution, String timezone, String geoLocation, String tunnel) {
        try {

//            create tunnel instance
//            t = new Tunnel();
//            HashMap<String, String> options = new HashMap<String, String>();
//            options.put("user", username);
//            options.put("key", accesskey);
//            //start tunnel
//            t.start(options);

            BrowserValue = browser;
            versionValue = version;
            PlatformValue = platform;
            FixedIpValue = fixedIp;
            ResolutionValueCap = resolution;
            TimeZoneValue = timezone;
            GeoLocationValue = geoLocation;
            Tunnel = tunnel;
            if (BrowserValue != null) {
                TestName = BrowserValue;
                if (PlatformValue != null) {
                    TestName = BrowserValue + Space + PlatformValue;
                    if (versionValue != null) {
                        TestName = BrowserValue + Space + PlatformValue + Space + versionValue;
                        if (FixedIpValue != null)
                            TestName = BrowserValue + Space + PlatformValue + Space + versionValue;

                    }
                }
            }

        } catch (Exception t) {
        }
    }

    @BeforeTest
    public void setUp() throws Exception {
        System.out.println(this.versionValue);

          //for (int i = 0; i < 9; i++) {
        try {

//            String[] extention = {"https://test-artefacts-prod.s3.amazonaws.com/extensions/orgId-32518/2.1.0_0.zip"};

            DesiredCapabilities capabilities = new DesiredCapabilities();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-web-security");
//            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            capabilities.setCapability("browserName", this.BrowserValue);
            capabilities.setCapability("browserVersion", this.versionValue);
            capabilities.setCapability("platform",this.PlatformValue);
            capabilities.setCapability("resolution", this.ResolutionValue);
//             capabilities.setCapability("geoLocation",this.GeoLocationValue);
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", true);
            capabilities.setCapability("video", true);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("tunnel", false);
//             capabilities.setCapability("selenium_version","3.141.59");

            capabilities.setCapability("build", "Jenkins - "+System.getProperty("BUILD_NUMBER")+" : "+ this.PlatformValue);
            capabilities.setCapability("name",this.TestName);

//          capabilities.setCapability("performance",true);
//          capabilities.setCapability("fixedIP", "10.243.32.87");
//          capabilities.setCapability("region","us");


//            options.addArguments("ignore-certificate-errors");
//            options.addArguments("enable-automation");

            //BS caps

//           capabilities.setCapability("os", "Windows");
//           capabilities.setCapability("os_version", "10");
//           capabilities.setCapability("browserstack.networkLogsOptions",networkLogsOptions);
//           capabilities.setCapability("browserstack.autoWait",35);
//           capabilities.setCapability("browserstack.console","verbose");
//           capabilities.setCapability("browserstack.debug","true");
//           capabilities.setCapability("browserstack.local","true");


//            capabilities.setCapability(ChromeOptions.CAPABILITY,options);
//            options.setCapability("nativeEvents",true);
//            capabilities.setCapability("loadExtension", extention);


//            capabilities.setCapability("acceptInsecureCerts","true");
//            capabilities.setCapability("chrome.driver","2.34");
//            capabilities.setCapability("selenium_version","3.141.59");

//            capabilities.setCapability("network",true);
//            capabilities.setCapability("project","P1");
//            options.setExperimentalOption("mobileEmulation","iPhone X");
//            capabilities.setCapability("ie.driver", "2.53.1");


//            {Mobile Emulation}
//            Map<String, String> mobileEmulation = new HashMap<>();
//            mobileEmulation.put("deviceName", "iPhone X");
//            options.setExperimentalOption("mobileEmulation", mobileEmulation);


//            Auth Token for video Sharing
//            MessageDigest m=MessageDigest.getInstance("MD5");
//            String s = "vishnukdas:D3tRgjqJOrG7GKCmdIkafAP7uUbPfiK3SaWXTWdjX3vhglk2yd";
//            m.update(s.getBytes(),0,s.length());
//            System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));


//            capabilities.setCapability("network.har", true);
//            capabilities.setCapability("idleTimeout","20");
//            capabilities.setCapability("ie.compatibility","");
//            capabilities.setCapability("unexpectedAlertBehaviour","accept");
//            capabilities.setCapability("safari.cookies", true);
//            capabilities.setCapability("w3c",true);
//            capabilities.setCapability("seleniumVersion", "3.0.1");


        /*  System.out.println(Tunnel);
            if (this.Tunnel.matches("true")) {

               RunTunnelListener TunnelInitateObjectToStart= new RunTunnelListener();
               TunnelInitateObjectToStart.onExecutionStart();
               Thread.sleep(20000);
               capabilities.setCapability("tunnel", "true");
            }*/

//                 capabilities.setCapability("unboundRegion", "PUSE-EU");
//                 capabilities.setCapability("timezone", this.TimeZoneValue);
//                 capabilities.setCapability("geoLocation", this.GeoLocationValue);
//                 capabilities.setCapability("headless", true);
//                 capabilities.setCapability("networkThrottling", "Regular 4G");
//                 capabilities.setCapability("prerun", "lambda:BasicAuthChrome/pre/httpdialog.au3");
//                 String[] Tags = new String[]{"myproject", "myproject2","myproject3"};
//                 capabilities.setCapability("tags", Tags);


            StopWatch driverStart = new StopWatch();
            driverStart.start();

            hub = "http://" + username + ":" + accesskey + gridURL;
//            hub="http://localhost:4444/wd/hub";
            System.out.println(hub);

            driver = new RemoteWebDriver(new URL(hub), capabilities);
//            driver = new RemoteWebDriver(new URL("https://mohammadasadkhan1:CsbtfqVzuuBShxEgq1K3@hub-cloud.browserstack.com/wd/hub"),capabilities);

            session = driver.getSessionId();

//            System.out.println(driver + "Session ID" + "  " + session.toString() + "\n" + browser + version + "\n" + fixedIp);
            driverStart.stop();

            float timeElapsed = driverStart.getTime() / 1000f;
            System.out.println("Driver initiate time" + "   " + timeElapsed);


        } catch (
                MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception f) {
            status = "failed";
            System.out.println(f);
            // System.out.println(f.getMessage() + browser + version + fixedIp);
        }
        //   }


    }

    @Test
    public void DesktopScript() {
        try {

            SessionTest SessionTestObject = new SessionTest();
            SessionTestObject.SessionLaunch(driver, status);

//             uploadTest UPFile = new uploadTest();
//             UPFile.upload(driver, status);

            TodoApp TodoAppTestObject = new TodoApp();
            TodoAppTestObject.TodoAppTest(driver);

//             NetSpeed NetSpeedTestObject = new NetSpeed();
//             NetSpeedTestObject.NetSpeed(driver, status, Nettotalspeedtest);

//             UserTest UserTestObject= new UserTest();
//             UserTestObject.TestCase(driver,status);
           
//             DownloadTest downLoad= new DownloadTest();
//             downLoad.FileDownload(driver);

//            GeolocationTest Geolocationobject = new GeolocationTest();
//            Geolocationobject.Geolocation(driver, status, GeoLocationValue, GeolocationTotal);

            ResolutionTest ResolutionTestObject = new ResolutionTest();
            ResolutionTestObject.Resolution(driver, ResolutionValue, status, ResolutionTotal, this.ResolutionValueCap);

            StreamTest StreamTestObject = new StreamTest();
            StreamTestObject.TestStream(driver, status);


//            TunnelTest TunnelTestObject = new TunnelTest();
//            TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);
//            System.out.println(Tunnel);

          /*  for (int i = 0; i < 15; i++) {
                TodoApp TodoAppTestObject = new TodoApp();
                TodoAppTestObject.TodoAppTest(driver);
                ResolutionTest ResolutionTestObject = new ResolutionTest();
                ResolutionTestObject.Resolution(driver, ResolutionValue, status, ResolutionTotal, this.ResolutionValueCap);

            }
            */

            /*if (this.Tunnel.matches("true")) {
                TunnelTest TunnelTestObject = new TunnelTest();
                TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);
            }*/


        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @AfterTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform"})
    public void tearDown(String version, String platform, String browser) throws Exception {
        long quitetimestart;
        long quitetimestop;

        quitetimestart = System.currentTimeMillis();

        if (driver != null) {
            System.out.println(driver + "Session ID" + "  " + session.toString());
            driver.quit();
//            RunTunnelListener TunnelInitateObjectToStop = new RunTunnelListener();
//            TunnelInitateObjectToStop.onExecutionFinish();
//            t.stop();

        }
        quitestoptime = System.currentTimeMillis();
        quitetimestop = quitestoptime - quitetimestart;
        System.out.println(platform + "  " + browser + "  " + version + "\n" + "Driver Quit time" + "   " + quitetimestop / 1000f + "Sec.");

    }


}

