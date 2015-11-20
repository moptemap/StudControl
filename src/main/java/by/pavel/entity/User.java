package by.pavel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private long id;

    @Size(min = 5, max = 100, message = "Длина email должна быть не меньше 5 и не больше 100 символов")
    @Column(name = "email", nullable = false, unique = true, insertable = true, updatable = true, length = 100)
    private String email;

    @Size(min = 6, max = 100, message = "Длина пароля должна быть не меньше 6 и не больше 100 символов")
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 100)
    private String password;

    @Size(min = 4, max = 50, message = "Длина имени должна быть не меньше 5 и не больше 50 символов")
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 50)
    private String firstName;


    @Column(name = "middle_name", nullable = true, insertable = true, updatable = true, length = 50)
    private String middleName;

    @Size(min = 3, max = 50, message = "Длина фамилии должна быть не меньше 3 и не больше 50 символов")
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 50)
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "birthday", nullable = true, insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "photo", nullable = true, insertable = true, updatable = true, length = 255)
    private String photo;

    @ManyToMany
    @JoinTable(name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "user")

    private List<ChatMessage> chatMessages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; //EncryptUtil.encrypt(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(email != null ? !email.equals(user.email) : user.email != null);

    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", photo='" + photo + '\'' +
                '}';
    }
}