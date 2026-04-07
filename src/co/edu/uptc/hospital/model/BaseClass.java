package co.edu.uptc.hospital.model;

public class BaseClass {

    private static int autoId = 0;
    protected int id;

    public BaseClass() {
        super();
    }

    /* Las subclases llaman a este constructor para obtener
       su id único automáticamente */
    public BaseClass(boolean autoAssign) {
        if (autoAssign) {
            this.id = ++autoId;
        }
    }

	public static int getAutoId() {
		return autoId;
	}

	public static void resetAutoId() {
		autoId = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
