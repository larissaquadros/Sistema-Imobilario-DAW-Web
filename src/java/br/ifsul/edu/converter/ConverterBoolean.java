
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.converter;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Larissa
 */
@FacesConverter(value = "converterBoolean")
public class ConverterBoolean implements Converter, Serializable{
    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {    
        if(string.equals("Sim")){
            return true;
        }else{
            return false;
        }
    }
    // converte do objeto para tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Boolean b = (Boolean) o;
        return b ? "Sim" : "Não";
    }
    
        
}