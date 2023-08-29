/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccc.gestionvoluntariadoGUI;

import com.ccc.gestionvoluntariado.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * @author Ermes
 */
public class VentanaEmergente {
    
    private String valor1;
    private String valor2;
    private String valor3;
    private DefaultTableModel tableModel;

    void ventanasEmergentesCrear(String[] nomCol, Consumer<String[]> valores) {
        JDialog dialog = new JDialog((JFrame) null, "Introduce los datos", true);
        dialog.setBounds(20, 20, 400, 200);
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
        String dospunt = ": ";

        JPanel panel = new JPanel();

        JLabel dato1 = new JLabel(nomCol[0] + dospunt);
        JLabel dato2 = new JLabel(nomCol[1] + dospunt);
        JLabel dato3 = new JLabel(nomCol[2] + dospunt);

        JTextField cajaTxt1 = new JTextField(10);
        JTextField cajaTxt2 = new JTextField(10);
        JTextField cajaTxt3 = new JTextField(10);

        JButton boton = new JButton("Proceder");

        cajaTxt1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        cajaTxt2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        cajaTxt3.setAlignmentX(Component.RIGHT_ALIGNMENT);

        dialog.add(panel);
        panel.add(dato1);
        panel.add(cajaTxt1);
        panel.add(dato2);
        panel.add(cajaTxt2);
        panel.add(dato3);
        panel.add(cajaTxt3);
        panel.add(boton);

        dialog.pack();

        boton.addActionListener((ActionEvent e) -> {
        valor1 = cajaTxt1.getText();
        valor2 = cajaTxt2.getText();
        valor3 = cajaTxt3.getText();

        // Verificación de los campos vacíos
        if(valor1.isEmpty() && valor2.isEmpty() && valor3.isEmpty()){
            // Mostrar un mensaje de error
            JOptionPane.showMessageDialog(dialog, "Se requiere al menos un campo.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            valores.accept(new String[] { valor1, valor2, valor3 });
            dialog.dispose();
        }
    });


    dialog.setVisible(true);

    //String[] valores = new String[]{valor1, valor2, valor3};

    //return valores;
}
    
    void ventanasEmergentesCrearReg(String[] nomCol, Consumer<String[]> valores) {
    JDialog dialog = new JDialog((JFrame) null, "Introduce los datos", true);
    dialog.setBounds(20, 20, 400, 200);
    dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
    String dospunt = ": ";

    JPanel panel = new JPanel();

    JLabel dato1 = new JLabel(nomCol[0] + dospunt);
    JLabel dato2 = new JLabel(nomCol[1] + dospunt);
    JLabel dato3 = new JLabel(nomCol[2] + dospunt);

    // Crea tus desplegables aquí
    JComboBox<Beneficiario> cajaTxt1 = new JComboBox<Beneficiario>(new BeneficiarioDAO().obtenerTodos().toArray(new Beneficiario[0]));
    JComboBox<Proyecto> cajaTxt2 = new JComboBox<Proyecto>(new ProyectoDAO().obtenerTodos().toArray(new Proyecto[0]));
    JComboBox<String> cajaTxt3 = new JComboBox<String>(new String[]{"Alta", "Baja"});
        
    JButton boton = new JButton("Proceder");

    cajaTxt1.setAlignmentX(Component.RIGHT_ALIGNMENT);
    cajaTxt2.setAlignmentX(Component.RIGHT_ALIGNMENT);
    cajaTxt3.setAlignmentX(Component.RIGHT_ALIGNMENT);

    dialog.add(panel);
    panel.add(dato1);
    panel.add(cajaTxt1);
    panel.add(dato2);
    panel.add(cajaTxt2);
    panel.add(dato3);
    panel.add(cajaTxt3);
    panel.add(boton);

    dialog.pack();

    boton.addActionListener((ActionEvent e) -> {
        Beneficiario ben = (Beneficiario) cajaTxt1.getSelectedItem();
        System.out.println(ben.getId());
        Proyecto pro = (Proyecto) cajaTxt2.getSelectedItem();
        String estado = (String) cajaTxt3.getSelectedItem();
        
        valor1 = String.valueOf(ben.getId());
        valor2 = String.valueOf(pro.getId_pro());
        valor3 = estado;
                
        // Verificar si el registro ya existe
        //UsuarioProyectoDAO regDAO = new UsuarioProyectoDAO();
        /*if(regDAO.existeRegistro(ben.getId(), pro.getId_pro(), estado)){
        JOptionPane.showMessageDialog(dialog, "Este registro ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        */      
        
        valores.accept(new String[] { valor1, valor2, valor3 });
        dialog.dispose();
        //      }
    });

    dialog.setVisible(true);
}
    
void creaVol(String[] valores) {
    try {
        // Convertir valor1 en un entero
        String nombre = valores[0];
        String apellidos = valores[1];
        String titulacion = valores[2];
        
        // Crear un objeto Voluntario con los valores obtenidos
        Voluntario voluntario = new Voluntario(nombre, apellidos, titulacion);
        
        // Crear un objeto VoluntarioDAO y llamar al método agregarVoluntario()
        VoluntarioDAO voluntarioDAO = new VoluntarioDAO();
        voluntarioDAO.agregarVoluntario(voluntario);
        System.out.println(voluntario.getId());
        
        // Puedes mostrar un mensaje de confirmación o actualizar la vista según tus necesidades

    } catch (NumberFormatException e) {
        // Mostrar un mensaje de error en caso de que el usuario ingrese un carácter no numérico
        JOptionPane.showMessageDialog(null, "El valor ingresado no es válido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

void creaBen(String[] valores) {
    try {
        // Convertir valor1 en un entero
        String nombre = valores[0];
        String apellidos = valores[1];
        String nacionalidad = valores[2];
        
        // Crear un objeto Voluntario con los valores obtenidos
        Beneficiario ben = new Beneficiario(nombre, apellidos, nacionalidad);
                
        // Crear un objeto VoluntarioDAO y llamar al método agregarVoluntario()
        BeneficiarioDAO benDAO = new BeneficiarioDAO();
        benDAO.agregarBeneficiario(ben);
        
        // Puedes mostrar un mensaje de confirmación o actualizar la vista según tus necesidades

    } catch (NumberFormatException e) {
        // Mostrar un mensaje de error en caso de que el usuario ingrese un carácter no numérico
        JOptionPane.showMessageDialog(null, "El valor ingresado no es válido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

void creaAcc(String[] valores) {
    try {
        // Convertir valor1 en un entero
        String fechaStr = valores[0];
        String participantesStr = valores[1];
        String area = valores[2];

        // Comprobar si los guiones están en las posiciones correctas en la fecha
        if (fechaStr.charAt(4) != '-' || fechaStr.charAt(7) != '-') {
            throw new IllegalArgumentException("El formato de fecha ingresado no es correcto. Introduzca la fecha en el formato: yyyy-MM-dd");
        }
        
        // Convertir la cadena fecha a un objeto Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Asegúrate de que este formato coincida con el formato de la fecha ingresada
        dateFormat.setLenient(false); // Esto hace que el formato de fecha sea estrictamente yyyy-MM-dd
        java.util.Date fechaUtil = dateFormat.parse(fechaStr);

        // Convertir el objeto java.util.Date a un objeto java.sql.Date
        java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());

        int id_ben = Integer.parseInt(participantesStr);
        Beneficiario ben = new BeneficiarioDAO().buscarBeneficiario(id_ben);
                
        if(ben == null) {
            throw new NullPointerException("Este beneficiario no existe en la base de datos.");
        }
        
        // Crear un objeto con los valores obtenidos
        AccionVoluntariado acc = new AccionVoluntariado(fecha, ben, area);

        // Crear un objeto DAO y llamar al método agregar correspondiente
        AccionVoluntariadoDAO accDAO = new AccionVoluntariadoDAO();
        accDAO.agregarAccionVoluntariado(acc);

        // Puedes mostrar un mensaje de confirmación o actualizar la vista según tus necesidades

    } catch (NumberFormatException e) {
        // Mostrar un mensaje de error en caso de que el usuario ingrese un carácter no numérico
        JOptionPane.showMessageDialog(null, "El valor ingresado no es válido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NullPointerException e) {
        // Mostrar un mensaje de error en caso de que el registro referenciado no exista
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (ParseException ex) {
        // Mostrar un mensaje de error en caso de que el formato de fecha sea incorrecto
        JOptionPane.showMessageDialog(null, "El formato de fecha ingresado no es correcto. Introduzca la fecha en el formato: yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
        // Mostrar un mensaje de error en caso de que los guiones no estén en las posiciones correctas
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}

void creaReg(String[] valores) {
    try {
        // Convertir valor[0] y valor[1] en un entero
        int id_ben = Integer.parseInt(valores[0]);
        int id_pro = Integer.parseInt(valores[1]);
        String estado = valores[2];

        Beneficiario ben = new BeneficiarioDAO().buscarBeneficiario(id_ben);
        Proyecto pro = new ProyectoDAO().buscarProyecto(id_pro);
        /*        
        if(ben == null || pro == null) {
            throw new NullPointerException("Uno o ambos registros no existen en la base de datos.");
        }
        */
        // Crear un objeto con los valores obtenidos
        UsuarioProyecto reg = new UsuarioProyecto(ben, pro, estado);

        // Crear un objeto DAO y llamar al método agregar correspondiente
        UsuarioProyectoDAO regDAO = new UsuarioProyectoDAO();
        regDAO.agregarUsuarioProyecto(reg);

        // Puedes mostrar un mensaje de confirmación o actualizar la vista según tus necesidades

    } catch (NumberFormatException e) {
        // Mostrar un mensaje de error en caso de que el usuario ingrese un carácter no numérico
        JOptionPane.showMessageDialog(null, "El valor ingresado no es válido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NullPointerException e) {
        // Mostrar un mensaje de error en caso de que el registro referenciado no exista
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

void creaPro(String[] valores) {
    try {
        // Convertir valor1 en un entero
        String nombre = valores[0];
        int anno = Integer.parseInt(valores[1]);
        int plazas = Integer.parseInt(valores[2]);
        
        // Crear un objeto Voluntario con los valores obtenidos
        Proyecto pro = new Proyecto(nombre, anno, plazas);
        
        // Crear un objeto VoluntarioDAO y llamar al método agregarVoluntario()
        ProyectoDAO proDAO = new ProyectoDAO();
        proDAO.agregarProyecto(pro);
        
        // Puedes mostrar un mensaje de confirmación o actualizar la vista según tus necesidades

    } catch (NumberFormatException e) {
        // Mostrar un mensaje de error en caso de que el usuario ingrese un carácter no numérico
        JOptionPane.showMessageDialog(null, "El valor ingresado no es válido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

DefaultTableModel buscVol(String[] valores){
    try {
        VoluntarioDAO volDAO = new VoluntarioDAO();
        List<Voluntario> busquedaVol = volDAO.filtrarVoluntarios(valores);
        Object[][] data = new Object[busquedaVol.size()][3]; // 3 es el número de columnas

// Rellenamos la matriz de datos con la información de los voluntarios
    for (int i = 0; i < busquedaVol.size(); i++) {
        Voluntario voluntario = busquedaVol.get(i);
        data[i][0] = voluntario.getNombre();
        data[i][1] = voluntario.getApellidos();
        data[i][2] = voluntario.getTitulacion();
        System.out.println(voluntario.getNombre()+" "+voluntario.getApellidos()+" "+voluntario.getTitulacion());
}

// Creamos el DefaultTableModel
    tableModel = new DefaultTableModel(data, gestionvoluntariadoGUI.nomColVol);        
    }
    catch (NumberFormatException e) {
        // Mostrar un mensaje de error en caso de que el usuario ingrese un carácter no numérico
        JOptionPane.showMessageDialog(null, "El valor ingresado no es válido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    return tableModel;


    
    }

}