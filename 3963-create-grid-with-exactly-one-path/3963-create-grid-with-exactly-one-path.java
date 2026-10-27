class Solution {
    public String[] createGrid(int m, int n) {
        char[][] mat = new char[m][n];
        for(char[] r:mat){
            Arrays.fill(r,'#');
        }
        for(int i=0;i<n;i++){
            mat[0][i]='.';
        }
        for(int i=0;i<m;i++){
            mat[i][n-1]='.';
        }
        String fina[] = new String[m];
        for(int i=0;i<m;i++){
            fina[i]=new String(mat[i]);
        }
        return fina;
    }
}