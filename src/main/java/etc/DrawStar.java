package etc;

public class DrawStar {

  public String draw(int size){

    if(size<5 && size%2!=1) throw new IllegalArgumentException("5이상 홀수로 입력 해주세요");

    StringBuilder stringBuilder = new StringBuilder();

    for(int i=0 ; i<size; i++){
      for(int j=0; j<size; j++){
        stringBuilder.append((print(size, i, j)?"*":""));
      }
      stringBuilder.append('\n');
    }

    return stringBuilder.toString();
  }

  public boolean print(int size, int row, int col){

    int sizeHalf = size / 2;
    //if(sizeHalf==row) return true;
    int abs = Math.abs(sizeHalf - row);

    System.out.println("row:" + row + ", col:" + col + ", abs:" + abs + ",  Math.abs(" + col+ " - "+sizeHalf+"):" +  Math.abs(col - sizeHalf) + ", (sizeHalf-abs)" + (sizeHalf-abs));

    int abs1 = Math.abs(col - sizeHalf);
    return abs1 <= sizeHalf-abs;
  }
}
