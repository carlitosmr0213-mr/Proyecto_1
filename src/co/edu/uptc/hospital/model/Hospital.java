package co.edu.uptc.hospital.model;

import java.util.Date;

public class Hospital extends BaseClass {

    private static int autoId = 0;

    private String name;
    private String nit;
    private String address;
    private String phone;
    private Date foundationDate;
    private String gerenteName;

    public Hospital() {
        super();
    }

    public Hospital(String name, String nit, String address, String phone,
                    Date foundationDate, String gerenteName) {
        super(++autoId);
        this.name          = name;
        this.nit           = nit;
        this.address       = address;
        this.phone         = phone;
        this.foundationDate = foundationDate;
        this.gerenteName   = gerenteName;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Date getFoundationDate() { return foundationDate; }
    public void setFoundationDate(Date foundationDate) { this.foundationDate = foundationDate; }

    public String getGerenteName() { return gerenteName; }
    public void setGerenteName(String gerenteName) { this.gerenteName = gerenteName; }

    @Override
    public String toString() {
        return "Hospital {"
                + "\n  ID            : " + id
                + "\n  Nombre        : " + name
                + "\n  NIT           : " + nit
                + "\n  Dirección     : " + address
                + "\n  Teléfono      : " + phone
                + "\n  Fundación     : " + foundationDate
                + "\n  Gerente       : " + gerenteName
                + "\n}";
    }
}
