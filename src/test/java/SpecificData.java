/**
 * 特定的数据
 * @author LinkinStar
 */
public class SpecificData {
    private int id;
    private String name;
    private String val;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "SpecificData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
