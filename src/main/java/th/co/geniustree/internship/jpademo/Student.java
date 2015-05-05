package th.co.geniustree.internship.jpademo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
@NamedQuery(name="Student.finByName",query = "select s from Student s where s.name =:name")
public class Student implements Serializable{
    @Id
    @TableGenerator(name = "SEQUENCE_GEN",table = "SEQUENCE")
    @GeneratedValue(generator = "SEQUENCE_GEN",strategy = GenerationType.TABLE)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "FACULTY_ID",nullable = false)
    private Faculty faculty;

    public Student() {
    }
    

    public Student(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }
    

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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
