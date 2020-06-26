/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcastudentsperformances;

import datapreprocessing.DataPreparation;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import machinelearning.PrincipalComponentAnalysis;
import weka.core.Instances;

/**
 *
 * @author vinicius
 */
public class PCAStudentsPerformances extends JFrame{
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        PCAStudentsPerformances pcastper = new PCAStudentsPerformances();
        
        JFileChooser chooser = new JFileChooser();
        
        File pathToFile = null;
        
        /*chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int returnVal;
        returnVal = chooser.showOpenDialog(pcastper);
        
        if(returnVal != JFileChooser.APPROVE_OPTION) {
            System.out.println("ERROR");
        }else{
            System.out.println("You chose to open this file: " +
                chooser.getSelectedFile().getAbsolutePath());
            pathToFile = new File(chooser.getSelectedFile().getAbsolutePath());
        }*/
        
        //DataPreparation data = new DataPreparation(pathToFile.getAbsolutePath());
        DataPreparation data = new DataPreparation("/home/vinicius/NetBeansProjects/WekaStudentsPerformances/data/portuguese_proc.arff");
        data.loadData();
        
        //System.out.println("Succesfully opened dataset: "+pathToFile.getAbsolutePath());
        System.out.println("Succesfully opened dataset: portuguese_proc.arff");
        
        data.printDatasetInfo();
        
        PrincipalComponentAnalysis pca = new PrincipalComponentAnalysis(data.getTabularData());
        pca.useCovarianceMatrix(true);
        pca.perform();
    }
    
}
