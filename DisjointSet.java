
public class DisjointSet {

	private int n;
	private int[] set;
	
	public void createSets(int n){
		this.n = n;
		set = new int[n];
		for(int i = 0; i < n; i++)
			set[i] = -1;
	}
	
	public int find(int elem){
		while(set[elem] > 0)
			elem = set[elem];
		return elem;
	}
	
	public void union(int elem1, int elem2){
		int parent1 = find(elem1);
		int parent2 = find(elem2);
		for(int i = 0; i < n; i++){
			if(find(i) == parent1)
				set[i] = parent2;
		}
	}
}
