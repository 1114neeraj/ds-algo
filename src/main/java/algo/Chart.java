package algo;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import algo.CParser.Holder;

public class Chart extends JFrame {
	
	public Chart() throws ClassNotFoundException, IOException {
		initUI();
	}
	
	private void initUI() throws ClassNotFoundException, IOException {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset() throws ClassNotFoundException, IOException {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        ArrayList<Holder> data = read();
        
        for(Holder d : data) {
        	dataset.setValue(d.getScore() * 1000, "Score", d.getName());
        }

        return dataset;
    }
    
    private static ArrayList read() throws IOException, ClassNotFoundException {
		
		// Reading the object from a file 
        FileInputStream file = new FileInputStream("scores.ser"); 
        ObjectInputStream in = new ObjectInputStream(file); 
          
        // Method for deserialization of object 
        ArrayList scores = (ArrayList)in.readObject(); 
          
        in.close(); 
        file.close(); 
          
		return scores;
	}

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "User",
                "",
                "Scores",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

			try {
				Chart ex = new Chart();
				ex.setVisible(true);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        });
    }
	
}
