
public class BotStrategy {

	public static double companyBotStrategy(int[][] trainingData) {

	    int correct=0;
	    int correctCount=0;
	    
	    int didNotAnswer=0;
	    int didNotAnswerCount=0;
	    
	    int incorrect=0;
	    int incorrectCount=0;
	    
	    for(int i=0;i<trainingData.length;i++){
	        
	        if(trainingData[i][1] == 1){
	            correct = correct + trainingData[i][0];
	            correctCount++;
	        }else if(trainingData[i][1] == 0){
	            didNotAnswer = didNotAnswer + trainingData[i][0];
	            didNotAnswerCount++;
	        }else if(trainingData[i][1] == -1){
	            incorrect = incorrect + trainingData[i][0];
	            incorrectCount++;
	        }
	    }
	    
	    double average = 0.0;
	    
	    if(correct>0)
	        average = (double)correct/(double)correctCount;
	    
	    return average;
	        
	}
	
	public static void main(String[] args){
		int [][] trainingData = {{4,1}, 
		               {4,-1}, 
		               {0,0}, 
		               {6,1} };
		
		System.out.println(companyBotStrategy(trainingData));
	
	}

	
}
