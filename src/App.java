import javax.swing.*;
//we are using SWING java framework to create GUI :)
public class App {
    public static void main(String[] args){
        JFrame frame = new JFrame("JavaChess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when windows is closed, exit program
        frame.setSize(1280,720);

        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame


        frame.setVisible(true); // makes frame visible (open)
    }
}
