package cc.july20b;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PTMSSNG {

	private static void solve(Map<Integer, Map<Integer, Point>> complexMap, List<Point> points) {
		
		Iterator<Point> itr = points.iterator();
		
		while(itr.hasNext()) {
			
			Point point = itr.next();
			
			
		}
		
	}
	
	private static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
}
