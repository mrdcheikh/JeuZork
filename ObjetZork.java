public class ObjetZork{
	    private String description;
	    private Piece Piece;
	    private double poids;
	    private boolean transportable;
   

	public ObjetZork(String description, double  poids, boolean transportable){
		this.description = description;
		this.poids = poids;
		this.transportable = transportable;
	}

		public ObjetZork(){
		
	}

	public String estTransportable(){
	    	String detail = this.description + "(";
		if(transportable){
			detail += this.poids + "kgs";}
		else{
			detail += "non transportable";
		}
		return detail;
	}

	public String getDescription(){
	    	return this.description;
	}

	public double getPoids(){
	    	return this.poids=poids;
	}

	/**
	 *  Renvoie la description de cette piece (i.e. la description spécifiée lors
	 *  de la création de cette instance).
	 *
	 * @return   resulat boolean 
	 */

	public boolean equals(Object o) {
		boolean res = false ;
		ObjetZork oz = (ObjetZork) o;
		if(this.getDescription().equals(oz.getDescription()) &&  this.getPoids()==oz.getPoids() &&                 this.estTransportable()==oz.estTransportable()){
			res = true;
		}
		return res;
	}
}
