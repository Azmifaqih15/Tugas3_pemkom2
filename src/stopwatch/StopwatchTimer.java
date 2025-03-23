/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stopwatch;
import javax.swing.*;
/**
 *
 * @author acer
 */
public class StopwatchTimer {
    private JLabel label;
    private boolean running = false;
    private int seconds = 0;
    private Thread thread;
    
    public StopwatchTimer(JLabel label) {
        this.label = label;
    }
    
    public void start() {
        if (!running) {
            running = true;
            thread = new Thread(() -> {
                while (running) {
                    try {
                        Thread.sleep(1000);
                        seconds++;
                        SwingUtilities.invokeLater(() -> label.setText("Time: " + seconds + " sec"));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
    
    public void stop() {
        running = false;
    }
    
     public void reset() {
        running = false;
        seconds = 0;
        label.setText("Time: 0 sec");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
