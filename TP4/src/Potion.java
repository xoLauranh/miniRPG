public class Potion extends Consumable {
    int manaRendu=2;
    public Potion(){
        super(3,1,"potion");
    }

    public void utilisePotion(Spellcaster spellcaster) {
        if (spellcaster.getMana() < 5) {
            spellcaster.setMana(spellcaster.getMana() + manaRendu);
            this.setNbrUtilisation(this.getNbrUtilisation() - 1);
            if (spellcaster.getMana() > 5)
                spellcaster.setMana(5);
        } else {
            System.out.println(spellcaster.getName() + " est déjà full mana...");
        }
    }

    public void augEff(){
        manaRendu++;
        System.out.println("Les potions rendent maintenant 1 fluid oz de mana supplémentaire !");
    }


    public int getManaRendu(){return manaRendu;}
    public void ameliorePotion(){manaRendu++;}
}
