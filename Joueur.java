import java.util.ArrayList;
/* 
 * Travail en trinome 
 * Ezeeddine Habiboullah 11709483	
 * Katia CHAIBI 11608816
 * Korka Diallo 11609328
*/

public class Joueur{
	private String nom;
	private double poidsmax;
	private ArrayList<ObjetZork> sac = new ArrayList<ObjetZork>();
	

		
	/**
	 * le joueur est definie par son nom et son poid 
	 * et la list d objet qui va transporter 
	 * 
	 */

	public Joueur(String nom, int poidsmax, ArrayList<ObjetZork> sac){
		this.nom = nom;
		this.poidsmax = poidsmax;
		this.sac = sac; 
	}
		
	/**
	 * permet de renvoi le nom du joueur  
	 * @return String 
	 */

	public String getNom(){
		return nom;
	}
	public void ajouterUnObjetSac(ObjetZork o){
			sac.add(o);
	}
		
	/**
	 * changer le poid du joueur  
	 * @param Double p
	 */

	public void setPoidsMax(double p) {
		poidsmax = p;
	}



	/**
	 * permet de savoir si le poid max du joueur 
	 * @return Double 
	 */


	public double getPoidsmax(){
		return poidsmax;
	}

	
	/**
	 * permet de renvoi un list d objet transporter par le joueur 
	 * @return ArrayList 
	 */


	public ArrayList<ObjetZork> getSac(){
		return sac;		
	}

		
	/**
	 * permet de renvoi un list d objet transporter par le joueur 
	 * @return Double 
	 */

	public double getPoidsTotaleSac(){	
		if(sac.size() == 0){
			return 0;
		}
		else {
		double poid_total = 0;
		for(int i=0;i< sac.size();i++){		
				poid_total+=sac.get(i).getPoids(); 
		}
		return poid_total;
		}
	}

	/*
	* permet de savoir si le joueur peut Transporter des objets ou non 
	* @return false ou true
	*
	*/

	public boolean peuTransporter(){
		if(getPoidsTotaleSac() < poidsmax){
			return true;
		}
		else 
		return false;
	}

	public void afficherSac(){	
		if(sac == null ){
			System.out.println("le sac est vide");
		}
		else{
		for(int i=0 ; i< sac.size();i++){
			System.out.println(sac.get(i).getDescription());
		}
	}
	}
}
