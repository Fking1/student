package club.fangqcloud.pojo;


public class User {

  private String userId;
  private String userName;
  private String password;
  private long type;
  private String email;

//  private Teacher teacher;
//  private Student student;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


//  public Teacher getTeacher() {
//    return teacher;
//  }
//
//  public void setTeacher(Teacher teacher) {
//    this.teacher = teacher;
//  }
//
//  public Student getStudent() {
//    return student;
//  }
//
//  public void setStudent(Student student) {
//    this.student = student;
//  }

  @Override
  public String toString() {
    return "User{" +
            "userId='" + userId + '\'' +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", type=" + type +
            ", email='" + email + '\'' +
            '}';
  }
}
