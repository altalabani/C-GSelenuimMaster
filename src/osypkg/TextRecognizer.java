//package osypkg;
//
///*
// * Decompiled with CFR 0_115.
// * 
// * Could not load the following classes:
// *  org.sikuli.basics.Debug
// *  org.sikuli.basics.FileManager
// *  org.sikuli.basics.Settings
// *  org.sikuli.natives.Mat
// *  org.sikuli.natives.OCRWord
// *  org.sikuli.natives.OCRWords
// *  org.sikuli.natives.Vision
// *  org.sikuli.script.IScreen
// *  org.sikuli.script.Image
// *  org.sikuli.script.Match
// *  org.sikuli.script.Region
// *  org.sikuli.script.RunTime
// *  org.sikuli.script.ScreenImage
// *  org.sikuli.script.TextRecognizer$ListTextMode
// */
//
//
//
//
//import com.googlecode.javacv.cpp.opencv_core;
//import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
//import java.io.File;
//import java.util.LinkedList;
//import java.util.List;
//
//import org.sikuli.basics.Debug;
//import org.sikuli.basics.FileManager;
//import org.sikuli.basics.Settings;
//
//import org.sikuli.natives.OCRWord;
//import org.sikuli.natives.OCRWords;
//import org.sikuli.natives.Vision;
//import org.sikuli.script.IScreen;
//import org.sikuli.script.Image;
//import org.sikuli.script.Match;
//import org.sikuli.script.Region;
//import org.sikuli.script.RunTime;
//import org.sikuli.script.ScreenImage;
//import org.sikuli.script.TextRecognizer.ListTextMode;
//
//public class TextRecognizer {
//    static RunTime runTime = RunTime.get();
//    private static TextRecognizer _instance = null;
//    private static boolean initSuccess = false;
//    private static int lvl = 3;
//
//    private TextRecognizer() {
//        this.init();
//    }
//
//    private void init() {
//        File fTessdataPath = null;
//        initSuccess = false;
//        if (Settings.OcrDataPath != null) {
//            fTessdataPath = new File(FileManager.slashify((String)Settings.OcrDataPath, (Boolean)false), "tessdata");
//            initSuccess = fTessdataPath.exists();
//        }
////        if (!(initSuccess || (TextRecognizer.initSuccess = (fTessdataPath = new File(TextRecognizer.runTime.fSikulixAppPath, "SikulixTesseract/tessdata")).exists()) || (TextRecognizer.initSuccess = null != runTime.extractTessData(fTessdataPath)))) {
////            Debug.error((String)"TextRecognizer: init: export tessdata not possible - run setup with option 3", (Object[])new Object[0]);
////        }
//        if (!new File(fTessdataPath, "eng.traineddata").exists()) {
//            initSuccess = false;
//        }
//        if (!initSuccess) {
//            Debug.error((String)"TextRecognizer not working: tessdata stuff not available at:\n%s", (Object[])new Object[]{fTessdataPath});
//            Settings.OcrTextRead = false;
//            Settings.OcrTextSearch = false;
//        } else {
//            Settings.OcrDataPath = fTessdataPath.getParent();
//            Vision.initOCR((String)FileManager.slashify((String)Settings.OcrDataPath, (Boolean)true));
//            Debug.log((int)lvl, (String)"TextRecognizer: init OK: using as data folder:\n%s", (Object[])new Object[]{Settings.OcrDataPath});
//        }
//    }
//
//    public static TextRecognizer getInstance() {
//        if (_instance == null) {
//            _instance = new TextRecognizer();
//        }
//        if (!initSuccess) {
//            return null;
//        }
//        return _instance;
//    }
//
//    public static void reset() {
//        _instance = null;
//        Vision.setSParameter((String)"OCRLang", (String)Settings.OcrLanguage);
//    }
//
//    public List<Match> listText(BufferedImage simg, Region parent) {
//        return this.listText(simg, parent, ListTextMode.WORD);
//    }
//
//    public List<Match> listText(BufferedImage simg, Region parent, ListTextMode mode) {
//        Mat mat = img2Mat(simg);
//        OCRWords words = Vision.recognize_as_ocrtext((Mat)mat).getWords();
//        LinkedList<Match> ret = new LinkedList<Match>();
//        int i = 0;
//        while ((long)i < words.size()) {
//            OCRWord w = words.get(i);
//            //Match m = new Match(parent.x + w.getX(), parent.y + w.getY(), w.getWidth(), w.getHeight(), (double)w.getScore(), parent.getScreen(), w.getString());
//            //ret.add(m);
//            ++i;
//        }
//        return ret;
//    }
//     public static opencv_core.mMat toMat(BufferedImage img){
//    OpenCVFrameConverter.ToIplImage cv = new OpenCVFrameConverter.ToIplImage();
//    Java2DFrameConverter jcv = new Java2DFrameConverter();
//    return cv.convertToMat(jcv.convert(img));
//}
////
////    public String recognize(ScreenImage simg) {
////        BufferedImage img = simg.getImage();
////        return this.recognize(img);
////    }
////
////    public String recognize(BufferedImage img) {
////        if (initSuccess) {
////            Mat mat = Image.convertBufferedImageToMat((BufferedImage)img);
////            return Vision.recognize((Mat)mat).trim();
////        }
////        return "";
////    }
////
////    public String recognizeWord(ScreenImage simg) {
////        BufferedImage img = simg.getImage();
////        return this.recognizeWord(img);
////    }
////
////    public String recognizeWord(BufferedImage img) {
////        if (initSuccess) {
////            Mat mat = Image.convertBufferedImageToMat((BufferedImage)img);
////            return Vision.recognizeWord((Mat)mat).trim();
////        }
////        return "";
////    }
//
//    static {
//        RunTime.loadLibrary((String)"VisionProxy");
//    }
//}
