import java.util.Scanner;

class Matrix {
    int[][] data;
    int rows, cols;

    // Parameterized constructor to initialize dimensions
    Matrix(int r, int c) {
        rows = r;
        cols = c;
        data = new int[r][c];
    }

    // Method to input data for the matrix
    void getData() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = sc.nextInt();
            }
        }
    }

    // Method to display the matrix
    void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Returns a new matrix representing -A
    Matrix negate() {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[i][j] = -this.data[i][j];
            }
        }
        return res;
    }

    // Method to add two matrices
    static Matrix add(Matrix m1, Matrix m2) {
        Matrix res = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                res.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return res;
    }

    // Method to subtract two matrices
    static Matrix subtract(Matrix m1, Matrix m2) {
        Matrix res = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                res.data[i][j] = m1.data[i][j] - m2.data[i][j];
            }
        }
        return res;
    }

    // Method to multiply two matrices
    static Matrix multiply(Matrix m1, Matrix m2) {
        Matrix res = new Matrix(m1.rows, m2.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                for (int k = 0; k < m1.cols; k++) {
                    res.data[i][j] += m1.data[i][k] * m2.data[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Client code to get dimensions
        System.out.print("Enter rows and columns for Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        Matrix A = new Matrix(r1, c1);
        System.out.println("Enter values for A:");
        A.getData();

        System.out.print("Enter rows and columns for Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        Matrix B = new Matrix(r2, c2);
        System.out.println("Enter values for B:");
        B.getData();

        // Validation for Matrix operations
        if (r1 == r2 && c1 == c2 && c1 == r2) {
            // Part 1: (-A + B)
            Matrix negA = A.negate();
            Matrix part1 = Matrix.add(negA, B);

            // Part 2: (A * B)
            Matrix part2 = Matrix.multiply(A, B);

            // Part 3: Result R = Part 1 - Part 2
            Matrix R = Matrix.subtract(part1, part2);

            System.out.println("\nResultant Matrix R is:");
            R.display();
        } else {
            System.out.println("Error: Dimensions incompatible for expression evaluation.");
        }
    }
}













