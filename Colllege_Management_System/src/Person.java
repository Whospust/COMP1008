public abstract class Person {
    private String name;
    private String id;
    private String email;
    public Person(String name, String id, String email) {
        // regex validation for name field which approves only letters and spaces
        if(!name.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Name can only contain letters and spaces");
        }
        // regex validation for id field which approves only specific format: S-1234
        if(!id.matches("^S-\\d{4}$")) {
            throw new IllegalArgumentException("Invalid Student ID! Format must be S-1234");
        }
        // regex validation for email field which approves only emails
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format!");
        }
        // if any part of validation has failed none of these fields below will be assigned
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Standard getters and setters with regex validation
    // validation is exactly the same as in constructor above for all fields
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

    // abstract method for child future classes
    public abstract void getDetails();
}
