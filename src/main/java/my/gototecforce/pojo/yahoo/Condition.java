package my.gototecforce.pojo.yahoo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition {

    private String code;
    private String temp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "code='" + code + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}