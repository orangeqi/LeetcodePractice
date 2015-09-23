
public class RectangleArea {

	/** 223 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		computeArea_1(0,0,0,0,1,1,1,1);
		// -2,-2,2,2,-1,-1,1,1
		//-2,-2,2,2,-2,-4,2,-2
	}
	
	/**
	 * Find the total area covered by two rectilinear rectangles in a 2D plane.
	 * Each rectangle is defined by its bottom left corner 
	 * and top right corner as shown in the figure.
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return area of two rectangles
	 */
	
	// solution 1 364 ms
	public static int computeArea_1(int A, int B, int C, int D,
			int E, int F, int G, int H){
		if(C<E||G<A )
	        return (G-E)*(H-F) + (C-A)*(D-B);
	 
	    if(D<F || H<B)
	        return (G-E)*(H-F) + (C-A)*(D-B);
	 
	    int right = Math.min(C,G);
	    int left = Math.max(A,E);
	    int top = Math.min(H,D);
	    int bottom = Math.max(F,B);
	 
	    return (G-E)*(H-F) + (C-A)*(D-B) - (right-left)*(top-bottom);
	}
}
