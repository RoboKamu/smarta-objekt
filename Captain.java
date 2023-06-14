package smartaBåtar;

/**
 *
 * @author karzan.murad
 */
public class Captain {

    private String name;
    private int age;

    public Captain(String name, int age, Boat båt) {
        setName(name);
        setAge(age);
    }

    public Captain() {
    }

    // getters
    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    // setters
    public void setName(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException("namn får inte vara blank");
        } else{
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("ålder måste vara större än noll");
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return String.format("Kapten: %s %d", name, age);
    }
}
