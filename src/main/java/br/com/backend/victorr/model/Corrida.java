package br.com.backend.victorr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Corrida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Passageiro passageiro;
	@ManyToOne(fetch = FetchType.LAZY)
	private Motorista motorista;
	private Double valorCorrida;
	
	
	
	public Corrida(Integer id, Passageiro passageiro, Motorista motorista, Double valorCorrida) {
		
		this.id = id;
		this.passageiro = passageiro;
		this.motorista = motorista;
		this.valorCorrida = valorCorrida;
	}
	public Corrida() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Double getValorCorrida() {
		return valorCorrida;
	}
	public void setValorCorrida(Double valorCorrida) {
		this.valorCorrida = valorCorrida;
	}
	


}
