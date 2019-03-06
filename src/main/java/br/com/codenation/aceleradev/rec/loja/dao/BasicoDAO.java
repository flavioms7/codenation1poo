package br.com.codenation.aceleradev.rec.loja.dao;

import java.util.List;

public interface BasicoDAO<T> {
    
    public T getById(int id);
    public List<T> getAll();
     
}