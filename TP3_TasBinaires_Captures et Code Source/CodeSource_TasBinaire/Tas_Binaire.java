public class Tas_Binaire {
    public int capacite;
    public int [] Tm;
    public int nombreElements;

    public Tas_Binaire(int capacite){
        this.capacite=capacite;
        Tm = new int [capacite];
        nombreElements =0;
    }
    public void createHeap(int [] arrA){
        if(arrA.length>0){
            for(int i=0;i<arrA.length;i++){
                inserer(arrA[i]);
            }
        }
    }
   
    public void inserer(int x) {
        if(nombreElements==capacite){
            System.out.println("Tas est plein");
        }
        
        int indice = nombreElements;
        Tm[indice] = x;
        nombreElements++;
        Entasser_Haut(indice);
    }

    public void Entasser_Haut(int position) {
        int Indice_Parent = parent(position);
        int Indice = position;
        while (Indice != 0 && Tm[Indice_Parent] >= Tm[Indice]) {

            permuter(Indice,Indice_Parent);
            Indice = Indice_Parent;
            Indice_Parent = parent(Indice_Parent);
        }
    }

    public int extraireMin() {
        int min = Tm[0];
        Tm[0] = Tm[nombreElements-1];
        Tm[nombreElements-1] = 0;
        Entasser_Bas(0);
        nombreElements--;
        return min;
    }

    public int extraireElement(int position){
        int element = Tm[position];
        if(nombreElements !=0){
        Tm[position]=Tm[nombreElements-1];
        Tm[nombreElements-1]=0;
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
        int enfantDroit = enfant_droit(k);
        if((enfantGauche < tasSize()-1) && Tm[petit] > Tm[enfantGauche]){
         petit = enfantGauche;
        }
        if ((enfantDroit < tasSize()-1) && Tm[petit] > Tm[enfantDroit]){
            petit = enfantDroit;
        }
        if(petit != k){
            permuter(k, petit);
            Entasser_Bas(petit);
        }
    }
    

    public void permuter(int a, int b) {
        int temp = Tm[a];
        Tm[a] = Tm[b];
        Tm[b] = temp;
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