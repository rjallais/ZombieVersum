import JavaBeans.DataVisualizerBean;
import org.encog.examples.guide.classification.*;
import org.encog.examples.guide.classification.IDataSet;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        IMPLEMENTAR A PARTE REAL DO PROJETO AQUI!!!
//                  VVVVVVVVVVVVVVVVVVVVV

        String[] newPatient = {"t", "t", "t", "t", "f", "t", "t", "f", "NOVA-DOENCA"};

        DataVisualizerBean dv = new DataVisualizerBean();

        dv.plotTable("zombie-health-new-cases20.csv");
        dv.plotGraph("zombie-health-new-cases20.csv", "red_eye");
        String[][] table = dv.sortTable("zombie-health-new-cases20.csv");
        table = dv.addPatient(newPatient, table);

        /**********************************************************************************/
//        String[] prob = {"paralysis", "member_loss", "trembling_finger", "history_bacteria"};
//        IDataSet ds = new IDataSet();
//        ProbabilisticComponent pb = new ProbabilisticComponent(ds);
//        pb.calculateProbability(prob);

        /***********************************************************************************/
        IDataSet dataset = new DataSetComponent();

        dataset.setDataSource("zombie-health-cases500.csv");

        IPatient aPatient = new Patient();

        aPatient.connect(dataset);

        IDoctor cDoctor = new SmartDoctor();

        cDoctor.connect(dataset);

        cDoctor.connect(aPatient);

        cDoctor.startInterview();
    }
}
