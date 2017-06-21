//package osypkg;
//
//import java.awt.image.BufferedImage;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.LinkedList;
//import java.util.List;
//
//import org.sikuli.apiscript.Match;
//
//import org.sikuli.script.Region;
//import org.sikuli.script.ScreenImage;
//
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.security.CodeSource;
//import java.util.Enumeration;
//import java.util.jar.JarEntry;
//import java.util.jar.JarFile;
//import java.util.logging.Level;
//import java.util.logging.Logger;
////import static org.bridj.Platform.getResource;
//import org.sikuli.basics.Settings;
//import org.sikuli.natives.Mat;
//import org.sikuli.script.RunTime;
//
//// Singleton
//public class TextRecognizer2 { 
//   
//   protected static TextRecognizer2 _instance = null; 
//   
//     
//       
//     static { 
//      try{ 
//         
//          
//        RunTime.loadLibrary((String)"VisionProxy");
//       
//         //NativeLoader.loadLibrary("VisionProxy"); 
//         TextRecognizer2 tr = TextRecognizer2.getInstance(); 
//      } 
//      catch(IOException e){ 
//         e.printStackTrace(); 
//      } 
//   
//    
//   } 
//
//   protected TextRecognizer2() throws IOException{ 
//       
//      init(); 
//       
//		
//   } 
//    
//   boolean _init_succeeded = false; 
// 
//   public void init(){ 
//      
//	   //Debug.info("Text Recognizer inited."); 
//      try{ 
//    	 
//         //String path = ResourceExtractor.extract("tessdata"); 
//         //String path = ResourceExtractor.extract("C:/tessdata");
//    	  String path  ="C:/tessdata/";
//    	  // TESSDATA_PREFIX doesn't contain tessdata/ 
//        
//    	 if(path.endsWith("tessdata/")) {
//    	 path = path.substring(0,path.length()-9); 
//                 
//         Settings.OcrDataPath =path;
//         Settings.WaitAfterHighlight=4;
//         //Settings.isWinApp=true;
//         Settings.OcrLanguage="eng";
//         Settings.WaitScanRate=500f;
//         Settings.ObserveScanRate = 1.9f;
//         Settings.DelayValue=20.0;
//         Settings.ObserveMinChangedPixels = 40;
//         //setTessVariable("tessedit_char_whitelist","ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
//         //System.out.println(Settings.OcrDataPath);
//         //Debug.log(3, "OCR data path: " + path); 
//         URL myResUrl1 = null;
//         //Sikulix Sikulix = null ;
//          Class<?> c = this.getClass();
//          
//          RunTime.loadLibrary((String)"VisionProxy");
//          
//           //NativeLoader.loadLibrary("VisionProxy"); 
//                  
//           //URL resource = c.getClass().getClassLoader().getResource("VisionProxy");
//           
//               //Runtime.getRuntime().load("C:\\PCDAutoOsy\\src\\sikulixlibs\\windows\\libs32\\WinUtil.dll");
//         
//		//Runtime.getRuntime().load("C:\\PCDAutoOsy\\src\\sikulixlibs\\windows\\libs32\\VisionProxy.dll");
//            //myResUrl1 = c.getClassLoader().getResource("\\src\\sikulixlibs\\windows\\libs64");
//            
//	    //File libsfiles = new File(myResUrl1.getFile());
//            //File[] listOfFiles = libsfiles.listFiles();
//            //System.out.println(libsfiles.getAbsoluteFile().getPath());
//		//
//		// String folderPath = libsfiles.getAbsoluteFile().getPath();
//		// System.out.println(folderPath);
//      
//      //String pluginLocation = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//       
//       //s = C.getResource("/sikulixlibs/windows/libs64/VisionProxy.dll").getPath();
//      
//         //Runtime.getRuntime().loadLibrary(getClass().getResource("/sikulixlibs/windows/libs64/VisionProxy.dll").getPath());
//         System.out.println("");
//         Vision.initOCR(path); 
//         _init_succeeded = true; 
//      
//    	 } 
//    	 
//      }
//      catch(Exception e){ 
//         e.printStackTrace();          
//      } 
//   } 
// 
//   public static TextRecognizer2 getInstance() throws IOException{ 
//      if(_instance==null) 
//         _instance = new TextRecognizer2(); 
//      return _instance; 
//   } 
// 
//   public enum ListTextMode { 
//      WORD, LINE, PARAGRAPH ,Text,;
//   }; 
// 
//   public List<Match> listText(BufferedImage simg, Region parent){ 
//      return listText(simg, parent, ListTextMode.WORD); 
//   } 
// 
//   //TODO: support LINE and PARAGRAPH 
//   // listText only supports WORD mode now. 
//   public List<Match> listText(BufferedImage simg, Region parent, ListTextMode mode){ 
//      Mat mat = OpenCV.convertBufferedImageToMat(simg); 
//      
//      List<Match> ret = new LinkedList<Match>(); 
//      if(mode==mode.PARAGRAPH){
//    	  OCRParagraphs Paragraphs = Vision.recognize_as_ocrtext(mat).getParagraphs(); 
//    	   for(int i=0;i<Paragraphs.size();i++){ 
//        	 OCRParagraph Paragraph= Paragraphs.get(i); 
//        	  
//             Match m = new Match(parent.x+Paragraph.getX(), parent.y+Paragraph.getY(), Paragraph.getWidth(), Paragraph.getHeight(),  
//                                 1, parent.getScreen(), Paragraph.toString()); 
//             ret.add(m);
//          }
//          //return ret; 
//      }
//      
//      if(mode==mode.WORD){
//         OCRWords words = Vision.recognize_as_ocrtext(mat).getWords(); 
//    	 for(int i=0;i<words.size();i++){ 
//         OCRWord w = words.get(i); 
//         System.out.println(w.getString());
//         Match m = new Match(parent.x+w.getX(), parent.y+w.getY(), w.getWidth(), w.getHeight(),  
//                             1, parent.getScreen(), w.getString()); 
//          ret.add(m);
//      } 
//      //return ret; 
//      }
//      return ret;  
//   
//   } 
// 
//   public List<Match> recognize(ScreenImage simg,Region parent){ 
//      BufferedImage img = simg.getImage(); 
//      return recognize(img,parent); 
//   } 
//    
//public List<Match> recognize(BufferedImage img,Region parent){ 
//      if (_init_succeeded){ 
//    	  Vision.setParameter("MinTargetSize",17);
//    	  List<Match> ret = new LinkedList<Match>(); 
//    	  
//    	  Mat mat = OpenCV.convertBufferedImageToMat(img);
//    	  //String  strMain = Vision.recognize_as_ocrtext(mat).getString();
//      	  //OCRText  strOCR = Vision.recognize_as_ocrtext(mat);
//    	  OCRWords words = Vision.recognize_as_ocrtext(mat).getWords();
//    	  //strMain=  strMain.toString().replace("|", "\n");
//    	  //words = Vision.recognize_as_ocrtext(mat).getWords();
//    	  //String []   str=  strMain.toString().replace(" ", "").split("\n");
//    	  
//    	  
//  		 	   
//  	  // HashMap<OCRWord,Object> HashMapWordCurrentlist = new HashMap<OCRWord,Object>();
//  	   
//  	   for(int i=0;i<words.size();i++){ 
//  		 //regionZoom = new Region(words.get(i).getX(), words.get(i).getY(), words.get(i).getWidth(), words.get(i).getHeight());
//		//regionZoom.highlight(2);
//		//HashMapWordCurrentlist.put(words.get(i),regionZoom);
//	  	//HashMapWordCurrentlist.put(words.get(i),words.get(i).getX()+","+words.get(i).getY());
//  	   	Match m = new Match(parent.x+words.get(i).getX(), parent.y+words.get(i).getY(), words.get(i).getWidth(), words.get(i).getHeight(),1, parent.getScreen(), words.get(i).getString()); 
//	   	ret.add(m);
//  	   }
//  	/*
//  	 Iterator<Entry<OCRWord,Object>> itr = HashMapWordCurrentlist.entrySet().iterator();
//  	   
//  	    while(itr.hasNext()){	
//		HashMap.Entry<OCRWord,Object > entry = itr.next();
//		OCRWord wHashMaplst =	 entry.getKey();
//		WordCurrent=	 entry.getValue().toString();
//		Region regionZoom=null;
//		//regionZoom = new Region(wHashMaplst.getX(),wHashMaplst.getY(),wHashMaplst.getWidth(),wHashMaplst.getHeight());
//		regionZoom = new Region(parent.x+wHashMaplst.getX(), parent.y+wHashMaplst.getY(), wHashMaplst.getWidth(), wHashMaplst.getHeight());
//		regionZoom.highlight(4);
//	   	//break;
//      }  */  	   	 
// 		   
//  	     return ret;
//      }else{ 
//         return null; 
//      }
//    } 
//
//
//
//public void  CordintesMatchWriterToFile (String CordintesMatch) {
//
//try {
//	
//    Path path = Paths.get("C://screencapture/CordintesMatcher.txt");
//       
//    if (Files.exists(path)) {
//    	
//    	FileOutputStream outputStream=new FileOutputStream(new File("C://screencapture/CordintesMatcher.txt"),true);
//    	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//        bufferedWriter.newLine();
//        bufferedWriter.append(CordintesMatch);
//        bufferedWriter.close();
//    }
//
//    if (Files.notExists(path)) {
//    FileOutputStream outputStream=new FileOutputStream(new File("C://screencapture/CordintesMatcher.txt"));
//    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
//    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//    //bufferedWriter.newLine();
//    bufferedWriter.append(CordintesMatch);
//    bufferedWriter.close();
//    }
//} catch (IOException e) {
//    e.printStackTrace();
//}
// 
//}
//}