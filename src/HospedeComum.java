/**
 * A classe HospedeComum se trata de um hóspede que os descontos não 
 * são baseados em instituições ou empresas, como as do turista(onde o 
 * desconto é dado pela empresa de aviação) e as do Universitário(onde o
 * desconto é dado devido a parcerias com instituições escolares), mas 
 * em fatores como idade, se a pessoa for muito velha ou muito nova, 
 * ela receberá um respectivo desconto. 
 * @author José Vitor
 */
public class HospedeComum extends Hospede{
    /**
     * Como o HospedeComum não se difere do Hospede
     * o construtor irá chamar apenas a classe mãe 
     * @param Nome do hóspede
     * @param Idade do hóspede
     */
    public HospedeComum(String nome, int idade){
        super(nome, idade);
    }
    /**
     * Se o hóspede tiver 10 anos ou menos receberá um desconto de 5%, 
     * enquanto se tiver 65 anos ou mais ele receberá um desconto de 7.5%
     * @return O valor do desconto baseado na idade
     */
    @Override
    public float calcularDesconto() {
        if(getIdade() <= 10){
            return 5;
        }else if(getIdade() >= 65){
            return (float) 7.5;
        }else{
            return 0;
        }
    }
    /** 
     * Aqui o toString terá os mesmos retornos da classe Hospede, 
     * pois a classe HospedeComum não possui nenhum atributo a mais 
     * que precise ser exibido.
     * @return Os dados do Hospede separados por linhas.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
