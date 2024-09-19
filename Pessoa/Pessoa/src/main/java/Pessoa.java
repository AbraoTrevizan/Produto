import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Pessoa {
    private String nomeCompleto;
    private double altura;
    private LocalDate dataNascimento;
    private String email;

    // Fazendo a classe Pessoa
    public Pessoa(String nomeCompleto, double altura, String dataNascimento) {
        this.nomeCompleto = nomeCompleto; // nomeCompleto
        this.altura = altura; // altura
        setDataNascimento(dataNascimento); //nascimento
        this.email = criarEmail(nomeCompleto); // Faz o email com nome completo
    }

    // Define a data de nascimento
    private void setDataNascimento(String dataNascimento) {
        try {
            // dd/MM/yyyy vai converter para isso
            LocalDate data = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            // Ve a data de nascimento se esta correta
            if (data.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("A data de nascimento não pode ser posterior à data atual.");
            }
            this.dataNascimento = data; 
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use dd/MM/yyyy.");
        }
    }

    // Cria o email com nome.sobrenome@dominio.com
    private String criarEmail(String nomeCompleto) {
        String[] partes = nomeCompleto.split(" "); // Divide o nome completo 
        String nome = partes[0].toLowerCase(); //  O primeiro nome e colocado em minusculo
        String sobrenome = partes[partes.length - 1].toLowerCase(); // O sobrenome e colocado em minusculo
        return nome + "." + sobrenome + "@dominio.com"; // Mostra o email criado
    }

   // Carrega as informações dadas
    public void exibirInformacoes() {
        System.out.printf("Nome Completo: %s\nAltura: %.2f\nData de Nascimento: %s\nEmail: %s\n\n",
                          this.nomeCompleto, this.altura, this.dataNascimento, this.email);
    }

    // Informações com a data de nascimento, nome e altura
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Abrao Trevizan", 1.85, "12/05/2005");
        Pessoa pessoa2 = new Pessoa("Tatiana Trevizan", 1.70, "31/11/1985");

        // Mostra as informações a cima para o usuario
        pessoa1.exibirInformacoes();
        pessoa2.exibirInformacoes();
    }
}
