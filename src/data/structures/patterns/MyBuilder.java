package data.structures.patterns;

public class MyBuilder {

    private String name;
    private String date;
    private int age;

    private MyBuilder() {
        //prevent instances
    }

    private MyBuilder(Builder builder) {
        this.name = builder.name;
        this.date = builder.date;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {
        private String name;
        private String date;
        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder date(String date) {
            this.date = date;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public MyBuilder build() {
            return new MyBuilder(this);
        }
    }
}
