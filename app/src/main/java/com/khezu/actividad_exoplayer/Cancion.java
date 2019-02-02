package com.khezu.actividad_exoplayer;

import java.util.UUID;

public class Cancion {
    private String mId;
    private int mImagen;
    private String mTitulo;


    public Cancion(int mImagen, String mTitulo) {
        mId = UUID.randomUUID().toString();

        this.mImagen = mImagen;
        this.mTitulo = mTitulo;

    }

    public int getmImagen() {
        return mImagen;
    }

    public void setmImagen(int mImagen) {
        this.mImagen = mImagen;
    }

    public String getmTitulo() {

        return mTitulo;
    }

    public void setmTitulo(String mTitulo) {
        this.mTitulo = mTitulo;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }


    @Override
    public String toString() {
        return "Cancion{" +
                "mId='" + mId + '\'' +
                ", mImagen=" + mImagen +
                ", mTitulo='" + mTitulo + '\'' +
                '}';
    }
}
