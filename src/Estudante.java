/**
 * A classe Estudante terá como diferencial o atributo instituicao, 
 * que corresponde a instituição de onde aquele estudante veio, podendo 
 * mudar dependendo se o estudante vem de uma faculdade ou de uma escola.
 * @author Alexson Almeida
 */
public class Estudante extends Hospede{

    //Atributos
    private Instituicao instituicao;
    private String nomeInst;

    /**
     * Além de definir os valores padrões do hóspede, também irá ser definido
     * o nome da instituição de ensino do estudante.
     * @param Nome do hóspede
     * @param Idade do hóspede
     * @param Tipo da instituição(Escola ou Universidade)
     * @param Nome da instituição de onde o estudante veio
     */
    public Estudante(String nome, int idade, Instituicao instituicao, String nomeInst) {
        super(nome, idade);
        this.instituicao = instituicao;
        this.nomeInst = nomeInst;
    }

    /**
     * Dependendo de onde o estudante frequenta(se é uma escola ou uma 
     * universidade) os descontos serão aplicados de maneira diferente
     * @return O valor do desconto, basedo de onde o estudante frequenta
     */
    @Override
    public float calcularDesconto() {
        if(instituicao.equals(Instituicao.ESCOLA)){
            return 10;
        }else if(instituicao.equals(Instituicao.UNIVERSIDADE)){
            return (float) 12.5;
        }else{
            return 0;
        }
    }

    /**
     * Além de retornar os mesmos valores que hóspede retorna, esse também
     * retorna o nome da instituição de ensino do estudante e o tipo dela
     * (Escola ou Universidade).
     * @return Os dados do Hospede separados por linhas.
     */
    public String toString() {
        String resultado = "" + super.toString();
        resultado += String.format("Nome da instituição: %s\n", this.nomeInst);
        resultado += String.format("Instituição: %s\n", this.instituicao);
        return resultado;
    }
    
    //Getter
    /**
     * @return O nome da instituição do estudante.
     */
    public String getNomeInst(){
        return this.nomeInst;
    }
}
