public class PattersPart_II {

    public static void HollowRectangle(int Rows, int Cols) {
        // System.out.println("Hollow rectangle");
        for(int i=1; i<=Rows; i++) {
            for(int j=1; j<=Cols; j++) {
                if( i == 1 || i == Rows || j == 1 || j == Cols ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void InvertedRotatedHalfPyramid(int Rows) {
        // System.out.println("Inverted half pyramid");
        for(int i=1; i<=Rows; i++) {

            // for spaces
            for(int j=1; j<=Rows-i; j++) {
                System.out.print(" ");
            }

            // for stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void InvertedHalfPyramidWithNumber(int Rows) {
        for(int i=0; i<=Rows; i++) {
            for(int j=1; j<=Rows-i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void FloydsTriangle(int Rows) {
        int num = 1 ;
        for(int i=1; i<=Rows; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
    // logic one
    public static void Zero_One_Triangle(int Rows) {
        for(int i=1; i<=Rows; i++) {
            int num1 = 0 ;
            int num2 = 1 ;
            if( i % 2 == 0) {
                for(int j=1; j<=i; j++) {
                    System.out.print(num1 + " ");
                    if( num1 == 0) {
                        num1 = 1 ;
                    } else {
                        num1 = 0 ;
                    }
                }
            } else {
                for(int j=1; j<=i; j++) {
                    System.out.print(num2 + " ");
                    if( num2 == 1) {
                        num2 = 0 ;
                    } else {
                        num2 = 1 ;
                    }
                }
            }
            System.out.println();
        }
    }
    // logic two
    public static void Zero_One_Triangles(int Rows) { 
        for(int i=1; i<=Rows; i++) {
            for(int j=1; j<=i; j++) {
                if( (i+j) % 2 == 0) {
                    System.out.print("1" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void Butterfly(int Rows) {
        for(int i=1; i<=Rows; i++) {
            // for stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            // for spaces
            for(int j=1; j<=2*(Rows-i); j++) {
                System.out.print(" ");
            }
            // for stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1; i<=Rows; i++) {
            for(int j=1; j<=Rows-i+1; j++) {
                System.out.print("*");
            }
            for(int j=1; j<=2*(i-1); j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=Rows-i+1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void SolidRhombus(int Rows) {
        for(int i=1; i<=Rows; i++) {
            // for spaces
            for(int j=1; j<=Rows-i; j++) {
                System.out.print(" ");
            }
            //for stars
            for(int j=1; j<=Rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void HollowRhombus(int Rows) {
        for(int i=1; i<=Rows; i++) {
            for(int j=1; j<=Rows-i; j++) {
                System.out.print(" ");
            }
            
            for(int j=1; j<=Rows; j++) {
                if( i==1 || i==Rows || j==1 || j==Rows) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void Diamond(int Rows) {
        for(int i=1; i<=Rows; i++) {
            for(int j=1; j<=Rows-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=((2*i)-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=Rows; i>=1; i--) {
            for(int j=1; j<=Rows-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=((2*i)-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void NumberPyramid(int Rows) { 
        int num = 1 ;
        for(int i=1; i<=Rows; i++) {

            for(int j=1; j<=Rows-i; j++) {
                System.out.print(" ");
            }

            for(int j=1; j<=((2*i)-1); j++) {
                if( j % 2 == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(num);
                } 
            }
            num++;
            System.out.println();
        }
    }

    public static void PalindromicPatternWithNumber(int Rows) {
        for(int i=1; i<=Rows; i++) {
            for(int j=1; j<=Rows-i; j++) {
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--) {
                System.out.print(j);
            }
            for(int j=2; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        // HollowRectangle(4,4);
        // InvertedRotatedHalfPyramid(4);
        // InvertedHalfPyramidWithNumber(5);
        // FloydsTriangle(5);
        // Zero_One_Triangle(10);
        // Zero_One_Triangles(10);
        // Butterfly(10);
        // SolidRhombus(10);
        // HollowRhombus(5);
        // Diamond(5);
        // NumberPyramid(5);
        // PalindromicPatternWithNumber(5);
    }
}