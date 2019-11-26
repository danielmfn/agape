package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cargo_discipulo")
public class CargoDiscipulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cargo")
    private Long id;

    @Column(name = "str_descricao_cargo")
    private String cargo;

    @ManyToMany
    @JoinTable(name = "tb_discipulo",
            joinColumns = @JoinColumn(name = "cod_cargo"),
            inverseJoinColumns = @JoinColumn(name = "cod_discipulo"))
    private List<Discipulo> discipulos;

    public CargoDiscipulo() {
    }

    public CargoDiscipulo(String cargo, List<Discipulo> discipulos) {
        this.cargo = cargo;
        this.discipulos = discipulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoDiscipulo that = (CargoDiscipulo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Discipulo> getDiscipulos() {
        return discipulos;
    }

    public void setDiscipulos(List<Discipulo> discipulos) {
        this.discipulos = discipulos;
    }

}