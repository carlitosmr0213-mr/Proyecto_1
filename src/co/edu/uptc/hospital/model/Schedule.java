package co.edu.uptc.hospital.model;
 
public class Schedule extends BaseClass {
 
    private String  dayOfWeek;
    private String  startTime;
    private String  endTime;
    private String  consultRoom;
    private boolean isAvailable;
 
    public Schedule() {
        super();
    }
 
    public Schedule(String dayOfWeek, String startTime,
                    String endTime, String consultRoom, boolean isAvailable) {
        super(true);
        this.dayOfWeek   = dayOfWeek;
        this.startTime   = startTime;
        this.endTime     = endTime;
        this.consultRoom = consultRoom;
        this.isAvailable = isAvailable;
    }
 
    public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getConsultRoom() {
		return consultRoom;
	}

	public void setConsultRoom(String consultRoom) {
		this.consultRoom = consultRoom;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
    public String toString() {
        return "Schedule {"
                + "\n  ID (sistema) : " + id
                + "\n  Day of Week  : " + dayOfWeek
                + "\n  Start Time   : " + startTime
                + "\n  End Time     : " + endTime
                + "\n  Consult Room : " + consultRoom
                + "\n  Available    : " + isAvailable
                + "\n}";
    }
}