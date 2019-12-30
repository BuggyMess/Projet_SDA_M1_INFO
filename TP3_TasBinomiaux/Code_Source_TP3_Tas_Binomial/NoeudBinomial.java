class NoeudBinomial{
    int cle, degre;
    NoeudBinomial parent;
    NoeudBinomial voisin;
    NoeudBinomial enfant;
 
    
    public NoeudBinomial(int k) {
        cle = k;
        degre = 0;
        parent = null;
        voisin = null;
        enfant = null;        
    }

    public NoeudBinomial reverse(NoeudBinomial sibl) {
            NoeudBinomial ret;
            if (voisin != null)
                ret = voisin.reverse(this);
            else
                ret = this;
            voisin = sibl;
            return ret;
    }
    

    public NoeudBinomial findMinNode() {
            NoeudBinomial x = this, y = this;
            int min = x.cle;
 
            while (x != null) {
                if (x.cle < min) {
                    y = x;
                    min = x.cle; }
                x = x.voisin;   }
             return y;
    }
    
    
    public int getSize(){
        return (1 + ((enfant == null) ? 0 : enfant.getSize()) + ((voisin == null) ? 0 : voisin.getSize()));
    }
}
 