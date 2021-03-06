package Programa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lector {

    private String[] morse;
    private String[] letras;
    private int[] frecuencias;
    private Elemento[] objetos;
    private ArrayList<String> apoyoMorse;
    private ArrayList<String> apoyoLetras;
    private ArrayList<String> apoyoFrecuencias;

    public Lector() {
        apoyoMorse = new ArrayList();
        apoyoLetras = new ArrayList();
        apoyoFrecuencias = new ArrayList();
        objetos = new Elemento[27];
        try {
            obtenerDatos();
            /* morse = crearArregloMorse();
            letras = crearArregloLetras();
            frecuencias = crearArregloFrecuencias();
            objetos=crearObjetos();
            mostrarObjetos();*/
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obtenerDatos() throws IOException {
        String archivo = "src\\main\\java\\Archivos\\codigoMorse.txt";
        File f = new File(archivo);
        BufferedReader br;
        try {
            int i = 0;
            br = new BufferedReader(new FileReader(f));
            String lineaTexto = "";
            while ((lineaTexto = br.readLine()) != null) {
                String[] palabras = lineaTexto.split(" ");
                apoyoLetras.add(palabras[0]);
                apoyoMorse.add(palabras[1]);
                apoyoFrecuencias.add(palabras[2]);
                objetos[i] = new Elemento(Integer.parseInt(palabras[2]), palabras[0], palabras[1]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void descomponerString(String cadena, boolean tipo) {
        //tipo = true;   entonces buscamos en base a la letra normal
        //tipo = false; entonces buscamos en base a la letra normal
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            if (buscarElementoEnArrays(tipo, String.valueOf(letra)) != -1);
        }
    }

    public int buscarElementoEnArrays(boolean tipo, String elemento) {
        if (tipo) {
            for (int i = 0; i < objetos.length; i++) {
                if (objetos[i].getLetra().equalsIgnoreCase(elemento)) {
                    return objetos[i].getFrecuencia();
                }
            }
        } else {
            for (int i = 0; i < objetos.length; i++) {
                if (objetos[i].getMorse().equalsIgnoreCase(elemento)) {
                    return objetos[i].getFrecuencia();
                }
            }
        }
        return -1;

    }

    public Elemento[] getObjetos(){
        return objetos;
    }
    /*
    public String[] crearArregloLetras() {
        String[] aux = new String[apoyoLetras.size()];
        for (int i = 0; i < apoyoLetras.size(); i++) {
            aux[i] = apoyoLetras.get(i);
        }
        return aux;
    }

    public String[] crearArregloMorse() {
        String[] aux = new String[apoyoMorse.size()];
        for (int i = 0; i < apoyoMorse.size(); i++) {
            aux[i] = apoyoMorse.get(i);
        }
        return aux;
    }

    public float[] crearArregloFrecuencias() {
        float[] aux = new float[apoyoFrecuencias.size()];
        for (int i = 0; i < apoyoFrecuencias.size(); i++) {
            aux[i] = Float.parseFloat(apoyoFrecuencias.get(i));
        }
        return aux;
    }*/
/*
    public Elemento[] crearObjetos() {
        Elemento[] aux = new Elemento[letras.length];
        Elemento e;
        for (int i = 0; i < letras.length; i++) {
            e = new Elemento(frecuencias[i], letras[i], morse[i]);
            aux[i] = e;
        }
        return aux;
    }/*
 
    public void ordenar() {
        int contador = 1;
        for (int i = 0; i < objetos.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < objetos.length; j++) {
                contador++;
                if (objetos[j].getFrecuencia() > objetos[min].getFrecuencia()) {
                    min = j;
                }
            }
            if (i != min) {
                Elemento aux = objetos[i];
                objetos[i] = objetos[min];
                objetos[min] = aux;
            }
        }
    }
    
    
    public void mostrarObjetos(){
      for(Elemento a: objetos){
       System.out.println(""+a.toString());
      }
    }
    
//    public void imprimirArreglos() {
//        System.out.println("Arreglo de letras.");
//        for (int i = 0; i < letras.length; i++) {
//            System.out.println(letras[i]);
//        }
//        System.out.println("Arreglo de claves morse.");
//        for (int i = 0; i < morse.length; i++) {
//            System.out.println(morse[i]);
//        }
//        System.out.println("Arreglo de frecuencias.");
//        for (int i = 0; i < frecuencias.length; i++) {
//            System.out.println(frecuencias[i]);
//        }        
//    }

    public Elemento[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Elemento[] objetos) {
        this.objetos = objetos;
    }*/
}
