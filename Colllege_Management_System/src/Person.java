public abstract class Person {
    private String name;
    private Long id;
    private String email;

    public Person(String name, Long id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
}
