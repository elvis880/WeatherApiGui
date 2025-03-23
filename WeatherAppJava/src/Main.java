import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main extends JPanel {
    JFrame frame;
    int width = 300,height = 500;
    protected Api api;


    public Main() {

        frame = new JFrame();
        api = new Api();

        frame.add(this);
        frame.setTitle("WeatherApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
        frame.setSize(width,height);
        frame.setVisible(true);




    }

    private Integer celsiustofahrenheit(double temp){
        int num= (int) (temp*9/5)+32;
        return num;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//		background image
        g.drawImage(ImageLoader("Images/violet.jpg"),0,0,width,height,null);





//        g.drawImage(ImageLoader("Images/magikarp.png"),150,150,250,250,null);
        //speech bubble
//        g.drawImage(ImageLoader("Images/speech_bubble.png"),75,250,350,280,null);

        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Tokyo,Japan",50,40);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Humidity "+api.humidity+"%", 80, 350);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        g.drawString(celsiustofahrenheit(Api.temp)+"\u00B0", 100, 130);

//        g.drawString("it's Sunny",180,410);

    }

    public BufferedImage ImageLoader(String path){
        BufferedImage image;
        try {
            image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        new Main();
    }

}