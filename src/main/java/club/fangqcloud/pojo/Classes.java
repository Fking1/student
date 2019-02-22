package club.fangqcloud.pojo;


public class Classes {

  private String classId;
  private String className;
  private long capacity;


  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(long capacity) {
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return "Classes{" +
            "classId='" + classId + '\'' +
            ", className='" + className + '\'' +
            ", capacity=" + capacity +
            '}';
  }
}
