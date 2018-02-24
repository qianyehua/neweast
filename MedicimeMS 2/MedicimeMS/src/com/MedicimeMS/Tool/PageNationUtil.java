package com.MedicimeMS.Tool;



import net.sf.json.JSONArray;

public class PageNationUtil {

	public JSONArray getContent(JSONArray arr,int showpage,int pagesize){
		  System.out.println(arr);
		int datacount=arr.size();
		JSONArray array=new JSONArray();
    	int pagecount=getPagecount(datacount, pagesize);
        int foot;
        int head=datacount-pagesize*(showpage-1)-1;
        if(showpage==pagecount){
        	foot=0;
        }
        else{
        	foot=datacount-pagesize*showpage;
        }
 
        while(showpage<=pagecount){
    	   for(int j=head;j>=foot;j--){
    		  array.add(arr.getJSONObject(j));
    	   }
         
    	   return array;
        }
  
        return null;
		
	}
	
	public int getPagecount( int datacounts,int pagesizes) {

		if(datacounts%pagesizes==0){
		   return datacounts/pagesizes;
		}
		else{
		   return (datacounts/pagesizes +1);
		}
			
	}
	    

}
