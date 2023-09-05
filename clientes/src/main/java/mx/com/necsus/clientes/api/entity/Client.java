package mx.com.necsus.clientes.api.entity;

import java.io.Serializable;
import java.util.Objects;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTS")
@SequenceGenerator(name = "idClient", sequenceName = "sec_clients", allocationSize = 1)
public class Client implements Serializable{

	private static final long serialVersionUID = -4904820806832149610L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idClient")
	private int idClient;
	private String name;
	private String email;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, idClient, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(email, other.email) && idClient == other.idClient && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", email=" + email + "]";
	}


}
