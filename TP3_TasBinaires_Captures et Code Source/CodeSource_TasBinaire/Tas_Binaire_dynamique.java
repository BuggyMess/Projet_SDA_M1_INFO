import java.util.*;

public class Tas_Binaire_dynamique {
    
    ArrayList<Integer> arrli ;
    public int nombreElements;

    public Tas_Binaire_dynamique(){
        
        arrli  = new ArrayList<Integer>();
        nombreElements =0;
    }
    
    public void display(){
        for(int i=0;i<arrli.size();i++){
            System.out.print(" " + arrli.get(i));
        }
        System.out.println("");
    }
    public void inserer(int x) {
             
        int indice = nombreElements;
        arrli.add(indice, x);
        nombreElements++;
        Entasser_Haut(indice);
    }

    public void Entasser_Haut(int position) {
        int Indice_Parent = parent(position);
        int Indice = position;
        while (Indice != 0 && arrli.get(Indice_Parent) >= arrli.get(Indice)) {
            permuter(Indice,Indice_Parent);
            Indice = Indice_Parent;
            Indice_Parent = parent(Indice_Parent);
        }
    }

    public int extraireMin() {
        int min = arrli.get(0);
        arrli.set(0, arrli.get(nombreElements-1));
        arrli.set(nombreElements-1,0);
        Entasser_Bas(0);
        nombreElements--;
        return min;
    }

    public int extraireElement(int position){
        int element = arrli.get(position);
        if(nombreElements !=0){
        arrli.set(position, arrli.get(nombreElements-1));
        arrli.set(nombreElements-1,0);
        Entasser_Bas(position);
        nombreElements--;
        return element;
        }
        System.out.println("Tas vide");
        return -1;
    }

    public void Entasser_Bas(int k) {
        int petit = k;
        int enfantGauche = enfant_gauche(k);
        int enfantDroit  = enfant_droit(k);
        if( (enfantGauche < tasSize()-1)&&(arrli.get(petit) > arrli.get(enfantGauche))){
         petit = enfantGauche;
        }
        if ((enfantGauche < tasSize()-1)&&(arrli.get(petit)> arrli.get(enfantDroit))){
            petit = enfantDroit;
        }
        if(petit != k){
            permuter(k, petit);
            Entasser_Bas(petit);
        }
    }
    

    public void permuter(int a, int b) {
        int temp = arrli.get(a);
        arrli.set(a, arrli.get(b));
        arrli.set(b,temp);
    }
    public boolean estVide() {
        return nombreElements == 0;
    }

    public int tasSize(){
        return nombreElements;
    }

    public int enfant_gauche(int i) {
		return (2*i+1);
		
	}
	public int enfant_droit(int i) {
		
		return(2*i+2);
	}
	public int parent(int i) {
		return (i/2);
	}

    
}