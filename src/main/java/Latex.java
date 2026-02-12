import java.io.*;

public class Latex {
    public String fileLocation;

    public Latex(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void latexTableInitial(String title) {
        File file = new File(fileLocation);

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"))) {
            bw.write("\\begin{table} [!htb]");
            bw.newLine();
            bw.write("    \\caption {" + title + "}");
            bw.newLine();
            bw.write("        \\begin{center}");
            bw.newLine();
            bw.write("\\begin{tabular}{|c|c|c|c|c|c|c}");
            bw.newLine();
            bw.write("\\cline{1-6} $\\varepsilon$ & \\multicolumn{5}{c|}{$N$} \\\\");
            bw.newLine();
            bw.write("\\cline{2-6} &$128$ & $256$ & $512$  & $1024$& $2048$\\\\");
//            bw.newLine();
//            bw.write("\\cline{2-6}& $32$&$64$& $128$&$256$&$512$&$1024$ \\\\");
            bw.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //        System.out.println("Данные отправлены в файл: "+fileOutPath);

    }


    public void latexTable(String[][] residual, String[][] oa) throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File(fileLocation);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"))) {
            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$1$");
            bw.newLine();
            bw.write("&$".concat(residual[0][0]) + "$&$".concat(residual[0][1]) + "$&$".concat(residual[0][2]) + "$&$".concat(residual[0][3]) + "$& $".concat(residual[0][4]) + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[0][0]) +       "$&$".concat(oa[0][1]) +        "$&$".concat(oa[0][2]) +       "$&$".concat(oa[0][3]) +       "$& $".concat(oa[0][4]) + "$\\\\");
            bw.newLine();


            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-1}$");
            bw.newLine();
            bw.write("&$".concat(residual[1][0]) + "$&$".concat(residual[1][1]) + "$&$".concat(residual[1][2]) + "$&$".concat(residual[1][3]) + "$&$".concat(residual[1][4]) + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[1][0]) +       "$&$".concat(oa[1][1]) +       "$&$".concat(oa[1][2]) +       "$&$".concat(oa[1][3]) +       "$&$".concat(oa[1][4]) + "$\\\\");
            bw.newLine();

            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-2}$");
            bw.newLine();
            bw.write("&$".concat(residual[2][0]) + "$&$".concat(residual[2][1]) + "$&$".concat(residual[2][2]) + "$&$".concat(residual[2][3]) + "$&$".concat(residual[2][4]) + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[2][0]) +       "$&$".concat(oa[2][1]) +       "$&$".concat(oa[2][2]) +       "$&$".concat(oa[2][3]) +       "$&$".concat(oa[2][4]) + "$\\\\");
            bw.newLine();

            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-3}$");
            bw.newLine();
            bw.write("&$".concat(residual[3][0]) + "$&$".concat(residual[3][1]) + "$&$".concat(residual[3][2]) + "$&$".concat(residual[3][3]) + "$&$".concat(residual[3][4]) + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[3][0]) +       "$&$".concat(oa[3][1]) +       "$&$".concat(oa[3][2]) +       "$&$".concat(oa[3][3]) +       "$&$".concat(oa[3][4]) + "$\\\\");
            bw.newLine();

            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-4}$");
            bw.newLine();
            bw.write("&$".concat(residual[4][0]) + "$&$".concat(residual[4][1]) + "$&$".concat(residual[4][2]) + "$&$".concat(residual[4][3]) + "$&$".concat(residual[4][4]) + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[4][0]) +       "$&$".concat(oa[4][1]) +       "$&$".concat(oa[4][2]) +       "$&$".concat(oa[4][3]) +       "$&$".concat(oa[4][4]) + "$\\\\");
            bw.newLine();

            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-5}$");
            bw.newLine();
            bw.write("&$".concat(residual[5][0]) + "$&$".concat(residual[5][1]) + "$&$".concat(residual[5][2]) + "$&$".concat(residual[5][3]) + "$&$".concat(residual[5][4]) + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[5][0]) +       "$&$".concat(oa[5][1]) +       "$&$".concat(oa[5][2]) +       "$&$".concat(oa[5][3]) +       "$&$".concat(oa[5][4]) + "$\\\\");
            bw.newLine();




            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-6}$");
            bw.newLine();
            bw.write("&$".concat(residual[6][0]) + "$&$".concat(residual[6][1]) + "$&$".concat(residual[6][2]) + "$&$".concat(residual[6][3]) + "$&$".concat(residual[6][4]) /*+ "$& $".concat(residual[2][5]) */ + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[6][0]) + "$&$".concat(oa[6][1]) + "$&$".concat(oa[6][2]) + "$&$".concat(oa[6][3]) + "$&$".concat(oa[6][4]) /*+ "$& $".concat(residual[2][5]) */ + "$\\\\");
            bw.newLine();


            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-7}$");
            bw.newLine();
            bw.write("&$".concat(residual[7][0]) + "$&$".concat(residual[7][1]) + "$&$".concat(residual[7][2]) + "$&$".concat(residual[7][3]) + "$&$".concat(residual[7][4]) /*+ "$& $".concat(residual[3][5]) */ + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[7][0]) + "$&$".concat(oa[7][1]) + "$&$".concat(oa[7][2]) + "$&$".concat(oa[7][3]) + "$&$".concat(oa[7][4]) /*+ "$& $".concat(residual[3][5]) */ + "$\\\\");
            bw.newLine();

            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("$10^{-8}$");
            bw.newLine();
            bw.write("&$".concat(residual[8][0]) + "$&$".concat(residual[8][1]) + "$&$".concat(residual[8][2]) + "$&$".concat(residual[8][3]) + "$&$".concat(residual[8][4]) /*+ "$ & $".concat(residual[4][5])*/ + "$\\\\");
            bw.newLine();
            bw.write("&$".concat(oa[8][0]) + "$&$".concat(oa[8][1]) + "$&$".concat(oa[8][2]) + "$&$".concat(oa[4][3]) + "$&$".concat(oa[8][4]) /*+ "$ & $".concat(residual[4][5])*/ + "$\\\\");
            bw.newLine();



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void latexTableEnd() {
        File file = new File(fileLocation);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"))) {
            bw.write("\\cline{1-6}");
            bw.newLine();
            bw.write("        \\end{tabular}");
            bw.newLine();
            bw.write("    \\end{center}");
            bw.newLine();
            bw.write("\\end{table}");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void latexHeadDocument() {
        File file = new File(fileLocation);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"))) {

            bw.write("\\documentclass[10pt,twoside]{uz_kgu}");
            bw.newLine();
            bw.write("\\usepackage{inputenc}");
            bw.newLine();
            bw.write("\\usepackage[russian]{babel}");
            bw.newLine();
            bw.write("\\newcommand{\\eps}{\\varepsilon}");
            bw.newLine();
            bw.write("\\begin{document}");
            bw.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void latexEndDocument() {
        File file = new File(fileLocation);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"))) {
            bw.newLine();
            bw.write("\\end{document}");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void compileAndOpenPDFFile() throws IOException {
        String pdfFile = fileLocation.replace(".tex", ".pdf");
        String directoryOfFile = fileLocation.substring(0, fileLocation.lastIndexOf("/") + 1);
        //        String[] command = {"pdflatex", "--output-directory=/home/funforces/Articles/NewArticleDerivative/ForScientificSupervisor/", fileLocation};
        String[] command = {"pdflatex", "--output-directory=".concat(directoryOfFile), fileLocation};
        Process process = Runtime.getRuntime().exec(command);
        process.getInputStream().transferTo(System.out);
        process.getErrorStream().transferTo(System.out);
        process.destroy();
        String[] command2 = {"open", pdfFile};
        Process process2 = Runtime.getRuntime().exec(command2);
        process2.getInputStream().transferTo(System.out);
        process2.getErrorStream().transferTo(System.out);
        process2.destroy();
    }
}
