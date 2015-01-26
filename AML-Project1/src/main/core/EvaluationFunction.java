package core;

import org.apache.mahout.math.*;

public class EvaluationFunction {
public Double evaluate(Vector predictions, Vector truevalue)
{
	int N=predictions.size();
	double rtn=0.0;
	for(Vector.Element p:predictions.all())
	{
		int item=p.index();
		double actual=truevalue.get(item);
		double pred=p.get();
		if(pred==0.0 || pred==1.0)
		{
			return null;
		}
		rtn+=Math.log(pred)*actual+(1-actual)*Math.log(1-pred);
	}
	return -rtn/N;
}
}
