public class Person {
    private String name;
    private String email;
    private String phone;
    private int age;
    private String country;
    private String notes;

    public Person(String name,String email,String phone,int age,String country, String notes){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.age=age;
        this.country=country;
        this.notes=notes;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public int getAge() { return age; }
    public String getCountry() { return country; }
    public String getNotes() { return notes; }
}

