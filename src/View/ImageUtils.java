package View;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtils {
    public static Image resizeImage(Image originalImage, int targetWidth, int targetHeight) {
        // Crée un BufferedImage avec la largeur et la hauteur cibles
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);

        // Obtient le Graphics2D à partir du BufferedImage
        Graphics2D g2d = resizedImage.createGraphics();

        // Dessine l'image originale redimensionnée dans le BufferedImage
        g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);

        // Libère les ressources du Graphics2D
        g2d.dispose();

        // Retourne l'image redimensionnée
        return resizedImage;
    }
}

