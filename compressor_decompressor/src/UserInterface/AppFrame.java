package UserInterface;

import comp_decomp.compress;
import comp_decomp.decompress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton deCompressButton;
    JLabel label;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        label = new JLabel();
        label.setText("CompressFIle - DeCompressFile");

        JPanel panel = new JPanel();
        panel.add(label);
        //panel.setBackground(Color);
        panel.setBounds(20,20,460,20);
        this.add(panel);

        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(20,120,200,30);
        compressButton.addActionListener(this);

        deCompressButton = new JButton("Select File to DeCompress");
        deCompressButton.setBounds(260,120,200,30);
        deCompressButton.addActionListener(this);

        this.setTitle("CompressFIle - DeCompressFile");
        this.add(compressButton);
        this.add(deCompressButton);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.cyan);
        this.setSize(500,250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compress.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if (e.getSource() == deCompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompress.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
