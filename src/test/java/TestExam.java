import org.junit.Test;

public class TestExam extends BaseTest{


    @Test
    public void setHeader(){
        exam.setName();
        exam.setFavori();
        exam.setSepetim();
    }

    @Test
    public void setText() throws InterruptedException {
        exam.setText("Pantolan");
    }

}
