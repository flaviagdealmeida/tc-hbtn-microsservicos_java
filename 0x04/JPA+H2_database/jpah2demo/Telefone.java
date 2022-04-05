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

import org.apache.catalina.authenticator.SpnegoAuthenticator.AcceptAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="telefones")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "ddd")
	private String ddd;
	
	@Column(name = "numero")
	private String numero;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
     private Cliente cliente;
	
	public Telefone(String ddd, String numero) {
		
		if(ddd == null || numero == null) {
			throw new IllegalArgumentException("Telefone invalido");
		}
		
		if (!ddd.matches("\\d{2}")) {
	        throw new IllegalArgumentException("DDD invalido!");
	    }

		 if (!numero.matches("\\d{8}|\\d{9}")) {
		        throw new IllegalArgumentException("Numero invalido!");
		    }
		this.ddd = ddd;
		this.numero = numero;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDdd() {
		return ddd;
	}


	public void setDdd(String ddd) {
		this.ddd = ddd;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ddd, id, numero);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}
	
	
	
	
}
