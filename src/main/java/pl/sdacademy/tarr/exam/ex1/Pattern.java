package pl.sdacademy.tarr.exam.ex1;

public class Pattern {

	public String prepareSquareWithDiagonals(char sign, int size) {
		StringBuilder pattern = new StringBuilder();

		for(int row=0; row<size; row++){
			for(int col=0; col<size; col++){
				if(col == row || col == size-row-1 || col == 0 || row == 0 || row == size - 1 || col == size - 1){
					pattern.append(sign);
				}else{
					pattern.append(" ");
				}
				if(col!=(size-1)){
					pattern.append(" ");
				}
			}
			pattern.append("\n");
		}

		System.out.print(pattern); // for debug only
		return pattern.toString();
	}
}
