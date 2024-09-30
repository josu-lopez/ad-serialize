package org.egibide.repository;

import org.egibide.models.Departamento;

import java.io.*;

public class DepartamentoRepository {
    private static DepartamentoRepository df = null;

    public Departamento obtenerDepartamento(Integer id) throws IOException, ClassNotFoundException {
        File ficheroDepartamento = new File("./ficheros/departamentos.dat");
        FileInputStream fisDepartamento = new FileInputStream(ficheroDepartamento);
        ObjectInputStream oisDepartamento = new ObjectInputStream(fisDepartamento);

        try {
            while (true) {
                Departamento departamento = (Departamento) oisDepartamento.readObject();
                if (id.equals(departamento.getId())) {
                    return departamento;
                }
            }
        } catch (EOFException e) {
            return null;
        }
    }

    public static DepartamentoRepository getInstance() {
        if (df == null) {
            df = new DepartamentoRepository();
        }
        return df;
    }
}
