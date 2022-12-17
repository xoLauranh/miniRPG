public abstract class Combattant
{
    String name;
    protected int pv;
    protected String typeCombattant;

    public Combattant(String name)
    {
        this.name = name;
        this.pv = 100;
    }

    public String getTypeCombattant()
    {
        return typeCombattant;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    String getName()
    {

        return name;
    }

    int getPv()
    {
        return pv;
    }

    protected abstract void attack(Combattant combattant);

    protected abstract void defend();
}




