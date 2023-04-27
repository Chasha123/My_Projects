
import java.util.List;

public class Degree {

    // Your additions/changes below this line
    private Profile level5;
    private Profile level6;

    public Degree(List<Grade> year2, List<Grade> year3) {
        if (year2 == null || year3 == null || year2.size() != 4 || year3.size() != 4) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < year2.size(); i++) {
            if (year2.get(i).classify().equals(Classification.Fail) || year3.get(i).classify().equals(Classification.Fail)) {
                throw new IllegalArgumentException();
            }
        }

        this.level6 = new Profile(year3);
        year2.addAll(year3); // CHEK IF THIS WORKS
        this.level5 = new Profile(year2);
    }

    public Classification classify() {
        if (this.level5.compareTo(this.level6) == 0) {
            return this.level5.classify();
        } else if (this.level5.compareTo(this.level6) == 1 && this.level5.isClear()) {
            return this.level5.classify();
        } else if (this.level5.compareTo(this.level6) == -1 && this.level6.isClear()) { 
            return this.level6.classify();
        } else {
            return Classification.Discretion;
        }
    }
}
