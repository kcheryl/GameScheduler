
public class DayRepoImp implements IDayRepo {
	private Day[] days;
	private int numDays;

	DayRepoImp() {
		days = new Day[5];
		numDays = 0;
	}

	@Override
	public String save(Day d) {
		if (numDays < days.length) {
			days[numDays] = d;
			numDays++;
		} else {
			Day[] oldDays = days.clone();
			days = new Day[numDays + 5];
			for (int i = 0; i < oldDays.length; i++) {
				days[i] = oldDays[i];
			}
			days[numDays] = d;
			numDays++;
		}
		return "Day saved successfully!";
	}

	@Override
	public Day findOne(String name) {
		for (Day day : days) {
			// if day exists
			if (day != null && day.getName().equals(name)) {
				return day;
			}
		}
		// if day does not exist
		return null;
	}

	@Override
	public Day[] findAll() {
		return this.days;
	}

}
