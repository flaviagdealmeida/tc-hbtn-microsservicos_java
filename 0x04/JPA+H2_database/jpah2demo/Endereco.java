import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="enderecos")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "endereco_tipo", nullable = true)
	private String logradouro;
	
	@Column(name = "endereco_logradouro", nullable = true)
	private String endereco;
	
	@Column(name = "endereco_numero", nullable = true)
	private String numero;
	
	@Column(name = "endereco_bairro", nullable = true)
	private String bairro;
	
	@Column(name = "endereco_cidade", nullable = true)
	private String cidade;
	
	@Column(name = "endereco_estado", nullable = true)
	private String estado;
	
	
	@ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;
	
	
	public Endereco(String logradouro, String endereco, String numero, String bairro, String cidade, String estado) {
		super();
		this.logradouro = logradouro;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndeereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, endereco, estado, id, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}
	
	
	

}
