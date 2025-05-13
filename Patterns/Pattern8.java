class Pattern8 {
    public static void main(String[] args) {
        int n = 4;
        for (int i=0;i<n;i++) {
            for (int y=0;y<i;y++) {
                System.out.print(" ");
            }
            for (int j=0;j<n;j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}