package com.example.postRequest;

public class ProcessorFile {
    private String rutaArchivo;
    private String tipo;

    public ProcessorFile() {
        this.rutaArchivo = "";
        this.tipo = "";
    }

    public ProcessorFile(String rutaArchivo, String type) {
        this.rutaArchivo = rutaArchivo;
        this.tipo = type;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
