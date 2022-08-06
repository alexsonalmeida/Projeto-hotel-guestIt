import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Na classe Aplicação, além do método main haverá mais três métodos que 
 * nos ajudarão a executar o sistema de hotelaria com êxito.
 * @author Alexson Almeida e José Vitor
 */
public class Aplicacao {

        /**
         * Neste método iremos gerar o arquivo .ser com os dados do hotel
         * @param h O hotel que será escrito em um arquivo serializable
         */
        public static void escreveArquivo (Hotel h) {
            try (
                    FileOutputStream hotelFile = new FileOutputStream("hotel.ser");
                    ObjectOutputStream hotelStream = new ObjectOutputStream(hotelFile);
                ) {
                    hotelStream.writeObject(h);

                } catch (IOException e) {
                    System.out.println("O arquivo não pode ser escrito");
                }
        }

        /**
         * Enquanto o metodo {@code escreveArquivo(Hotel h)} escreve um 
         * arquivo, esse nos permite ler dessa forma podemos criar um 
         * arquivo e reaproveitar os dados dele ao ler
         * @return Os dados do hotel que foram lidos do arquivo
         */
        public static Hotel lerArquivo() {
            Hotel hotelLeitura = null;
            try (
                FileInputStream hotelFile = new FileInputStream("hotel.ser");
                ObjectInputStream hotelStream = new ObjectInputStream(hotelFile);
            ) {
                hotelLeitura = (Hotel) hotelStream.readObject();
            } catch (FileNotFoundException e) {   
                System.err.println("Arquivo não encontrado");
            } catch (IOException e) {   
                System.err.println("O arquivo não pôde ser lido");
            } catch (ClassNotFoundException e){
                System.err.println("Classe não encontrada");
            } 
            return hotelLeitura;
        }
        /**
         * Esse metodo irá receber o ID do tipo de quarto(1: Comum - 
         * 2: Estudante - 3: Turista) e o ID do tipo de hóspede que será 
         * criado(1: Unico - 2: Solteiro duplo - 3: Casal - 4: Familia) e
         * irá criar uma lista com base nesses IDs
         * @param quarto O ID do tipo de quarto que sera criado
         * @param hospede O ID do tipo de hóspede que será criado
         * @return Uma lista de hóspedes 
         */
        public static List<Hospede> criaHospede(int quarto, int hospede) {
            int c = 0;
            int i = 0;
            String nome = "";
            int idade = 0;
            Scanner sc = new Scanner(System.in);
            List<Hospede> lista = new ArrayList<>();
            switch (quarto) {
                case 1:
                    c = 1;
                break;
                case 4:
                    System.out.println("Qual o tamanho da família?");
                    c = sc.nextInt();
                    sc.nextLine();
                break;
                default:
                    c = 2;
                break;
            }
            switch (hospede) {
                case 1:
                    System.out.print("Digite o nome do hóspede responsável: ");
                    nome = sc.nextLine();
                    System.out.print("Digite a idade: ");
                    idade = sc.nextInt();
                    sc.nextLine();
                    Hospede h1 = new HospedeComum(nome, idade);
                    lista.add(h1);
                    break;
                case 2:
                    int op;
                    String instituicao;
                    System.out.print("Digite o nome do hóspede responsável: ");
                    nome = sc.nextLine();
                    System.out.print("Digite a idade: ");
                    idade = sc.nextInt();
                    System.out.println("Digite o tipo da instituicao: (1:Escola - 2:Universidade)");
                    op = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o nome da instituicao: ");
                    instituicao = sc.nextLine();
                    if (op == 1) {
                        Hospede h2 = new Estudante(nome, idade, Instituicao.ESCOLA, instituicao);
                        lista.add(h2);
                    } else {
                        Hospede h2 = new Estudante(nome, idade, Instituicao.UNIVERSIDADE, instituicao);
                        lista.add(h2);
                    }      
                    break; 
                case 3:
                    int op1;
                    String agenciaViagem;
                    System.out.print("Digite o nome do hóspede responsável: ");
                    nome = sc.nextLine();
                    System.out.print("Digite a idade: ");
                    idade = sc.nextInt();
                    System.out.println("Digite o tipo de agencia: (1:local - 2:internacional)");
                    op1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o nome da agencia: ");
                    agenciaViagem = sc.nextLine();
                    if (op1 == 1) {
                        Hospede h3 = new Turista(nome, idade, Agencia.LOCAL, agenciaViagem);
                        lista.add(h3);
                    } else {
                        Hospede h3 = new Turista(nome, idade, Agencia.INTERNACIONAL, agenciaViagem);
                        lista.add(h3);
                    }
                    break;
            }

            if (c != 1) {
                for (i = 1; i < c; i++) {
                    System.out.print("Digite o nome do hóspede: ");
                    nome = sc.nextLine();
                    System.out.print("Digite a idade: ");
                    idade = sc.nextInt();
                    sc.nextLine();
                    Hospede fulano = new HospedeComum(nome, idade);
                    lista.add(fulano);
                }            
            }
            return lista;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Hotel hotel = null;
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        System.out.println("Seja vem vindo ao hotel " + Hotel.nomeHotel);
        System.out.println("Deseja ler o arquivo hotel já existente? 1-Sim 2-Não");
        int op2 = scan.nextInt();
        if(op2 == 1){
            if(lerArquivo() == null){
                hotel = new Hotel();
            }else{
                hotel = lerArquivo();
            }
        }else{
            hotel = new Hotel();
        }
        while (opcao != -1) {
            try {
                System.out.println("Digite uma opção(Digite 0 para ver os comandos):");
                opcao = scan.nextInt();
                int numQuarto = 0;
                switch (opcao) {
                    case 0:
                        System.out.println("Menu de opções");
                        System.out.println("0. Ajuda");
                        System.out.println("1. Check-in de hóspede(s)");
                        System.out.println("2. Check-out de hóspede(s)");
                        System.out.println("3. Chamar serviço de quarto");
                        System.out.println("4. Listar hospede");
                        System.out.println("5. Listar quarto");
                        System.out.println("6. Listar dados do hotel");
                        System.out.println("7. Calcular o cache do hóspede");
                        System.out.println("-1. Sair do sistema");
                        break;

                    case 1:
                        int tipoQuarto, tipoHospede;
                        System.out.println("Qual o tipo do Hóspede responsável?");
                        System.out.println("1: Comum - 2: Estudante - 3: Turista - 0: Sair");
                        tipoHospede = scan.nextInt();
                        if(tipoHospede == 0) {
                            break;
                        } else if(tipoHospede < 0 || tipoHospede > 3) {
                            System.out.println("Erro, opção de tipo de hóspede indisponível");
                            break;
                        }
                        System.out.println("Qual o tipo de quarto desejado?");
                        System.out.println("1: Unico - 2: Solteiro duplo - 3: Casal - 4: Familia - 0: Sair");
                        tipoQuarto = scan.nextInt();
                        if (tipoQuarto == 0) {
                            break;
                        } else if (tipoQuarto < 0 ||  tipoQuarto > 4) {
                            System.out.println("Erro, opção de tipo de quarto indisponível");
                            break;
                        }
                        int cont = 0;
                        if(tipoQuarto == 1) cont = 15;
                        else if(tipoQuarto == 2) cont = 10;
                        else if(tipoQuarto == 3) cont = 0;
                        else if(tipoQuarto == 4) cont = 5;
                        boolean disp = false;
                        for (int i = cont; i < Hotel.qtdMaxQuartos; i++) {
                            if(hotel.getQuarto(i).getHospedes() == null){
                                hotel.addHospedes(criaHospede(tipoQuarto, tipoHospede), i);
                                disp = true;
                                break;
                            }
                        }
                        if(disp == true)
                            System.out.println("Hóspede adicionado!");
                        else 
                            System.out.println("Todos os quartos dessa categoria estão cheios");
                        break;
                    case 2:
                        System.out.println("Digite o numero do quarto que será desocupado:(-1 para cancelar)");
                        numQuarto = scan.nextInt();
                        if(numQuarto == -1) break;
                        Hospede desocupado = hotel.desocupar(numQuarto);
                        System.out.println("Quarto desocupado com sucesso");
                        System.out.println("O valor a ser pago é de: " + desocupado.getCache());
                        break;
                    case 3:
                        System.out.println("Digite qual serviço de quarto você deseja fornecer: ");
                        System.out.println("1. Faxina");
                        System.out.println("2. Bufe de alimentação");
                        System.out.println("3. Lavanderia");
                        System.out.println("-1. Cancelar ação");
                        int op = scan.nextInt();
                        if(op == -1){
                            break;
                        }else{
                            System.out.println("Digite o numero do quarto que recebera o serviço de quarto:(-1 para cancelar) ");
                            numQuarto = scan.nextInt();
                            if(numQuarto == -1) break;
                            if(op == 1){
                                hotel.servicoQuarto(numQuarto, ServicoDeQuarto.FAXINA);
                            }else if(op == 2){
                                hotel.servicoQuarto(numQuarto, ServicoDeQuarto.BUFE);
                            }else if(op == 3){
                                hotel.servicoQuarto(numQuarto, ServicoDeQuarto.LAVANDERIA);
                            }
                            System.out.println("Serviço fornecido");
                        }
                        break;

                    case 4:
                        System.out.println("Digite o número do quarto do hospede que será exibido: ");
                        numQuarto = scan.nextInt();
                        if(hotel.getHospede(numQuarto).equals(null)){
                            System.out.println("O quarto está vazio");
                        }else{
                            System.out.println(hotel.getHospede(numQuarto));
                        }
                        break;
                    case 5:
                        System.out.println("Digite o número do quarto que será exibido: ");
                        numQuarto = scan.nextInt();
                        System.out.println(hotel.getQuarto(numQuarto));
                        break;
                    case 6:
                        System.out.println(hotel);
                        break;
                    case 7:
                        System.out.println("Digite o número do quarto do hóspede que você desejar calcular o cachê: ");
                        numQuarto = scan.nextInt();
                        System.out.println("O cache do hóspede selecionado com desconto é: " + hotel.getHospede(numQuarto).getCache());
                        break;
                    case -1:
                        escreveArquivo(hotel);
                        break;
                    default:
                        System.out.println("Opção Invalida");
                        break;
                }
            } catch (NullPointerException e) {
                System.err.println("Erro!! Um valor nulo foi usado ou escolhido, por favor tente novamente");
            } catch (InputMismatchException e){
                System.err.println("Erro!! Um valor de tipo incompativel com o requisitado foi usado, por favor tente novamente");
            } catch (IndexOutOfBoundsException e){
                System.err.println("Erro!! Tentando referenciar a um indice fora do Array ou adicionar mais valores do que se deveria em um Array");
            }
        }
        scan.close();
    }
}   
