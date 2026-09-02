class Solution {

    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int maxvalue = 4001;
        int arr[] = new int[n+m];
        for(int i = 0; i < n;i++) {
            arr[i] = arr1[i];
        }
        for(int i = 0; i < m;i++) {
            arr[n+i] = arr2[i]; 
        }
        Arrays.sort(arr);
        int totaluniquenumbers = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < (m+n);i++) {
            Integer a = map.get(arr[i]);
            if(a == null) {
                map.put(arr[i], ++totaluniquenumbers);
            }   
        }
        for(int i = 0; i < n;i++) {
            arr1[i] = map.get(arr1[i]);
        }
        Set<Integer> arr2set = new HashSet<>();
        for(int i = 0; i < m;i++) {
            arr2[i] = map.get(arr2[i]);
            arr2set.add(arr2[i]);
        }
        int value = totaluniquenumbers;
        int res[][] = new int[n+1][value+1];
        
        for(int i = 0; i <= n;i++) {
            res[i] = new int[value+1];
            for(int j = 0; j <= value; j++) {
                res[i][j] = maxvalue;
            }
        }
        for(int i = 0; i <= totaluniquenumbers;i++)
            res[0][i] = 0;
        for(int i = 1;  i <= n;i++) {
            for(int j = 1; j <= totaluniquenumbers; j++) {
                res[i][j] = res[i-1][j-1] + ((arr1[i-1] == j)?  0 :  (arr2set.contains(j)) ? 1 : maxvalue);
                res[i][j] = Math.min(res[i][j], res[i][j-1]);

            }
        }
    
        return (res[n][totaluniquenumbers] >= maxvalue) ? -1 : res[n][totaluniquenumbers];
    }
}