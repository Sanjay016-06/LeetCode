public class SummaryRanges {

class Interval {
int start;
int end;

public Interval(int start, int end) {
	this.start = start;
	this.end = end;
}
}
TreeSet<Interval> lookUp;
int[][] resCache;
boolean cacheDirty;

public SummaryRanges() {

Comparator<Interval> sortInterval = new Comparator<Interval>() {
	@Override
	public int compare(Interval it1, Interval it2) {
		return it1.start - it2.start;
	}
};
lookUp = new TreeSet<Interval>(sortInterval);

resCache = new int[0][2];
cacheDirty = true;
}

// lower - Returns the greatest element in this set strictly less than the given
// element, or null if there is no such element.

// higher - Returns the least element in this set strictly greater than the
// given element, or null if there is no such element.
public void addNum(int val) {

Interval itCur = new Interval(val, val);

// CASE 1: interval already exists
if (lookUp.contains(itCur))
	return;
	
//https://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html
Interval itLower = lookUp.lower(itCur), itHigher = lookUp.higher(itCur);

// CASE 2:
if (itLower != null && val <= itLower.end)
	return;

// CASE 3:
if ((itHigher != null && itHigher.start == val + 1) && (itLower != null && val == itLower.end + 1)) {
	itLower.end = itHigher.end; // merge both the intervals
	lookUp.remove(itHigher);
}

// CASE 4:
else if (itHigher != null && itHigher.start == val + 1) 
	itHigher.start = val; // to be merged with higher

// CASE 5:
else if (itLower != null && val == itLower.end + 1) 
	itLower.end = val; // to be merged with lower

// CASE 6:
else 
	lookUp.add(new Interval(val, val));

// in all the above 4 cases - lookUp is modified
cacheDirty = true;
}

public int[][] getIntervals() {

if (!cacheDirty)
	return resCache;

int len = lookUp.size();
resCache = new int[len][2];

int i = 0;
for (Interval curr : lookUp) {
	resCache[i][0] = curr.start;
	resCache[i][1] = curr.end;
	i++;
}
cacheDirty = false;
return resCache;
}
}