package osypkg;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.GrayFilter;

/*import org.apache.commons.imaging.formats.jpeg.xmp.JpegRewriter;
 import org.apache.commons.imaging.formats.tiff.TiffImageData.Data;
 */
public class ImageUtil {
	public static boolean isLineBlank(BufferedImage img, int y, int fromX,
			int toX) {
		boolean blank = true;
		for (int x = fromX; blank && x <= toX; x++) {
			int rgb = img.getRGB(x, y);
			int red = ((rgb >> 16) & 0xff);
			int green = ((rgb >> 8) & 0xff);
			int blue = ((rgb) & 0xff);
			if ((red | green | blue) == 0) {
				blank = false;
			}
			x++;
		}
		return blank;
	}

	public static boolean isColumnBlank(BufferedImage img, int x, int fromY,
			int toY) {
		boolean blank = true;
		for (int y = fromY; blank && y <= toY; y++) {
			int rgb = img.getRGB(x, y);
			int red = ((rgb >> 16) & 0xff);
			int green = ((rgb >> 8) & 0xff);
			int blue = ((rgb) & 0xff);
			if ((red | green | blue) == 0) {
				blank = false;
			}
		}
		return blank;
	}

	public static BufferedImage copy(BufferedImage src) {
		ConvolveOp op = new ConvolveOp(new Kernel(1, 1, new float[] { 1.0f }),
				ConvolveOp.EDGE_NO_OP, defaultRenderingHints());
		return op.filter(src, null);
	}

	private static RenderingHints defaultRenderingHints() {
		Map<Key, Object> map = new HashMap<Key, Object>();

		map.put(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		map.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		map.put(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		return new RenderingHints(map);
	}

	public static BufferedImage blur(BufferedImage src) {
		float oneninth = 0.79f / 12;
		float[] kernel = new float[] { oneninth, oneninth, oneninth, oneninth,
				oneninth, oneninth, oneninth, oneninth, oneninth, };

		ConvolveOp blur = new ConvolveOp(new Kernel(3, 3, kernel),
				ConvolveOp.EDGE_NO_OP, defaultRenderingHints());
		return blur.filter(src, null);

	}

	public static BufferedImage sharpen(BufferedImage src) {
		float[] kernel = new float[] { 0f, -1f, 0f, -1f, 5f, -1f, 0f, -1f, 0f };
		ConvolveOp sharpen = new ConvolveOp(new Kernel(3, 3, kernel));
		return sharpen.filter(src, null);
	}

	public static BufferedImage scalefast(BufferedImage src, int targetW,
			int targetH) {
		BufferedImage tmp = new BufferedImage(targetW, targetH, src.getType());
		Graphics2D g = tmp.createGraphics();
		g.setRenderingHints(defaultRenderingHints());
		g.drawImage(src, 0, 0, targetW, targetH, null);
		g.dispose();

		return tmp;
	}

	public static BufferedImage scale(BufferedImage src, int targetW,
			int targetH) {

		int origW = src.getWidth();
		int origH = src.getHeight();

		BufferedImage dst = src;
		double stepUpScale = 1.5;
		double stepDownScale = 1 / stepUpScale;

		int w = origW;
		int h = origH;
		do {
			if (w > targetW) {
				w = (int) (w * stepDownScale);
				if (w < targetW) {
					w = targetW;
				}
			}
			if (h > targetH) {
				h = (int) (h * stepDownScale);
				if (h < targetH) {
					h = targetH;
				}
			}
			if (w < targetW) {
				w = (int) (w * stepUpScale);
				if (w > targetW) {
					w = targetW;
				}
			}
			if (h < targetH) {
				h = (int) (h * stepUpScale);
				if (h > targetH) {
					h = targetH;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, dst.getType());
			Graphics2D g = tmp.createGraphics();
			g.setComposite(AlphaComposite.Src);
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			// g.setRenderingHints(defaultRenderingHints());
			g.drawImage(dst, 0, 0, w, h, null);
			g.dispose();
			dst = tmp;
		} while (w != targetW || h != targetH);
		return dst;
	}

	public static BufferedImage threshold(BufferedImage src, int minThreshold) {
		BufferedImage img = copy(src);
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				int rgb = img.getRGB(x, y);

				// int alpha = ((rgb >> 24) & 0xff);
				int red = ((rgb >> 16) & 0xff);
				int green = ((rgb >> 8) & 0xff);
				int blue = ((rgb) & 0xff);
				int g = (red & green & blue);
				if (g < minThreshold) {
					g = 0;
				} else {
					g = 255;
				}

				rgb = (g << 16) | (g << 8) | g;
				img.setRGB(x, y, rgb);
			}
		}
		return img;
	}

	public static double distanceBetween(BufferedImage o1, BufferedImage o2) {
		double m = 0;
		for (int x = 0; x < o1.getWidth(); x++) {
			for (int y = 0; y < o1.getHeight(); y++) {
				try {
					int rgb1 = o1.getRGB(x, y);
					int rgb2 = o2.getRGB(x, y);
					int alpha1 = ((rgb1 >> 24) & 0xff);
					int alpha2 = ((rgb2 >> 24) & 0xff);
					int r1 = ((rgb1 >> 16) & 0xff);
					int r2 = ((rgb2 >> 16) & 0xff);
					int g1 = ((rgb1 >> 8) & 0xff);
					int g2 = ((rgb2 >> 8) & 0xff);
					int b1 = (rgb1 & 0xff);
					int b2 = (rgb2 & 0xff);
					assert alpha1 == alpha2;
					assert r1 == 0 || r1 == 255;
					assert r2 == 0 || r2 == 255;
					assert g1 == 0 || g1 == 255;
					assert g2 == 0 || g2 == 255;
					assert b1 == 0 || b1 == 255;
					assert b2 == 0 || b2 == 255;

					m += (Math.abs(r1 - r2) + Math.abs(g1 - g2)
							+ Math.abs(b1 - b2) + Math.abs(alpha1 - alpha2));
					// m += Math.abs(rgb1 - rgb2);
				} catch (Exception ex) {
					throw new RuntimeException("x=" + x + "y=" + y + "("
							+ o1.getWidth() + "," + o2.getWidth() + ")" + "("
							+ o1.getHeight() + "," + o2.getHeight() + ")", ex);
				}
			}
		}
		return m;
	}

	public static BufferedImage trim(BufferedImage image) {
		int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x2 = 0, y2 = 0;
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int argb = image.getRGB(x, y);
				if (argb != -1) {
					x1 = Math.min(x1, x);
					y1 = Math.min(y1, y);
					x2 = Math.max(x2, x);
					y2 = Math.max(y2, y);
				}
			}
		}
		WritableRaster r = image.getRaster();
		ColorModel cm = image.getColorModel();
		r = r.createWritableChild(x1, y1, x2 - x1, y2 - y1, 0, 0, null);
		return new BufferedImage(cm, r, cm.isAlphaPremultiplied(), null);
	}

	public static BufferedImage GrayScale1(BufferedImage image) {

		int width = image.getWidth();
		int height = image.getHeight();

		ImageFilter filter = new GrayFilter(true, 70);
		ImageProducer producer = new FilteredImageSource(image.getSource(),
				filter);
		java.awt.Image grayImg = Toolkit.getDefaultToolkit().createImage(
				producer);

		BufferedImage image1 = new BufferedImage(image.getWidth(),
				image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = image1.getGraphics();
		g.drawImage(grayImg, 0, 0, null);
		g.dispose();
		return image1;
	}

	public static BufferedImage GrayScale(BufferedImage image) {

		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color c = new Color(image.getRGB(j, i));
				int red = (int) (c.getRed() * 0.299);
				int green = (int) (c.getGreen() * 0.587);
				int blue = (int) (c.getBlue() * 0.114);
				Color newColor = new Color(red + green + blue, red + green
						+ blue, red + green + blue);
				image.setRGB(j, i, newColor.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage savePNGWithDPI(BufferedImage bufferedImageIn,
			int DPI) throws IOException {

		for (Iterator<?> iw = ImageIO.getImageWritersByFormatName("png"); iw
				.hasNext();) {
			ImageWriter writer = (ImageWriter) iw.next();
			// instantiate an ImageWriteParam object with default compression
			// options
			ImageWriteParam iwp = writer.getDefaultWriteParam();

			ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier
					.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);
			IIOMetadata metadata = writer.getDefaultImageMetadata(
					typeSpecifier, iwp);
			if (metadata.isReadOnly()
					|| !metadata.isStandardMetadataFormatSupported()) {
				continue;
			}

			// setDPIforPNG(metadata, DPI);
			double dotsPerMilli = 1.0 * DPI / 10 / 2.54;
			double checkDots = 1.0 * 144 / 10 / 2.54;

			IIOMetadataNode horiz = new IIOMetadataNode("HorizontalPixelSize");
			horiz.setAttribute("value", Double.toString(dotsPerMilli));

			IIOMetadataNode vert = new IIOMetadataNode("VerticalPixelSize");
			vert.setAttribute("value", Double.toString(dotsPerMilli));

			IIOMetadataNode dim = new IIOMetadataNode("Dimension");
			dim.appendChild(horiz);
			dim.appendChild(vert);

			IIOMetadataNode root = new IIOMetadataNode("javax_imageio_1.0");
			root.appendChild(dim);

			metadata.mergeTree("javax_imageio_1.0", root);

			File file = new File("C:/Users/another/Desktop/Osos1.tiff");
			FileImageOutputStream output = new FileImageOutputStream(file);
			writer.setOutput(output);
                        
			IIOImage image = new IIOImage(bufferedImageIn, null, metadata);
			writer.write(null, image, iwp);
			writer.dispose();
			break;
		}
		return bufferedImageIn;
	}

	public static BufferedImage makeColorTransparent(BufferedImage image,
			final Color color, int tolerance) {

		/*
		 * if( g instanceof Graphics2D ){ Graphics2D g2d = (Graphics2D) g;
		 * g2d.setComposite(AlphaComposite.Clear); g2d.fillRect(0, 0,
		 * image.getWidth(), image.getHeight()); //g2d.setBackground(new
		 * Color(0,0,0,0)); ////g2d.setBackground(Color.WHITE); Font font = new
		 * Font("Tahoma", Font.PLAIN, 14); g2d.setFont(font);
		 * g2d.setComposite(AlphaComposite.Src); g2d.drawImage(newimage, 0, 0,
		 * null);
		 * 
		 * 
		 * } float alphaLevel; Graphics g; int w = image.getWidth(); int h =
		 * image.getHeight(); Graphics2D g2D = (Graphics2D)g; Composite oldcomp
		 * = g2D.getComposite(); // draw the background Composite newcomp =
		 * AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f);
		 * g2D.setComposite(newcomp); g2D.drawImage(image,0,0,null);
		 * g2D.setComposite(oldcomp);
		 * 
		 * BufferedImage dest = new BufferedImage(w, h,
		 * BufferedImage.TYPE_INT_ARGB);
		 */

		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				int pixel = image.getRGB(j, i);
				byte alpha = (byte) pixel;
				alpha %= 0xff;
				if (pixel == 0) {
					// Set the color of the pixel to White
					image.setRGB(j, i, Color.blue.getRGB());
				}
			}
		}

		return image;
	}
}
