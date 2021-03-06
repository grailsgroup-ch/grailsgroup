package ch.grailsgroup

import java.awt.Image as AWTImage
import java.awt.image.BufferedImage
import javax.swing.ImageIcon
import javax.imageio.ImageIO as IIO
import java.awt.Graphics2D

class ImageResizer {

	static ByteArrayOutputStream resize( Image image, maxW, maxH){
		AWTImage ai = new ImageIcon(image.image).image
		int width = ai.getWidth( null )
		int height = ai.getHeight( null )
	
		//TODO da gaht nöd: Wenn Limits, dann beim Hochladen
		//Die Bilder in der db sind grösser als 2M
		//Wieso die Beschränkung nach unten?
		//def limits = 300..2000
		//assert limits.contains( width ) && limits.contains( height ) : 'Picture is either too small or too big!'
	
		float aspectRatio = width / (float) height
		float requiredAspectRatio = maxW / (float) maxH
	
		int dstW = 0
		int dstH = 0
		if (requiredAspectRatio < aspectRatio) {
			dstW = maxW 
			dstH = Math.round( maxW / aspectRatio)
		} else {
			dstH = maxH 
			dstW = Math.round(maxH * aspectRatio)
		}
	
		BufferedImage bi = new BufferedImage(dstW, dstH,   BufferedImage.TYPE_INT_RGB)
		Graphics2D g2d = bi.createGraphics() 
		g2d.drawImage(ai, 0, 0, dstW, dstH, null, null)
	
		ByteArrayOutputStream out = new ByteArrayOutputStream()
		IIO.write( bi, (image.contentType - 'image/'), out)
		return out
	}
}
