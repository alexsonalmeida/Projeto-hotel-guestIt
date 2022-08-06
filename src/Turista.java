/**
 * A classe Turista terá o como diferencial o atributo agenViagem
 * que representa a agência de viagens encarregada por deixar o turista 
 * naquela cidade, além disso a agência de viagens terá parceria com o hotel, 
 * dessa forma o hotel fornece um desconto para o turista, dependendo se o 
 * turista veio de outro país, ou se é um turista local.
 * @author Alexson Almeida
 */
public class Turista extends Hospede{

    //Atributos
    private Agencia agenViagem;
    private String nomeAgen;

    /**
     * Além de definir os valores padrões do hóspede, também irá ser definido
     * o nome da agência de viagens do hóspede e o tipo dela(Local ou 
     * Internacional)
     * @param Nome do hóspede
     * @param Idade do hóspede
     * @param Tipo da Agencia de viagem
     * @param Nome da agência de viagens do hóspede
     */
    public Turista(String nome, int idade,  Agencia agenViagem, String nomeAgen) {
        super(nome, idade);
        this.agenViagem = agenViagem;
        this.nomeAgen = nomeAgen;
    }

    /**
     * Além de retornar os mesmos valores que hóspede retorna, esse também
     * retorna o nome da agência de viagens e o tipo dela
     * (Local ou Internacional).
     * @return Os dados do Hospede separados por linhas.
     */
    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += String.format("Agencia de viagens: %s\n", this.nomeAgen);
        resultado += String.format("Tipo da agência: %s \n", this.agenViagem);
        return resultado;
    }

    /**
     * Dependendo de onde o turista veio (De outro país ou um turista que 
     * apenas é de outra cidade/estado), haverá descontos diferentes
     * @return O valor do desconto, basedo de onde o turista veio
     */
    @Override
    public float calcularDesconto() {
        if(agenViagem.equals(Agencia.LOCAL)){
            return 10;
        }else if(agenViagem.equals(Agencia.INTERNACIONAL)){
            return 15;
        }else{
            return 0;
        }
    }

    //Getter
    /**
     * @return O nome da agência de viagens do hóspede.
     */
    public String getNomeAgen() {
        return this.nomeAgen;
    }
}
