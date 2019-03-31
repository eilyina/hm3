import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Person extends Adress {


    public String title;
    public String first;
    public String last;
    public String gender;
    public LocalDate birthDayDate;
    public int age;


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

    public LocalDate getBirthDayDate() {


          return birthDayDate;
    }

    public void setBirthDayDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2019, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

       this.birthDayDate = LocalDate.ofEpochDay(randomDay);
    }


    public int getAge(LocalDate birthDayDate, LocalDate currentDate) {
        if ((birthDayDate != null) && (currentDate != null)) {
            return age = Period.between(birthDayDate, currentDate).getYears();

        } else {
            return 0;
        }
    }

        public String getGenderRandom() {
            Random random = new Random();
            String[] values ={"м","ж"};


                int idx=random.nextInt(values.length);
            gender = values[idx];


            return  gender;
        }


    @Override
        public String toString(){
            return getTitle() + ", "+getFirst()+", "+getLast()+", "+getGender()+", "+getStreet() + ", "+getCity()+", "+getState()+", "+getBirthDayDate();
        }

}
