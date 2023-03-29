import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class GeradoradeFigurinhas {
    public void cria() throws Exception {
        // leitura da imagem
        InputStream inputStream = new FileInputStream(new File("entrada/zazacat.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com trasparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new  BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);

        // copiar a imagem original para novo imagem(em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 70);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        // escrever frase comica hahaha
        graphics.drawString("snifsnif", 0, novaAltura -100);

        //escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png",new File("saida/zazacat2.jpg"));






    }
}

