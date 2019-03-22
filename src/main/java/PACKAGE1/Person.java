package PACKAGE1;

public class Person extends Adress {


        public String title;
        public String first;
        public String last;
    public String gender;

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getFirst() {
            return first;
        }
        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }
        public void setLast(String last) {
            this.last = last;
        }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

        @Override
        public String toString(){
            return getTitle() + ", "+getFirst()+", "+getLast()+", "+getGender()+", "+getStreet() + ", "+getCity()+", "+getState();
        }

}
