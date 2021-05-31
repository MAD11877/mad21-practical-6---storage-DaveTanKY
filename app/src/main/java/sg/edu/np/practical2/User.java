package sg.edu.np.practical2;

public class User {
    public String name, desc;
    public int id;
    public boolean followed;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.id = age;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }



    public User(){};

    public User(String name, String desc, int id, boolean followed, int age) {
        this.name = name;
        this.desc = desc;
        this.id = id;
        this.followed = followed;
        this.age = age;
    }
}
