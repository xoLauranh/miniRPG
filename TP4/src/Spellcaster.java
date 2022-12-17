import java.util.ArrayList;

public abstract class Spellcaster extends Hero {
    int mana;

    protected Potion potion;
    public Spellcaster(String name,int mana, int degatDeBase)
    {
        super(name,degatDeBase,null,new Armor());

       this.potion=new Potion();

       this.mana=mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana(){
        return this.mana;
    }

    public Potion getPotion() {
        return potion;
    }

    public void ajouterPotion()
    {
        this.potion.quantite = this.potion.quantite+1;
        System.out.println("1 potion a été ajoutée à " + this.getName());
    }
}


