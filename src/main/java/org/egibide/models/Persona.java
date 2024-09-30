package org.egibide.models;

import org.egibide.repository.DepartamentoRepository;

import java.io.IOException;
import java.util.Date;
import java.io.Serializable;

public class Persona implements Serializable {
    private Integer id;
    private String nombre;
    private Date fechaNacimiento;
    private Departamento departamento;

    public Persona() {
        super();
    }

    public Persona(Integer id, String nombre, Date fechaNacimiento, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.departamento = departamento;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", departamento=" + departamento +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        stream.writeInt(this.id);
        stream.writeUTF(this.nombre);
        stream.writeObject(this.fechaNacimiento);
        stream.writeInt(this.departamento.getId());
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        this.id = (Integer) stream.readInt();
        this.nombre = (String) stream.readUTF();
        this.fechaNacimiento = (Date) stream.readObject();
        this.departamento = DepartamentoRepository.getInstance().obtenerDepartamento(stream.readInt());
    }
}
