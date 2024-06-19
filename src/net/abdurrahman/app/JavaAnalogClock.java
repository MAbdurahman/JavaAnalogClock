package net.abdurrahman.app;

import java.awt.BasicStroke;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.Date;

/**
 * JavaAnalogClock Class -
 * @author:  MAbdurrahman
 * @date:  18 June 2024
 * @version:  1.0.0
 */

public class JavaAnalogClock extends JPanel {
    /** Instance Variables */
    protected int centerPointX;
    protected int centerPointY;
    protected Font clockFont;
    protected Date currentDate;

    /**
     * Default JavaAnalogClock Constructor - Creates an object of the JavaAnalogClock
     */
    @SuppressWarnings({"OverridableMethodCallInConstructor",
            "SleepWhileInLoop", "LeakingThisInConstructor"})
    public JavaAnalogClock() {
        JFrame frame = new JFrame("Analog Clock");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,500);
        Image icon = Toolkit.getDefaultToolkit().getImage(JavaAnalogClock.class.
                getResource("../img/analogClock.png"));
        frame.setIconImage(icon);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        Sound.CLOCK_TICKING.loop();

        /** this while loop updates the clock */
        while (true) {
            repaint();

            try {
                Thread.sleep(1000);

            } catch (Exception ex) {
                String message = ex.getMessage();
                JOptionPane.showMessageDialog(frame, message);

            }
        }//end of the while loop

    }//end Default JavaAnalogClock Constructor

    /**
     * paint Method - Overrides the paint method of the JPanel Abstract Class, and redefines
     * it to draw the clock oval, minute markings, clock numbers, the hour, the minute, and
     * the second hands for the JavaAnalogClock.
     * @param g - the Graphics context
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        centerPointX = getSize().width / 2;
        centerPointY = getSize().height / 2;
        currentDate = new Date();

        /**
         * Get the current hour and the coordinate points for the hour hand.  To alter the
         * dimensions of the hour hand, change the value 15 in the following variables:
         * hoursMinusTenXCoordinate, hoursMinusYCoordinate, hoursPlusTenXCoordinate, and
         * hoursPlusTenYCoordinate.
         */

        int hours = currentDate.getHours();

        int hoursMinusTen = hours - 10;
        int hoursPlusTen = hours + 10;

        int hoursXCoordinate = (int) (Math.cos(hours * Math.PI / 6 - Math.PI / 2) * 120 + centerPointX);
        int hoursYCoordinate = (int) (Math.sin(hours * Math.PI / 6 - Math.PI / 2) * 120 + centerPointY);

        int hoursMinusTenXCoordinate = (int) (Math.cos(hoursMinusTen * Math.PI / 6 - Math.PI / 2) * 15 + centerPointX);
        int hoursMinusTenYCoordinate = (int) (Math.sin(hoursMinusTen * Math.PI / 6 - Math.PI / 2) * 15 + centerPointY);

        int hoursPlusTenXCoordinate = (int) (Math.cos(hoursPlusTen * Math.PI / 6 - Math.PI / 2) * 15 + centerPointX);
        int hoursPlusTenYCoordinate = (int) (Math.sin(hoursPlusTen * Math.PI / 6 - Math.PI / 2) * 15 + centerPointY);

        /**
         * Get the current minute and the coordinate points for the minute hand.  To alter the
         * dimensions of the minute hand, change the value 15 in the following variables:
         * minutesMinusTenXCoordinate, minutesMinusYCoordinate, minutesPlusTenXCoordinate, and
         * minutesPlusTenYCoordinate.
         */

        int minutes = currentDate.getMinutes();

        int minutesMinusTen = minutes - 10;
        int minutesPlusTen = minutes + 10;

        int minutesXCoordinate = (int) (Math.cos(minutes * Math.PI / 30 - Math.PI / 2) * 170 + centerPointX);
        int minutesYCoordinate = (int) (Math.sin(minutes * Math.PI / 30 - Math.PI / 2) * 170 + centerPointY);

        int minutesMinusTenXCoordinate = (int) (Math.cos(minutesMinusTen * Math.PI / 30 - Math.PI / 2) * 15 + centerPointX);
        int minutesMinusTenYCoordinate = (int) (Math.sin(minutesMinusTen * Math.PI / 30 - Math.PI / 2) * 15 + centerPointY);

        int minutesPlusTenXCoordinate = (int) (Math.cos(minutesPlusTen * Math.PI / 30 - Math.PI / 2) * 15 + centerPointX);
        int minutesPlusTenYCoordinate = (int) (Math.sin(minutesPlusTen * Math.PI / 30 - Math.PI / 2) * 15 + centerPointY);

        /**
         * Get the current second and the coordinate points for the second hand.  To alter the
         * dimensions of the second hand, change the value 8 in the following variables:
         * secondsMinusFiveXCoordinate, secondsMinusFiveYCoordinate, secondsPlusFiveXCoordinate,
         * and secondsPlusFiveYCoordinate.
         */
        int seconds = currentDate.getSeconds();

        int secondsMinusFive = seconds - 5;
        int secondsPlusFive = seconds + 5;

        int secondsXCoordinate = (int) (Math.cos(seconds * Math.PI / 30 - Math.PI / 2) * 170 + centerPointX);
        int secondsYCoordinate = (int) (Math.sin(seconds * Math.PI / 30 - Math.PI / 2) * 170 + centerPointY);

        int secondsMinusFiveXCoordinate = (int) (Math.cos(secondsMinusFive * Math.PI / 30 - Math.PI / 2) * 8 + centerPointX);
        int secondsMinusFiveYCoordinate = (int) (Math.sin(secondsMinusFive * Math.PI / 30 - Math.PI / 2) * 8 + centerPointY);

        int secondsPlusFiveXCoordinate = (int) (Math.cos(secondsPlusFive * Math.PI / 30 - Math.PI / 2) * 8 + centerPointX);
        int secondsPlusFiveYCoordinate = (int) (Math.sin(secondsPlusFive * Math.PI / 30 - Math.PI / 2) * 8 + centerPointY);

        /** The attributes and colors used in the JavaAnalogClock */
        int clockFaceWidth = 400;
        int clockFaceHeight = 400;

        Color whiteColor = Color.decode("#e0e0e0");
        Color blackColor = Color.decode("#474747");
        Color redColor = Color.decode("#c2280a");


        /** Fill the background with the white or black color */
        if ((hours >= 18) && (minutes >= 0) || (hours <= 6) && (minutes >= 0)) {
            setBackground(whiteColor);

        } else {
            setBackground(blackColor);

        }

        /** Fill the clockFace with the white or black color */
        if ((hours >= 18) && (minutes >= 0) || (hours <= 6) && (minutes >= 0)) {
            g2d.setColor(blackColor);

        } else {
            g2d.setColor(whiteColor);

        }
        g2d.fillOval(((getSize().width) / 2) - (clockFaceWidth / 2), ((getSize().height) / 2) - (clockFaceHeight / 2),
                clockFaceWidth, clockFaceHeight);

        /** Draw the text "Java" to the center of the clock */
        if ((hours >= 18) && (minutes >= 0) || (hours <= 6) && (minutes >= 0)) {
            g2d.setColor(whiteColor);

        } else {
            g2d.setColor(blackColor);

        }

        clockFont = new Font("Verdana", Font.PLAIN, 16);
        g2d.setFont(clockFont);
        g2d.drawString("J a v a", centerPointX - 30, centerPointY - 60);


        /** Create and set the font for the numbers, and draw the numbers 1 through 12 around the clock */
        clockFont = new Font("Verdana", Font.BOLD, 32);
        g2d.setFont(clockFont);
        g2d.drawString("1",  centerPointX + 70, centerPointY - 130);
        g2d.drawString("2",  centerPointX + 125, centerPointY - 70);
        g2d.drawString("3",  centerPointX + 150, centerPointY + 13);
        g2d.drawString("4",  centerPointX + 125, centerPointY + 95);
        g2d.drawString("5",  centerPointX + 65, centerPointY + 150);
        g2d.drawString("6",  centerPointX - 12, centerPointY + 170);
        g2d.drawString("7",  centerPointX - 90, centerPointY + 150);
        g2d.drawString("8",  centerPointX - 150, centerPointY + 95);
        g2d.drawString("9",  centerPointX - 170, centerPointY + 13);
        g2d.drawString("10", centerPointX - 150, centerPointY - 70);
        g2d.drawString("11", centerPointX - 90, centerPointY - 130);
        g2d.drawString("12", centerPointX - 15, centerPointY - 150);

        /** Fill the polygon with the appropriate color for the hour hand */
        if ((hours >= 18) && (minutes >= 0) || (hours <= 6) && (minutes >= 0)) {
            g2d.setColor(whiteColor);

        } else {
            g2d.setColor(blackColor);

        }
        int[] coordinateXHours = {(int)centerPointX, (int)hoursMinusTenXCoordinate, (int)hoursXCoordinate, (int)hoursPlusTenXCoordinate};
        int[] coordinateYHours = {(int)centerPointY,(int) hoursMinusTenYCoordinate,(int) hoursYCoordinate,(int) hoursPlusTenYCoordinate};

        g2d.fillPolygon(coordinateXHours, coordinateYHours, 4);

        /** Fill the polygon with the appropriate color for the minute hand */
        if ((hours >= 18) && (minutes >= 0) || (hours <= 6) && (minutes >= 0)) {
            g2d.setColor(whiteColor);

        } else {
            g2d.setColor(blackColor);

        }
        int[]coordinateXMinutes = {centerPointX, minutesMinusTenXCoordinate, minutesXCoordinate, minutesPlusTenXCoordinate};
        int[]coordinateYMinutes = {centerPointY, minutesMinusTenYCoordinate, minutesYCoordinate, minutesPlusTenYCoordinate};
        g2d.fillPolygon(coordinateXMinutes, coordinateYMinutes, 4);
        g2d.fillOval(centerPointX - 12, centerPointY - 12, 20, 20);

        /** Fill the polygon with the appropriate color the second hand */
        g2d.setColor(redColor);
        int[]coordinateXSeconds = {centerPointX, secondsMinusFiveXCoordinate, secondsXCoordinate, secondsPlusFiveXCoordinate};
        int[]coordinateYSeconds = {centerPointY, secondsMinusFiveYCoordinate, secondsYCoordinate, secondsPlusFiveYCoordinate};
        g2d.fillPolygon(coordinateXSeconds, coordinateYSeconds, 4);

        /** Draw the marks that denote minutes around the clock */
        for (int i = 0; i < 360; i++) {
            int markingXEnd;
            int markingYEnd;
            int markingXBegin;
            int markingYBegin;

            markingXEnd = (int) (Math.cos(i * Math.PI / 30 - Math.PI / 3) * 180 + centerPointX);
            markingYEnd = (int) (Math.sin(i * Math.PI / 30 - Math.PI / 3) * 180 + centerPointY);

            markingXBegin = (int) (Math.cos(i * Math.PI / 30 - Math.PI / 3) * 300 + centerPointX);
            markingYBegin = (int) (Math.sin(i * Math.PI / 30 - Math.PI / 3) * 300 + centerPointY);

            if ((hours >= 18) && (minutes >= 0) || (hours <= 6) && (minutes >= 0)) {
                g2d.setColor(whiteColor);

            } else {
                g2d.setColor(blackColor);

            }

            if ((i % 5) == 0) {
                g2d.setStroke(new BasicStroke(4.0f));

            } else {
                g2d.setStroke(new BasicStroke(2.0f));
            }
            g2d.drawLine(markingXBegin, markingYBegin, markingXEnd, markingYEnd);

        }//end of the for loop to draw the minute markings around the clock
    }//end of the paint Method

    /**
     * main Method - contains the command line arguments
     * @param args - String[] representing the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Set System Look and Feel
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
               IllegalAccessException ex) {
            String message = ex.getMessage();
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), message);
        }
                new JavaAnalogClock();

    }// end of the main Method
}//end of JavaAnalogClock Class
