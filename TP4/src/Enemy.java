public class Enemy extends Combattant {
    int resistance = 0;
    int degat = 25;

    int pV = 100;
    public Enemy(){
        super("Chanel's minion (ennemi)");
        this.pv = pV;
        this.typeCombattant = "enemy";
            }

    public Enemy(String name){
        super(name);
        this.pv = pV;
        this.typeCombattant = "enemy";
    }

    protected void attack(Combattant combattant  )
    {
        combattant.setPv(combattant.getPv()-(degat+resistance));
        System.out.println("L'ennemie a infligé 1 dégat, il reste " + combattant.getPv() + " pv à " + combattant.getName() );
    }

    public void augmenterPv(){
        pV+=50;
        System.out.println("Les ennemis ont plus de vie !");
    }
    public void augmenterDegat(){
        degat+=20;
        System.out.println("Les ennemis sont plus puissants !");
    }

    public void augmenterResistance(){
        resistance+=15;
        System.out.println("Resistance des héros accrue !");
    }
    @Override
    protected void defend() {

    }
}
