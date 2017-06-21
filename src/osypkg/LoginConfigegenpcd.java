    package osypkg;

    import java.awt.Color;
    import java.awt.Robot;
    import java.awt.event.InputEvent;
    import java.io.IOException;
    import java.util.List;
    import java.util.NoSuchElementException;
    import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.ExpectedCondition;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.FluentWait;
    import org.openqa.selenium.support.ui.Wait;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.sikuli.api.DesktopScreenRegion;
    import org.sikuli.api.ScreenRegion;
    import org.sikuli.api.visual.Canvas;
    import org.sikuli.api.visual.DesktopCanvas;

    /*import com.cobra.ldtp.Ldtp;
     import com.cobra.ldtp.LdtpExecutionError;
     import com.cobra.ldtp.PollEvents;*/
    //public class SeleniumSikuliPCD implements Runnable{
    public class LoginConfigegenpcd {

        /*
             * final private Log logger = LogFactory.getLog(FirefoxDriver.class); static
             * private final int DEFAULT_WAIT_TIMEOUT_MSECS = 10000;
         */
        //private static Match Returnfind = null;
        //static private WebDriver driver;
        //static private Screen screenRegion;
        // static JavascriptExecutor executor;
        static private String TestCase = "";
        static private String TestMachineIP = "";
        static private String CustmerName = "";
        /*
             * static private boolean LinuxVm=false; static private boolean
             * WindowsVm=false;
         */
        static private int linuxVmNum = 0;
        static private int windowsVmNum = 0;
        ProcessBuilder pb;
        Process p = null;
        String windowName;
        private boolean testingStatus = false;

        public void start() throws Exception {

            ScreenRegion DesktopScrRegion = new DesktopScreenRegion(300, 400, 0, 0);
            Canvas Desktopcanvas = new DesktopCanvas();
            Desktopcanvas.addBox(DesktopScrRegion).withLineColor(Color.GRAY).withColor(Color.yellow);

            boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
            try {
                if (isDebug) {
                    Desktopcanvas.clear();
                }
                Desktopcanvas.addLabel(DesktopScrRegion, "taskkill /F /IM drivers.exe");
                Desktopcanvas.display(2);

                AutoTestingAdminNB AutoTestingAdminN = new AutoTestingAdminNB();
                AutoTestingAdminN.setMessagesArea("test");

                Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");

            } catch (IOException e) {
                e.printStackTrace();
            }

    //            String USERNAME = "osamaaltalabani1";
    //            String AUTOMATE_KEY = "XMLYaQFfrzqnEEq9DZxp";
    //            String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    //  
    //            DesiredCapabilities caps = new DesiredCapabilities();
    //            caps.setCapability("browser", "firefox");
    //            caps.setCapability("browserstack.debug", "true");
    //            caps.setCapability("build", "First build");
    //
    //            WebDriver BrowserStack = new RemoteWebDriver(new URL(URL), caps);
    //            BrowserStack.get("http://www.google.com");
    //            WebElement  BrowserStackelem = BrowserStack.findElement(By.name("q"));
    //
    //            BrowserStackelem.sendKeys("BrowserStack");
    //            BrowserStackelem.submit();
    //
    //            System.out.println(BrowserStack.getTitle());
    //            BrowserStack.quit();
            //Match MatchStatus = null;
    //                File file = new File("C:\\out.txt");
    //                FileOutputStream fos = new FileOutputStream(file);
    //                PrintStream ps = new PrintStream(fos);
    //                System.setOut(ps);
            WebDriver driver = new ChromeDriver();
            //WebDriver driver = new FirefoxDriver();

            driver.manage().window().maximize();
            driver.get(TestMachineIP);
            System.out.println("Full website is loaded");
            //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    //               driver.manage().window().setPosition(new Point(200,300));
    //		 java.awt.Dimension screenSize =
    //		 java.awt.Toolkit.getDefaultToolkit().getScreenSize(); Dimension dim =
    //		 new Dimension((int) screenSize.getWidth(), (int)
    //		 screenSize.getHeight()); Dimension dim = new Dimension((int) 1600,
    //		 (int) 860); driver.manage().window().setSize(dim);
    //		 		
            System.out.println(driver.getTitle());
            System.out.println("The current Window Handle: "
                    + driver.getWindowHandle());

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    //Wait for the condition
                    .withTimeout(30, TimeUnit.SECONDS)
                    // which to check for the condition with interval of 5 seconds. 
                    .pollingEvery(5, TimeUnit.SECONDS)
                    //Which will ignore the NoSuchElementException
                    .ignoring(NoSuchElementException.class);

            Thread.sleep(1000L);

            //long StartTime = System.currentTimeMillis(); //fetch starting time
            List<WebElement> destinationsList = driver.findElements(By.name("destinationsList"));
            destinationsList.get(0).click();
            destinationsList.get(0).sendKeys("Abu Dhabi, Arabian Gulf");
            //destinationsList.get(0).sendKeys("Benalmadena, Costa del Sol, Spain");
            destinationsList.get(0).click();
            destinationsList.get(0).sendKeys(Keys.ENTER);
            
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<WebElement> obdate = driver.findElements(By.name("obdate"));
            obdate.get(0).click();
            obdate.get(0).sendKeys(Keys.ENTER);
            driver.findElements(By.id("search-holiday-btn")).get(0).click();
            long Time = System.currentTimeMillis(); //fetch starting time

            WebElement results = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#results > h1:nth-child(1)")));

            System.out.println(results.getText());
            System.out.println(Time);
            Time = System.currentTimeMillis() - Time;

            //Desktopcanvas.clear();
            Desktopcanvas.clear().addLabel(DesktopScrRegion, "search time elapsed: " + Time + "  ms");
            Desktopcanvas.display(2);

            Desktopcanvas.clear().addLabel(DesktopScrRegion, "Clicking on VIEW & BOOK");
            Desktopcanvas.display(2);
            Thread.sleep(1000L);

            ExpectedCondition<List<WebElement>> element1 = ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.holiday:nth-child(1) > ul:nth-child(4) > li:nth-child(1) > div:nth-child(3) > a:nth-child(1)"));
            List<WebElement> allVisibleElementselement1 = wait.until(element1);

            if (allVisibleElementselement1.size() > 0) {

                Desktopcanvas.clear().addLabel(DesktopScrRegion, "found VIEW & BOOK");
                Desktopcanvas.display(3);
                allVisibleElementselement1.get(0).click();

            } else {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "not found VIEW & BOOK");
                Desktopcanvas.display(3);
            }

            Thread.sleep(10000L);
            Desktopcanvas.clear().addLabel(DesktopScrRegion, "Clicking on NEXT on holiday detials");
            Desktopcanvas.display(3);
            Thread.sleep(1000L);

            List<WebElement> details_next = driver.findElements(By.xpath("//*[@id='details-next-after-content']/a[1]"));
            Thread.sleep(100L);

            if (details_next.size() > 0) {
                Thread.sleep(1000L);
                details_next.get(0).click();
            }
            
            //JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,1300)", "");
            //Robot robot = new Robot();
    //        robot.mouseMove(364,431);
    //        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    //        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            
            //ExpectedCondition<List<WebElement>> loadRooms = ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='loadRooms']/div/div/section/div/label"));
            //List<WebElement> allVisibleElementloadRooms = wait.until(loadRooms);

            //*[@id="loadRooms"]/div/div[2]/div/label            
            Thread.sleep(11000L);
            List<WebElement> loadRooms = driver.findElements(By.xpath("//*[@id='loadRooms']/div/div[2]/div/label"));
            if (loadRooms.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found loadRooms");
                Desktopcanvas.display(3);
                loadRooms.get(0).click();
             } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found loadRooms");
                Desktopcanvas.display(3);
            }

            //List<WebElement> loadRooms1=  driver.findElements(By.xpath("//*[@id='loadRooms']/div/div/section/div/label"));
            //if (loadRooms1.size()>0){
            // loadRooms1.get(0).click();
            // }
                                   
            Thread.sleep(1500L);
            List<WebElement> nextDayCk1 = driver.findElements(By.xpath("//*[@id='accommodation']/div/div[2]/label"));

            if (nextDayCk1.size() > 0) {
                nextDayCk1.get(0).click();
            }

            Thread.sleep(100L);
            List<WebElement> nextDayCk2 = driver.findElements(By.xpath("//*[@id='accommodation']/div[2]/label"));
            Thread.sleep(1500L);

            if (nextDayCk2.size() > 0) {
                nextDayCk2.get(0).click();
            }

            Thread.sleep(100L);
            List<WebElement> insurance = driver.findElements(By.xpath("//*[@id='insurance']/div[2]/div/div[2]/div[3]/label"));
            Thread.sleep(100L);

            if (insurance.size() > 0) {
                insurance.get(0).click();
            }

            Thread.sleep(1000L);
            List<WebElement> insurance1 = driver.findElements(By.xpath("//*[@id='insurance']/div[2]/div/div[1]/label/div[2]"));
            Thread.sleep(100L);

            if (insurance1.size() > 0) {
                insurance1.get(0).click();
            }

            Thread.sleep(1000L);
            List<WebElement> booking_process = driver.findElements(By.xpath("//*[@id='booking-process']/section/nav/div/a[1]"));
            Thread.sleep(100L);
            if (booking_process.size() > 0) {
                booking_process.get(0).click();
            }

            Thread.sleep(1000L);
            List<WebElement> title1 = driver.findElements(By.xpath("//*[@id='title1']"));
            Thread.sleep(100L);
            if (title1.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found title1");
                Desktopcanvas.display(3);
                //Thread.sleep(100L);
                title1.get(0).click();
                Thread.sleep(100L);
                title1.get(0).sendKeys("Mr");
                //Thread.sleep(100L);
                title1.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found title1");
                Desktopcanvas.display(3);
            }

            //*[@id="first-name1"]
            Thread.sleep(1000L);
            List<WebElement> first_name1 = driver.findElements(By.xpath("//*[@id='first-name1']"));
            Thread.sleep(100L);
            if (first_name1.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found first_name1");
                Desktopcanvas.display(3);
                //Thread.sleep(100L);
                first_name1.get(0).click();
                Thread.sleep(100L);
                first_name1.get(0).sendKeys("Osy");
                //Thread.sleep(100L);
                first_name1.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found first_name1");
                Desktopcanvas.display(3);
            }

            //*[@id="last-name1"]
            Thread.sleep(1000L);
            List<WebElement> last_name1 = driver.findElements(By.xpath("//*[@id='last-name1']"));
            Thread.sleep(100L);
           if (last_name1.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found last_name1");
                Desktopcanvas.display(3);
                //Thread.sleep(100L);
                last_name1.get(0).click();
                Thread.sleep(100L);
                last_name1.get(0).sendKeys("Osylastname");
                Thread.sleep(100L);
                last_name1.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found last_name1");
                Desktopcanvas.display(3);
            }

            //*[@id="title2"]
            Thread.sleep(1000L);
            List<WebElement> title2 = driver.findElements(By.xpath("//*[@id='title2']"));
            Thread.sleep(100L);
            if (title2.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found title2");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                title2.get(0).click();
                Thread.sleep(100L);
                title2.get(0).sendKeys("Ms");
                Thread.sleep(100L);
                first_name1.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found title2");
                Desktopcanvas.display(3);
            }

            //*[@id="first-name2"]
            Thread.sleep(1000L);
            List<WebElement> first_name2 = driver.findElements(By.xpath("//*[@id='first-name2']"));
            Thread.sleep(100L);
            if (first_name2.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found first-name2");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                first_name2.get(0).click();
                Thread.sleep(100L);
                first_name2.get(0).sendKeys("MsOsy");
                Thread.sleep(100L);
                first_name2.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found first-name2");
                Desktopcanvas.display(3);
            }

            //*[@id="last-name2"]
            Thread.sleep(1000L);
            List<WebElement> last_name2 = driver.findElements(By.xpath("//*[@id='last-name2']"));
            Thread.sleep(100L);
            if (last_name2.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found first-name2");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                last_name2.get(0).click();
                Thread.sleep(100L);
                last_name2.get(0).sendKeys("Osyfirstname");
                Thread.sleep(100L);
                last_name2.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found first-name2");
                Desktopcanvas.display(3);
            }

            //*[@id="street"]
            Thread.sleep(1000L);
            List<WebElement> street = driver.findElements(By.xpath("//*[@id='street']"));
            Thread.sleep(100L);
            if (street.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found street");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                street.get(0).click();
                Thread.sleep(100L);
                street.get(0).sendKeys("4, Lealand Grove, Bawnoges");
                Thread.sleep(100L);
                //street.get(0).click();
                street.get(0).sendKeys(Keys.TAB);
                   
            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found street");
                Desktopcanvas.display(3);
            }

            //*[@id="mobilePrefix"]
            Thread.sleep(1000L);
            List<WebElement> mobilePrefix = driver.findElements(By.xpath("//*[@id='mobilePrefix']"));
            Thread.sleep(100L);
            if (mobilePrefix.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found mobilePrefix");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                mobilePrefix.get(0).click();
                Thread.sleep(100L);
                mobilePrefix.get(0).sendKeys("087");
                Thread.sleep(100L);
                mobilePrefix.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found mobilePrefix");
                Desktopcanvas.display(3);
            }

            //*[@id="mobile"]
            Thread.sleep(1000L);
            List<WebElement> mobile = driver.findElements(By.xpath("//*[@id='mobile']"));
            Thread.sleep(100L);
            if (mobile.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found mobile");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                mobile.get(0).click();
                Thread.sleep(100L);
                mobile.get(0).sendKeys("9015582");
                Thread.sleep(100L);
                mobile.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found mobile");
                Desktopcanvas.display(3);
            }

            //*[@id="town"]
            Thread.sleep(1000L);
            List<WebElement> town = driver.findElements(By.xpath("//*[@id='town']"));
            Thread.sleep(100L);
            if (town.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found town");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                town.get(0).click();
                Thread.sleep(100L);
                town.get(0).sendKeys("Dublin");
                Thread.sleep(100L);
                town.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found town");
                Desktopcanvas.display(3);
            }
            
            //*[@id="county"]
            Thread.sleep(1000L);
            List<WebElement> county = driver.findElements(By.xpath("//*[@id='county']"));
            Thread.sleep(100L);
            if (county.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found county");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                county.get(0).click();
                Thread.sleep(100L);
                county.get(0).sendKeys("Dublin");
                Thread.sleep(100L);
                county.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found county");
                Desktopcanvas.display(3);
            }
            
            //*[@id="email"]
            Thread.sleep(1000L);
            List<WebElement> email = driver.findElements(By.xpath("//*[@id='email']"));
            Thread.sleep(100L);
            if (email.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found email");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                email.get(0).click();
                Thread.sleep(100L);
                email.get(0).sendKeys("osamaa@clickandgo.com");
                Thread.sleep(100L);
                email.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found email");
                Desktopcanvas.display(3);
            }
            
            //*[@id="email_confirm"]
            Thread.sleep(1000L);
            List<WebElement> email_confirm = driver.findElements(By.xpath("//*[@id='email_confirm']"));
            Thread.sleep(100L);
            if (email_confirm.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found email_confirm");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                email_confirm.get(0).click();
                Thread.sleep(100L);
                email_confirm.get(0).sendKeys("osamaa@clickandgo.com");
                Thread.sleep(100L);
                email_confirm.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found email_confirm");
                Desktopcanvas.display(3);
            }
                        
            //*[@id="cardName"]
            Thread.sleep(1000L);
            List<WebElement> cardName = driver.findElements(By.xpath("//*[@id='cardName']"));
            Thread.sleep(100L);
            if (cardName.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found cardName");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                cardName.get(0).click();
                Thread.sleep(100L);
                cardName.get(0).sendKeys("osy card name");
                Thread.sleep(100L);
                cardName.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found cardName");
                Desktopcanvas.display(3);
            }
        
            //*[@id="cardStreet"]
            Thread.sleep(1000L);
            List<WebElement> cardStreet = driver.findElements(By.xpath("//*[@id='cardStreet']"));
            Thread.sleep(100L);
            if (cardStreet.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found cardStreet");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                
                cardStreet.get(0).click();
                Thread.sleep(100L);
                cardStreet.get(0).sendKeys("4, Lealand Grove, Bawnoges");
                Thread.sleep(100L);
                cardStreet.get(0).sendKeys(Keys.TAB);
                

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found cardStreet");
                Desktopcanvas.display(3);
            }
                  
            //*[@id="cardTown"]
            Thread.sleep(1000L);
            List<WebElement> cardTown = driver.findElements(By.xpath("//*[@id='cardTown']"));
            Thread.sleep(100L);
            if (cardTown.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found cardTown");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                cardTown.get(0).click();
                Thread.sleep(100L);
                cardTown.get(0).sendKeys("Dublin");
                Thread.sleep(100L);
                cardTown.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found cardTown");
                Desktopcanvas.display(3);
            }
            
            //*[@id="cardType"]
            Thread.sleep(1000L);
            List<WebElement> cardType = driver.findElements(By.xpath("//*[@id='cardType']"));
            Thread.sleep(1000L);
            if (cardType.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found cardType");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                cardType.get(0).click();
                Thread.sleep(100L);
                cardType.get(0).sendKeys("Visa");
                Thread.sleep(100L);
                cardType.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found cardType");
                Desktopcanvas.display(3);
            }
            
            
            //*[@id="cardNumber"]
            Thread.sleep(1000L);
            List<WebElement> cardNumber = driver.findElements(By.xpath("//*[@id='cardNumber']"));
            Thread.sleep(1000L);
            if (cardNumber.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found cardNumber");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                cardNumber.get(0).click();
                Thread.sleep(100L);
                cardNumber.get(0).sendKeys("1234567891");
                Thread.sleep(100L);
                cardNumber.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found cardNumber");
                Desktopcanvas.display(3);
            }
            
            //*[@id="cardExpiry"]
            Thread.sleep(1000L);
            List<WebElement> cardExpiry = driver.findElements(By.xpath("//*[@id='cardExpiry']"));
            Thread.sleep(1000L);
            if (cardExpiry.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found cardExpiry");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                cardExpiry.get(0).click();
                Thread.sleep(100L);
                cardExpiry.get(0).sendKeys("10/18");
                Thread.sleep(100L);
                cardExpiry.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found cardExpiry");
                Desktopcanvas.display(3);
            } 
            
            //*[@id="cardCVV"]
            Thread.sleep(1000L);
            List<WebElement> cardCVV = driver.findElements(By.xpath("//*[@id='cardCVV']"));
            Thread.sleep(1000L);
            if (cardCVV.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found cardCVV");
                Desktopcanvas.display(3);
                Thread.sleep(100L);
                cardCVV.get(0).click();
                Thread.sleep(100L);
                cardCVV.get(0).sendKeys("334");
                Thread.sleep(100L);
                cardCVV.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found cardCVV");
                Desktopcanvas.display(3);
            } 
            
            //*[@id="card"]/div/p[1]/label
             Thread.sleep(1000L);
            List<WebElement>  Iagree  = driver.findElements(By.xpath("//*[@id='agreeterms']"));
            //*[@id="agreeterms"]
            if (Iagree.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found I agree");
                Desktopcanvas.display(3);
                Iagree.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found I agree");
                Desktopcanvas.display(3);
            }
                                   
            //*[@id="card"]/div/p[2]/label
             Thread.sleep(1000L);
            List<WebElement>  Iauthorise  = driver.findElements(By.xpath("//*[@id='card']/div/p[2]/label"));
            if (Iauthorise.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found I authorise");
                Desktopcanvas.display(3);
                Iauthorise.get(0).click();

            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found I authorise");
                Desktopcanvas.display(3);
            }
            
            //*[@id="holiday-payment-form"]/nav/div/a
             Thread.sleep(1000L);
            List<WebElement>  holiday_payment_form  = driver.findElements(By.xpath("//*[@id='holiday-payment-form']/nav/div/a"));
            if (holiday_payment_form.size() > 0) {
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Found holiday_payment_form");
                Desktopcanvas.display(3);
                //holiday_payment_form.get(0).click();
                Robot robot = new Robot();
                robot.mouseMove(holiday_payment_form.get(0).getLocation().getX(),holiday_payment_form.get(0).getLocation().getY());
                //robot.mouseMove(holiday_payment_form.get(0).getRect().x,holiday_payment_form.get(0).getRect().y);
            } else {
                Desktopcanvas.clear();
                Desktopcanvas.clear().addLabel(DesktopScrRegion, "Not found holiday_payment_form");
                Desktopcanvas.display(3);
            }
            
            
            
    //                  File file = new File("C:\\Users\\another\\Desktop\\out.txt");
    //                  FileOutputStream fos = new FileOutputStream(file);
    //                  PrintStream ps = new PrintStream(fos);
    //                  System.setOut(ps);
    //                  URL myResUrl = null;
    //                  //Class<?> cl = this.getClass();
    //                  ClassLoader cl = getClass().getClassLoader();
    //                  myResUrl=  this.getClass().getResource("/images/WEbStartButton.png");
    //                  System.out.println( myResUrl.toURI().toString());
            //GetAction getAction =new GetAction();  
            //long StartTime = System.currentTimeMillis(); //fetch starting time
    //                 new Thread(() -> {
    //                 long StartTimes = System.currentTimeMillis(); 
    //                 Match MatchStatuss = null;
    //                 do {
    //		 if (System.currentTimeMillis()-StartTimes <60000){ 
    //                     try {
    //                         MatchStatuss = getAction.findTargetImg("/images/DontBlock.png",
    //                                 "Dont Block", "Click", null, null, 0.7);
    //                     } catch (FindFailed ex) {
    //                         Logger.getLogger(LoginConfigegenpcd.class.getName()).log(Level.SEVERE, null, ex);
    //                     } catch (InterruptedException ex) {
    //                         Logger.getLogger(LoginConfigegenpcd.class.getName()).log(Level.SEVERE, null, ex);
    //                     } catch (IOException ex) {
    //                         Logger.getLogger(LoginConfigegenpcd.class.getName()).log(Level.SEVERE, null, ex);
    //                     }
    //		 if (MatchStatuss != null) {
    //		 break;
    //		 }
    //		 if (MatchStatuss == null&&System.currentTimeMillis()-StartTimes >60000)
    //		 {
    //		 Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
    //		 Desktopcanvas.addLabel(DesktopScrRegion, "Fetching timer elapsed");
    //		 Desktopcanvas.display(10);
    //		 System.exit(1);
    //		 }}} while (MatchStatuss == null);
    //                    try {  
    //                        Thread.sleep(100L);
    //                    } catch (InterruptedException ex) {
    //                        Logger.getLogger(LoginConfigegenpcd.class.getName()).log(Level.SEVERE, null, ex);
    //                    }
    //                 }).start();
    //                 
    //                 StartTime = System.currentTimeMillis();
    //                 do {
    //		 if (System.currentTimeMillis()-StartTime <120000){ // With 1 minute or 6,0000 milliseconds check since the loop started.
    //		 MatchStatus = getAction.findTargetImg("/images/WEbStartButton.png", "WEbStartButton.png", "Click", null,
    //		 null,0.7,0);
    //		 if (MatchStatus != null) {
    //		 break;
    //		 }
    //		 if (MatchStatus == null&&System.currentTimeMillis()-StartTime >60000)
    //		 {
    //		 Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
    //        	 Desktopcanvas.addLabel(DesktopScrRegion, "Fetching timer elapsed");
    //		 Desktopcanvas.display(10);
    //		 System.exit(1);
    //		 }}} while (MatchStatus == null);
    //		 Thread.sleep(100L);
    //
    //
    //
    //                 StartTime = System.currentTimeMillis();
    //                 do {
    //		 if (System.currentTimeMillis()-StartTime <120000){ // With 1 minute or 6,0000 milliseconds check since the loop started.
    //		 MatchStatus = getAction.findTargetImg("/images/OKBlueOpenJNLP.png", "OKBlueOpenJNLP.png", "Click", null,
    //		 null,0.7,0);
    //		 if (MatchStatus != null) {
    //		 break;
    //		 }
    //		 if (MatchStatus == null&&System.currentTimeMillis()-StartTime >60000)
    //		 {
    //		 Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
    //        	 Desktopcanvas.addLabel(DesktopScrRegion, "Fetching timer elapsed");
    //		 Desktopcanvas.display(10);
    //		 System.exit(1);
    //		 }}} while (MatchStatus == null);
    //		 Thread.sleep(100L);
    //                  
    //                Object[][] RegionCoordinleft = { { 1, 10 }, { 240, 10 },
    //                                               { 50, 50 }, { 50, 50 }, 
    //                                               { 100, 100 } };
    //                
    //		Object[][] RegionCoordinCenter = { { 400, 170 }, { 150, 900 },
    //				{ 400, 600 }, { 600, 600 }, { 70, 70 } };
    //
    //		Object[][] RegionCoordinCenterBottom = { { 400, 400 }, { 150, 900 },
    //				{ 400, 600 }, { 600, 600 }, { 70, 70 } };
    //
    //		LinkedHashMap<Integer, Object[]> LHashMapServerCoordin = new LinkedHashMap<>();
    //
    //		LHashMapServerCoordin.put(1, RegionCoordinleft[0]);
    //
    //                 StartTime = System.currentTimeMillis();
    //                 do {
    //		 if (System.currentTimeMillis()-StartTime <120000){ // With 1 minute or 6,0000 milliseconds check since the loop started.
    //		 MatchStatus = getAction.findTargetImg("/images/AddConnectionTab.png", "AddConnectionTab", "Click", null,
    //		 null,0.7,0);
    //		 if (MatchStatus != null) {
    //		 break;
    //		 }
    //		 if (MatchStatus == null&&System.currentTimeMillis()-StartTime >60000)
    //		 {
    //		 Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
    //        	 Desktopcanvas.addLabel(DesktopScrRegion, "Fetching timer elapsed");
    //		 Desktopcanvas.display(10);
    //		 System.exit(1);
    //		 }}} while (MatchStatus == null);
    //		 Thread.sleep(100L);
    //		 
    ////                 StartTime = System.currentTimeMillis();            
    ////                 do {
    ////		 if (System.currentTimeMillis()-StartTime <60000){ 
    ////		 MatchStatus = GetAction.findTargetText("Add", "Add", "Click", null,
    ////		 null);
    ////		 if (MatchStatus != null) {
    ////		 break;
    ////		 }
    ////		 if (MatchStatus == null&&System.currentTimeMillis()-StartTime >60000)
    ////		 {
    ////		 Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
    ////		 Desktopcanvas.addLabel(DesktopScrRegion, "Fetching timer elapsed");
    ////		 Desktopcanvas.display(10);
    ////		 System.exit(1);
    ////		 }}} while (MatchStatus == null);
    ////		 Thread.sleep(100L);
    ////                    
    //                 String UserName= "osy1";
    //                 String Pass="osy";
    //                 getAction.RobotAction("AddConnectionLogin",UserName,Pass,TestMachineIP);
    //
    //                 StartTime = System.currentTimeMillis();
    //                 do {
    //		 if (System.currentTimeMillis()-StartTime <60000){ 
    //		 MatchStatus =
    //		 getAction.findTargetImg("/images/OKLogin.png",
    //		 "OK Login", "Click", null, null, 0.7,0);
    //		 if (MatchStatus != null) {
    //		 break;
    //		 }
    //		 if (MatchStatus == null&&System.currentTimeMillis()-StartTime >60000)
    //		 {
    //		 Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
    //		 Desktopcanvas.addLabel(DesktopScrRegion, "Fetching timer elapsed");
    //		 Desktopcanvas.display(10);
    //		 System.exit(1);
    //		 }}} while (MatchStatus == null);
    //		 Thread.sleep(100L);  
    //                 
    //      driver.quit();   
            //driver.close();
            //System.out.println("Starting testing path :" + TestCase);
            testingStatus = true;

            if (TestCase.contentEquals("1")) {
                //AddNewCompany.AddCustBuildEnv();
                //getAction.RobotDoAction("TAB");
                //getAction.RobotDoAction("ENTER");
            }

            if (TestCase.contentEquals("5")) {
                System.out.println("Starting testing path :" + TestCase);
                //AddNewCompany.AddCustBuildEnv(false);
                //Thread.sleep(1000L);
                //GetAction.RobotDoAction("ENTER");
                if (linuxVmNum != 0 || windowsVmNum != 0) {
                    //BuildNewVmwareEnvironment buildNewVmwareEnvironment = new BuildNewVmwareEnvironment();
                    //buildNewVmwareEnvironment.BuildNewVmwareEnv("New");
                }
            }

    //		if (TestCase.contentEquals("5")) {
    //			GetAction.findTargetText(CustmerName, CustmerName, "DoubleClick",
    //					null, null);
    //			//BuildNewVmwareEnvironment.BuildNewVmwareEnv(CustmerName);
    //
    //		}
            testingStatus = false;
            System.out.println("End");
            Desktopcanvas.clear();
            Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
            Desktopcanvas.addLabel(DesktopScrRegion, "End");
            Desktopcanvas.display(100);

        }

        public static void waitForTextToAppear(WebDriver newDriver, String textToAppear, WebElement element) {
            WebDriverWait wait = new WebDriverWait(newDriver, 30);
            wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
        }

        public void setTestCase(String TC) {
            TestCase = TestCase.replaceAll("", TC.toString());

        }

        public void setTestMachineIP(String IP) {
            TestMachineIP = TestMachineIP.replaceAll("", IP.toString());

        }

        public void setCustmerName(String Name) {
            CustmerName = CustmerName.replaceAll("", Name.toString());

        }

        /*
             * public void setVmType (boolean linuxVm,boolean windowsVm) {
             * LinuxVm=linuxVm; WindowsVm=windowsVm;
             * 
             * }
         */
        public void setVmNumber(int linuxVmN, int windowsVmN) {
            linuxVmNum = linuxVmN;
            windowsVmNum = windowsVmN;

        }

        public static int getLinuxVmNum() {
            return linuxVmNum;
        }

        public boolean getTestingStatus() {
            return testingStatus;

        }

        public void setTestingStatus(boolean testingNow) {
            testingStatus = testingNow;

        }

        public void set(boolean testingNow) {
            testingStatus = testingNow;

        }
    }
