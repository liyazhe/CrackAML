package core;

import java.io.*;
import java.util.*;

import org.apache.mahout.math.*;
import org.apache.mahout.math.Vector;
//import org.joda.time.DateTime;

//import util.DateTimeUtil;

public class Perceptron {
	public Vector weight;
	public int trainingMistake;
	public int testMistake;
	public double objectiveValue;
	private Features features;
	
	public Perceptron(String path)
	{
		this.features=new Features(path);
		this.weight=new DenseVector(features.size);
		this.trainingMistake=Integer.MAX_VALUE-1;
		this.testMistake=Integer.MAX_VALUE-1;
		this.objectiveValue=0.0;
	}
	public void increment(String[] dataItem,Features features)
	{
		double stepSize=0.2;
		int c=Integer.valueOf(dataItem[1]);
		long tStart=System.currentTimeMillis();
		RandomAccessSparseVector f1=features.getFeautreMap(dataItem,0);
		long tIter1=System.currentTimeMillis();
		RandomAccessSparseVector f2=features.getFeautreMap(dataItem,1);
		long tIter2=System.currentTimeMillis();
		double score1=f1.dot(this.weight);
		long tIter3=System.currentTimeMillis();
		double score2=f2.dot(this.weight);
		long tIter4=System.currentTimeMillis();
		if(score1>=score2 && c==1)
		{	
			this.weight = this.weight.plus(f2.plus(f1.times(-1.0)).times(stepSize));
			this.trainingMistake+=1;
		}
		else if(score1<score2 && c==0)
		{
			this.weight = this.weight.plus(f1.plus(f2.times(-1.0)).times(stepSize));
			this.trainingMistake+=1;
		}
		long tIter5=System.currentTimeMillis();
		double t1=(tIter1-tStart)/1000.0;
		double t2=(tIter2-tIter1)/1000.0;
		double t3=(tIter3-tIter2)/1000.0;
		double t4=(tIter4-tIter3)/1000.0;
		double t5=(tIter5-tIter4)/1000.0;
		//System.out.println(t1);
		//System.out.println(t2);
		//System.out.println(t3);
		//System.out.println(t4);
		//System.out.println(t5);
	}
	
	public void train(List<String> rawData)
	{

		Integer prevMistake=Integer.MAX_VALUE;
		int i=1;
		while(prevMistake>this.trainingMistake)
		{
			int j=0;
			System.out.printf("epoch %d \n", i);
			long tStart=System.currentTimeMillis();
			prevMistake=this.trainingMistake;
			this.trainingMistake=0;
			for(String d:rawData)
			{
				String[] dataItem=d.split(",");
				increment(dataItem,features);
				j++;
			}
			long tEnd=System.currentTimeMillis();
			System.out.println("time taken:"+(tEnd-tStart)/1000.0);
			System.out.printf("training mistake %d \n", trainingMistake);
			i++;
		}
	}
	public Vector[] predict(List<String> rawData,EvaluationFunction func)
	{
		int i=0;
		this.testMistake=0;
		Vector result=new RandomAccessSparseVector(rawData.size());
		Vector label=new RandomAccessSparseVector(rawData.size());
		Vector truevalue=new RandomAccessSparseVector(rawData.size());
		try{
			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("//Users//Yazhe//Documents//UCL-MachineLearning//COMPGI09-AppliedMachineLearning//Projects//Project1-ClickPrediction//Testing//prediction.csv")));

			for(String d:rawData)
			{
				String[] dataItem=d.split(",");
				int c=Integer.valueOf(dataItem[1]);
				truevalue.set(i,c);
				//DateTime t=DateTimeUtil.parseStringToDateTime(dataItem[2]);
				RandomAccessSparseVector f1=features.getFeautreMap(dataItem,0);
				RandomAccessSparseVector f2=features.getFeautreMap(dataItem,1);
				
				double score1=f1.dot(this.weight);
				double score2=f2.dot(this.weight);
				
				double positive=Math.exp(score2);
				double prob=positive/(Math.exp(score1)+positive);
				result.set(i, prob);
				double l=0.0;
				if(prob>0.5)
				{
					l=1.0;
					label.set(i,l);
				}
				if(c!=l)
					this.testMistake+=1.0;
				i++;
				pw.println(d+","+prob+","+l);
			}
			pw.close();
		}
		catch(Exception e)
		{
			System.out.println("no such file");
		}
		this.objectiveValue=func.evaluate(result,truevalue);
				
		return new Vector[]{result,label};
	}
	public static void main(String[] args)
	{
		ProjectIO pr=new ProjectIO();
		List<String> rawData=pr.importDataFromFile(args[0]);
		Perceptron myperceptron=new Perceptron(args[1]);
		int n=rawData.size();
		List<String> training=rawData.subList(0,(int)Math.floor(n*0.9));
		System.out.printf("training data size = %d \n",training.size());
		List<String> validation=rawData.subList((int)Math.floor(n*0.9)+1,n-1);
		EvaluationFunction func=new EvaluationFunction();
		myperceptron.train(training);
		Vector[] predictions=myperceptron.predict(validation, func);
		try{
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(args[1]+"//weight.csv")));
		pw.println(myperceptron.weight.toString().replace(",", "\n").replace(":",","));
		pw.close();
		}
		catch(Exception e)
		{
			System.out.println("No such file");
		}
		System.out.printf("test data size = %d \n",validation.size());
		System.out.printf("test mistakes = %d \n",myperceptron.testMistake);
		System.out.printf("loss function value = %f \n",myperceptron.objectiveValue);
	}
}
