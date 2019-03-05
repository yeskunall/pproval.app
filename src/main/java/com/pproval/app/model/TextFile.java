package com.pproval.app.model;

import javax.persistence.*;

@Entity
public class TextFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = null;
    @Lob
    private byte [] data;
    private String fileName;

    public TextFile(){

    }
    public TextFile(String fileName, byte[] data){
        this.fileName=fileName;
        this.data= data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
