/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javalaboratorio;

import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author nelsonsolorzano
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opt = 100;
        var _calendar = new GregorianCalendar();
        var _scanner = new Scanner(System.in);
        var _personas = new ArrayList<Persona>();
        var _pathBase = "C:\\CLIENTES";
        var _sdf = new SimpleDateFormat("yyyyMMdd");
        var _extension =".csv";
        var _filename = "clientes_" + _sdf.format(_calendar.getTime());
        
        try {
            while (opt != 0) {
                System.out.println("----MENU---");
                System.out.println("Escriba 1 - para agregar una persona");
                System.out.println("Escriba 2 - para listar personas agregadas");
                System.out.println("Escriba 3 - para guardar las personas registradas");
                System.out.println("Escriba 4 - para procesar clientes");
                System.out.println("Escriba 0 - para salir.");

                opt = _scanner.nextInt();

                if (opt == 1) {
                    var _persona = new Persona();
                    int anio, mes, dia;
                    System.out.println("Ingrese los datos de la persona");
                    System.out.println("ingrese identificación: - ejemplo: 0801-1900-12345:");
                    _persona.setIdentificacion(_scanner.next());
                    _scanner.nextLine();
                    System.out.println("Escriba el nombre completo de la persona:");
                    _persona.setNombre(_scanner.nextLine());
                    System.out.println("Escriba el año de nacimiento:");
                    anio = _scanner.nextInt();
                    System.out.println("Escriba numero de mes de nacimiendo:");
                    mes = _scanner.nextInt();
                    System.out.println("Escriba el numero de dia de nacimiento");
                    dia = _scanner.nextInt();
                    _calendar.set(anio, (mes - 1), dia);
                    _persona.setFechaNacimiento(_calendar.getTime());
                    _scanner.nextLine();
                    System.out.println("Ingrese la direccion:");
                    _persona.setDireccion(_scanner.nextLine());
                    System.out.println("Ingrese el numero de telefono - ejemplo - 9898-9898");
                    _persona.setTelefono(_scanner.nextLine());
                    System.out.println("Ingrese el correo electronico:");
                    _persona.setEmail(_scanner.nextLine());
                    System.out.println("Ingrese el genero - ejemplo - masculino / femenino");
                    _persona.setGenero(_scanner.nextLine());
                    System.out.println("Ingrese el estado civil - ejemplo - s / c / d / ul");
                    _persona.setEstadoCivil(_scanner.nextLine());
                    _personas.add(_persona);

                } else if (opt == 2) {
                    if (_personas.isEmpty()) {
                        System.out.println("No se han registrado personas");
                    } else {
                        _personas.forEach(p -> {
                            System.out.println(p.toString());
                        });
                    }

                } else if (opt == 3) {
                    if (_personas.isEmpty()) {
                        System.out.println("""
                                           Debe de existir al menos 1 persona registrada para iniciar
                                            el proceso de guardado""");
                    } else {
                        try {
                            _calendar = new GregorianCalendar();
                          

                            var _directory = new File(_pathBase+"\\GENERADOS\\");
                            if (!_directory.exists()) {
                                _directory.mkdirs();
                            }
                            var _file = new File(_pathBase+"\\GENERADOS\\" + _filename+_extension);
                            var _writer = new FileWriter(_file.getAbsoluteFile());
                            var _personasToCsv = new StatefulBeanToCsvBuilder<Persona>(_writer).build();
                            _personasToCsv.write(_personas);
                            _writer.close();
                            System.out.println("Los clientes fueron guardados en la "
                                    + "siguiente ruta:\n C:\\CLIENTES\\GENERADOS\\" + _filename+_extension);

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                } else if (opt == 4) {
                    try {
                        var _source = new File(_pathBase+"\\GENERADOS\\" + _filename+_extension);
                        if(_source.exists()){
                            var _newPath = "C:\\CLIENTES\\PROCESADOS\\";
                        var _directory = new File(_newPath);
                            if (!_directory.exists()) {
                                _directory.mkdirs();
                            }
                          File _out = new File(_newPath+_filename+"_prc"+_extension);
                        Files.copy(_source.toPath(), _out.toPath());
                        }else{
                            System.out.println("No se han guardado clientes en la ruta especificada\n"
                                    + " para ser procesados");
                        }
                        
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("ha ocurrido un error.");
            System.exit(0);
        }

    }

}
