/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.usj.lpii.lpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author adriano
 */
public class Financas {
    public static Financas financas = new Financas();
    
    EntityManager em = Persistence
            .createEntityManagerFactory("FinancasJPAPU")
            .createEntityManager();
    
    public void adicionarMovimentacao(Movimentacao m){
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }
    
    public List<Movimentacao> listarMovimentacoes(){
       return em.createQuery("SELECT m FROM Movimentacao m").getResultList();
    }
    
    public Movimentacao buscarMovimentcaoPorId(int id){
        return em.find(Movimentacao.class, id);
}
    public double totalizar(){
        em.getTransaction().begin();
        Double receitas=(Double) em.createQuery(
                "SELECT SUM(m.valor) FROM Movimentacao m"
                + "WHERE m.despesa=false")
                .getSingleResult();
        Double despesas=(Double) em.createQuery(
                "SELECT SUM(m.valor) FROM Movimentacao m"
                + "WHERE m.despesa=true")
                .getSingleResult();
        
        em.getTransaction().commit();
        if (receitas==null)
            receitas=0.0;
        if (despesas==null)
            despesas=0.0;
        return receitas-despesas;
    }
    
    
    
}
