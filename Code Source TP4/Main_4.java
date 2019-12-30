import java.util.*;

public class Main_4 {

  static int[] reverse(int a[]) 
  { 
      
      int i, k, t; 
      int n = a.length;
      for (i = 0; i < n / 2; i++) { 
          t = a[i]; 
          a[i] = a[n - i - 1]; 
          a[n - i - 1] = t; 
      } 
      return a;
    }

public static void main(String args[]){
     final int DEGREE = 2;
    Random r = new Random(11926806);
    int [] arr = new int[1000000];
    int capacite = arr.length;
    BTree b_arbre = new BTree(DEGREE);
    Analyzer time_analysis = new Analyzer();
    Analyzer memory_analysis = new Analyzer();
    long before =0, after=0;
    

   for(int i=0;i<arr.length;i++){
       arr[i]=r.nextInt(100000);
    }

   //Trier la table en ordre croissant
   //Arrays.sort(arr);

   //Trier la table en ordre decroissant
   //arr = reverse(arr);


   for(int i=0;i<arr.length;i++){
    before = System.nanoTime();
    b_arbre.insert(b_arbre, arr[i]);
    after = System.nanoTime();
   // time_analysis.append(after - before);
     }
    
     b_arbre.deleteKey(b_arbre, arr[100]);
     /*
     for(int i=0;i<10000;i++){
        before = System.nanoTime();
        b_arbre.deleteKey(b_arbre, arr[i]);
        after = System.nanoTime();
     }*/

     /*for(int i=1000;i<200000;i++){
        before = System.nanoTime();
        b_arbre.insert(b_arbre,i);
        after = System.nanoTime();
     }*/
     /*for(int i=1000;i<200000;i++){
        before = System.nanoTime();
        b_arbre.deleteKey(b_arbre,arr[i]);
        after = System.nanoTime();
     }*/

    
  /* for(int i=1;i<100000;i++){
    
     if(r.nextDouble() > 0.5){
      before = System.nanoTime();
      b_arbre.insert(b_arbre, arr[i]);
      after = System.nanoTime();

     }else{
      before = System.nanoTime();
      b_arbre.deleteKey(b_arbre, arr[i]);
      after = System.nanoTime();
     }
     time_analysis.append(after - before);}
   // memory_analysis.append( ((1000000-DEGREE)*(Math.log(1000000-DEGREE)))*DEGREE-i );}
    //System.out.println(arr[i]);
   /* before = System.nanoTime();
    t_b.inserer(arr[i]);
    after = System.nanoTime();
*/

//time_analysis.append(after - before);
//memory_analysis.append( t_b.capacite - t_b.nombreElements );

       // Enregistrement du temps pris par l'opération
       //time_analysis.append(after - before);
       // Enregistrement du nombre de copies efféctuées par l'opération.
      //}
 /*  int random_indice;

   for(int i=0;i<100000;i++){
       random_indice = r.nextInt(10000);
       before = System.nanoTime();
      
       after = System.nanoTime();

       time_analysis.append(after - before);
       memory_analysis.append( t_b.capacite - t_b.nombreElements );
 
   }*/




  



  
   

    
    
    
    System.err.println("Total cost : "+time_analysis.get_total_cost());
    System.err.println("Average cost : "+time_analysis.get_average_cost());
    System.err.println("Variance : "+time_analysis.get_variance());
    System.err.println("Standard deviation : "+time_analysis.get_standard_deviation());

    time_analysis.save_values("Plots_TP4/B_Arbre_Temps_Amorti_AjoutSuppression_aleatoire_Degree=2.plot");
    //memory_analysis.save_values("Plots_TP4/B_Arbre_Memoire_AjoutSuppression_aleatoire_Degree=2.plot");
}
}