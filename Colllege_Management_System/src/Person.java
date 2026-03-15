public abstract class Person {
    private String name;
    private String id;
    private String email;

    public Person(String name, String id, String email) {
        if(!name.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Name can only contain letters and spaces");
        }
        this.name = name;
        if(!id.matches("^S-\\d{4}$")) {
            throw new IllegalArgumentException("Invalid Student ID! Format must be S-1234");
        }
        this.id = id;
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format!");
        }
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Name can only contain letters and spaces");
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(!id.matches("^S-\\d{4}$")) {
            throw new IllegalArgumentException("Invalid Student ID! Format must be S-1234");
        }
        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format!");
        }
        this.email = email;
    }

    public abstract void getDetails();
}
