package com.example.unsafeinfo;

public class HazardousInfo {
    private String plataforma;
    private String usuario;
    private String senha;

    public HazardousInfo(String plataforma, String usuario, String senha){
        this.plataforma = plataforma;
        this.usuario = usuario;
        this.senha = senha;
    }
    public String getPlataforma(){
        return plataforma;
    }
    public void setPlataforma(){
        this.plataforma = plataforma;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(){
        this.usuario = usuario;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(){
        this.senha = senha;
    }
}
