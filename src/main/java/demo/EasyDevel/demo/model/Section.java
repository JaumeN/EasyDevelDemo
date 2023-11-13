package demo.EasyDevel.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="t_section")
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_section_id_seq")
    @SequenceGenerator(name = "t_section_id_seq", sequenceName = "t_section_id_seq", allocationSize=1)
    private Integer id;
    private String nombre;

    public Section(){}

    public Section(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
