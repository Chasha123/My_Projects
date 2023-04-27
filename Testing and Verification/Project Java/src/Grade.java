
public class Grade {

	private final int points;

	public int getPoints() {
		return points;
	}

	public Grade(int p) throws IllegalArgumentException {
		if (p < 1 || p > 20) {
			throw new IllegalArgumentException();
		}
		points = p;
	}

	// Your additions/changes below this line
	public Classification classify() {
		if (this.points <= 4) {
			return Classification.First;
		} else if (this.points <= 8) {
			return Classification.UpperSecond;
		} else if (this.points <= 12) {
			return Classification.LowerSecond;
		} else if (this.points <= 16) {
			return Classification.Third;
		} else {
			return Classification.Fail;
		}
	}

	public static Grade fromPercentage(int percent) throws IllegalArgumentException {

		int[] percentArr = { 79, 76, 73, 70, 67, 65, 62, 60, 57, 55, 52, 50, 47, 45, 42, 40, 35, 30, 0, -1 };
		int points = 0;
		Boolean exit = false;
		if (percent <= 100 && -1 <= percent) {
			for (int i = 0; i < percentArr.length; i++) {
				if (percent >= percentArr[i] && !exit) {
					points = i + 1;
					exit = true;
					// break;
				}
			}
			return new Grade(points);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
