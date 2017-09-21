package org.centrale.ferret;


public class foundGeneAndRegion {
    
    //Class use for GENE search, containing genes names and LOCUS of these genes in LocationOfFoundGenes
    //an a boolean true if all genes were found
	private String geneNamesFound;
	private inputRegion[] locationOfFoundGenes;
	private Boolean allFound;
	
	foundGeneAndRegion(String geneNamesFound, inputRegion[] locationOfFoundGenes, Boolean allFound){
		this.geneNamesFound = geneNamesFound; 
		this.locationOfFoundGenes = locationOfFoundGenes;
		this.allFound = allFound;
	}
	
	public String getFoundGenes(){
		return this.geneNamesFound;
	}
	
	public inputRegion[] getInputRegionArray(){
		return this.locationOfFoundGenes;
	}
	
	public Boolean getFoundAllGenes(){
		return this.allFound;
	}
	
}
