
class TasBinomial{
    public NoeudBinomial Noeuds;
    public int size;
    public TasBinomial()
    {
        Noeuds = null;
        size = 0;
    }

    public boolean estVide()    {
        return Noeuds == null;
    }
    
    public int getSize(){
        return size;
    }
    
    public void rendreVide(){
        Noeuds = null;
        size = 0;
    }
       
    public void inserer(int value) {
        if (value > 0)   {
            NoeudBinomial temp = new NoeudBinomial(value);
            if (Noeuds == null)   {
                Noeuds = temp;
                size = 1;
            } 
            else 
            {   unionNoeuds(temp);
                size++;
            }  }
    }
    
    
    public void fusion(NoeudBinomial binTas)  {
        NoeudBinomial temp1 = Noeuds, temp2 = binTas;
 
        while ((temp1 != null) && (temp2 != null)) 
        {
            if (temp1.degre == temp2.degre) {
                NoeudBinomial tmp = temp2;
                temp2 = temp2.voisin;
                tmp.voisin = temp1.voisin;
                temp1.voisin = tmp;
                temp1 = tmp.voisin;
            } 
            else 
            {
                if (temp1.degre < temp2.degre) {
                    if ((temp1.voisin == null) || (temp1.voisin.degre > temp2.voisin)) 
                    {
                        NoeudBinomial tmp = temp2;
                        temp2 = temp2.voisin;
                        tmp.voisin = temp1.voisin;
                        temp1.voisin = tmp;
                        temp1 = tmp.voisin;
                    }
                    else {
                        temp1 = temp1.voisin;
                    }
                }
                else {
                    NoeudBinomial tmp = temp1;
                    temp1 = temp2;
                    temp2 = temp2.voisin;
                    temp1.voisin = tmp;
                    if (tmp == Noeuds) 
                    {
                        Noeuds = temp1;
                    }
                    else 
                    {
 
                    }
                }
            }
        }
        if (temp1 == null)  {
            temp1 = Noeuds;
            while (temp1.voisin != null)  {
                temp1 = temp1.voisin;
            }
            temp1.voisin = temp2;
        }  else
        {   }
    }
    
    public void unionNoeuds(NoeudBinomial binTas) 
    {
        fusion(binTas);
 
        NoeudBinomial precTemp = null, temp = Noeuds, suivTemp = Noeuds.voisin;

        while (suivTemp != null) {
            if ((temp.degre != suivTemp.degre) || ((suivTemp.voisin != null) && (suivTemp.voisin.degre == temp.degre))) 
            {                
                precTemp = temp;
                temp = suivTemp;
            } 
            else
            {
                if (temp.cle <= suivTemp.cle) {
                    temp.voisin = suivTemp.voisin;
                    suivTemp.parent = temp;
                    suivTemp.voisin = temp.enfant;
                    temp.enfant = suivTemp;
                    temp.degre++;
                } 
                else  {
                    if (precTemp == null) {
                        Noeuds = suivTemp;
                    }
                    else {
                        precTemp.voisin = suivTemp;
                    }
                    temp.parent = suivTemp;
                    temp.voisin = suivTemp.parent;
                    suivTemp.enfant = temp;
                    suivTemp.degre++;
                    temp = suivTemp;
                }
            }
            suivTemp = temp.voisin;
        }
    }
    
    public int TrouverMin() 
    {
        return Noeuds.TrouverMin().cle;
    }
   
    
    public int extraireMin() 
    {
        if (Noeuds == null)
            return -1;
 
        NoeudBinomial temp = Noeuds, prevTemp = null;
        NoeudBinomial minNoeud = Noeuds.TrouverMin();
 
        while (temp.cle != minNoeud.cle) {
            prevTemp = temp;
            temp = temp.voisin;
        }
 
        if (prevTemp == null) 
        {
            Noeuds = temp.voisin;
        }
        else
        {
            prevTemp.voisin = temp.voisin;
        }
 
        temp = temp.enfant;
        NoeudBinomial fakeNoeud = temp;
 
        while (temp != null) 
        {
            temp.parent = null;
            temp = temp.voisin;
        }
 
        if ((Noeuds == null) && (fakeNoeud == null)) {
            size = 0;
        } 
        else
        {
            if ((Noeuds == null) && (fakeNoeud != null)) 
            {
                Noeuds = fakeNoeud.reverse(null);
                size = Noeuds.getSize();
            }
            else
            {
                if ((Noeuds != null) && (fakeNoeud == null))
                {
                    size = Noeuds.getSize();
                }
                else
                {
                    unionNoeuds(fakeNoeud.reverse(null));
                    size = Noeuds.getSize();
                }
            }    }
        return minNoeud.cle;
    }   
}    
 
 
