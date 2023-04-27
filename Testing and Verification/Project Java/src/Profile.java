
import java.util.List;

public class Profile {
	// Your additions/changes below this line

	private List<Grade> grades;

	public Profile(List<Grade> g) {
		if (g == null || g.isEmpty()) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).classify().equals(Classification.Fail)) {
				throw new IllegalArgumentException();
			}
		}
		this.grades = g;
	}

	public Classification classify() {
//       double fiftyPercent = (100 / this.grades.size()) * (this.grades.size() / 2);
		double[] gClass = calClass();

		if (gClass[0] >= 50/* fiftyPercent */) {
			return Classification.First;
		} else if (gClass[1] >= 50/* fiftyPercent */) {
			return Classification.UpperSecond;
		} else if (gClass[2] >= 50/* fiftyPercent */) {
			return Classification.LowerSecond;
		} else {
			return Classification.Third;
		}
	}

	public boolean isClear() {
		double[] gClass = calClass();
		// double twentyFivePersent = (100 / (double) this.grades.size()) *
		// (this.grades.size() / 4);

		if ((this.classify().equals(Classification.First) || this.classify().equals(Classification.UpperSecond))
				&& gClass[3] >= 25 /* twentyFivePersent/ **/) {
			return false;
		} else {
			return true;
		}
	}

	private double[] calClass() { // returns an array of the percentages taken by each grade
		double[] arrGrades = { 0, 0, 0, 0 }; // first, upper, lower, third
		double fraction = (double) 100 / this.grades.size();

		for (int i = 0; i < this.grades.size(); i++) {
			if (this.grades.get(i).classify().equals(Classification.First)) {
				arrGrades[0] += fraction;
			} else if (this.grades.get(i).classify().equals(Classification.UpperSecond)
					/*|| this.grades.get(i).classify().equals(Classification.First)/**/) {
				arrGrades[1] += fraction;
			} else if (!this.grades.get(i).classify().equals(Classification.Third) ) {
				arrGrades[2] += fraction;
			} else {
				arrGrades[3] += fraction;
			}
		}
		return arrGrades;
	}

	protected int compareTo(Profile profile) {
		return this.classify().ordinal() - profile.classify().ordinal();
	}

}
