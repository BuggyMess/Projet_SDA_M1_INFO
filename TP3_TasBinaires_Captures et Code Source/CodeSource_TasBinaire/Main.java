import java.util.*;

public class Main {

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
    int capacite = arr.length;
    Tas_Binaire t_b = new Tas_Binaire(capacite);
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
      t_b.inserer(arr[i]);
     }
   /*for(int i=0;i<arr.length;i++){
    t_b.inserer(arr[i]);
     if(r.nextDouble() > 0.5){
      before = System.nanoTime();
      t_b.inserer(arr[i]);
      after = System.nanoTime();

     }else{
      before = System.nanoTime();
      t_b.extraireElement(r.nextInt(1000));
      after = System.nanoTime();
     }*/
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
   int random_indice;

   for(int i=0;i<100000;i++){
       random_indice = r.nextInt(10000);
       before = System.nanoTime();
       t_b.extraireElement(random_indice);
       after = System.nanoTime();

       time_analysis.append(after - before);
       memory_analysis.append( t_b.capacite - t_b.nombreElements );
 
   }




  



  
   

    
    
    
    System.err.println("Total cost : "+time_analysis.get_total_cost());
    System.err.println("Average cost : "+time_analysis.get_average_cost());
    System.err.println("Variance : "+time_analysis.get_variance());
    System.err.println("Standard deviation : "+time_analysis.get_standard_deviation());

    time_analysis.save_values("Plots_TP3/Tas_Binaire_time_analysis_extraire.plot");
    memory_analysis.save_values("Plots_TP3/Tas_Binaire_memory_analysis_extraire.plot");
}
}