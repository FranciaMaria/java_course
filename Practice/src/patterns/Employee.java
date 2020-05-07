package patterns;

public class Employee {

    public static class Builder {

        private int id;
        private String firstName;
        private String lastName;
        private String country;

        public Builder(int id) {
            this.id = id;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.id = this.id;
            employee.firstName = this.firstName;
            employee.lastName = this.lastName;
            employee.country = this.country;
            return  employee;
        }

    }

    private int id;
    private String firstName;
    private String lastName;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private Employee() {}

    public String toString()
    {
        return "id:" + this.id + ", firstName: " + this.firstName + ", lastName: " + this.lastName + ", country: " + this.country;
    }

}
