/**
 * A classe Hóspede é uma classe abstrata que vai ser a classe mãe das 
 * classes Turista, Universitário e HospedeComum. O método que vai ser 
 * sobrescrito por essas classes vai ser o método {@code calcularDesconto()}.
 * @author José Vitor
 */
public abstract class Hospede {

    //Atributos
    private String nome;
    private int idade;
    private float cache;
    private int numQuarto;

    /**
     * Aqui no método construtor será definido o nome, idade e 
     * o número do quarto externamente(ou seja, teremos que digitar 
     * os valores quando formos inicializar o programa) e o por padrão 
     * o cache será iniciado como 0, pois o hóspede ainda não gastou nada.
     * @param Nome do hóspede
     * @param Idade do hóspede
     */
    public Hospede(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        this.numQuarto = -1;
        this.cache = 0;
    }
    
    /**
     * Aqui o toString irá retornar o nome, cache, idade e o número do quarto do hóspede.
     * @return Os dados do Hospede separados por linhas.
     */
    @Override
    public String toString() {
        String resultado = String.format("Nome: %s\nIdade: %d\n", this.nome, this.idade);
        resultado += String.format("Numero do Quarto: %d\nValor do cache: %.2f\n", this.numQuarto, this.cache);
        return resultado;
    }
    
    /**
     * A forma que o desconto será calculado será diferente em cada classe, 
     * portanto ele será abstrato aqui.
     * @return O desconto do hóspede em porcentagem(ex: 40 = 40%).
     */
    public abstract float calcularDesconto();
    
    /**
     * Incrementa ou decrementa o valor do cache
     * @param Valor a ser adicionado ou removido do cache
     */
    public void addCache(float value){
        this.cache += value;
    }

    //Getters e Setters
    /**
     * @return O cache do hóspede, levando em conta o desconto que ele tem.
     */
    public float getCache(){
        return this.cache - (this.cache * calcularDesconto()/100);
    }

    
    /**
     * @return O nome do hóspede.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * @return A idade do hóspede.
     */
    public int getIdade(){
        return this.idade;
    }

    /**
     * @return O número do quarto do hóspede.
     */
    public int getNumQuarto(){
        return this.numQuarto;
    }

    /**
     * @param Numero do quarto do hóspede
     */
    public void setNumQuarto(int numQuarto){
        this.numQuarto = numQuarto;
    }
}   
