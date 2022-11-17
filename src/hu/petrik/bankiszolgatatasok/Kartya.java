package hu.petrik.bankiszolgatatasok;

public class Kartya extends BankiSzolgaltatas{

    private Szamla szamla;

    private String kartyaSzam;

    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaSzam) {
        super(tulajdonos);
        this.szamla = szamla;
        this.kartyaSzam = kartyaSzam;
    }

    public String getKartyaSzam() {
        return kartyaSzam;
    }

    public boolean vasarlas(int osszeg){
        if (this.szamla.aktualisEgyenleg - osszeg > 0){
            this.szamla.aktualisEgyenleg -= osszeg;
            return true;
        }else{
            return false;
        }
    }
}
