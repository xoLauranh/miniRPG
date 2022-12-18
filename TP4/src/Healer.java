import java.util.Scanner;

public class Healer extends Spellcaster{

    int soin = 20;
    public Healer(String name)
    {
        super(name,5,20);
        this.typeCombattant= "healer";
    }

    protected void attack(Combattant ennemie)
    {
        if (this.getMana() >0)
        {
            ennemie.setPv(ennemie.getPv()-getDegatDeBase());
            this.setMana(this.getMana()-1);
            System.out.println("Vous avez infligé " + getDegatDeBase() + " dégats à" + ennemie + "il vous reste " + this.getMana() + " fluid oz de mana" );
        }
        else
        {
            System.out.println("! vous n'avez plus assez de mana !");
        }
    }

    public String afficher()
    {
        return this.getName() + "(" + this.getTypeCombattant() + "," + this.getPv() + " PV, " + this.getMana() + " fluid oz de mana)";
    }

    @Override
    protected void defend() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous :\n1.Manger\n2.Prendre une potion\n3.Vous soigner");
    int choix = 0;
    while (!(choix == 1 || choix == 2 || choix ==3))

        choix = scanner.nextInt();

        switch (choix) {
            case 1: {
                if (this.getNourriture().quantite > 0)
                    this.getNourriture().manger(this);
                break;
            }

            case 2: {
                if (this.potion.quantite > 0)
                    this.potion.utilisePotion(this);
                break;
            }

            case 3: {
                if (this.getMana() > 0) {
                    if (this.getPv() < 100) {
                        this.setPv(this.getPv() + soin);
                        this.setMana(this.getMana() - 1);
                        if (this.getPv() > 100)
                            this.setPv(100);
                    } else System.out.println("Le héro a déjà toute sa vie");
                } else System.out.println("Le héro n'a plus de mana");
                break;
            }

        }
    }

    public void ameliorerSoin(){
        soin=soin+20;
        System.out.println("Les healer se soignent 20 de vie en plus");
    }
}
