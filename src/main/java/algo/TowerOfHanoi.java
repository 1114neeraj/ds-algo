package algo;

public class TowerOfHanoi {

	private static void move(int noOfDiscs, char sourceTower, char intermediateTower, char destinationTower) {
		
		if(noOfDiscs == 1) {
			System.out.println("moving from " + sourceTower + " to " + destinationTower);
		}
		else {
			move(noOfDiscs-1, sourceTower, destinationTower, intermediateTower);
			System.out.println("moving from " + sourceTower + " to " + destinationTower);
			move(noOfDiscs-1, intermediateTower, sourceTower, destinationTower);
		}
		
	}
	
	public static void main(String[] args) {
		TowerOfHanoi obj = new TowerOfHanoi();
		obj.move(3, 'A', 'B', 'C');
	}
}
