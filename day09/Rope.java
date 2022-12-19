package day9;

import java.util.HashSet;
import java.util.Set;

public class Rope {

    static record Coord(int x, int y){
        Coord addX(int x){
            return new Coord(this.x+x, this.y);
        }
        Coord addY(int y){
            return new Coord(this.x, this.y+y);
        }

        Coord add(int x, int y){
            return new Coord(this.x+x, this.y+y);
        }
    }
    private Set<Coord> cSet = new HashSet<>();

    private Coord[] knots;

    public Rope(int hx, int hy, int length){
        knots = new Coord[length];
        for(int i=0; i<length; i++) knots[i] = new Coord(hx, hy);
        cSet.add(new Coord(hx, hy));
    }

    public boolean isAdjacent(Coord k1, Coord k2){
        boolean adjX=false;
        boolean adjY=false;

        if(Math.abs(k1.x() - k2.x()) <= 1) adjX=true;
        if(Math.abs(k1.y() - k2.y()) <= 1) adjY=true;

        return adjX&&adjY;
    }

    public void doStep(char dir, int n){
        for(int i=0; i<n; i++){ 
                  
            switch(dir){
                case 'U': knots[0] = knots[0].addY(-1); break;
                case 'D': knots[0] = knots[0].addY(1); break;
                case 'L': knots[0] = knots[0].addX(-1); break;
                case 'R': knots[0] = knots[0].addX(1); break;
            }
            for(int j=1; j<knots.length; j++){
                if(!isAdjacent(knots[j-1], knots[j])){
                    if(knots[j-1].x()!=knots[j].x()) knots[j] = knots[j].addX((int)Math.signum(knots[j-1].x()-knots[j].x()));
                    if(knots[j-1].y()!=knots[j].y()) knots[j] = knots[j].addY((int)Math.signum(knots[j-1].y()-knots[j].y()));
                }
            }
            cSet.add(knots[knots.length-1]);
        }
    }

    public int getPos(){
        return cSet.size();
    }
}
