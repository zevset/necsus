package mx.com.necsus.clientes.api;

import java.io.Serializable;

public class ResponseClient implements Serializable{
	
	private static final long serialVersionUID = -7427492457465938170L;
	private String id;
	private boolean sucess;

	public ResponseClient() {
		super();
	}

	
	public ResponseClient(String id, boolean sucess) {
		super();
		this.id = id;
		this.sucess = sucess;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSucess() {
		return sucess;
	}
	
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	@Override
	public String toString() {
		return "ResponseCreate [id=" + id + ", sucess=" + sucess + "]";
	}

}
