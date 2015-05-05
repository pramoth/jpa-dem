
package th.co.geniustree.internship.jpademo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="T_FACULTY",indexes = {@Index(name = "FACULTY_NAME_IDX",columnList = "NAME")})
public class Faculty implements Serializable{
    @Id@TableGenerator(name = "FACULTY_GEN",table = "SEQUENCE")
    @GeneratedValue(generator = "FACULTY_GEN",strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME",nullable = false,length = 100)
    private String name;
    
    @OneToMany(mappedBy = "faculty",cascade = CascadeType.ALL)
    @JoinColumn(name = "FACULTY_ID",nullable = false)
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Faculty other = (Faculty) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
