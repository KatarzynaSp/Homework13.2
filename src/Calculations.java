import java.io.*;

public class Calculations {
    public static void main(String[] args) {

        File file = new File("Calculations.txt");
        File file1 = new File("Calculations2.txt");
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            String line;
            BufferedWriter bfw = new BufferedWriter(new FileWriter(file1));
            while ((line = bfr.readLine()) != null) {
                String[] sings = line.split(" ");
                double number1 = Double.parseDouble(sings[0]);
                double number2 = Double.parseDouble(sings[2]);
                double result = getResult(sings[1], number1, number2);
                write(bfw, sings, number1, number2, result);
            }
            bfr.close();
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double getResult(String sing, double number1, double number2) {
        double result;
        switch (sing) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            default:
                result = number1 / number2;
        }
        return result;
    }

    private static void write(BufferedWriter bfw, String[] sings, double number1, double number2, double result) {
        try {
            bfw.write(number1 + " " + sings[1] + " " + number2 + " = " + result);
            bfw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}