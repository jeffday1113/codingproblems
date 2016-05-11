package javasolutions;

import java.util.Vector;

public class CartesianProduct {

	public static void main(String[] args){
		CartesianProduct cp = new CartesianProduct();
		Vector<String> testVec1 = new Vector<String>();
		testVec1.addElement("quick");
		testVec1.addElement("lazy");

		Vector<String> testVec2 = new Vector<String>();
		testVec2.addElement("brown");
		testVec2.addElement("black");
		testVec2.addElement("grey");

		Vector<String> testVec3 = new Vector<String>();
		testVec3.addElement("fox");
		testVec3.addElement("dog");

		Vector<Vector<String>> vec = new Vector<Vector<String>>();
		vec.addElement(testVec1);
		vec.addElement(testVec2);
		vec.addElement(testVec3);
		//cp.printCartesianProductIterative(vec);
		cp.printCartesianProductRecursive(vec, 0, "");
	}
	
	public void printCartesianProductRecursive(Vector<Vector<String>> lists, int index, String current){
		/* If index is equal to size of the list, added something from the last list, print */
		if (index == lists.size()){
			System.out.println(current);
		}
		else{
			/* Index will choose which list to look in, recursive calls will increase that index each call */
			for (int j = 0; j < lists.get(index).size(); j++){
				/* Make recursive cll for each element in list */
				printCartesianProductRecursive(lists, index + 1, current + (lists.get(index).get(j) + ", "));
			}
		}
	}

	public void printCartesianProductIterative(Vector<Vector<String>> lists){
		/* Create indexes array for each set starting at 0 */
		int[] indexes = new int[lists.size()];
		String answer = "";
		boolean firstIteration = true;
		while (true){
			/* Check to see if all of the array is zero */
			boolean indexesAllZero = checkIfAllZeros(indexes);
			/* If they are all zero and it isn't the first iteration, all done */
			if (indexesAllZero && !firstIteration)
				return;
			if (firstIteration)
				firstIteration = false;
			/* Print each  */
			for (int j = 0; j < lists.size(); j++){
				answer += lists.get(j).get(indexes[j]);
				if (j < lists.size()-1){
					answer += ", ";
				}
				else{
					System.out.println(answer);
					answer = "";
				}
			}
			editIndexesCount(indexes, lists);

		}
	}
	
	private boolean checkIfAllZeros(int[] indexes){
		boolean indexesAllZero = true;
		for (int i = 0; i < indexes.length; i++){
			indexesAllZero = indexesAllZero && (indexes[i] == 0);
		}
		return indexesAllZero;
	}

	private int[] editIndexesCount(int[] indexes, Vector<Vector<String>> lists){
		int lastIndex = indexes.length - 1;
		indexes[lastIndex] = indexes[lastIndex] + 1;
		while(true){
			if (indexes[lastIndex] == lists.get(lastIndex).size()){
				indexes[lastIndex] = 0;
				lastIndex = lastIndex - 1;
				if (lastIndex < 0)
					return indexes;
				indexes[lastIndex] = indexes[lastIndex] + 1;
			}
			else{
				return indexes;
			}
		}	
	}

}
