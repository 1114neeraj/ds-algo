package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]); 

		List<int[]> list = new ArrayList<>();

		for(int[] value : people) {
			list.add(value[1], value);
		}

		return list.toArray(people);
	}

	public static void main(String[] args) {
		int[][] array = { {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2} };

		QueueReconstruction obj = new QueueReconstruction();
		int[][] result = obj.reconstructQueue(array);

		for(int i=0;i<result.length;i++) {
			System.out.print(String.format("(%s, %s) ", result[i][0], result[i][1]));
		}
	}

}
