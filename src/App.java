
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Algorithms.ISort;
import Panel.MyPanel;
import Data.Data;

public class App {
    public App() {
        var frame = new JFrame();
        Data.panel = new MyPanel();
        frame.add(Data.panel, BorderLayout.CENTER);
        // add names and colors for graph
        JPanel sidePanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < Data.algorithms.length; i++) {
            JButton n = new JButton(Data.algorithms[i].getClass().getName());
            n.setBackground(Data.algorithms[i].getColor());
            n.setFocusable(false);
            sidePanel.add(n);
        }
        //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        showSorting(frame);
        ISort.delay(4000);
        Data.panel.setBackground(Color.gray);
        frame.add(sidePanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        CalculateTime();
        Data.panel.Draw();
    }

    private void CalculateTime() {
        Data.times = new long[Data.DataCount.length * 5];
        for (int i = 0; i < Data.DataCount.length; i++) {
            var RandomData = MakeData.GenerateRandom(Data.DataCount[i], 1, 100);
            for (int j = 0; j < Data.algorithms.length; j++) {
                var data = RandomData.clone();
                long t = System.nanoTime();
                Data.algorithms[j].sort(data);
                Data.times[i * 5 + j] = (System.nanoTime() - t) / 100_000;
            }
        }
    }

    private void showSorting(JFrame frame) {
        for (int i = 0; i < Data.DataCountForShow.length; i++) {
            var RandomData = MakeData.GenerateRandom(Data.DataCountForShow[i], 1, 100);
            for (int j = 0; j < Data.algorithms.length; j++) {
                var data = RandomData.clone();
                Data.algorithms[j].showSort(data);
                ISort.delay(2000);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
