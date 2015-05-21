package org.bbn.sbd.scoring;

import java.util.List;

public class PRF {

	@SuppressWarnings("unused")
	public static void score(List<Double> hyp, List<Double> truelabels) 
	{
		if(hyp.size() != truelabels.size())
		{
			System.out.println("Please ensure that true labels and hypothesis lists are of equal size.");
			System.exit(1);
		}
		
		double precision = 0.0;
		double recall = 0.0;
		double fscore = 0.0;
		
		double tp=0, fp=0, tn=0, fn=0;
		
		for(int i=0; i< hyp.size(); i++)
		{
			System.out.println("hyp: " + hyp.get(i) + " true: " + truelabels.get(i));
			
			if(hyp.get(i).compareTo(truelabels.get(i)) == 0)
			{
				
				if(hyp.get(i) > 0)
				{
					tp++;
					System.out.println("incrementing tp");
				}
					
				else tn++;
			}
			else
			{
				if(hyp.get(i) > 0)
					fp++;
				else fn++;
			}
		}
		
		if(tp+fp != 0)
		{
			precision = tp/(tp+fp);
			System.out.println("Precision is: " + precision);
		}	
		else System.out.println("Precision is NaN");
		
		if(tp+fn != 0)
		{
			recall = tp/(tp+fn);
			System.out.println("Recall is: " + recall);
		}
		else System.out.println("Recall is NaN");
		
		if(precision+recall != 0)
		{
			fscore = 2*precision*recall/(precision+recall);
			System.out.println("F-measure is: " + fscore);
		}	
		else System.out.println("F-measure is NaN");
	}

}
