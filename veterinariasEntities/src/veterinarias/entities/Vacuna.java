package veterinarias.entities;

import veterinarias.generics.GenericEntity;

public class Vacuna extends GenericEntity {
	
	private Mascota mascota;

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

}