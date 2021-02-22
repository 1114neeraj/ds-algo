package algo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CParser {
	
	private static String filename = "scores.ser";
	
	public static class Holder implements Serializable, Comparable<Holder> {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 102902L;
		
		private String name;
		private double score;
		
		@Override
		public int compareTo(Holder o) {
			return Double.compare(this.score, o.score);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String url = "https://www.codechef.com/ssubmission/prob?v=1591885526356&page=undefined&pcode=COVDSMPL&ccode=JUNE20B";
		ArrayList scores = scrape(url);
		//Collections.sort(scores);
		for(Object holder : scores) {
			if(((Holder)holder).name.contains("scayans")) {
				System.out.println(((Holder)holder).score);
			}
		}
	}
	
	private static ArrayList<Holder> scrape(String url) throws IOException {
		
		try {
			return read();
		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
		}
		
		ArrayList<Holder> scores = new ArrayList<>();
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		List<Future<ArrayList<Holder>>> futures = new ArrayList<>();
		
		futures.add(executor.submit(new Worker(url)));
		
		for(int i=1;i<=297;i++) {
			url = "https://www.codechef.com/ssubmission/prob?v=1591885526356&page="+i+"&pcode=COVDSMPL&ccode=JUNE20B";
			futures.add(executor.submit(new Worker(url)));
		}
		
		for(Future<ArrayList<Holder>> future : futures) {
			try {
				scores.addAll(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		
		write(scores);
		
		return scores;
	}
	
	public static class Worker implements Callable<ArrayList<Holder>> {
		
		private String url;
		
		public Worker(String url) {
			this.url = url;
		}
		
		@Override
		public ArrayList<Holder> call() throws Exception {
			return getScore(getDocument(this.url));
		}
		
		private Document getDocument(String url) throws IOException {
			
			String content;
			Document doc = null;
//			try {
//				content = read();
//				doc = Jsoup.parse(content);
//			} catch (Exception e) {
//				doc = Jsoup.connect(url).get();
//				write(doc.toString());
//			}
			
			doc = Jsoup.connect(url).get();
			
			return doc;
		}
		
		private ArrayList<Holder> getScore(Document doc) throws IOException {
			Elements trs = doc.select("tbody tr");
			
			int i = 0;
			
			ArrayList<Holder> scores = new ArrayList<>();
			
			for(Element tr : trs) {
				
				if(i==trs.size()-1) {
					break;
				}
				
				Elements tds = tr.select("td");
				
				int count = 0;
				
				Holder score = new Holder();
				
				for(Element td : tds) {
					
					if(count == 0 ) {
						String text = td.text().replace("<\\/td>", "");
						text = text.replace("<\\/span>", "");
						text = text.replace("<\\/a>", "");
						text = text.replace("<\\/a>", "");
						score.name = text;
					}
					
					if(count==1) {
						String text = td.text().replace("<\\/td>", "");
						text = text.replace("<\\/a>", "");
						score.score = Double.parseDouble(text);
//						System.out.println(text);
						break;
					}
					
					count++;
					
				}
				
				scores.add(score);
				
				i++;
				
			}
			
			return scores;
		}
		
	}
	
	
	
	private static void write(ArrayList scores) throws IOException {
		//Saving of object in a file 
		FileOutputStream file = new FileOutputStream(filename); 
		ObjectOutputStream out = new ObjectOutputStream(file); 

		// Method for serialization of object 
		out.writeObject(scores); 

		out.close(); 
		file.close(); 

		System.out.println("Object has been serialized"); 

	}
	
	private static ArrayList read() throws IOException, ClassNotFoundException {
		
		// Reading the object from a file 
        FileInputStream file = new FileInputStream(filename); 
        ObjectInputStream in = new ObjectInputStream(file); 
          
        // Method for deserialization of object 
        ArrayList scores = (ArrayList)in.readObject(); 
          
        in.close(); 
        file.close(); 
          
		return scores;
	}
	
}
