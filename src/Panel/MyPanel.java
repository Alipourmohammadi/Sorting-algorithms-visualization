package Panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import Data.Data;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
  private boolean drawArray = false;
  private int[] arr;
  private int[] points;
  private Color[] colors;
  private String name;

  public void drawArray(int[] arr, int[] points, Color[] colors) {
    setBackground(Color.white);
    drawArray = true;
    this.arr = arr;
    this.points = points;
    this.colors = colors;
    repaint();
  }

  public MyPanel() {
    setBackground(Color.gray);
    setPreferredSize(new Dimension(1000, 700));
  }

  public void Draw() {
    repaint();
  }

  public void DrawName(String input) {
    name = input;
    repaint();
  }

  private void showArrays(Graphics g) {
    g.setColor(Color.green.darker().darker());
    drawArray = false;
    var partition = getWidth() / arr.length;
    var hight = getHeight();
    var max = findMax(arr);
    for (int i = 0; i < arr.length; i++) {
      g.fillRect(i * partition, hight - (int) ((arr[i] * hight) / max), partition -
          3, hight);
    }
    if (points != null) {
      for (int i = 0; i < points.length; i++) {
        g.setColor(colors[i]);
        g.fillRect(points[i] * partition, hight - (int) ((arr[points[i]] * hight) / max), partition -
            3, hight);
      }
    }
  }

  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
    if (drawArray) {
      showArrays(g);
      if (name != null) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Arial", 1, 16));
        g2d.drawString(name, 10, 20);
      }
      return;
    }

    if (Data.times != null && Data.times[0] != 0) {
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2d.setColor(Color.black);
      g2d.setStroke(new BasicStroke(4));
      // distance form edge of the screen
      int Distance = 25;
      int hight = getHeight();
      int width = getWidth();
      // vertical Line:
      g2d.drawLine(Distance, Distance, Distance, hight - Distance);
      // Horizontal line:
      g2d.drawLine(Distance, hight - Distance, width - Distance, hight - Distance);
      g2d.setStroke(new BasicStroke(2));
      var count = Data.DataCount.length;
      // offset from end of x line
      int offset = 80;
      var xLineLength = width - Distance - Distance - offset;
      var partition = xLineLength / count;
      var max = findMax(Data.times);
      var yLineLength = hight - Distance - Distance;
      int[][] points = new int[Data.algorithms.length][2];
      g2d.setFont(new Font("Arial", 1, 12));

      for (int i = 0; i < count; i++) {
        g2d.setColor(Color.black);
        int x = Distance + (partition * (i + 1));
        int y = hight - Distance - 4;
        // horizontal pointers
        g2d.fillOval(x, y, 8, 8);
        g2d.drawString(String.valueOf(Data.DataCount[i]), x, y + 20);
        // data's
        for (int j = 0; j < Data.algorithms.length; j++) {
          // draw the dot
          g2d.setColor(Data.algorithms[j].getColor());
          var value = (int) ((Data.times[i * 5 + j] * yLineLength) / max);
          g2d.fillOval(x, y - value, 8, 8);

          // draw the line if there is data before it:
          if (i != 0) {
            g2d.drawLine(points[j][1] + 4, points[j][0], x + 4, y - value + 4);
          }
          // draw the dot on the vertical line:
          g2d.setColor(Color.BLACK);
          g2d.fillOval(Distance - 4, y - value, 8, 8);
          g2d.drawString(String.valueOf(Data.times[i * 5 + j]), Distance + 8, hight -
              Distance - value + 5);
          // save point to use later for drawing the lines
          points[j][0] = hight - Distance - value;
          points[j][1] = x;
        }
      }
    }
  }

  private long findMax(long[] arr) {
    long result = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= result) {
        result = arr[i];
      }
    }
    return result;
  }

  private long findMax(int[] arr) {
    long result = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= result) {
        result = arr[i];
      }
    }
    return result;
  }
}
