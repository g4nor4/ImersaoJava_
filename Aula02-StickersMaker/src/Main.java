import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        var geradora = new GeradoradeFigurinhas();
        geradora.cria();
    }
}