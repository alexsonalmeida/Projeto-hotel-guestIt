import java.util.ArrayList;
import java.util.List;

public class Quarto {

    //Atributos
    private TipoDeQuarto tpQuarto;
    private List<Hospede> hospedes;
    private int maxHospedes;
    private float precoHosp;

    public Quarto(TipoDeQuarto tpQuarto) {
        this.tpQuarto = tpQuarto;
        switch (this.tpQuarto) {
            case QUARTO_UNICO:
                this.maxHospedes = 1;
                this.precoHosp = 90;
                break;

            case QUARTO_CASAL:
                this.maxHospedes = 2;
                this.precoHosp = 160;
                break;

            case QUARTO_SOLTEIRO_DUPLO:
                this.maxHospedes = 2;
                this.precoHosp = 200;
                break;

            case QUARTO_FAMILIA:
                this.maxHospedes = 5;
                this.precoHosp = 400;
                break;

            default:
                this.maxHospedes = 0;
                this.precoHosp = 0;
                break;
        }
    }

    public void addHospedes(List<Hospede> hospedes){
        if(this.hospedes == null){
            this.hospedes = new ArrayList<Hospede>();
        }
        if(hospedes.size() > maxHospedes){
            throw new Error("Quantidade de hóspedes excede a capacidade do quarto");
        }else{
            this.hospedes = new ArrayList<Hospede>(hospedes);
        }
    }

    public void addHospede(Hospede hospede){
        if(this.hospedes == null){
            this.hospedes = new ArrayList<Hospede>();
        }
        if(this.hospedes.size() >= maxHospedes){
            throw new Error("Quantidade maxima de hóspedes antiginda");
        }else{
            this.hospedes.add(hospede);
        }
    }

    public float getPrecoHosp(){
        return this.precoHosp;
    }

    public List<Hospede> getHospedes(){
        return this.hospedes;
    }

    public int getMaxHospedes(){
        return this.maxHospedes;
    }

    public TipoDeQuarto getTpQuarto() {
        return this.tpQuarto;
    }
    
    @Override
    public String toString() {
        String resultado = String.format("Tipo do Quarto: %s \n", this.tpQuarto);
        if(this.hospedes == null){
            resultado += "Sem hóspedes no momento\n";
        }else{
            resultado += "Hóspesdes: ";
            int i = 0;
            for (Hospede hospede : this.hospedes) {
                if(i == this.hospedes.size() - 1){
                    resultado += hospede.getNome();
                }else{
                    resultado += hospede.getNome() + ", ";
                }
                i++;
            }
            resultado += "\n";
        }
        return resultado;
    }
}
