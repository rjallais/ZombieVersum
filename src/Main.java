import JavaBeans.DataVisualizerBean;
import org.encog.examples.guide.classification.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        IMPLEMENTAR A PARTE REAL DO PROJETO AQUI!!!
//                  VVVVVVVVVVVVVVVVVVVVV

        String[] newPatient = {"t", "t", "t", "t", "f", "t", "t", "NOVA-DOENCA"};

        DataVisualizerBean dv = new DataVisualizerBean();

        dv.plotTable("zombie-health-spreadsheet-ml-training.csv");
        dv.plotGraph("zombie-health-spreadsheet-ml-training.csv");
        String[][] table = dv.sortTable("zombie-health-spreadsheet-ml-training.csv");
        table = dv.addPatient(newPatient, table);

        /**********************************************************************************/
        String[] prob = {"paralysis", "member_loss", "trembling_finger", "history_bacteria"};
        IDataSet ds = new IDataSet();
        ProbabilisticComponent pb = new ProbabilisticComponent(ds);
        pb.calculateProbability(prob);

        /***********************************************************************************/
        SmartDoctor sd = new SmartDoctor();
        IResponder resp = new Patient();
        ArrayList<String> sint = new ArrayList<>();
        sd.connect(resp);
        sd.dadosPlanilha("zombie-health-spreadsheet-ml-training.csv");
        sd.doutorInteligente("zombie-health-spreadsheet-ml-training.csv", sint);
        sd.importData("zombie-health-spreadsheet-ml-training.csv");
        sd.startInterview();
    }
}
