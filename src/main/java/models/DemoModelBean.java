package models;

import java.util.Date;

public class DemoModelBean {
String data;
    public  DemoModelBean(String data) {
       this.data = data;
       getData();

    }

    public String getData () {
        return String.format("%s (%s)", data, new Date());
    }
}
