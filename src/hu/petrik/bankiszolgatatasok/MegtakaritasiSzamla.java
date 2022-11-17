package hu.petrik.bankiszolgatatasok;

public class MegtakaritasiSzamla extends Szamla {

    private double kamat;

    public static double alapKamat = 10;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos){
        super(tulajdonos);
        this.kamat = this.alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (getAktualisEgyenleg() - osszeg < 0) {
            return false;
        } else {
            this.aktualisEgyenleg -= osszeg;
            return true;
        }
    }

    public void kamatJovairas(){
        super.aktualisEgyenleg = (int) (super.aktualisEgyenleg * (1+(this.kamat/100)));
    }
}
