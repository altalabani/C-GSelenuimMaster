//package osypkg;
//
//
//import java.awt.AWTException;
//import java.awt.Dimension;
//import java.awt.Image;
//import java.awt.Rectangle;
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.StringSelection;
//
//import java.awt.event.KeyEvent;
//import java.awt.im.InputContext;
//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.net.URL;
//import java.nio.ByteBuffer;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//
//import org.sikuli.api.DesktopScreenRegion;
//import org.sikuli.api.ScreenRegion;
//import org.sikuli.api.visual.Canvas;
//import org.sikuli.api.visual.DesktopCanvas;
//import org.sikuli.basics.Settings;
//import org.sikuli.script.Button;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Match;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Region;
//import org.sikuli.script.Screen;
//import org.sikuli.script.ScreenImage;
//import org.sikuli.script.TextRecognizer;
//
//
//public class GetAction {
//
// public Match  findTargetText(String text, String txtToEnter, String Action,LinkedHashMap<Integer,Object[]> LHashMapSvrRegionCoordin,Match ToFind) throws Exception {
//	 			
//                Match find = null;	
//                InputContext it = InputContext.getInstance();
//		it.selectInputMethod(new Locale("en", "UK", "WIN"));
//		ScreenRegion DesktopScrRegion = new DesktopScreenRegion(300, 400, 200,50);
//		Canvas Desktopcanvas = new DesktopCanvas();
//				
//		Screen screen = new Screen();
//                //ScreenImage screenImage = new Screen().capture();
//		Region region = new Region(screen.getX(), screen.getY(), screen.getW(),screen.getH());
//                
//		//region.highlight(2);
//		
//                if (LHashMapSvrRegionCoordin!=null) {
//			region = new Region((Integer)LHashMapSvrRegionCoordin.get(1)[0],(Integer)LHashMapSvrRegionCoordin.get(1)[1], 300,300);
//			region.highlight(2);
//		}
//                
//                  
//                
//                //ScreenImage screenImageregion = new Screen().capture(region);
//		BufferedImage screenImagebuff = new Screen().capture(region).getImage();
//                //screenImagebuff=  ImageUtil.scale(screenImagebuff, 200, 210);
//                                
//                //screenImagebuff=  ImageUtil.GrayScale(screenImagebuff);
//                //screenImagebuff=ImageUtil.sharpen(screenImagebuff);
//                //screenImagebuff=ImageUtil.sharpen(screenImagebuff);
//                screenImagebuff=ImageUtil.sharpen(screenImagebuff);
//                //screenImagebuff= ImageUtil.threshold(screenImagebuff,80);
//                //screenImagebuff=ImageUtil.sharpen(screenImagebuff);
//                //screenImagebuff=ImageUtil.sharpen(screenImagebuff);
//                //ImageUtil.savePNGWithDPI(screenImagebuff, 300);
//                //screenImagebuff=  ImageUtil.scale(screenImagebuff, 200, 200);
//                //screenImagebuff=ImageUtil.sharpen(screenImagebuff);
//                ScreenImage screenImageZooms=new ScreenImage(region.getRect(), screenImagebuff);
//               
//                //BufferedImage screenImagebuff1=ImageUtil.savePNGWithDPI(screenImagebuff, 100);
//                 
//                //screenImagebuff=ImageUtil.threshold(screenImage1.getImage(),80);
//                //screenImagebuff=ImageUtil.sharpen(screenImagebuff);
//                //screenImagebuff=ImageUtil.sharpen(screenImage1.getImage());
//                
//                //File outputfile = new File("C:/Users/another/Desktop/osos.tiff");
//                //ImageIO.write(screenImagebuff, "tiff", outputfile);
//              
//               // File file1 = new File("C:\\Users\\another\\Desktop\\MyFile.txt");
//                 
//                 //File file = new File("C:\\Users\\another\\Desktop\\MyFile.png");
//                 //ImageIO.write(screenImagebuff, "png", file);
//                  //BufferedImage img = null;
//                  //screenImagebuff = ImageIO.read(new File("C:/Users/another/Desktop/Osos.tiff"));
//                  //Image image  =ImageIO.read(new File("C:/Users/another/Desktop/Osos.tiff"));
//                 //screenImageZooms=new ScreenImage(region.getRect(), screenImagebuff);
//                  
//                 
////            BufferedImage buffer = ImageIO.read(new File("old.png"));;
////            // Here you can rotate your image as you want (making your magic)
////            Image image  = ImageIO.read(buffer.getAlphaRaster());
////            //ScreenImage screenImageZooms=new ScreenImage(region.getRect(), screenImagebuff);
//////
////                
////                ByteArrayOutputStream baos = new ByteArrayOutputStream();
////                ImageIO.write( screenImagebuff, "jpg", baos );
////                baos.flush();
////                byte[] imageInByte = baos.toByteArray();
//     //BufferedImage screen1 = ImageIO.read(new ByteArrayInputStream(BufferedImage));
//     //BufferedImage part = screen1.getSubimage(screenImagebuff.getData().getBounds().x, screenImagebuff.getData().getBounds().y, screenImagebuff.getData().getBounds().width, screenImagebuff.getData().getBounds().height);
//     //ScreenImage ScreenImage1= new ScreenImage(screenImagebuff.getData().getBounds()., screenImagebuff);
//                
//                
//                
//                
//                List<Match> list;
//                
//                Settings.OcrTextSearch=true;
//                Settings.OcrTextRead=true;
//                Settings.OcrLanguage = "eng";
//                //Settings.WaitAfterHighlight = 4;
////		Settings.isWinApp=true;
// 		//Settings.WaitScanRate = 500f;
//                //Settings.ObserveScanRate = 1.9f;
//		//Settings.DelayValue = 20.0;
// 		//Settings.ObserveMinChangedPixels = 9;
//                Settings.InputFontSize=16;
////               Settings.InputFontMono=true;
//               //Settings.MinSimilarity=0.7;
//               //Settings.RepeatWaitTime=2;
//               //Settings.OverwriteImages=true;
////               
//                String path = "C:/tessdata/";
//			if (path.endsWith("tessdata/")) {
//				path = path.substring(0, path.length() - 9);
//                Settings.OcrDataPath = path;
//                }
//               
//        
////        File imageFile = new File("C:/Users/another/Desktop/Osos.tiff");
////        //ITesseract instance = new Tesseract();  // JNA Interface Mapping
////         ITesseract instance = new Tesseract1(); // JNA Direct Mapping
////        
////        try {
////            String result = instance.doOCR(screenImageZooms.getImage());
////            System.out.println(result);
////        } catch (TesseractException e) {
////            System.err.println(e.getMessage());
////        }
//    
//                        
//        //Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
////        Tesseract1 instance = new Tesseract1();
////        String result = instance.doOCR(screenImagebuff);
////        System.out.println(result);
////
////                        
////                        
////       
////        TessAPITest TessAPITest =new TessAPITest();
////        TessAPITest.setUp();
////        TessAPITest.testTessBaseAPIRect();
////        
//            //String words=  TextRecognizer.getInstance().recognize(screenImagebuff);
//            //System.out.println(words);
//          
//            list =TextRecognizer.getInstance().listText(screenImageZooms, region, TextRecognizer.ListTextMode.WORD);
//		for (int x=0;x<list.size();x++){
//		System.out.println(list.get(x).text());
//			if (list.get(x).text().equals(text)){
//				find= list.get(x);
//			}
//		}
//	    											
//		if (Action.contentEquals("Wait")) {
//			
//			if (find == null) {
//				Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
//				Desktopcanvas.addLabel(DesktopScrRegion,"Searching for "+ txtToEnter+"..");
//				Desktopcanvas.display(1);
//				return null;
//
//			} else {
//
//				return find;
//			}
//		}
//					
//		 if (find != null & Action.contentEquals("Find")) {
//			 	return find;
//		 }
//		
//		/*if(find != null) {
//		    Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
//			Desktopcanvas.addLabel(DesktopScrRegion, text+ " text is found");
//			Desktopcanvas.display(1);
//		}*/
//						
//		if (find != null & Action.contentEquals("rightClick")) {
//				screen.rightClick(find);
//			}
//			
//			if (find != null & Action.contentEquals("Click")) {
//				screen.click(find);
//				
//			}
//			
//			if (find != null & Action.contentEquals("DoubleClick")) {
//				screen.doubleClick(find);
//			
//			}
//
//			if (find != null & Action.contentEquals("MouseMove")) {
//				screen.mouseMove(find);
//				
//			}
//						
//			if (find != null & Action.contentEquals("DoubleClickPropertySetting")) {
//				region.highlight();
//				
//			}
//			
//			if (find != null & Action.contentEquals("DragDrop")) {
//				
//				if (LHashMapSvrRegionCoordin!=null) {
//					region = new Region((Integer)LHashMapSvrRegionCoordin.get(1)[0],(Integer)LHashMapSvrRegionCoordin.get(1)[1], find.getW(),find.getH());
//					//region.highlight(2);
//				}
//				//Region regionDragDrop = new Region((Integer)LHashMapSvrRegionCoordin.get(1)[0],(Integer)LHashMapSvrRegionCoordin.get(1)[1],find.getW(),find.getH());
//			    //Region regionDragDrop = new Region(383,51,find.getW(),find.getH());
//				screen.dragDrop(find,region);
//				
//			} 
//		
//			else if (find == null) {
//			Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
//			Desktopcanvas.addLabel(DesktopScrRegion, text+ " not found");
//			Desktopcanvas.display(5);
//			return null;
//		}
//		return find;
//	}
//
////public static Match findTargetImg(BufferedImage img,String imageName,String Action,LinkedHashMap<Integer,Object[]> LHashMapSvrRegionCoordin,Match ToFind,double similarity) throws FindFailed, InterruptedException {
//
//public Match findTargetImg(String imagePath,String imageName,String Action,LinkedHashMap<Integer,Object[]> LHashMapSvrRegionCoordin,Match ToFind,double similarity, int iterate) throws FindFailed, InterruptedException, IOException {
//                
////    System.setSecurityManager(new SecurityManager());
////    
////        AccessController.doPrivileged(new PrivilegedAction() {
////            public Object run() {
////                // put the privileged code here, example:
////                System.loadLibrary("awt");
////                return null; // in our scenario nothing to return
////            }
////        });
//    
//                   
//	        ScreenRegion DesktopScrRegion = new DesktopScreenRegion(300, 400, 200,50); 
//                Canvas Desktopcanvas = new DesktopCanvas();
//                //URL url = this.getClass().getResource("/images/WEbStartButton.png");
//                //java.security.Permission readPermission = new java.io.FilePermission('/home/remon/thesis.pdf', 'read');
//                System.out.println("start loadeding image");
//                URL url = this.getClass().getResource(imagePath);
//                System.out.println("image path: "+url);
//                Pattern pattrenImage;
//      
//                Image image = ImageIO.read(url);
//                BufferedImage buffered = (BufferedImage) image;
//                pattrenImage = new Pattern(buffered);
//                image.flush();
//                Screen screen = new Screen();
//               	Match find;
//                System.out.println("image is loaded");
//		Region region = new Region(screen.getX(), screen.getY(), screen.getW(),screen.getH());
//               
//		if (null!=LHashMapSvrRegionCoordin) {
//			region = new Region((Integer)LHashMapSvrRegionCoordin.get(1)[0],(Integer)LHashMapSvrRegionCoordin.get(1)[1], (Integer)LHashMapSvrRegionCoordin.get(1)[2],(Integer)LHashMapSvrRegionCoordin.get(1)[3]);
//			region.highlight(2);
//		}
//                
//                  if (0.99==similarity){
//                      		
//			find =region.exists(pattrenImage.similar((float) 0.99));
//		}else{
//			find = region.exists(pattrenImage.similar((float) 0.7));
//		}
//		
//                               
//		if (Action.contains("Wait")) {
//			if (find == null) {
//				Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
//				Desktopcanvas.addLabel(DesktopScrRegion,"Searching "+imageName+"..");
//				Desktopcanvas.display(1);
//				return null;
//
//			} else {
//
//				return find;
//			}
//		}
//		
//                 if (find != null & Action.contentEquals("Find")) {
//                                System.out.println("found image");
//			 	return find;
//		 }
//						
//		 if (find != null & Action.contentEquals("Click")) {
//                     if (iterate>1){
//                        for (int i=1;i< iterate;i++){
//                         screen.click(find);
//                         }
//                     }else{
//                        screen.click(find);
//                     }                                   
//		 }
//
//                  if (find != null & Action.contentEquals("DoubleClickBelow")) {
//			 	screen.above(0).doubleClick();
//		 }
//                  
//                   if (find != null & Action.contentEquals("ClickAbove")) {
//			 	 screen.above(0).click();
//		 }
//                 
//		 if (find != null & Action.contentEquals("DoubleClick")) {
//				screen.doubleClick(find);
//		}
//			
//		if (find != null &Action.contentEquals("DragDrop")&& ToFind==null) {
//				screen.dragDrop(find,region);
//		}
//		 
//		if (find != null &Action.contentEquals("DragDrop")&& ToFind!=null) {
//				screen.dragDrop(find,ToFind);
//		}
//			
//		if (find != null & Action.contentEquals("ScrollD")) {
//				//screen.wheel(find,Button.WHEEL_DOWN, 4);
//				/*Location loc= new Location(find.getX(),find.getY()+50);
//				find.drag(loc);*/
//		screen.wheel(find,Button.WHEEL_DOWN, 40);
//		}
//                
//                if (find != null & Action.contentEquals("rightClick")) {
//				region.rightClick(find);
//			}
//								
//		else if (find == null) {
//			Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
//			Desktopcanvas.addLabel(DesktopScrRegion, imageName +" not found");
//			Desktopcanvas.display(1);
//                        System.out.println("image not found");
//			return null;
//		}
//
//		return find;
//	}
//
//	
//	public  void RobotDoAction(String Virtualkey) throws AWTException {
//	
//	int KeyEvent= 0;
//	Robot robot = new Robot();
//	
//	if (Virtualkey.contentEquals("ENTER")){
//		KeyEvent= 10;
//					
//	}
//	
//	if (Virtualkey.contentEquals("TAB")){
//		KeyEvent= 9;
//					
//	}
//	
//	robot.keyPress(KeyEvent);
//	robot.keyRelease(KeyEvent);
//	//robot.delay(1000);
//	
//	}
//	
//	public  void RobotAction(String Action, String UserName,String Pass,String PCDHostIP) throws AWTException, InterruptedException {
//		
//		InputContext it = InputContext.getInstance();
//		it.selectInputMethod(new Locale("en", "US", "WIN"));
//		Robot robot = new Robot();
//		robot.delay(600);
//		robot.setAutoDelay(10);
//		Thread.sleep(1000L);
//		robot.setAutoWaitForIdle(true);
//
//		switch (Action) {
//
//		case "UserTab":
//                    
//                   // String get= text.getText();
//                    StringSelection selec= new StringSelection(UserName+"firstname");
//                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//                    clipboard.setContents(selec, selec);
//			
//                    //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(UserName+"firstname"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection(UserName+"secondname"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit()
//					.getSystemClipboard()
//					.setContents(new StringSelection("oaltala@egenera.com"),
//							null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit()
//					.getSystemClipboard()
//					.setContents(new StringSelection("oaltala@egenera.com"),
//							null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection(UserName), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection(UserName+"pass"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection(UserName+"pass"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//			break;
//
//		case "CustomerTab":
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection(UserName), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("1234567890"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("0876543210"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("address1"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("address2"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("d22"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("test link"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("www.egenera.com"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(500);
//
//			robot.keyPress(KeyEvent.VK_TAB);
//			robot.keyRelease(KeyEvent.VK_TAB);
//
//			Toolkit.getDefaultToolkit().getSystemClipboard()
//					.setContents(new StringSelection("Partner's REF"), null);
//
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(100);
//			break;
//                    
//                case "AddConnectionLogin":
//                    
//                    robot.keyPress(KeyEvent.VK_TAB);
//                    robot.keyRelease(KeyEvent.VK_TAB);
//                    selec= new StringSelection(PCDHostIP);
//                    clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//                    clipboard.setContents(selec, selec);
//                    robot.keyPress(KeyEvent.VK_CONTROL);
//                    robot.keyPress(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_CONTROL);
//                    robot.delay(500);
//			
//                    robot.keyPress(KeyEvent.VK_TAB);
//                    robot.keyRelease(KeyEvent.VK_TAB);
//                    selec= new StringSelection(UserName);
//                    clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//                    clipboard.setContents(selec, selec);
//                    robot.keyPress(KeyEvent.VK_CONTROL);
//                    robot.keyPress(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_CONTROL);
//                    robot.delay(500);
//
//                    robot.keyPress(KeyEvent.VK_TAB);
//                    robot.keyRelease(KeyEvent.VK_TAB);
//                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(Pass), null);
//                    robot.keyPress(KeyEvent.VK_CONTROL);
//                    robot.keyPress(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_CONTROL);
//                    robot.delay(500);
//
//			//robot.keyPress(KeyEvent.VK_TAB);
//			//robot.keyRelease(KeyEvent.VK_TAB);
//
//			
//			//robot.keyPress(KeyEvent.VK_CONTROL);
//			//robot.keyPress(KeyEvent.VK_V);
//			//robot.keyRelease(KeyEvent.VK_V);
//			//robot.keyRelease(KeyEvent.VK_CONTROL);
//			//robot.delay(500);
//
//                }
//        }
//				 	
//	/*static XmlRpcClient client=null;
//	public static void LdtpRun(){
//		
//		int i;
//		
//		Ldtp Ldtp =new Ldtp(null);
//		Ldtp.imageCapture();
//				
//		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
//		client = new XmlRpcClient();
//		try {
//			String url = String.format("http://%s:%s/RPC2", "localhost", "4118");
//			config.setServerURL(new URL(url));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		client.setConfig(config);
//		Boolean alive = isAlive();
//		if (!alive) {
//		
//		if (config.getServerURL().getHost().contains("localhost"))
//		launchLdtpProcess();
//		  // Verify we are able to connect after launching the server
//		 alive = isAlive();
//		 if (!alive)
//		 throw new LdtpExecutionError("Unable to connect to server");
//		  	}
//				
//		//Ldtp ldtp = new Ldtp("*Firefox");
//		//ldtp.getTextValue ("*Firefox");
//		 String[] windowList = ldtp.getWindowList();
//		for(i = 0; i < windowList.length; i++)
//		    System.out.print(windowList[i]);
//		System.out.println("");
//		String[] appList = ldtp.getAppList();
//		for(i = 0; i < appList.length; i++)
//		    System.out.print(appList[i]);
//		System.out.println("");
//		String[] objList = ldtp.getObjectList();
//		for(i = 0; i < objList.length; i++)
//		    System.out.print(objList[i] + " ");
//		System.out.println("");
//		try {
//		    ldtp.setWindowName("Testing LDTP with Java Client");
//		    objList = ldtp.getObjectList();
//		    for(i = 0; i < objList.length; i++)
//			System.out.print(objList[i] + " ");
//		    System.out.println("");
//		} catch (LdtpExecutionError ex) {
//		    System.out.println(ex.getMessage());
//		} finally {
//		    ldtp.setWindowName("*-gedit");
//		}
//		
//		/*Integer[] size = ldtp.getWindowSize();
//		for(i = 0; i < size.length; i++)
//		    System.out.print(size[i] + " ");
//		System.out.println("");
//		size = ldtp.getObjectSize("btnOpen");
//		for(i = 0; i < size.length; i++)
//		    System.out.print(size[i] + " ");
//		System.out.println("");
//		System.out.println(ldtp.guiExist());
//		System.out.println(ldtp.guiExist("btnOpen"));
//		System.out.println(ldtp.objectExist("btnOpen"));
//		System.out.println(ldtp.selectMenuItem("mnuFile;mnuNew"));
//		try {
//		    System.out.println(ldtp.selectMenuItem("mnuFile;mnuDing"));
//		} catch (LdtpExecutionError ex) {
//		    System.out.println(ex.getMessage());
//		}
//		System.out.println(ldtp.doesMenuItemExist("mnuFile;mnuNew"));
//		System.out.println(ldtp.doesMenuItemExist("mnuFile;mnuDing"));
//		String[] subMenus = ldtp.listSubMenus("mnuFile");
//		for(i = 0; i < subMenus.length; i++)
//		    System.out.print(subMenus[i] + " ");
//		System.out.println("");
//		System.out.println(ldtp.imageCapture());
//		System.out.println(ldtp.launchApp("gnome-terminal"));
//		System.out.println(ldtp.waitTillGuiExist());
//		ldtp.setWindowName("Testing LDTP with Java Client");
//		System.out.println(ldtp.waitTillGuiExist(5));
//		ldtp.setWindowName("*-gedit");
//		System.out.println(ldtp.getTextValue("txt1"));
//		System.out.println(ldtp.click("btnNew"));
//		ldtp = new Ldtp("*Notepad");
//		System.out.println(ldtp.getTextValue("txt0"));
//		
//		}
//		private static 	void launchLdtpProcess(){
//		Process p = null;
//		ProcessBuilder pb = new ProcessBuilder("CobraWinLDTP.exe");
//		try {
//			p = pb.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//		
//		private static Boolean isAlive() {
//			  	Boolean isAlive = false;
//			  	Object[] params = null;
//			  	try {
//			  	    isAlive = (Boolean) client.execute("isalive", params);
//			  	} catch (org.apache.xmlrpc.XmlRpcException ex) {
//			  	    // Ignore any exception
//			  	} catch (Exception ex) {
//			  	    // Ignore any exception
//			  	}
//			  	return isAlive;
//			 
//		}
//		*/
//		/*
//	 * WebElement WebElements = driver.findElement(By.className("name"));
//	 * List<WebElement> WebElements1 = driver.findElements(By.id("name")); List
//	 * <WebElement>
//	 * textboxes1=driver.findElements(By.xpath("//input[@type='text']")); List
//	 * <WebElement> textboxes2 =driver.findElements(By.tagName("td"));
//	 * List<WebElement> elementsdiv =
//	 * driver.findElements(By.tagName("v-window")); List<WebElement> inputclass
//	 * = driver.findElements(By.className("input")); List<WebElement>
//	 * inputElements = driver.findElements(By.tagName("input"));
//	 * driver.switchTo().frame(driver
//	 * .findElements(By.tagName("iframe").get(0)); for(WebElement ele :
//	 * inputclass){ System.out.println("total textboxes "+inputclass.size());
//	 * System.out.println(ele.getAttribute("type"));
//	 * System.out.println(ele.getTagName());
//	 * //System.out.println(ele.getClass());
//	 * //System.out.println(ele.getText());
//	 * //System.out.println(ele.hashCode()); System.out.println(""); }
//	 */
//	/*private static Bitmap getTextImage(String text, int width, int height) {
//        final Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        final Paint paint = new Paint();
//        final Canvas canvas = new Canvas(bmp);
//
//        canvas.drawColor(Color.WHITE);
//
//        paint.setColor(Color.BLACK);
//        paint.setStyle(Style.FILL);
//        paint.setAntiAlias(true);
//        paint.setTextAlign(Align.CENTER);
//        paint.setTextSize(24.0f);
//        canvas.drawText(text, width / 2, height / 2, paint);
//
//        return bmp;
//    }*/
//}
