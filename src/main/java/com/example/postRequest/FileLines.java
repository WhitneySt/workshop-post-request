package com.example.postRequest;

import java.util.ArrayList;

public class FileLines<T> {
    ArrayList<T> lines;

    public FileLines() {
        this.lines = new ArrayList<>();
    }

    public T crearLinea(T content){
        this.lines.add(content);
        return content;
    }

    public ArrayList<T> getLines(){
        return this.lines;
    }

    public T getLine(int index) {
        return this.lines.get(index);
    }

    public  void borrarCabeceras() {
        this.lines.remove(0);
    }

    public int obtenerTamanio() {
        return this.lines.size();
    }
}
