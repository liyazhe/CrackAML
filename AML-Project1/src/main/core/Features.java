package core;

import org.apache.mahout.math.*;
import org.apache.mahout.math.function.Functions;

import java.io.*;
import java.util.*;

import org.joda.time.*;

import util.DateTimeUtil;
public class Features {
	public Integer size;
	private List<Integer> clicked=new ArrayList<Integer>();
	private List<Integer> hours=new ArrayList<Integer>();
	private List<Integer> days=new ArrayList<Integer>();
	private List<Integer> C1=new ArrayList<Integer>();
	private List<Integer> pos=new ArrayList<Integer>();
	private List<String> siteID=new ArrayList<String>();
	private List<String> siteDomain=new ArrayList<String>();
	private List<String> siteCat=new ArrayList<String>();
	private List<String> appID=new ArrayList<String>();
	private List<String> appDomain=new ArrayList<String>();
	private List<String> appCat=new ArrayList<String>();
	private List<String> deviceID=new ArrayList<String>();
	private List<String> deviceIP=new ArrayList<String>();
	private List<String> deviceM=new ArrayList<String>();
	private List<Integer> deviceT=new ArrayList<Integer>();
	private List<Integer> connect=new ArrayList<Integer>();
	private List<Integer> c14=new ArrayList<Integer>();
	private List<Integer> c15=new ArrayList<Integer>();
	private List<Integer> c16=new ArrayList<Integer>();
	private List<Integer> c17=new ArrayList<Integer>();
	private List<Integer> c18=new ArrayList<Integer>();
	private List<Integer> c19=new ArrayList<Integer>();
	private List<Integer> c20=new ArrayList<Integer>();
	private List<Integer> c21=new ArrayList<Integer>();
	
	public Features (String path)
	{
		Integer[] c=new Integer[]{0,1};
		this.clicked.addAll(java.util.Arrays.asList(c));
		
		Integer[] h=new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
		this.hours.addAll(java.util.Arrays.asList(h));
		
		Integer[] d=new Integer[] {1,2,3,4,5,6,7};
		this.days.addAll(java.util.Arrays.asList(d));
		
		Integer[] c1=new Integer[] {1001,1002,1005,1007,1008,1010,1012};
		this.C1.addAll(java.util.Arrays.asList(c1));
		
		Integer[] p=new Integer[]{0,1,2,3,4,5,7};
		this.pos.addAll(java.util.Arrays.asList(p));
		
		try{
		BufferedReader br=new BufferedReader(new FileReader(new File(path+"//6.csv")));
		String sid=br.readLine();
		while ((sid=br.readLine())!=null)
		{
			siteID.add(sid);
		}
		br.close();
		}
		catch(IOException e)	
		{
			System.out.println("Error: file not exist");
		}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//7.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				siteDomain.add(sdom);
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//8.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				siteCat.add(sdom);
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//9.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				appID.add(sdom);
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//10.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				appDomain.add(sdom);
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//11.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				appCat.add(sdom);
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//12.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				deviceID.add(sdom);
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
//		try{
//			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//13.csv")));
//			String sdom=br.readLine();
//			while ((sdom=br.readLine())!=null)
//			{
//				deviceIP.add(sdom);
//			}
//			br.close();
//			}
//			catch(IOException e)	
//			{
//				System.out.println("Error: file not exist");
//			}
//		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//14.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				deviceM.add(sdom);
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}

		Integer[] dtype=new Integer[]{0,1,2,4,5};
		this.deviceT.addAll(java.util.Arrays.asList(dtype));
		
		Integer[] ctype=new Integer[]{0,2,3,5};
		this.connect.addAll(java.util.Arrays.asList(ctype));
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//17.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				c14.add(Integer.valueOf(sdom));
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
			
		
		Integer[] c15type=new Integer[]{768, 728, 480, 320, 300, 216, 120, 1024};
		this.c15.addAll(java.util.Arrays.asList(c15type));
		
		Integer[] c16type=new Integer[]{1024,20,250,320,36,480,50,768,90};
		this.c16.addAll(java.util.Arrays.asList(c16type));
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//20.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				c17.add(Integer.valueOf(sdom));
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		Integer[] c18type=new Integer[]{0,1,2,3};
		this.c18.addAll(java.util.Arrays.asList(c18type));
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//22.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				c19.add(Integer.valueOf(sdom));
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//23.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				c20.add(Integer.valueOf(sdom));
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(path+"//24.csv")));
			String sdom=br.readLine();
			while ((sdom=br.readLine())!=null)
			{
				c21.add(Integer.valueOf(sdom));
			}
			br.close();
			}
			catch(IOException e)	
			{
				System.out.println("Error: file not exist");
			}
		
		this.size=(this.hours.size()+this.C1.size()+this.pos.size()+this.siteID.size()+this.siteDomain.size()+this.siteCat.size()+this.appID.size()+this.appDomain.size()+this.appCat.size()+this.deviceID.size()+this.deviceIP.size()+this.deviceM.size()+this.deviceT.size()+this.connect.size()+this.c14.size()+this.c15.size()+this.c16.size()+this.c17.size()+this.c18.size()+this.c19.size()+this.c20.size()+this.c21.size())*this.clicked.size();
		//this.size=clicked.size()*(hours.size()*days.size()*(siteID.size()+appID.size()+deviceM.size()+c14.size()+c21.size()+c20.size()+c16.size())+pos.size()*(siteID.size()+siteDomain.size()+appDomain.size()));
	}
	// time and click relation
	public RandomAccessSparseVector timeClickFeatureTemplate(DateTime t, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size());
		int hour=t.getHourOfDay();
		int h=hours.indexOf(hour);
		int c=clicked.indexOf(click);
		f.set(c*hours.size()+h, 1.0);
		return f;
	}
	// banner position and click relation
	public RandomAccessSparseVector posClickFeatureTemplate(int p, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(pos.size()*clicked.size());
		int h=pos.indexOf(p);
		int c=clicked.indexOf(click);
		try{
		f.set(c*pos.size()+h, 1.0);
		}
		catch(Exception e)
		{
			System.out.println(p);
		}
		return f;
	}
	// c1 anonymous and click relation
	public RandomAccessSparseVector c1ClickFeatureTemplate(int p, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(C1.size()*clicked.size());
		int h=C1.indexOf(p);
		int c=clicked.indexOf(click);
		f.set(c*C1.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector sidClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(siteID.size()*clicked.size());
		int h=siteID.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*siteID.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector sdomClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(siteDomain.size()*clicked.size());
		int h=siteDomain.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*siteDomain.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector scatClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(siteCat.size()*clicked.size());
		int h=siteCat.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*siteCat.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector appidClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(appID.size()*clicked.size());
		int h=appID.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*appID.size()+h, 1.0);
		return f;
	}
	
	public RandomAccessSparseVector appdomClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(appDomain.size()*clicked.size());
		int h=appDomain.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*appDomain.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector appcatClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(appCat.size()*clicked.size());
		int h=appCat.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*appCat.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector devidClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(deviceID.size()*clicked.size());
		int h=deviceID.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*deviceID.size()+h, 1.0);
		return f;
	}
//	public RandomAccessSparseVector devipClickFeatureTemplate(String id, int click)
//	{
//		RandomAccessSparseVector f=new RandomAccessSparseVector(deviceIP.size()*clicked.size());
//		int h=deviceIP.indexOf(id);
//		int c=clicked.indexOf(click);
//		f.set(c*deviceIP.size()+h, 1.0);
//		return f;
//	}
	public RandomAccessSparseVector devmClickFeatureTemplate(String id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(deviceM.size()*clicked.size());
		int h=deviceM.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*deviceM.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector devtClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(deviceT.size()*clicked.size());
		int h=deviceT.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*deviceT.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector conClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(connect.size()*clicked.size());
		int h=connect.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*connect.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c14ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c14.size()*clicked.size());
		int h=c14.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c14.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c15ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c15.size()*clicked.size());
		int h=c15.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c15.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c16ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c16.size()*clicked.size());
		int h=c16.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c16.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c17ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c17.size()*clicked.size());
		int h=c17.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c17.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c18ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c18.size()*clicked.size());
		int h=c18.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c18.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c19ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c19.size()*clicked.size());
		int h=c19.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c19.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c20ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c20.size()*clicked.size());
		int h=c20.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c20.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector c21ClickFeatureTemplate(Integer id, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(c21.size()*clicked.size());
		int h=c21.indexOf(id);
		int c=clicked.indexOf(click);
		f.set(c*c21.size()+h, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAdayClickFeatureTemplate(DateTime t, int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		f.set(c*hours.size()*days.size()+h*days.size()+d, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAposClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*pos.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=pos.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*pos.size()+p, 1.0);
		return f;
	}
	//good feature!
	public RandomAccessSparseVector timeAsiteidClickFeatureTemplate(DateTime t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*siteID.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=siteID.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*siteID.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAsitedomClickFeatureTemplate(DateTime t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*siteDomain.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=siteDomain.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*siteDomain.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAsitecatClickFeatureTemplate(DateTime t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*siteCat.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=siteCat.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*siteCat.size()+p, 1.0);
		return f;
	}	
	public RandomAccessSparseVector timeAappidClickFeatureTemplate(DateTime t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*appID.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=appID.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*appID.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAappdomClickFeatureTemplate(DateTime t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*appDomain.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=appDomain.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*appDomain.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAappcatClickFeatureTemplate(DateTime t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*appCat.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=appCat.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*appCat.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAdivmClickFeatureTemplate(DateTime t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*deviceM.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=deviceM.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*deviceM.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAdivtClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*deviceT.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=deviceT.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*deviceT.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAconClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*connect.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=connect.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*connect.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc14ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c14.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c14.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c14.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc15ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c15.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c15.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c15.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc16ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c16.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c16.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c16.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc17ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c17.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c17.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c17.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc18ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c18.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c18.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c18.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc19ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c19.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c19.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c19.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc20ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c20.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c20.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c20.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector timeAc21ClickFeatureTemplate(DateTime t, Integer id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(hours.size()*clicked.size()*days.size()*c21.size());
		int hour=t.getHourOfDay();
		int day=t.getDayOfWeek();
		int h=hours.indexOf(hour);
		int d=days.indexOf(day);
		int c=clicked.indexOf(click);
		int p=c21.indexOf(id);
		f.set((c*hours.size()*days.size()+h*days.size()+d)*c21.size()+p, 1.0);
		return f;
	}
	public RandomAccessSparseVector posAsiteidClickFeatureTemplate(Integer t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(pos.size()*clicked.size()*siteID.size());
		int c=clicked.indexOf(click);
		int p=pos.indexOf(t);
		int s=siteID.indexOf(id);
		f.set((c*pos.size()+p)*siteID.size()+s, 1.0);
		return f;
	}
	public RandomAccessSparseVector posAappidClickFeatureTemplate(Integer t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(pos.size()*clicked.size()*appID.size());
		int c=clicked.indexOf(click);
		int p=pos.indexOf(t);
		int s=appID.indexOf(id);
		f.set((c*pos.size()+p)*appID.size()+s, 1.0);
		return f;
	}
	public RandomAccessSparseVector posAsitedomClickFeatureTemplate(Integer t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(pos.size()*clicked.size()*siteDomain.size());
		int c=clicked.indexOf(click);
		int p=pos.indexOf(t);
		int s=siteDomain.indexOf(id);
		f.set((c*pos.size()+p)*siteDomain.size()+s, 1.0);
		return f;
	}
	public RandomAccessSparseVector posAsitecatClickFeatureTemplate(Integer t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(pos.size()*clicked.size()*siteCat.size());
		int c=clicked.indexOf(click);
		int p=pos.indexOf(t);
		int s=siteCat.indexOf(id);
		f.set((c*pos.size()+p)*siteCat.size()+s, 1.0);
		return f;
	}
	public RandomAccessSparseVector posAappdomClickFeatureTemplate(Integer t, String id,int click)
	{
		RandomAccessSparseVector f=new RandomAccessSparseVector(pos.size()*clicked.size()*appDomain.size());
		int c=clicked.indexOf(click);
		int p=pos.indexOf(t);
		int s=appDomain.indexOf(id);
		f.set((c*pos.size()+p)*appDomain.size()+s, 1.0);
		return f;
	}
	public RandomAccessSparseVector getFeautreMap(String[] dataItem, int click)
	{
		//int click=Integer.valueOf(dataItem[1]); //truevalue
		DateTime t=DateTimeUtil.parseStringToDateTime(dataItem[2]); //date and time
		int c1=Integer.valueOf(dataItem[3]); //anonymous c1
		int pos=Integer.valueOf(dataItem[4]);//banner position
		String siteid=dataItem[5]; // site id
		String sitedom=dataItem[6]; //site domain
		String sitecat=dataItem[7]; //site category
		String appid=dataItem[8]; //app id
		String appdom=dataItem[9]; //app domain
		String appcat=dataItem[10]; //app category
		String devid=dataItem[11]; //device id
		String devip=dataItem[12]; //device ip
		String devm=dataItem[13]; //device model
		Integer devt=Integer.valueOf(dataItem[14]); //device type
		Integer con=Integer.valueOf(dataItem[15]); //connection type
		Integer C14=Integer.valueOf(dataItem[16]); //anonymous c14
		Integer C15=Integer.valueOf(dataItem[17]); //anonymous c15
		Integer C16=Integer.valueOf(dataItem[18]); //anonymous c16
		Integer C17=Integer.valueOf(dataItem[19]); //anonymous c17
		Integer C18=Integer.valueOf(dataItem[20]); //anonymous c18
		Integer C19=Integer.valueOf(dataItem[21]); //anonymous c19
		Integer C20=Integer.valueOf(dataItem[22]); //anonymous c20
		Integer C21=Integer.valueOf(dataItem[23]); //anonymous c21

		int start=0;
		RandomAccessSparseVector f=new RandomAccessSparseVector(this.size);
		RandomAccessSparseVector f1=timeClickFeatureTemplate(t,click);
		f.viewPart(start, f1.size()).assign(f1, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f1.size();
		
		RandomAccessSparseVector f2=c1ClickFeatureTemplate(c1,click);
		f.viewPart(start, f2.size()).assign(f2, Functions.PLUS);
		//System.out.print("feature2: "+start+"\n");
		start+=f2.size();
		
		RandomAccessSparseVector f3=posClickFeatureTemplate(pos,click);
		f.viewPart(start, f3.size()).assign(f3, Functions.PLUS);
		//System.out.print("feature3: "+start+"\n");
		start+=f3.size();
		RandomAccessSparseVector f4=sidClickFeatureTemplate(siteid,click);
		f.viewPart(start, f4.size()).assign(f4, Functions.PLUS);
		//System.out.print("feature4: "+start+"\n");
		start+=f4.size();
		RandomAccessSparseVector f5=sdomClickFeatureTemplate(sitedom,click);
		f.viewPart(start, f5.size()).assign(f5, Functions.PLUS);
		//System.out.print("feature5: "+start+"\n");
		start+=f5.size();
		RandomAccessSparseVector f6=scatClickFeatureTemplate(sitecat,click);
		f.viewPart(start, f6.size()).assign(f6, Functions.PLUS);
		//System.out.print("feature6: "+start+"\n");
		start+=f6.size();
		RandomAccessSparseVector f7=appidClickFeatureTemplate(appid,click);
		f.viewPart(start, f7.size()).assign(f7, Functions.PLUS);
		//System.out.print("feature7: "+start+"\n");
		start+=f7.size();
		
		RandomAccessSparseVector f8=appdomClickFeatureTemplate(appdom,click);
		f.viewPart(start, f8.size()).assign(f8, Functions.PLUS);
		//System.out.print("feature8: "+start+"\n");
		start+=f8.size();
		RandomAccessSparseVector f9=appcatClickFeatureTemplate(appcat,click);
		f.viewPart(start, f9.size()).assign(f9, Functions.PLUS);
		//System.out.print("feature9: "+start+"\n");
		start+=f9.size();
		RandomAccessSparseVector f10=devidClickFeatureTemplate(devid,click);
		f.viewPart(start, f10.size()).assign(f10, Functions.PLUS);
		//System.out.print("feature10: "+start+"\n");
		start+=f10.size();
//		RandomAccessSparseVector f11=devipClickFeatureTemplate(devip,click);
//		f.viewPart(start, f11.size()).assign(f11, Functions.PLUS);
//		start+=f11.size();
		RandomAccessSparseVector f12=devmClickFeatureTemplate(devm,click);
		f.viewPart(start, f12.size()).assign(f12, Functions.PLUS);
		//System.out.print("feature11: "+start+"\n");
		start+=f12.size();
		RandomAccessSparseVector f13=devtClickFeatureTemplate(devt,click);
		f.viewPart(start, f13.size()).assign(f13, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f13.size();
		RandomAccessSparseVector f14=conClickFeatureTemplate(con,click);
		f.viewPart(start, f14.size()).assign(f14, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f14.size();
		RandomAccessSparseVector f15=c14ClickFeatureTemplate(C14,click);
		f.viewPart(start, f15.size()).assign(f15, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f15.size();
		RandomAccessSparseVector f16=c15ClickFeatureTemplate(C15,click);
		f.viewPart(start, f16.size()).assign(f16, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f16.size();
		
		RandomAccessSparseVector f17=c16ClickFeatureTemplate(C16,click);
		f.viewPart(start, f17.size()).assign(f17, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f17.size();
		RandomAccessSparseVector f18=c17ClickFeatureTemplate(C17,click);
		f.viewPart(start, f18.size()).assign(f18, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f18.size();
		RandomAccessSparseVector f19=c18ClickFeatureTemplate(C18,click);
		f.viewPart(start, f19.size()).assign(f19, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f19.size();
		RandomAccessSparseVector f20=c19ClickFeatureTemplate(C19,click);
		f.viewPart(start, f20.size()).assign(f20, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f20.size();
		RandomAccessSparseVector f21=c20ClickFeatureTemplate(C20,click);
		f.viewPart(start, f21.size()).assign(f21, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f21.size();
		RandomAccessSparseVector f22=c21ClickFeatureTemplate(C21,click);
		f.viewPart(start, f22.size()).assign(f22, Functions.PLUS);
		//System.out.print("feature1: "+start+"\n");
		start+=f22.size();
		
		/*RandomAccessSparseVector f=new RandomAccessSparseVector(this.size);
		RandomAccessSparseVector f1=timeAsiteidClickFeatureTemplate(t,siteid,click);
		f.viewPart(start, f1.size()).assign(f1, Functions.PLUS);
		start+=f1.size();
		
		RandomAccessSparseVector f2=timeAappidClickFeatureTemplate(t,appid,click);
		f.viewPart(start, f2.size()).assign(f2, Functions.PLUS);
		start+=f2.size();
		
		RandomAccessSparseVector f3=timeAdivmClickFeatureTemplate(t,devm,click);
		f.viewPart(start, f3.size()).assign(f3, Functions.PLUS);
		start+=f3.size();
		
		RandomAccessSparseVector f4=timeAc14ClickFeatureTemplate(t,C14,click);
		f.viewPart(start, f4.size()).assign(f4, Functions.PLUS);
		start+=f4.size();
		RandomAccessSparseVector f7=timeAc16ClickFeatureTemplate(t,C16,click);
		f.viewPart(start, f7.size()).assign(f7, Functions.PLUS);
		start+=f7.size();
		RandomAccessSparseVector f5=timeAc20ClickFeatureTemplate(t,C20,click);
		f.viewPart(start, f5.size()).assign(f5, Functions.PLUS);
		start+=f5.size();
		RandomAccessSparseVector f6=timeAc21ClickFeatureTemplate(t,C21,click);
		f.viewPart(start, f6.size()).assign(f6, Functions.PLUS);
		start+=f6.size();
		RandomAccessSparseVector f8=posAsiteidClickFeatureTemplate(pos,siteid,click);
		f.viewPart(start, f8.size()).assign(f8, Functions.PLUS);
		start+=f8.size();
		RandomAccessSparseVector f9=posAsitedomClickFeatureTemplate(pos,sitedom,click);
		f.viewPart(start, f9.size()).assign(f9, Functions.PLUS);
		start+=f9.size();
		RandomAccessSparseVector f10=posAappdomClickFeatureTemplate(pos,appdom,click);
		f.viewPart(start, f10.size()).assign(f10, Functions.PLUS);
		start+=f10.size();*/
		return f;
	}
}
