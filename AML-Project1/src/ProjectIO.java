import java.util.*;
import java.io.*;
public class ProjectIO {
public static void main(String[] args)
{
	File fileName=new File(args[0]);
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
}
}
