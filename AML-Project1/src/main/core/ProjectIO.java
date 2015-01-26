package core;

import java.util.*;
import java.io.*;

import org.apache.commons.lang3.*;
import org.joda.time.DateTime;

import util.DateTimeUtil;

public class ProjectIO {
public List<String> importDataFromFile(String n)
{
	File fileName=new File(n);
	ArrayList<String> rawData=new ArrayList<String>();
	try{
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		String s;
		long tStart=System.currentTimeMillis();
		while((s=br.readLine())!=null)
		{
			rawData.add(s);
		}
		long tEnd=System.currentTimeMillis();
		double tDur=(tEnd-tStart)/1000.0;
		br.close();
		System.out.println("Time used:"+tDur);
	}
	catch(Exception e)
	{
		System.out.println("File not exist");
	}
	return rawData;
}
public static void getUniqueColumns(String filename)
{
	Set<String> deviceM=new TreeSet<String>();
	Set<String> deviceT=new TreeSet<String>();
	Set<String> connect=new TreeSet<String>();
	Set<String> C14=new TreeSet<String>();
	Set<String> C15=new TreeSet<String>();
	Set<String> C16=new TreeSet<String>();
	Set<String> C17=new TreeSet<String>();
	Set<String> C18=new TreeSet<String>();
	Set<String> C19=new TreeSet<String>();
	Set<String> C20=new TreeSet<String>();
	Set<String> C21=new TreeSet<String>();
	try{
		BufferedReader br=new BufferedReader(new FileReader(new File(filename)));
		String s;
		System.out.println("Begin reading...");
		int i=0;
		while((s=br.readLine())!=null)
		{
			String[] dataItem=s.split(",");
			//deviceM.add(dataItem[13]); //device model
			//deviceT.add(dataItem[14]); //device type
			connect.add(dataItem[15]); //connection type
			C14.add(dataItem[16]); //anonymous c14
			C15.add(dataItem[17]); //anonymous c15
			C16.add(dataItem[18]); //anonymous c16
			C17.add(dataItem[19]); //anonymous c17
			C18.add(dataItem[20]); //anonymous c18
			C19.add(dataItem[21]); //anonymous c19
			C20.add(dataItem[22]); //anonymous c20
			C21.add(dataItem[23]);
			if(i%1000000==0)
			{
				System.out.println(i+" items finished.");
			}
			i++;
		}
		br.close();
	}
	catch(Exception e)
	{
		System.out.println("notnh");
	}
	String fname="//Users//Yazhe//Documents//UCL-MachineLearning//COMPGI09-AppliedMachineLearning//Projects//Project1-ClickPrediction//Testing";
	try{
		System.out.println("Begin writing...");
//		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//16.csv")));
//		pw.print(StringUtils.join(deviceT,","));
//		pw.close();
		PrintWriter pw1=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//17.csv")));
		pw1.print(StringUtils.join(connect,"\n"));
		pw1.close();
		PrintWriter pw2=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//18.csv")));
		pw2.print(StringUtils.join(C14,"\n"));
		pw2.close();
		PrintWriter pw3=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//19.csv")));
		pw3.print(StringUtils.join(C15,"\n"));
		pw3.close();
		PrintWriter pw4=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//20.csv")));
		pw4.print(StringUtils.join(C16,"\n"));
		pw4.close();
		PrintWriter pw5=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//21.csv")));
		pw5.print(StringUtils.join(C17,"\n"));
		pw5.close();
		PrintWriter pw6=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//22.csv")));
		pw6.print(StringUtils.join(C18,"\n"));
		pw6.close();
		PrintWriter pw7=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//23.csv")));
		pw7.print(StringUtils.join(C19,"\n"));
		pw7.close();
		PrintWriter pw8=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//24.csv")));
		pw8.print(StringUtils.join(C20,"\n"));
		pw8.close();
		PrintWriter pw9=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//25.csv")));
		pw9.print(StringUtils.join(C21,"\n"));
		pw9.close();
	}
	catch(Exception e)
	{
		System.out.println("here");
		}
}
public static void getFirstOrderTypeCount(String filename)
{
	List<HashMap<String,Integer>> fileInfo=new ArrayList<HashMap<String,Integer>>();
	List<String> filenames=new ArrayList<String>();
	for(int i=0;i<23;i++)
	{
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		fileInfo.add(hm);
	}
	
	try{
		BufferedReader br=new BufferedReader(new FileReader(new File(filename)));
		String s;
		System.out.println("Begin reading...");
		int i=0;
		s=br.readLine();
		String[] names=Arrays.copyOfRange(s.split(","), 3, 23) ;
		filenames.add("day");
		filenames.add("hour");
		for(int j=0;j<20;j++)
		{
			filenames.add(names[j]);
		}
		
		while((s=br.readLine())!=null)
		{
			String[] dataItem=Arrays.copyOfRange(s.split(","), 2, 23) ;
			for(int j=0;j<21;j++)
			{
				String item=dataItem[j];
				if(j==0)
				{
					DateTime t=DateTimeUtil.parseStringToDateTime(item);
					String d=String.valueOf(t.getDayOfWeek());
					int c=0;
					HashMap<String, Integer> st1=fileInfo.get(j);
					if(st1.containsKey(d))
						c=st1.get(d);
					c+=1;
					fileInfo.get(j).put(d, c);
					c=0;
					String h=String.valueOf(t.getHourOfDay());
					HashMap<String, Integer> st2=fileInfo.get(j+1);
					if(st2.containsKey(h))
						c=st2.get(h);
					c+=1;
					fileInfo.get(j+1).put(h, c);
				}
				else
				{
					int c=0;
					HashMap<String, Integer> st=fileInfo.get(j+1);
					if(st.containsKey(item))
						c=st.get(item);
					c+=1;
					fileInfo.get(j+1).put(item, c);
				}
			}
			if(i%1000000==0)
			{
				System.out.println(i+" items finished.");
			}
			i++;
		}
		br.close();
	}
	catch(IOException e)
	{
		System.out.println("notnh");
	}
	String fname="//Users//Yazhe//Documents//UCL-MachineLearning//COMPGI09-AppliedMachineLearning//Projects//Project1-ClickPrediction//Testing";
	try{
		System.out.println("Begin writing...");
		for(int i=0;i<23;i++)
		{
			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(fname+"//"+filenames.get(i)+".csv")));
			pw.print(StringUtils.join(fileInfo.get(i).entrySet(),"\n"));
			pw.close();
		}
	}
	catch(Exception e)
	{
		System.out.println("here");
		}
	System.out.println("task finished");
}
public static void main(String[] args)
{
	getFirstOrderTypeCount(args[0]);
}
}
