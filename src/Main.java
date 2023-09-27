import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    public  static  void operate(int key){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        //file inputstream reader
        try{
            FileInputStream fis = new FileInputStream(file);
            byte[]data = new byte[fis.available()];
            fis.read(data);
            int i =0;
            for (byte b:data) {
                System.out.println(b);
               data[i]= (byte)( b^key);
               i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();

            JOptionPane.showMessageDialog(null,"Successfully Done");

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        JFrame f1 = new JFrame();
        f1.setTitle("Image Operation");
        f1.setSize(500,500);
        f1.setLocationRelativeTo(null);

        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto", Font.BOLD,25);


        //creating button
        JButton button = new JButton();
        button.setText("Open Image");
        button.setFont(font);


        //creating textfield
        JTextField textField = new JTextField(10);
        textField.setFont(font);

        button.addActionListener(e->{
            System.out.println("Button clicked");
             String text = textField.getText();
             int temp = Integer.parseInt(text);
             operate(temp);
        });


        f1.setLayout(new FlowLayout());
        f1.add(button);
        f1.add(textField);
        f1.getContentPane().setBackground(new Color(185, 201, 200));
        f1.setVisible(true);
    }
}