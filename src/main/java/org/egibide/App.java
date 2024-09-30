package org.egibide;

import org.egibide.models.Departamento;
import org.egibide.models.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Departamento departamento1 = new Departamento(1, "Contabilidad");
        Departamento departamento2 = new Departamento(2, "Ventas");
        Departamento departamento3 = new Departamento(3, "Compras");

        System.out.println("Escribiendo departamentos en el fichero");

        File ficheroDepartamentos = new File("./ficheros/departamentos.dat");
        FileOutputStream fileoutDepartamentos = new FileOutputStream(ficheroDepartamentos);
        ObjectOutputStream objectoutDepartamentos = new ObjectOutputStream(fileoutDepartamentos);

        objectoutDepartamentos.writeObject(departamento1);
        objectoutDepartamentos.writeObject(departamento2);
        objectoutDepartamentos.writeObject(departamento3);

        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Aaa", new Date(), departamento1));
        personas.add(new Persona(2, "Bbb", new Date(), departamento2));
        personas.add(new Persona(3, "Ccc", new Date(), departamento3));

        System.out.println("Escribiendo personas en el fichero");
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        File ficheroPersonas = new File("./ficheros/personas.dat");
        FileOutputStream fileoutPersonas = new FileOutputStream(ficheroPersonas);
        ObjectOutputStream objectoutPersonas = new ObjectOutputStream(fileoutPersonas);

        for (Persona persona : personas) {
            objectoutPersonas.writeObject(persona);
        }

        fileoutPersonas.close();

        System.out.println("Leyendo personas desde el fichero");

        FileInputStream fileinPersonas = new FileInputStream(ficheroPersonas);
        ObjectInputStream objectinPersonas = new ObjectInputStream(fileinPersonas);

        try {
            while (true) {
                Persona persona = (Persona) objectinPersonas.readObject();
                System.out.println(persona);
            }
        } catch (EOFException e) {
            System.out.println("Lectura finalizada");
        }
    }
}
