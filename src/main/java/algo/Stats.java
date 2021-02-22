package algo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import algo.CParser.Holder;

public class Stats {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		ArrayList data = read();
		DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
		
		for(Object d : data) {
			System.out.println(((Holder)d).getScore());
			descriptiveStatistics.addValue(((Holder)d).getScore());
		}
		
		System.out.println(descriptiveStatistics.getMean());
		System.out.println(descriptiveStatistics.getStandardDeviation());
		
		NormalDistribution gaussianDistribution = 
				new NormalDistribution(descriptiveStatistics.getMean(), descriptiveStatistics.getStandardDeviation());
		
		System.out.println(gaussianDistribution.cumulativeProbability(0.004));
		
//		System.out.println(stats.getAverage()/0.004);

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

}
