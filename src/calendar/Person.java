package calendar;

public class Person {
    private String name;
    private String company;
    private String mail;
    private String phone;
    private Address address;

    public Person(String name, String company, String mail, String phone, Address address) {
        this.name = name;
        this.company = company;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
