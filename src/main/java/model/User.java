package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"user_id", "first_name", "last_name", "username", "user_type", "last_login_time"})
public class User {
    @JacksonXmlProperty(localName = "userid")
    @JsonProperty("user_id")
    @JsonAlias("User ID")
    private int user_id;
    @JacksonXmlProperty(localName = "firstname")
    @JsonProperty("first_name")
    @JsonAlias("First Name")
    private String first_name;
    @JacksonXmlProperty(localName = "surname")
    @JsonProperty("last_name")
    @JsonAlias("Last Name")
    private String last_name;
    @JacksonXmlProperty(localName = "username")
    @JsonAlias("Username")
    @JsonProperty("username")
    private String username;
    @JacksonXmlProperty(localName = "type")
    @JsonProperty("user_type")
    @JsonAlias("User Type")
    private String user_type;
    @JacksonXmlProperty(localName = "lastlogintime")
    @JsonProperty("last_login_time")
    @JsonAlias("Last Login Time")
    private Date last_login_time;

    public User(int user_id, String first_name, String last_name, String username, String user_type, Date last_login_time) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.user_type = user_type;
        this.last_login_time = last_login_time;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ" )
    public Date getLast_login_time() {
        return last_login_time;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUser_id() == user.getUser_id() &&
                Objects.equals(getFirst_name(), user.getFirst_name()) &&
                Objects.equals(getLast_name(), user.getLast_name()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getUser_type(), user.getUser_type()) &&
                Objects.equals(getLast_login_time(), user.getLast_login_time());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getFirst_name(), getLast_name(), getUsername(), getUser_type(), getLast_login_time());
    }
}
