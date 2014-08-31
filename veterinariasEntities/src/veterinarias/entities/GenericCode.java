package veterinarias.entities;

import veterinarias.generics.GenericEntity;

public class GenericCode extends GenericEntity {

    private Long codigo;
    private String descripcion;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
