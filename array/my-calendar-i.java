class MyCalendar {
     List<int[]>list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] x : list){
            int first = x[0];
            int second= x[1];
            if(startTime<second&&endTime>first){
                  return false;
            }
        }
        list.add(new int[]{startTime,endTime});
        return true;
    }
}
