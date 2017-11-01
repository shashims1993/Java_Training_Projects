import java.util.Comparator;

public class ageComparision implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {

		Student s1 = (Student) arg0;
		Student s2 = (Student) arg1;

		if (s1.getAge() == s2.getAge()) {
			if (s1.getName().equals(s2.getName())) {
				if (s1.getId() == s2.getId()) {
					return 0;
				} else if (s1.getId() < s2.getId()) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return s1.getName().compareTo(s2.getName());
			}
		} else if (s1.getAge() < s2.getAge()) {
			return 1;
		} else {
			return -1;
		}
	}
}
