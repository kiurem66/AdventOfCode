package day8;

import java.util.List;

public class Forest {
    int[][] treeTable;
    boolean[][] visibileTable;


    public Forest(List<String> list){
        treeTable = new int[list.size()][list.get(0).length()];
        for(int i=0; i<list.size(); i++){
            String line = list.get(i);
            for(int j=0; j<line.length(); j++){
                treeTable[i][j] = Integer.valueOf(line.charAt(j));
            }
        }
        generateVisible();
    }

    private void generateVisible(){
        visibileTable = new boolean[treeTable.length][treeTable[0].length];

        for(int i=0; i<treeTable.length; i++){
            int maxInLine = treeTable[i][0];
            visibileTable[i][0] = true;
            for(int j=1; j<treeTable[0].length; j++){
                if(treeTable[i][j] > maxInLine){
                    visibileTable[i][j] = true;
                    maxInLine=treeTable[i][j];
                }
            }

            maxInLine = treeTable[i][treeTable[0].length-1];
            visibileTable[i][treeTable[0].length-1] = true;
            for(int j=treeTable[0].length-2; j>=0; j--){
                if(treeTable[i][j] > maxInLine){
                    visibileTable[i][j] = true;
                    maxInLine=treeTable[i][j];
                }
            }
        }

        for(int i=0; i<treeTable[0].length; i++){
            int maxInLine = treeTable[0][i];
            visibileTable[0][i] = true;
            for(int j=1; j<treeTable.length; j++){
                if(treeTable[j][i] > maxInLine){
                    visibileTable[j][i] = true;
                    maxInLine=treeTable[j][i];
                }
            }

            maxInLine = treeTable[treeTable.length-1][i];
            visibileTable[treeTable.length-1][i] = true;
            for(int j=treeTable.length-2; j>=0; j--){
                if(treeTable[j][i] > maxInLine){
                    visibileTable[j][i] = true;
                    maxInLine=treeTable[j][i];
                }
            }
        }   
    }

    void printVisibility(){
        for(boolean[] line : visibileTable){
            for(boolean t: line){
                if(t) System.out.print("1");
                else System.out.print("0");
            }
            System.out.println();
        }
    }

    public int getVisible(){
        int n=0;
        for(int i=0; i<visibileTable.length; i++){
            for(int j=0; j<visibileTable[0].length; j++){
                if(visibileTable[i][j]) n++;
            }
        }
        return n;
    }

    public int getMaxScenicScore(){
        int max=0;
        for(int i=0; i<treeTable.length; i++){
            for(int j=0; j<treeTable[0].length; j++){
                int score = getTreeScore(j, i);
                if(score>max) max=score;
            }
        }
        return max;
    }


    private int getTreeScore(int x, int y){
        int up = 0;
        for(int i=y-1; i>=0; i--){
            up++;
            if(treeTable[i][x] >= treeTable[y][x]) break;
        }

        int down = 0;
        for(int i=y+1; i<treeTable.length; i++){
            down++;
            if(treeTable[i][x] >= treeTable[y][x]) break;
        }

        int left = 0;
        for(int i=x-1; i>=0; i--){
            left++;
            if(treeTable[y][i] >= treeTable[y][x]) break;
        }

        int right = 0;
        for(int i=x+1; i<treeTable[y].length; i++){
            right++;
            if(treeTable[y][i] >= treeTable[y][x]) break;
        }

        return up*down*left*right;
    }
}
