package Sorting;

public class mergesort {

	public static void main(String[] args) {
		   int a[] = {10, 12, 55, 11, 54, 22, 5, 7, 2, 4};
		     sort(a);
		     StringBuffer str=new StringBuffer();
		        for(int i=0;i<a.length;i++) {
		            if(i==a.length-1) {
		                str.append(a[i]);
		            }else {
		                str.append(a[i]+" ");
		               
		            }
		        }
		        String s=str.toString();
		        System.out.println(s);
		 }
	public static void sort(int a[]){
		      
		         int l=0;
		         int r=a.length-1;
		       
		         devide(a,l,r);
		     }
		     //·ÖÖÎ
		     
	private static void devide(int a[],int left, int right){
		 
		         int mid=(left+right)/2;
		         if(left<right){

		             devide(a,left,mid);
		             devide(a,mid+1,right);
		             merge(a,left,mid,mid+1,right);
		         }
		     }

	private static void merge(int a[], int left, int mid, int i, int right) {
		         int[]temp= new int[a.length];
		         // ls left start
		         
		         int index=left;
		         int ls=left,le=mid;
		         int rs=i,re=right;
		      
		         while(ls<=le&&rs<=re){
		             if (a[ls]<a[rs]){
		                 temp[index]=a[ls];
		                 ls++;
		             }else{
		                 temp[index]=a[rs];
		                 rs++;
		             }
		             index++;
		         }
		         //ÅÐ¶Ï×ó±ßÊÇ·ñÓÐÊ£Óà
		         if(ls<=le){
		             for (int j=ls;j<=le;j++){
		                 temp[index++]=a[j];
		             }
		         }
		         if (rs<=re){
		             for (int j=rs;j<=re;j++){
		                 temp[index++]=a[j];
		             }
		         }
		         for(int j=left;j<=right;j++){
		             a[j]=temp[j];
		         }
		    
		 }
		     }
