/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.usj.lpii.lpa;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author adriano
 */
@ManagedBean
@SessionScoped
public class BeanMovimentacao {
    
    private String despesa;
    private String valor;
    private String titulo;

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void adicionar(){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDespesa(despesa.equals("true"));
        Double valorDouble = new Double(valor);
        movimentacao.setValor(valorDouble);
        movimentacao.setTitulo(titulo);
        Financas.financas.adicionarMovimentacao(movimentacao);
    }
    
    public List<Movimentacao> getlista() {
        return Financas.financas.listarMovimentacoes();
    }
   
    
    public BeanMovimentacao() {
    }
    
    
    
}
