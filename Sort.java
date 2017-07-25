package Ray.Sort;

public class Sort {
	public void bubbleSort(int []array){
		for(int i = 1;i<array.length;i++){
			for(int j =0;j<array.length-i;j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	public void selectSort(int []array){
		for(int i = 0;i<array.length-1;i++){
			int index =i;
			for(int j =i+1;j<array.length;j++){
				if(array[j]<array[index]){
					index = j;
				}
			}
			if(index!=i){
				int temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
	}
	public void insertSort(int []array){
		for(int i=1;i<array.length;i++){
			int t = array[i];
			int j = i-1;
			while(j>=0&&t<array[j]){
				array[j+1] =array[j];
				j--;
			}
			array[j+1] = t;
		}
	}
	public void shellSort(int []array){
		for(int r = array.length;r>=1;r/=2){
			for(int i = r;i<array.length;i++){
				int temp = array[i];
				int j = i-r;
				while(j>=0&&temp<array[j]){
					array[j+r] = array[j];
					j-=r;
				}
				array[j+r] =temp;
			}
		}
	}
	 public static void quickSort(int[] keys) {
	        quickSort(keys, 0, keys.length-1);
	    }
	  
	    private static void quickSort(int[] keys, int begin, int end)
	    {
	        if (begin>=0 && begin<keys.length && end>=0 && end<keys.length && begin<end)
	        {
	            int i=begin, j=end;                            
	            int vot=keys[i];                              
	            while (i!=j)
	            {
	                while (i<j && keys[j]>=vot)               

	                    j--;
	                if (i<j)
	                    keys[i++]=keys[j];                    
	                while (i<j && keys[i]<=vot)               

	                    i++;
	                if (i<j)
	                    keys[j--]=keys[i];                    
	            }
	            keys[i]=vot;                                  
	                     
	            quickSort(keys, begin, j-1);                  
	            quickSort(keys, i+1, end);                     
	        }
	    }
	public void merge(int a[],int s,int m,int t,int []temp){
		//temp =new int[t-s+1];
		int i = s,j =m+1,k =0;
		while(i<m&&j<=t){
			if(a[i]<a[j]){
				temp[k] = a[i];
				k++;
				i++;
			}else{
				temp[k] = a[j];
				j++;
				k++;
			}
		}
		while(i<m){
			temp[k] = a[i];
			k++;
			i++;
		}
		while(j<=t){
			temp[k] = a[i];
			j++;
			k++;
		}
		while(s<=t){
			a[s++] = temp[k++];
		}
	}
	public void mergeSort(int array[],int l,int r,int []temp){
		if(l<r){
			int mid = (l+r)/2;
			mergeSort(array,l,mid,temp);
			mergeSort(array,mid+1,r,temp);
			merge(array,l,mid,r,temp);
		}
	}
	public void mergeSort(int []arr){
		int []temp = new int[arr.length];
		mergeSort(arr, 0, arr.length-1, temp);
	}
	public static void main(String[] args) {
		int arr[] = {1,8,2,6};
		quickSort(arr);
		for(int i:arr){
			System.out.print(i+" ");
		}
	}
}
