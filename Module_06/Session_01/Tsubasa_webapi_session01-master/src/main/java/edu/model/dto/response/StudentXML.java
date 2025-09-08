package edu.model.dto.response;

import edu.model.entity.Student;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.util.List;
@XmlRootElement
public class StudentXML {

    private List<Student> students;

    public StudentXML() {
    }

    public StudentXML(List<Student> students) {
        this.students = students;
    }
    @XmlElement
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
