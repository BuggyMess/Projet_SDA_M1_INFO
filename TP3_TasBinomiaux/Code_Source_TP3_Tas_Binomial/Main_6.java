import java.util.*;

public class Main_6 {

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
  
    Random r = new Random(11926806);
    int [] arr = new int[1000000];
    
    BinomialHeap t_bino1 = new BinomialHeap();
    BinomialHeap t_bino2 = new BinomialHeap();
    BinomialHeap t_bino3 = new BinomialHeap();
    BinomialHeap t_bino4 = new BinomialHeap();
    Analyzer time_analysis = new Analyzer();
    Analyzer memory_analysis = new Analyzer();
    long before =0, after=0;
    

   for(int i=0;i<arr.length;i++){
       arr[i]=r.nextInt(100000);
    }

   //Trier la table en ordre croissant
   Arrays.sort(arr);

   //Trier la table en ordre decroissant
   arr = reverse(arr);

   //Ajout seulement
   for(int i=0;i<arr.length;i++){
    before = System.nanoTime();
    t_bino.insert(arr[i]);
    after = System.nanoTime(); 
    time_analysis.append(after - before);
     }

     //Ajout et Suppression
     for(int j=0;j<arr.length;j++){
        if(r.nextDouble() > 0.5){
        before = System.nanoTime();
        t_bino1.insert(arr[j]);
        after = System.nanoTime();
       }else{
        before = System.nanoTime();
        t_bino1.extractMin();
        after = System.nanoTime();
       }

    //Ajout suppression et fusion
    for (int i=0;i<4;i++){

   if(i<2){
   for(int j=0;j<arr.length/2;j++){
      if(r.nextDouble() > 0.5){
      before = System.nanoTime();
      t_bino1.insert(arr[j]);
      after = System.nanoTime();
     }else{
      before = System.nanoTime();
      t_bino1.extractMin();
      after = System.nanoTime();
     }
     time_analysis.append(after - before);
     
    }
    for(int l=0;l<arr.length/2;l++){
        if(r.nextDouble() > 0.5){
        before = System.nanoTime();
        t_bino2.insert(arr[l]);
        after = System.nanoTime();
       }else{
        before = System.nanoTime();
        t_bino2.extractMin();
        after = System.nanoTime();
       }
       time_analysis.append(after - before);
      }
     }else{
        before = System.nanoTime();
        t_bino2.merge(t_bino1.Nodes);
        after = System.nanoTime();
        time_analysis.append(after - before);
      }



    }
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
  /* int random_indice;

   for(int i=0;i<100000;i++){
       random_indice = r.nextInt(10000);
       before = System.nanoTime();
       t_b.extraireElement(random_indice);
       after = System.nanoTime();

       time_analysis.append(after - before);
       memory_analysis.append( t_b.capacite - t_b.nombreElements );
 
   }*/




  



  
   

    
    
    
    System.err.println("Total cost : "+time_analysis.get_total_cost());
    System.err.println("Average cost : "+time_analysis.get_average_cost());
    System.err.println("Variance : "+time_analysis.get_variance());
    System.err.println("Standard deviation : "+time_analysis.get_standard_deviation());

    time_analysis.save_values("Plots_TP3_TasBinomial/Tas_Binomial_Temps_Ajout_Suppression.plot");
    //memory_analysis.save_values("Plots_TP3/Tas_Binaire_memory_analysis_extraire.plot");
}
}