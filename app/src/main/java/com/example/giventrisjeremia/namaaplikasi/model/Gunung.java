package com.example.giventrisjeremia.namaaplikasi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Giventris Jeremia on 27/05/2017.
 */

public class Gunung {

        @SerializedName("nama_gunung")
        @Expose
        private String namaGunung;
        @SerializedName("tinggi_gunung")
        @Expose
        private String tinggiGunung;
        @SerializedName("foto_gunung")
        @Expose
        private String fotoGunung;

        public String getNamaGunung() {
            return namaGunung;
        }

        public void setNamaGunung(String namaGunung) {
            this.namaGunung = namaGunung;
        }

        public String getTinggiGunung() {
            return tinggiGunung;
        }

        public void setTinggiGunung(String tinggiGunung) {
            this.tinggiGunung = tinggiGunung;
        }

        public String getFotoGunung() {
            return fotoGunung;
        }

        public void setFotoGunung(String fotoGunung) {
            this.fotoGunung = fotoGunung;
        }

    }
