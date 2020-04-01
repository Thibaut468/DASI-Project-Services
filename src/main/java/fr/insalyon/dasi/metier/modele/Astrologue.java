/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author thibautgravey
 */
@Entity
public class Astrologue extends Medium implements Serializable {
    
    private String formation;
    private int promotion;
    
    protected Astrologue() {
    }
    
    public Astrologue(String denomination, boolean genre, String presentation, String formation, int promotion) {
        super(denomination,genre,presentation);
        this.formation=formation;
        this.promotion=promotion;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }
    
    @Override
    public String toString() {
        return super.toString()+", type=Astrologue, formation=" + formation + ", promotion="+promotion;
    }
    
}