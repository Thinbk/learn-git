import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GhepTranh implements Runnable {
    private BufferedImage image;
    private String filename;
    private int rows, columns;
    private BufferedImage[][] smallImages;
    private int smallWidth;
    private int smallHeight;
    private String targetDir;
    private int imageCounter;


    public GhepTranh (String filename, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.filename = filename;
        init();
    }

    private void init() {
        this.image = this.getGridImage();
        this.smallWidth = image.getWidth() / columns;
        this.smallHeight = image.getHeight() / rows;
        this.smallImages = new BufferedImage[columns][rows];
    }

    private BufferedImage getGridImage() {
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void run() {
        this.createSmallImages();
        this.createDirectoryForSaving("img/save");
        this.saveSmallImages();
    }

    private void createSmallImages() {
        imageCounter = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                smallImages[x][y] = image.getSubimage(x * smallWidth, y
                        * smallHeight, smallWidth, smallHeight);
                imageCounter++;
            }
        }
        System.out.println("Images created: " + imageCounter);
    }

    private void createDirectoryForSaving(String dir) {
        this.targetDir = dir;
        if (!(new File(dir).mkdirs())) {
            System.err.println("Directory could not be created");
        }
    }

    private void saveSmallImages() {
        imageCounter = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                try {
                    ImageIO.write(smallImages[x][y], "png", new File(targetDir+"/tile-"
                            + (imageCounter++) + ".png"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Images saved: " + imageCounter);
    }

    public BufferedImage[][] getSmallImages() {
        return this.smallImages;
    }

    public static void main(String[] args) {
        GhepTranh  image = new GhepTranh ("img/card-grid-image-mass-effect.jpg",
                4, 15);
        new Thread(image).start();
    }
}