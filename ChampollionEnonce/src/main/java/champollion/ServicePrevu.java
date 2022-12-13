package champollion;

import java.util.ArrayList;

public class ServicePrevu {
	private UE enseignement;
	private Enseignant intervenant;
	private int volumeCM;
	private int volumeTD;
	private int volumeTP;

	public ServicePrevu(UE enseignement, Enseignant intervenant, int volumeCM, int volumeTD, int volumeTP) {
		this.enseignement = enseignement;
		this.intervenant = intervenant;
		this.volumeCM = volumeCM;
		this.volumeTD = volumeTD;
		this.volumeTP = volumeTP;
	}

	public UE getEnseignement() {
		return enseignement;
	}

	public Enseignant getIntervenant() {
		return intervenant;
	}

	public int getVolumeCM() {
		return volumeCM;
	}

	public int getVolumeTD() {
		return volumeTD;
	}

	public int getVolumeTP() {
		return volumeTP;
	}

	public void setEnseignement(UE enseignement) {
		this.enseignement = enseignement;
	}

	public void setIntervenant(Enseignant intervenant) {
		this.intervenant = intervenant;
	}

	public void setVolumeCM(int volumeCM) {
		this.volumeCM = volumeCM;
	}

	public void setVolumeTD(int volumeTD) {
		this.volumeTD = volumeTD;
	}

	public void setVolumeTP(int volumeTP) {
		this.volumeTP = volumeTP;
	}

}
