//package osypkg;
//
//import com.sun.jna.Pointer;
//import java.awt.Rectangle;
//import java.awt.image.BufferedImage;
//import java.awt.image.RenderedImage;
//import java.io.File;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.List;
//import java.util.Properties;
//import javax.imageio.IIOImage;
//import net.sourceforge.tess4j.ITessAPI.TessPageIterator;
//import net.sourceforge.tess4j.ITessAPI.TessPageIteratorLevel;
//import net.sourceforge.tess4j.ITessAPI.TessResultIterator;
//import net.sourceforge.tess4j.TessAPI;
//import net.sourceforge.tess4j.TessAPI1;
//import net.sourceforge.tess4j.TesseractException;
//import net.sourceforge.tess4j.util.ImageIOHelper;
//
//
//public class Tesseract {
// 
// 
//    private static Tesseract instance;
//    private final static Rectangle EMPTY_RECTANGLE = new Rectangle();
//    private String language = "eng";
//    private String datapath = "C:/tessdata";
//    private int psm = TessAPI.TessPageSegMode.PSM_AUTO;
//    private boolean hocr;
//    private int pageNum;
//    private int ocrEngineMode = TessAPI.TessOcrEngineMode.OEM_DEFAULT;
//    private Properties prop = new Properties();
//    public final static String htmlBeginTag =
//            "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\""
//            + " \"http://www.w3.org/TR/html4/loose.dtd\">\n"
//            + "<html>\n<head>\n<title></title>\n"
//            + "<meta http-equiv=\"Content-Type\" content=\"text/html;"
//            + "charset=utf-8\" />\n<meta name='ocr-system' content='tesseract'/>\n"
//            + "</head>\n<body>\n";
//    public final static String htmlEndTag = "</body>\n</html>\n";
// 
//    /**
//     * Private constructor.
//     */
//    Tesseract() {
// 
//        System.setProperty("jna.encoding", "UTF8");
//     
//}
// 
//    /**
//     * Gets an instance of the class library.
//     *
//     * @return instance
//     */
//    public static synchronized Tesseract getInstance() {
// 
//        if (instance == null) {
// 
//            instance = new Tesseract();
//         
//}
// 
//        return instance;
//     
//}
// 
//    /**
//     * Sets tessdata path.
//     *
//     * @param datapath the tessdata path to set
//     */
//    public void setDatapath(String datapath) {
// 
//        this.datapath = datapath;
//     
//}
// 
//    /**
//     * Sets language for OCR.
//     *
//     * @param language the language code, which follows ISO 639-3 standard.
//     */
//    public void setLanguage(String language) {
// 
//        this.language = language;
//     
//}
// 
//    /**
//     * Sets OCR engine mode.
//     *
//     * @param ocrEngineMode the OcrEngineMode to set
//     */
//    public void setOcrEngineMode(int ocrEngineMode) {
// 
//        this.ocrEngineMode = ocrEngineMode;
//     
//}
// 
//    /**
//     * Sets page segmentation mode.
//     *
//     * @param mode the page segmentation mode to set
//     */
//    public void setPageSegMode(int mode) {
// 
//        this.psm = mode;
//     
//}
// 
//    /**
//     * Enables hocr output.
//     *
//     * @param hocr to enable or disable hocr output
//     */
//    public void setHocr(boolean hocr) {
// 
//        this.hocr = hocr;
//        prop.setProperty("tessedit_create_hocr", hocr ? "1" : "0");
//     
//}
// 
//    /**
//     * Set the value of Tesseract's internal parameter.
//     *
//     * @param key variable name, e.g.,
//     * <code>tessedit_create_hocr</code>,
//     * <code>tessedit_char_whitelist</code>, etc.
//     * @param value value for corresponding variable, e.g., "1", "0",
//     * "0123456789", etc.
//     */
//    public void setTessVariable(String key, String value) {
// 
//        prop.setProperty(key, value);
//     
//}
// 
//    /**
//     * Performs OCR operation.
//     *
//     * @param imageFile an image file
//     * @return the recognized text
//     * @throws TesseractException
//     */
//    public String doOCR(File imageFile) throws TesseractException {
// 
//        return doOCR(imageFile, null);
//     
//}
// 
//    /**
//     * Performs OCR operation.
//     *
//     * @param imageFile an image file
//     * @param rect the bounding rectangle defines the region of the image to be
//     * recognized. A rectangle of zero dimension or
//     * <code>null</code> indicates the whole image.
//     * @return the recognized text
//     * @throws TesseractException
//     */
//    public String doOCR(File imageFile, Rectangle rect) throws TesseractException {
// 
//        try {
// 
//            return doOCR(ImageIOHelper.getIIOImageList(imageFile), rect);
//         
//} catch (IOException ioe) {
// 
//            throw new TesseractException(ioe);
//         
//}
//     
//}
// 
//    /**
//     * Performs OCR operation.
//     *
//     * @param bi a buffered image
//     * @return the recognized text
//     * @throws TesseractException
//     */
//    public String doOCR(BufferedImage bi) throws TesseractException, IOException {
// 
//        return doOCR(bi, null);
//     
//}
// 
//    /**
//     * Performs OCR operation.
//     *
//     * @param bi a buffered image
//     * @param rect the bounding rectangle defines the region of the image to be
//     * recognized. A rectangle of zero dimension or
//     * <code>null</code> indicates the whole image.
//     * @return the recognized text
//     * @throws TesseractException
//     */
//    public String doOCR(BufferedImage bi, Rectangle rect) throws TesseractException, IOException {
// 
//        IIOImage oimage = new IIOImage(bi, null, null);
//        List<IIOImage> imageList = new ArrayList<IIOImage>();
//        imageList.add(oimage);
//        return doOCR(imageList, rect);
//     
//}
// 
//    /**
//     * Performs OCR operation.
//     *
//     * @param imageList a list of
//     * <code>IIOImage</code> objects
//     * @param rect the bounding rectangle defines the region of the image to be
//     * recognized. A rectangle of zero dimension or
//     * <code>null</code> indicates the whole image.
//     * @return the recognized text
//     * @throws TesseractException
//     */
//    public String doOCR(List<IIOImage> imageList, Rectangle rect) throws TesseractException, IOException {
// 
//        StringBuilder sb = new StringBuilder();
//        pageNum = 0;
// 
//        for (IIOImage oimage : imageList) {
// 
//            pageNum++;
//            try {
// 
//                ByteBuffer buf = ImageIOHelper.getImageByteBuffer(oimage);
//                RenderedImage ri = oimage.getRenderedImage();
//                String pageText = doOCR(ri.getWidth(), ri.getHeight(), buf, rect, ri.getColorModel().getPixelSize());
//                sb.append(pageText);
//             
//} catch (IOException ioe) {
// 
//                //skip the problematic image
//                System.err.println(ioe.getMessage());
//             
//}
//         
//}
// 
//        if (hocr) {
// 
//            sb.insert(0, htmlBeginTag).append(htmlEndTag);
//         
//}
//        return sb.toString();
//     
//}
// 
//    /**
//     * Performs OCR operation. Use
//     * <code>SetImage</code>, (optionally)
//     * <code>SetRectangle</code>, and one or more of the
//     * <code>Get*Text</code> functions.
//     *
//     * @param xsize width of image
//     * @param ysize height of image
//     * @param buf pixel data
//     * @param rect the bounding rectangle defines the region of the image to be
//     * recognized. A rectangle of zero dimension or
//     * <code>null</code> indicates the whole image.
//     * @param bpp bits per pixel, represents the bit depth of the image, with 1
//     * for binary bitmap, 8 for gray, and 24 for color RGB.
//     * @return the recognized text
//     * @throws TesseractException
//     */
//    
//     public String doOCR1static {
//    
//    
//TessResultIterator ri = TessAPI1.TessBaseAPIGetIterator(api);
//TessPageIterator pi = TessAPI1.TessResultIteratorGetPageIterator(ri);
//String str = TessAPI1.TessResultIteratorGetUTF8Text(ri, TessPageIteratorLevel.RIL_WORD);
//IntBuffer leftB = IntBuffer.allocate(1);
//IntBuffer topB = IntBuffer.allocate(1);
//IntBuffer rightB = IntBuffer.allocate(1);
//IntBuffer bottomB = IntBuffer.allocate(1);
//TessAPI1.TessPageIteratorBoundingBox(pi, TessPageIteratorLevel.RIL_WORD, leftB, topB, rightB, bottomB);
//int left = leftB.get();
//int top = topB.get();
//int right = rightB.get();
//int bottom = bottomB.get();
//}
//    public String doOCR(int xsize, int ysize, ByteBuffer buf, Rectangle rect, int bpp) throws TesseractException {
// 
//        TessAPI api = TessAPI.INSTANCE;
//        TessAPI.TessBaseAPI handle = api.TessBaseAPICreate();
//        api.TessBaseAPIInit2(handle, datapath, language, ocrEngineMode);
//        api.TessBaseAPISetPageSegMode(handle, psm);
//         
//        Enumeration em = prop.propertyNames();
//        while (em.hasMoreElements()) {
// 
//            String key = (String) em.nextElement();
//            api.TessBaseAPISetVariable(handle, key, prop.getProperty(key));
//         
//}
// 
//        int bytespp = bpp / 8;
//        int bytespl = (int) Math.ceil(xsize * bpp / 8.0);
//        api.TessBaseAPISetImage(handle, buf, xsize, ysize, bytespp, bytespl);
// 
//        if (rect != null && !rect.equals(EMPTY_RECTANGLE)) {
// 
//            api.TessBaseAPISetRectangle(handle, rect.x, rect.y, rect.width, rect.height);
//         
//}
// 
//        Pointer utf8Text = hocr ? api.TessBaseAPIGetHOCRText(handle, pageNum - 1) : api.TessBaseAPIGetUTF8Text(handle);
//        String str = utf8Text.getString(0);
//        api.TessDeleteText(utf8Text);
//        api.TessBaseAPIDelete(handle);
//         
//        return str;
//     
//}
// 
//}