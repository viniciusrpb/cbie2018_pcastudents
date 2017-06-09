/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expectationmaximization;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

/**
 *
 * @author vinicius
 */
public class ExpectationMaximization {

    public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}
    
    public ExpectationMaximization(int numberOfClusters) throws Exception{
        
        EM expmax = new EM();

        // This is the important parameter to set
        //expmax.setPreserveInstancesOrder(true);
        
        
        expmax.setNumClusters(numberOfClusters);
        
        BufferedReader datafile = readDataFile("students-performance-all-nominal.arff"); 
        Instances data;
        data = new Instances(datafile);

        // setting class attribute
        //data.setClassIndex(data.numAttributes() - 1);
        
 	expmax.buildClusterer(data);
        
        ClusterEvaluation eval = new ClusterEvaluation();
        eval.setClusterer(expmax);                                   // the cluster to evaluate
        eval.evaluateClusterer(data);                                // data to evaluate the clusterer on
        System.out.println("Numero de clusters: " + eval.getNumClusters());  // output # of clusters
        System.out.println("Complete report\n\n");
        System.out.println(eval.clusterResultsToString());
        

        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        //int[] assignments = expmax.clusterInstance(null);

        for(int i = 0; i < data.numInstances();i++) {
            System.out.printf("Instance %d -> Cluster %d\n", i, expmax.clusterInstance(data.instance(i)));
            i++;
        }
        
        
    }
        /**
        * @param args the command line arguments
        */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // numero de clusters eh igual a 3
        // mudar aqui!!!
        ExpectationMaximization em = new ExpectationMaximization(5);
        
    }
}
