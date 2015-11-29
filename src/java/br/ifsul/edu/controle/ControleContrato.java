/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.controle;

import br.ifsul.edu.dao.ContratoDao;
import br.ifsul.edu.dao.ImovelDao;
import br.ifsul.edu.dao.IndiceDao;
import br.ifsul.edu.dao.PessoaFisicaDao;
import br.ifsul.edu.dao.PessoaJuridicaDao;
import br.ifsul.edu.model.Contrato;
import br.ifsul.edu.model.Pessoa;
import br.ifsul.edu.model.PessoaFisica;
import br.ifsul.edu.model.PessoaJuridica;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleContrato")
@ViewScoped
public class ControleContrato implements Serializable{
    
    private ImovelDao daoImovel;
    private ContratoDao dao; 
    private Contrato objeto;
    private PessoaFisicaDao daoPessoaFisica;
    private PessoaJuridicaDao daoPessoaJuridica;
    private IndiceDao daoIndice;
      

    public ControleContrato() {
        dao = new ContratoDao();
        daoImovel = new ImovelDao();
        daoIndice = new IndiceDao();
        daoPessoaFisica = new PessoaFisicaDao();
        daoPessoaJuridica = new PessoaJuridicaDao();
    }
    
      public String listar() {
        return "/privado/contrato/listar?faces-redirect=true";
    }
      
    public void novo() {
        objeto = new Contrato();
    }

   
    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persistir(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        } catch (Exception e) {
            e.getStackTrace();
            Util.mensagemErro(e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro(e.getMessage());
        }
    }
    
    public void definirPF(PessoaFisica obj){
        Pessoa p = (Pessoa) obj;
        objeto.setLocatario(p);
    }
    
    public void definirPJ(PessoaJuridica obj){
        Pessoa p = (Pessoa) obj;
        objeto.setLocatario(p);
    }
    
    public void remover(Integer id){
        try {
            dao.remover(id);
        } catch(Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }

    public ContratoDao getDao() {
        return dao;
    }

    public void setDao(ContratoDao dao) {
        this.dao = dao;
    }

    public IndiceDao getDaoIndice() {
        return daoIndice;
    }

    public void setDaoIndice(IndiceDao daoIndice) {
        this.daoIndice = daoIndice;
    }

    public ImovelDao getDaoImovel() {
        return daoImovel;
    }

    public void setDaoImovel(ImovelDao daoImovel) {
        this.daoImovel = daoImovel;
    }

    public Contrato getObjeto() {
        return objeto;
    }

    public void setObjeto(Contrato objeto) {
        this.objeto = objeto;
    }

    public PessoaFisicaDao getDaoPessoaFisica() {
        return daoPessoaFisica;
    }

    public void setDaoPessoaFisica(PessoaFisicaDao daoPessoaFisica) {
        this.daoPessoaFisica = daoPessoaFisica;
    }

    public PessoaJuridicaDao getDaoPessoaJuridica() {
        return daoPessoaJuridica;
    }

    public void setDaoPessoaJuridica(PessoaJuridicaDao daoPessoaJuridica) {
        this.daoPessoaJuridica = daoPessoaJuridica;
    }

    
    
}
